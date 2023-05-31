package org.example.repositories;

import org.example.MyConnection;
import org.example.entity.Author;
import org.example.entity.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookRepository {

    public void save(Book book) throws SQLException {
        Connection conn = MyConnection.Getconnection();
        String sql = "INSERT INTO Books( BookName, PublishedYear , AuthorName)  VALUES ( ? , ? , ?)";
        PreparedStatement pstatement = conn.prepareStatement(sql);
        pstatement.setString(1, book.getBookName());
        pstatement.setInt(2, book.getPublishedYear());
        pstatement.setString(3, book.getAuthorName());
        pstatement.executeUpdate();
//
        String sql2 = "SELECT AuthorId FROM Authors WHERE firstname = ? ";
        PreparedStatement pstatement2 = conn.prepareStatement(sql2);
        pstatement2.setString(1 , book.getAuthorName());
        ResultSet resultSet  =pstatement2.executeQuery();
        resultSet.next();
        int authorid = resultSet.getInt("AuthorId");

        String sql3 = "SELECT BookId FROM Books WHERE BookName = ? ";
        PreparedStatement pstatement3 = conn.prepareStatement(sql3);
        pstatement3.setString(1 , book.getBookName());
        ResultSet resultSet1  =pstatement3.executeQuery();
        resultSet1.next();
        int bookid = resultSet1.getInt("BookId");

        String sql4 = "INSERT INTO AuthorBook(BookId , AuthorId) VALUES (? , ? )";
        PreparedStatement pstatement4 = conn.prepareStatement(sql4);
        pstatement4.setInt(1, authorid);
        pstatement4.setInt(2, bookid);
        pstatement4.executeUpdate();
        conn.close();
    }

    public Book load(int bookid) throws SQLException {
        Connection conn = MyConnection.Getconnection();
        String sql = "SELECT * FROM Books WHERE BookId = ?";
        PreparedStatement pstatement = conn.prepareStatement(sql);
        pstatement.setInt(1, bookid);
        ResultSet resultSet = pstatement.executeQuery();
        resultSet.next();
        return new Book( resultSet.getString("BookName"),
                resultSet.getInt("PublishedYear"), resultSet.getString("AuthorName"));

    }

    public void delete(Book book) throws SQLException {
        Connection conn = MyConnection.Getconnection();
        String sql = "DELETE FROM  Books WHERE BooksId = ?";
        PreparedStatement pstatement = conn.prepareStatement(sql);
        pstatement.setInt(1, book.getBookId());
        pstatement.executeUpdate();
        conn.close();
    }
}