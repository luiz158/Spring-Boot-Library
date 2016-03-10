package com.library.domain.entities;

import javax.persistence.*;
import java.util.Date;


@Entity
public class BookLeading {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToOne(optional = false)
    @JoinColumn(name = "book_id", unique = true, nullable = false, updatable = false)
    private Book book;

    @OneToOne(optional = false)
    @JoinColumn(name = "reader_id", unique = true, nullable = false, updatable = false)
    private Reader reader;

    @Column(name = "Date_Took")
    private Date dateTook;

    @Column(name = "Date_Back")
    private Date dateBack;

    public BookLeading() {

    }

    public long getId() {
        return id;
    }

    public Reader getReader() {
        return reader;
    }

    public Book getBook() {
        return book;
    }

    public Date getDateTook() {
        return dateTook;
    }

    public Date getDateBack() {
        return dateBack;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }

    public void setDateTook(Date dateTook) {
        this.dateTook = dateTook;
    }

    public void setDateBack(Date dateBack) {
        this.dateBack = dateBack;
    }
}
