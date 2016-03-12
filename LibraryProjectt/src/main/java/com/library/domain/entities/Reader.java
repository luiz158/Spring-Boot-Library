package com.library.domain.entities;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
public class Reader {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "full_name")
    @Size(min = 4, max = 30, message = "size of field must be between 3 and 15 characters")
    private String fullName;

    @Column(name = "has_book")
    @Size(min = 3, max = 15, message = "size of field must be between 3 and 15 characters")
    private String hasBook;

    @OneToOne(optional = false, mappedBy = "reader")
    private BookLeading bookLeading;

    public Reader() {

    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getHasBook() {
        return hasBook;
    }

    public void setHasBook(String hasBook) {
        this.hasBook = hasBook;
    }

    public long getId() {
        return id;
    }

    public BookLeading getBookLeading() {
        return bookLeading;
    }

    public void setBookLeading(BookLeading bookLeading) {
        this.bookLeading = bookLeading;
    }
}
