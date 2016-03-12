package com.library.services;


import com.library.domain.Book;
import com.library.domain.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    @Qualifier("bookRepository")
    private BookRepository bookRepository;


    public BookService() {

    }

    public Book addBook(Book book) {
        Book saveBook = bookRepository.saveAndFlush(book);
        return saveBook;
    }

    public void delete(long id) {
        bookRepository.delete(id);
    }

    public Book editBook(Book book) {
        Book editBook = bookRepository.saveAndFlush(book);
        return editBook;
    }

    public List<Book> getAll() {
        return bookRepository.findAll();
    }

    public Book findOne(long id) {
        Book book = bookRepository.findOne(id);
        return book;
    }

}
