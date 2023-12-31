package com.example.groupca_ws_spm.business;

import java.util.Objects;

public class Book {
private int bookId;
private String bookName;
private String authorName;
private String description;

    public Book(int bookId, String bookName, String authorName, String description) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.authorName = authorName;
        this.description = description;
    }

    public Book() {
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        Book book = (Book) o;
        return getBookId() == book.getBookId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBookId());
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", bookName='" + bookName + '\'' +
                ", authorName='" + authorName + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

}
