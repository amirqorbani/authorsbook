package org.example;

import org.example.services.AuthorService;
import org.example.services.BookService;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
//        AuthorService authorService = new AuthorService();
//        authorService.register("amir" , "ghorbani" , 27);
        BookService bookService = new BookService();
        bookService.addBook("parvaz" ,1997  , 2);


    }
}