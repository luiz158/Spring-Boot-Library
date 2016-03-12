package com.library.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Date;


@Entity
public class BookLeading {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToOne(optional = false)
    @JoinColumn(name = "book_id", unique = true, nullable = false, updatable = false)
    @NotNull(message = "Wrong Book_Id")
    private Book book;

    @OneToOne(optional = false)
    @JoinColumn(name = "reader_id", unique = true, nullable = false, updatable = false)
    @NotNull(message = "Wrong Reader_Id")
    private Reader reader;

    @Column(name = "Date_Took")
    @NotNull(message = "field must be filled in")
    private Date dateTook;

    @Column(name = "Date_Back")
    @NotNull(message = "field must be filled in")
    private Date dateBack;

    public BookLeading() {

    }

    public long getId() {
        return id;
    }

    public Reader getReader() {
        return reader;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Date getDateTook() {
        return dateTook;
    }

    public void setDateTook(Date dateTook) {
        this.dateTook = dateTook;
    }

    public Date getDateBack() {
        return dateBack;
    }

    public void setDateBack(Date dateBack) {
        this.dateBack = dateBack;
    }
}
