package com.library.domain.services.impl;


import com.library.domain.entities.Reader;
import com.library.domain.repositories.ReaderRepository;
import com.library.domain.services.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class ReaderServiceImpl implements ReaderService {

    @Autowired
    @Qualifier("readerRepository")
    private ReaderRepository readerRepository;

    @Override
    public Reader findOne(long id) {
        Reader findReader = readerRepository.findOne(id);
        return findReader;
    }

    @Override
    public Reader addReader(Reader reader) {

        Reader addReaders = readerRepository.saveAndFlush(reader);

        return addReaders;
    }

    @Override
    public void delete(long id) {
        readerRepository.delete(id);
    }

    @Override
    public Reader editReader(Reader reader) {
        Reader editReaders = readerRepository.saveAndFlush(reader);

        return editReaders;
    }

    @Override
    public List<Reader> getAll() {
         return readerRepository.findAll();
    }
}
