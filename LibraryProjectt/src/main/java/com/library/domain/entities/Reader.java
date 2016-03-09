package com.library.domain.entities;

import javax.persistence.*;

@Entity
public class Reader {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name="full_name")
    private String fullName;

    @Column(name="has_book")
    private String hasBook;

    public Reader(){

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
}
