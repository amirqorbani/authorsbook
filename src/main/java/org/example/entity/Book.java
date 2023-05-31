package org.example.entity;

import org.example.MyConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Book {
    private int BookId;
    private String BookName;
    private int PublishedYear;
    private String AuthorName;

    public Book( String bookName, int publishedYear, String authorName) {
        BookName = bookName;
        PublishedYear = publishedYear;
        AuthorName = authorName;
    }

    public int getBookId() throws SQLException {
        Connection conn = MyConnection.Getconnection();
        String sql = "SELECT BookId FROM Books WHERE BookName = ?";
        PreparedStatement pstatement = conn.prepareStatement(sql);
        pstatement.setString(1, this.BookName);
        ResultSet resultSet = pstatement.executeQuery();
        int BookId = resultSet.getInt("BookId");
        return BookId;
    }

    public String getBookName() {
        return BookName;
    }

    public int getPublishedYear() {
        return PublishedYear;
    }

    public String getAuthorName() {
        return AuthorName;
    }

    @Override
    public String toString() {
        return "Book{" +
                "BookId=" + BookId +
                ", BookName='" + BookName + '\'' +
                ", PublishedYear=" + PublishedYear +
                ", AuthorName='" + AuthorName + '\'' +
                '}';
    }
}
