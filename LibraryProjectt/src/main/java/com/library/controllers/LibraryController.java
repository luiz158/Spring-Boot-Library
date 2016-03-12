package com.library.controllers;


import com.library.domain.Book;
import com.library.domain.BookLeading;
import com.library.domain.Reader;
import com.library.services.BookLeadingService;
import com.library.services.BookService;
import com.library.services.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@Controller
@RequestMapping("/")
public class LibraryController {

    @Autowired
    @Qualifier("bookService")
    private BookService bookService;

    @Autowired
    @Qualifier("readerService")
    private ReaderService readerService;

    @Autowired
    @Qualifier("bookLeadingService")
    private BookLeadingService bookLeadingService;

    @RequestMapping(method = RequestMethod.GET)
    public String welcomeView(Model model) {

        List<Book> listBook = bookService.getAll();

        List<Reader> listReader = readerService.getAll();

        List<BookLeading> bookLeadings = bookLeadingService.getAll();

        model.addAttribute("books", listBook);

        model.addAttribute("readers", listReader);

        model.addAttribute("bookLeadings", bookLeadings);

        return "welcomeview";
    }

    @RequestMapping(value = "/addNewBook", method = RequestMethod.GET)
    public String addNewBook(ModelMap modelMap) {

        modelMap.addAttribute("book", new Book());

        return "book/newBook";
    }

    @RequestMapping(value = "/book/createBook", method = RequestMethod.POST)
    public String createBook(@Valid @ModelAttribute Book book, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "book/newBook";
        }

        bookService.addBook(book);

        return "redirect:/";

    }


    @RequestMapping(value = "/book/updateBook", method = RequestMethod.POST)
    public String updateBook(@RequestParam("id") long id, @RequestParam("nameBook") String nameBook, @RequestParam("author") String author, @RequestParam("publishingHouse") String publishingHouse) {

        Book book = bookService.findOne(id);
        book.setNameBook(nameBook);
        book.setAuthor(author);
        book.setPublishingHouse(publishingHouse);

        bookService.editBook(book);

        return "redirect:/";
    }


    @RequestMapping(value = "/{id}/editBook", method = RequestMethod.GET)
    public String editsBook(@PathVariable long id, Model model) {

        Book book = bookService.findOne(id);
        model.addAttribute("book", book);

        return "book/editBook";
    }


    @RequestMapping(value = "/{id}/deleteBook", method = RequestMethod.GET)
    public String deleteBook(@PathVariable long id) {
        bookService.delete(id);

        return "redirect:/";
    }

    @RequestMapping(value = "/addNewReader", method = RequestMethod.GET)
    public String addNewReader(ModelMap modelMap) {

        modelMap.addAttribute("reader", new Reader());

        return "reader/newReader";
    }

    @RequestMapping(value = "/reader/createReader", method = RequestMethod.POST)
    public String createReader(@Valid @ModelAttribute Reader reader, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "reader/newReader";
        }

        readerService.addReader(reader);

        return "redirect:/";
    }

    @RequestMapping(value = "/{id}/editReader", method = RequestMethod.GET)
    public String editReader(@PathVariable long id, Model model) {

        Reader reader = readerService.findOne(id);
        model.addAttribute("reader", reader);

        return "reader/editReader";
    }


    @RequestMapping(value = "/reader/updateReader", method = RequestMethod.POST)
    public String updateReader(@RequestParam("id") long id, @RequestParam("fullName") String fullName, @RequestParam("hasBook") String hasBook) {
        Reader reader = readerService.findOne(id);
        reader.setFullName(fullName);
        reader.setHasBook(hasBook);

        readerService.editReader(reader);

        return "redirect:/";
    }

    @RequestMapping(value = "/{id}/deleteReader", method = RequestMethod.GET)
    public String deleteReader(@PathVariable long id) {
        readerService.delete(id);
        return "redirect:/";
    }


    @RequestMapping(value = "/addNewBookLeading", method = RequestMethod.GET)
    public String takeBookBtn(ModelMap modelMap) {
        modelMap.addAttribute("bookLeading", new BookLeading());
        return "bookLeading/newBookLeading";
    }

    @RequestMapping(value = "/bookLeading/createBookLeading", method = RequestMethod.POST)
    public String createBookLeading(@Valid @ModelAttribute BookLeading bookLeading, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {

            return "bookLeading/newBookLeading";
        }

        bookLeadingService.addBookLeading(bookLeading);

        return "redirect:/";
    }

    @RequestMapping(value = "{id}/deleteBookLeading", method = RequestMethod.GET)
    public String deleteBookLeading(@PathVariable long id) {
        bookLeadingService.delete(id);

        return "redirect:/";
    }

}
