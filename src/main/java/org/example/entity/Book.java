package org.example.entity;

public class Book {
    private int BookId;
    private String BookName;
    private int PublishedYear;
    private String AuthorName;

    public Book(int bookId, String bookName, int publishedYear, String authorName) {
        BookId = bookId;
        BookName = bookName;
        PublishedYear = publishedYear;
        AuthorName = authorName;
    }

    public int getBookId() {
        return BookId;
    }

    public void setBookId(int bookId) {
        BookId = bookId;
    }

    public String getBookName() {
        return BookName;
    }

    public void setBookName(String bookName) {
        BookName = bookName;
    }

    public int getPublishedYear() {
        return PublishedYear;
    }

    public void setPublishedYear(int publishedYear) {
        PublishedYear = publishedYear;
    }

    public String getAuthorName() {
        return AuthorName;
    }

    public void setAuthorName(String authorName) {
        AuthorName = authorName;
    }

    @Override
    public String toString() {
        return "Book{" +
                "BookId=" + BookId +
                ", BookName='" + BookName + '\'' +
                ", PublishedYear=" + PublishedYear +
                ", AuthorName='" + AuthorName + '\'' +
                '}';
    }
}
