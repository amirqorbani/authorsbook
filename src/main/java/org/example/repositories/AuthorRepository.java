package org.example.repositories;

import org.example.MyConnection;
import org.example.entity.Author;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthorRepository {
    void save(Author author) throws SQLException {
        Connection conn = MyConnection.Getconnection();
        String sql = "insert into Authors(AuthorID , FirstName , LastName , Age ) Values ( ? , ? , ?)";
        PreparedStatement pstatement = conn.prepareStatement(sql);
        pstatement.setString(1, author.getFirstName());
        pstatement.setString(2, author.getLastName());
        pstatement.setInt(3, author.getAge());
        pstatement.executeUpdate();
        conn.close();
    }

    Author load(int authorId) throws SQLException {
        Connection conn = MyConnection.Getconnection();
        String sql = "select * from Authors where AuthorId = ?";
        PreparedStatement pstatement = conn.prepareStatement(sql);
        pstatement.setInt(1, authorId);
        ResultSet resultSet = pstatement.executeQuery();
        conn.close();
        return new Author(resultSet.getInt("AuthorId"), resultSet.getString("FirstName"),
                resultSet.getString("LastName"), resultSet.getInt("Age"));

    }

}
