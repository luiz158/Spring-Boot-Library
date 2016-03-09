package com.library.domain.services;


import com.library.domain.entities.BookLeading;

import java.util.List;

public interface BookLeadingService {

    BookLeading addBookLeading(BookLeading bookLeading);
    void delete(long id);
    BookLeading editBookLeading(BookLeading bookLeading);
    List<BookLeading> getAll();
    BookLeading findOne(long id);
}
