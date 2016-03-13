package com.library.services;

import com.library.domain.Book;
import com.library.domain.BookLeading;
import com.library.domain.repositories.BookRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.when;

public class BookServiceTest {

    @Mock
    private BookRepository bookRepository;

    private BookService bookService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        bookService = new BookService(bookRepository);
    }

    @Test
    public void shouldAddOneBook() {

        BookLeading bookLending = new BookLeading();
        Book newBook = new Book();
        newBook.setAuthor("Jonas");
        newBook.setNameBook("Something Interesting");
        newBook.setPublishingHouse("ABCDEF");
        newBook.setBookLeading(bookLending);

        Book expectedSavedBook = new Book();
        expectedSavedBook.setId(1);
        expectedSavedBook.setAuthor("Jonas");
        expectedSavedBook.setNameBook("Something Interesting");
        expectedSavedBook.setPublishingHouse("ABCDEF");
        expectedSavedBook.setBookLeading(bookLending);

        when(bookRepository.saveAndFlush(newBook)).thenReturn(expectedSavedBook);

        Book receivedBook = bookService.addBook(newBook);

        assertThat(receivedBook, is(expectedSavedBook));

    }

}