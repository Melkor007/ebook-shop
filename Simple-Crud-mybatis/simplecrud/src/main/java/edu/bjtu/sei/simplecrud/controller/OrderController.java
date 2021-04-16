package edu.bjtu.sei.simplecrud.controller;


import edu.bjtu.sei.simplecrud.domain.Book;
import edu.bjtu.sei.simplecrud.domain.Order;
import edu.bjtu.sei.simplecrud.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private HttpServletRequest req;

    @RequestMapping("myOrder")
    public String myOrder(Model model) {
        int id = Integer.parseInt(req.getParameter("user_id"));
        List<Order> orders = orderService.findById(id);
        model.addAttribute("orders", orders);
        return "myOrder";
    }




}
