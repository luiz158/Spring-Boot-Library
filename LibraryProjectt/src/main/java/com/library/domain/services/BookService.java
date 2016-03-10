package com.library.domain.services;


import com.library.domain.entities.Book;

import java.util.List;

public interface BookService {

    Book addBook(Book book);
    void delete(long id);
    Book findOne(long id);
    Book editBook(Book book);
    List<Book> getAll();

}
