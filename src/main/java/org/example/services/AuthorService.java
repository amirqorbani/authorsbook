package org.example.services;

import org.example.entity.Author;
import org.example.repositories.AuthorRepository;

import java.sql.SQLException;

public class AuthorService {
    public void register(String firstname , String lastname , int age) throws SQLException {
        new AuthorRepository().save(new Author(firstname , lastname , age));
    }
}
