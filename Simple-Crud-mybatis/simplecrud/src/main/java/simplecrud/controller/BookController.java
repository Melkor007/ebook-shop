package simplecrud.controller;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import simplecrud.domain.Book;
import simplecrud.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import simplecrud.service.OrderService;
import simplecrud.service.UserService;

import java.security.Principal;
import java.util.List;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private UserService userService;
//    private Authentication auth;

    @RequestMapping("/book-list")
    public String BookList(Model model, Authentication auth) {
        List<Book> books = bookService.bookList();
        model.addAttribute("books", books);
        return "book-list";
    }

    @GetMapping("/book-list/buy/{book_id}")
    public String buy(Model model, @PathVariable int book_id, Authentication auth){
        //int id = Integer.parseInt(req.getParameter("user_id"));
        String username = auth.getName();
        int id = userService.findByName(username).getUser_id();
        orderService.insert(book_id, id);
        List<Book> books = bookService.bookList();
        model.addAttribute("books", books);
        return "redirect:/book-list";
    }

    @GetMapping("/book-list/update_price/{book_id}")
    public String update_price(Model model, @PathVariable Integer book_id){
        return "redirect:/book-list";
    }

    @RequestMapping("/book-list/insert")
    public String insert(Model model){
        return "abaaba";
    }

    @RequestMapping("/book-list/delete/{book_id}")
    public String delete(Model model, @PathVariable Integer book_id){
        return "abaaba";
    }


}
