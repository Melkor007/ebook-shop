package simplecrud.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import simplecrud.domain.Book;
import simplecrud.domain.Order;
import simplecrud.exception.ResourceNotFoundException;
import simplecrud.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private HttpServletRequest req;

    @GetMapping("order-list")
    public String orderList(Model model) {
        //int id = Integer.parseInt(req.getParameter("user_id"));
        int id = 10000000;
        List<Order> orders = orderService.orderList(id);
        model.addAttribute("orders", orders);
        return "order-list";
    }

    @GetMapping("/order-list/delete/{order_id}")
    public String delete(Model model, @PathVariable int order_id) {
        //int id = Integer.parseInt(req.getParameter("user_id"));
        orderService.delete(order_id);
        int id = 10000000;
        List<Order> orders = orderService.orderList(id);
        model.addAttribute("orders", orders);
        return "redirect:/order-list";
    }


}
