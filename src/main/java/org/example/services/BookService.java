package org.example.services;

import org.example.MyConnection;
import org.example.entity.Author;
import org.example.entity.Book;
import org.example.repositories.AuthorRepository;
import org.example.repositories.BookRepository;

import java.sql.*;

public class BookService {
  public  void  addBook(String bookname , int publishedyear , int authorid) throws SQLException {
      Connection conn = MyConnection.Getconnection();
      String sql = "select AuthorName from Authors where AuthorId = ? ";
      PreparedStatement pstatement = conn.prepareStatement(sql);
      pstatement.setInt(1 , authorid);
      ResultSet resultSet  =pstatement.executeQuery();
        String authorname = resultSet.getString("AuthorName");
      new BookRepository().save(new Book(bookname , publishedyear ,authorname ));

  }
}
