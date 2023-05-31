package org.example.entity;

public class Author {
    private int AuthorId;
    private String FirstName ;
    private String LastName;
    private int Age;
    private Book[] Books;

    public Author(int authorId, String firstName, String lastName, int age) {
        AuthorId = authorId;
        FirstName = firstName;
        LastName = lastName;
        Age = age;
    }

    public int getAuthorId() {
        return AuthorId;
    }

    public void setAuthorId(int authorId) {
        AuthorId = authorId;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public Book[] getBooks() {
        return Books;
    }

    public void setBooks(Book[] books) {
        Books = books;
    }

    @Override
    public String toString() {

        return "Author{" +
                "AuthorId=" + AuthorId +
                ", FirstName='" + FirstName + '\'' +
                ", LastName='" + LastName + '\'' +
                ", Age=" + Age +
                "list of books :" + Books.toString()
                +'}';
    }
}

