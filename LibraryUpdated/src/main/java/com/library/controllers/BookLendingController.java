package com.library.controllers;


import com.library.domain.BookLending;
import com.library.services.BookLendingService;
import com.library.services.BookService;
import com.library.services.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;


@Controller
@RequestMapping("/bookLeading")
public class BookLendingController {

    @Autowired
    private BookLendingService bookLeadingService;

    @Autowired
    private BookService bookService;

    @Autowired
    private MemberService readerService;

    @RequestMapping(method= RequestMethod.GET)
    public String bookLeadingFrame(Model model){
        List<BookLending> getAll = bookLeadingService.getAll();
        model.addAttribute("bookLeadings",getAll);
        return "bookLeading/bookLeading";
    }

    @RequestMapping(value="/addNewBookLeading",method=RequestMethod.GET)
    public String addBookLeading(Model model){
        model.addAttribute("bookLeading",new BookLending());
        model.addAttribute("books",bookService.getAll());
        model.addAttribute("readers",readerService.getAll());
        return "bookLeading/newBookLeading";
    }

    @RequestMapping(value="/createBookLeading",method=RequestMethod.POST)
    public String createBookLeading(@ModelAttribute BookLending bookLeading){
        bookLeadingService.addBookLeading(bookLeading);
        return "redirect:/bookLeading";
    }

    @RequestMapping(value="/{id}/deleteBookLeading",method=RequestMethod.GET)
    public String delete(@PathVariable long id){
        bookLeadingService.delete(id);
        return "redirect:/bookLeading";
    }

}
