package edu.bjtu.sei.simplecrud.controller;

import edu.bjtu.sei.simplecrud.domain.Book;
import edu.bjtu.sei.simplecrud.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping("/book-list")
    public String BookList(Model model) {
        List<Book> books = bookService.booklist();
        model.addAttribute("books", books);

        return "book-list";
    }

    @RequestMapping("/book-list/buy/{book_id}")
    public String buy(Model model, @PathVariable Integer book_id){

    }

    @RequestMapping("/book-list/update_price/{book_id}")
    public String update_price(Model model, @PathVariable Integer book_id){

    }

    @RequestMapping("/book-list/insert")
    public String insert(Model model){

    }

    @RequestMapping("/book-list/delete/{book_id}")
    public String delete(Model model, @PathVariable Integer book_id){

    }


}
