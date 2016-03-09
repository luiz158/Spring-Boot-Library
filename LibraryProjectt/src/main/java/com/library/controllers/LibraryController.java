package com.library.controllers;


import com.library.domain.entities.Book;
import com.library.domain.entities.BookLeading;
import com.library.domain.entities.Reader;
import com.library.domain.repositories.BookRepository;
import com.library.domain.services.impl.BookLeadingServiceImpl;
import com.library.domain.services.impl.BookServiceImpl;
import com.library.domain.services.impl.ReaderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Controller
@RequestMapping("/")
public class LibraryController {

    @Autowired
    @Qualifier("bookServiceImpl")
   private BookServiceImpl bookService;

    @Autowired
    @Qualifier("readerServiceImpl")
    private ReaderServiceImpl readerService;

    @Autowired
    @Qualifier("bookLeadingServiceImpl")
    private BookLeadingServiceImpl bookLeadingService;

    @RequestMapping(method = RequestMethod.GET)
    public String welcomeView(Model model){

        List<Book> listBook = bookService.getAll();

        List<Reader> listReader = readerService.getAll();

        List<BookLeading> bookLeadings = bookLeadingService.getAll();

        model.addAttribute("books", listBook );

        model.addAttribute("readers",listReader);

        model.addAttribute("bookLeadings",bookLeadings);

        return "welcomeview";
    }

    @RequestMapping(value = "/addNewBook", method = RequestMethod.GET)
    public String addNewBook(){
        return "book/newBook";
    }

    @RequestMapping(value= "/book/createBook",method=RequestMethod.POST)
    public String createBook(@RequestParam("nameBook") String nameBook, @RequestParam("author") String author, @RequestParam("publishingHouse")String publishingHouse){

        Book book = new Book();
        book.setNameBook(nameBook);
        book.setAuthor(author);
        book.setPublishingHouse(publishingHouse);

        bookService.addBook(book);

        return "redirect:/";

    }


    @RequestMapping(value="/book/updateBook",method=RequestMethod.POST)
    public String updateBook( @RequestParam("id")long id,@RequestParam("nameBook") String nameBook,@RequestParam("author")String author,@RequestParam("publishingHouse")String publishingHouse) {
        Book book = bookService.findOne(id);
        book.setNameBook(nameBook);
        book.setAuthor(author);
        book.setPublishingHouse(publishingHouse);

        bookService.editBook(book);

        return "redirect:/";
    }



        @RequestMapping(value ="/{id}/editBook", method = RequestMethod.GET)
        public String editsBook(@PathVariable long id, Model model) {

            Book book = bookService.findOne(id);
            model.addAttribute("book",book);

            return "book/editBook";
        }


    @RequestMapping(value="/{id}/deleteBook",method=RequestMethod.GET)
    public String deleteBook(@PathVariable long id){
        bookService.delete(id);

        return "redirect:/";
    }

    @RequestMapping(value="/addNewReader", method = RequestMethod.GET)
    public String addNewReader(){

        return "reader/newReader";
    }

    @RequestMapping(value="/reader/createReader",method = RequestMethod.POST)
    public String createReader(@RequestParam("fullName")String fullName,@RequestParam("hasBook")String hasBook){
        Reader reader = new Reader();
        reader.setFullName(fullName);
        reader.setHasBook(hasBook);

        readerService.addReader(reader);

        return "redirect:/";
    }

    @RequestMapping(value="/{id}/editReader",method = RequestMethod.GET)
    public String editReader(@PathVariable long id, Model model){

        Reader reader = readerService.findOne(id);
        model.addAttribute("reader",reader);

        return "reader/editReader";
    }


    @RequestMapping(value="/reader/updateReader",method=RequestMethod.POST)
    public String updateReader(@RequestParam("id")long id,@RequestParam("fullName")String fullName,@RequestParam("hasBook")String hasBook){
        Reader reader = readerService.findOne(id);
        reader.setFullName(fullName);
        reader.setHasBook(hasBook);

        readerService.editReader(reader);

        return "redirect:/";
    }

    @RequestMapping(value="/{id}/deleteReader",method=RequestMethod.GET)
    public String deleteReader(@PathVariable long id){
        readerService.delete(id);
        return "redirect:/";
    }


    @RequestMapping(value="/addNewBookLeading",method=RequestMethod.GET)
    public String takeBookBtn(){
        return "bookLeading/newBookLeading";
    }

    @RequestMapping(value="/bookLeading/createBookLeading",method=RequestMethod.POST)
    public String createBookLeading(@RequestParam("book.nameBook")String bookName, @RequestParam("reader.fullName")String fullName, @RequestParam("dateTook")Date dateTook,@RequestParam("dateBack")Date dateBack){
        BookLeading bookLeading = new BookLeading();
        Book newBook = new Book();
        newBook.setNameBook(bookName);
        bookLeading.setBook(newBook);
        Reader newReader = new Reader();
        newReader.setFullName(fullName);
        bookLeading.setReader(newReader);
        bookLeading.setDateTook(new Date());
        bookLeading.setDateBack(new Date());

        bookLeadingService.addBookLeading(bookLeading);

        return "redirect:/";
    }

}
