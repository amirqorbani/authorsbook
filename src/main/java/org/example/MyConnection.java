package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {
    public static Connection Getconnection() throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/authorsbooks" ,
                "postgrs" , "sbu16036");
        return conn;
    }

}
