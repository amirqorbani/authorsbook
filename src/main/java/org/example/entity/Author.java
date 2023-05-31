package org.example.entity;

import org.example.MyConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Author {
    private int AuthorId;
    private String FirstName ;
    private String LastName;
    private int Age;
    private String[] Books;

    public Author( String firstName, String lastName, int age) {
        FirstName = firstName;
        LastName = lastName;
        Age = age;
    }

    public int getAuthorId() throws SQLException {
        Connection conn = MyConnection.Getconnection();
        String sql = "select AuthorId from Authors where FirstName = ?";
        PreparedStatement pstatement = conn.prepareStatement(sql);
        pstatement.setString(1, this.FirstName);
        ResultSet resultSet = pstatement.executeQuery();
        int AuthorId = resultSet.getInt("AuthorId");
        return AuthorId;
    }

    public String getFirstName() throws SQLException {return FirstName;}

    public String getLastName() {
        return LastName;
    }

    public int getAge() {
        return Age;
    }


    public String[] getBooks() throws SQLException {
        Connection conn = MyConnection.Getconnection();
        String sql = "SELECT BookName FROM Books WHERE AuthorName = ?";
        PreparedStatement pstatement = conn.prepareStatement(sql);
        pstatement.setString(1, this.FirstName);
        ResultSet resultSet = pstatement.executeQuery();
        int counter = 0;
        while (resultSet.next()){
            counter++;
        }
        String[] books = new String[counter];
        for (int i = 0; i <counter ; i++) {
            books[i] = resultSet.getString("BookName");
            resultSet.next();
        }
            return books;
        }


    @Override
    public String toString() {

        return "Author{" +
                "AuthorId=" + AuthorId +
                ", FirstName='" + FirstName + '\'' +
                ", LastName='" + LastName + '\'' +
                ", Age=" + Age +
                "list of books :" + Books.toString()
                +'}';
    }
}

