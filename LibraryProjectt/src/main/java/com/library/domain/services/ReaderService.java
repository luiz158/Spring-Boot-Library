package com.library.domain.services;



import com.library.domain.entities.Reader;

import java.util.List;

public interface ReaderService {
    Reader addReader(Reader reader);
    void delete(long id);
    Reader findOne(long id);
    Reader editReader(Reader reader);
    List<Reader> getAll();
}
