package com.library.domain.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Date;


@Entity
public class BookLeading {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToOne(optional = false)
    @JoinColumn(name = "book_id", unique = true, nullable = false, updatable = false)
    @NotNull(message = "field should be filled in")
    private Book book;

    @OneToOne(optional = false)
    @JoinColumn(name = "reader_id", unique = true, nullable = false, updatable = false)
    @NotNull(message = "field should be filled in")
    private Reader reader;

    @Column(name = "Date_Took")
    @NotNull(message = "field should be filled in")
    private Date dateTook;

    @Column(name = "Date_Back")
    @NotNull(message = "field should be filled in")
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
