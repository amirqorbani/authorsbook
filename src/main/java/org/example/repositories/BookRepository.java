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
        String sql = "insert into Books( BookName, PublishedYear , AuthorName)  Values ( ? , ? , ?)";
        PreparedStatement pstatement = conn.prepareStatement(sql);
        pstatement.setString(1, book.getBookName());
        pstatement.setInt(2, book.getPublishedYear());
        pstatement.setString(3, book.getAuthorName());
        pstatement.executeUpdate();
//
        String sql2 = "select AuthorId from Authors where AuthorName = ? ";
        PreparedStatement pstatement2 = conn.prepareStatement(sql2);
        pstatement2.setString(1 , book.getAuthorName());
        ResultSet resultSet  =pstatement2.executeQuery();
        int authorid = resultSet.getInt("AuthorId");

        String sql3 = "select BookId from Books where BookName = ? ";
        PreparedStatement pstatement3 = conn.prepareStatement(sql3);
        pstatement3.setString(1 , book.getBookName());
        ResultSet resultSet1  =pstatement3.executeQuery();
        int bookid = resultSet1.getInt("BookId");

        String sql4 = "insert into Authorbook(BookId , AuthorId) values (? , ? )";
        PreparedStatement pstatement4 = conn.prepareStatement(sql4);
        pstatement4.setInt(1, authorid);
        pstatement4.setInt(2, bookid);
        pstatement4.executeUpdate();
        conn.close();
    }

    public Book load(int bookid) throws SQLException {
        Connection conn = MyConnection.Getconnection();
        String sql = "select * from books where BookId = ?";
        PreparedStatement pstatement = conn.prepareStatement(sql);
        pstatement.setInt(1, bookid);
        ResultSet resultSet = pstatement.executeQuery();
        conn.close();
        return new Book( resultSet.getString("BookName"),
                resultSet.getInt("PublishedYear"), resultSet.getString("AuthorName"));

    }

    public void delete(Book book) throws SQLException {
        Connection conn = MyConnection.Getconnection();
        String sql = "Delete FROM  books WHERE BooksId = ?";
        PreparedStatement pstatement = conn.prepareStatement(sql);
        pstatement.setInt(1, book.getBookId());
        pstatement.executeUpdate();
        conn.close();
    }
}