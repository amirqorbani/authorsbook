package org.example.services;

import org.example.MyConnection;
import org.example.entity.Book;
import org.example.repositories.BookRepository;

import java.sql.*;

public class BookService {
  public  void  addBook(String bookname , int publishedyear , int authorid) throws SQLException {
      Connection conn = MyConnection.Getconnection();
      String sql = "SELECT firstname FROM Authors WHERE AuthorId = ? ";
      PreparedStatement pstatement = conn.prepareStatement(sql);
      pstatement.setInt(1 , authorid);
      ResultSet resultSet  = pstatement.executeQuery();
      resultSet.next();
        String firstname = resultSet.getString("firstname");
      new BookRepository().save(new Book(bookname , publishedyear , firstname ));

  }
}
