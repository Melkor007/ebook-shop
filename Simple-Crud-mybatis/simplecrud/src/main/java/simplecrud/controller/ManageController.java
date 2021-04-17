package simplecrud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import simplecrud.domain.Book;
import simplecrud.domain.User;
import simplecrud.service.BookService;
import simplecrud.service.OrderService;
import simplecrud.service.UserService;

import java.util.List;

/**
 * @ClassName: ManageController
 * @Description: TODO
 * @Author: Shadow Zhu
 * @Date: 2021/4/17 15:46
 * @Version: v1.0
 */
public class ManageController {

    @Autowired
    private BookService bookService;
    @Autowired
    private UserService userService;

    @GetMapping("/managerView")
    public String BookList(Model model) {
        List<Book> books = bookService.bookList();
        model.addAttribute("books", books);

        List<User> users = userService.u
        return "managerView";
    }

    @GetMapping("/book-list/buy/{book_id}")
    public String buy(Model model, @PathVariable int book_id){
        //int id = Integer.parseInt(req.getParameter("user_id"));
        orderService.insert(book_id, 10000000);
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
