package com.skillsoft.springdatajpa.model;

import javax.persistence.*;

@Entity

@NamedQuery(name = "Book.findAvailableBooksJPQL",
        query = "SELECT b FROM Book b WHERE b.available = 1")

@NamedQuery(name = "Book.findByRatingJPQL",
        query = "SELECT b FROM Book b WHERE b.rating >= ?1")

@NamedNativeQuery(name = "Book.findByTitleNative",
        query = "SELECT * FROM book b WHERE b.title = :title",
        resultClass = Book.class)

@Table(name = "Book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long bookId;
    private String title;
    private String author;
    private int rating;
    private boolean available;

    public Book() {
    }

    public Book(String title, String author, int rating, boolean available) {
        this.title = title;
        this.author = author;
        this.rating = rating;
        this.available = available;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", rating=" + rating +
                ", available=" + available +
                '}'+'\n';
    }
}
