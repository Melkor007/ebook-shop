package simplecrud.controller;


import simplecrud.domain.Order;
import simplecrud.exception.ResourceNotFoundException;
import simplecrud.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private HttpServletRequest req;

    @RequestMapping("/order-list")
    public String orderList(Model model) throws ResourceNotFoundException {
//        int id = Integer.parseInt(req.getParameter("user_id"));
        int id = 10000000;
        List<Order> orders = orderService.orderList(id);
        model.addAttribute("orders", orders);
        return "order-list";
    }




}
