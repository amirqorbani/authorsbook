package org.example.repositories;

import org.example.MyConnection;
import org.example.entity.Author;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthorRepository {
   public void save(Author author) throws SQLException {
        Connection conn = MyConnection.Getconnection();
        String sql = "INSERT INTO Authors( FirstName , LastName , Age ) VALUES ( ? , ? , ?)";
        PreparedStatement pstatement = conn.prepareStatement(sql);
        pstatement.setString(1, author.getFirstName());
        pstatement.setString(2, author.getLastName());
        pstatement.setInt(3, author.getAge());
        pstatement.executeUpdate();
        conn.close();
    }

   public Author load(int authorId) throws SQLException {
        Connection conn = MyConnection.Getconnection();
        String sql = "SELECT * FROM Authors WHERE AuthorId = ?";
        PreparedStatement pstatement = conn.prepareStatement(sql);
        pstatement.setInt(1, authorId);
        ResultSet resultSet = pstatement.executeQuery();
        conn.close();
        return new Author( resultSet.getString("FirstName"),
                resultSet.getString("LastName"), resultSet.getInt("Age"));

    }

}
