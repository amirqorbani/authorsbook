package org.example.repositories;

import org.example.MyConnection;
import org.example.entity.Author;
import org.example.entity.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookRepository {

    void save(Book book) throws SQLException {
        Connection conn = MyConnection.Getconnection();
        String sql = "insert into Books(BookID , BookName, PublishedYear , AuthorName)  Values ( ? , ? , ?)";
        PreparedStatement pstatement = conn.prepareStatement(sql);
        pstatement.setString(1, book.getBookName());
        pstatement.setInt(2, book.getPublishedYear());
        pstatement.setString(3, book.getAuthorName());
        pstatement.executeUpdate();
        conn.close();
    }

    Book load(int bookid) throws SQLException {
        Connection conn = MyConnection.Getconnection();
        String sql = "select * from books where BookId = ?";
        PreparedStatement pstatement = conn.prepareStatement(sql);
        pstatement.setInt(1, bookid);
        ResultSet resultSet = pstatement.executeQuery();
        conn.close();
        return new Book(resultSet.getInt("BookId"), resultSet.getString("BookName"),
                resultSet.getInt("PublishedYear"), resultSet.getString("AuthorName"));

    }

    void delete(Book book) throws SQLException {
        Connection conn = MyConnection.Getconnection();
        String sql = "Delete FROM  books WHERE BooksId = ?";
        PreparedStatement pstatement = conn.prepareStatement(sql);
        pstatement.setInt(1, book.getBookId());
        pstatement.executeUpdate();
        conn.close();
    }
}