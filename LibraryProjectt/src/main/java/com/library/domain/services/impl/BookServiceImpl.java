package com.library.domain.services.impl;


import com.library.domain.entities.Book;
import com.library.domain.repositories.BookRepository;
import com.library.domain.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    @Qualifier("bookRepository")
    private BookRepository bookRepository;


    @Override
    public Book addBook(Book book) {
        Book saveBook =  bookRepository.saveAndFlush(book);
        return saveBook;
    }

    public BookServiceImpl(){

    }

    @Override
    public void delete(long id) {
        bookRepository.delete(id);
    }

    @Override
    public Book editBook(Book book) {
       Book editBook = bookRepository.saveAndFlush(book);

        return editBook;
    }

    @Override
    public List<Book> getAll() {
        return  bookRepository.findAll();
    }

    @Override
    public Book findOne(long id) {
        Book book = bookRepository.findOne(id);

        return book;
    }

}
