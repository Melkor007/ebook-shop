package simplecrud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import simplecrud.domain.Book;
import simplecrud.domain.User;
import simplecrud.service.BookService;
import simplecrud.service.OrderService;
import simplecrud.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @ClassName: ManageController
 * @Description: TODO
 * @Author: Shadow Zhu
 * @Date: 2021/4/17 15:46
 * @Version: v1.0
 */
@Controller
public class ManageController {

    @Autowired
    private HttpServletRequest req;

    @Autowired
    private BookService bookService;
    @Autowired
    private UserService userService;

    @RequestMapping("/managerView")
    public String BookList(Model model) {
        List<Book> books = bookService.bookList();
        model.addAttribute("books", books);

        List<User> users = userService.userList();

        model.addAttribute("users", users);
        return "managerView";
    }

    @GetMapping("/managerView/deleteUser/{user_id}")
    public String deleteUser(Model model, @PathVariable int user_id){
//        userService.delete(user_id);
        userService.deleteuser(user_id);
        return "redirect:/managerView";
    }

    @PostMapping("/managerView/update_price")
    public String update_price(){
        String book_id = req.getParameter("book_id");
        String book_price = req.getParameter("book_price");
        bookService.update(Integer.valueOf(book_id),Double.valueOf(book_price));
        return "redirect:/managerView";
    }

    @GetMapping("/managerView/deleteBook/{book_id}")
    public String deleteBook(Model model, @PathVariable int book_id){
        bookService.delete(book_id);
        return "redirect:/managerView";
    }
}
