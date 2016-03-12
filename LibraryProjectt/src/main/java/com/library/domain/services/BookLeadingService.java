package com.library.domain.services;


import com.library.domain.entities.BookLeading;

import java.util.List;

public interface BookLeadingService {

    BookLeading addBookLeading(BookLeading bookLeading);

    List<BookLeading> getAll();

    void delete(long id);
}
