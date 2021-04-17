package simplecrud.controller;


import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import simplecrud.domain.Book;
import simplecrud.domain.Order;
import simplecrud.exception.ResourceNotFoundException;
import simplecrud.mapper.BookMapper;
import simplecrud.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import simplecrud.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private HttpServletRequest req;

    @Autowired
    private UserService userService;

    @GetMapping("order-list")
    public String orderList(Model model, Authentication auth) {
        //int id = Integer.parseInt(req.getParameter("user_id"));
        String username = auth.getName();
        int id = userService.findByName(username).getUser_id();
        List<Order> orders = orderService.orderList(id);
        model.addAttribute("orders", orders);
        return "order-list";
    }

    @GetMapping("/order-list/delete/{order_id}")
    public String delete(Model model, @PathVariable int order_id, Authentication auth) {
        //int id = Integer.parseInt(req.getParameter("user_id"));
        orderService.delete(order_id);
        String username = auth.getName();
        int id = userService.findByName(username).getUser_id();
        List<Order> orders = orderService.orderList(id);
        model.addAttribute("orders", orders);
        return "redirect:/order-list";
    }


}
