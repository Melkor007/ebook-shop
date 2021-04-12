package edu.bjtu.sei.simplecrud.controller;

import edu.bjtu.sei.simplecrud.domain.Order;
import edu.bjtu.sei.simplecrud.exception.ResourceNotFoundException;
import edu.bjtu.sei.simplecrud.service.OrderService;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class OrderController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Value("${msg.rows_per_page}")
    private int ROW_PER_PAGE;

    @Autowired
    private OrderService orderService;

    @Value("${msg.title}")
    private String title;

//    @GetMapping(value = {"/","/index"})
//    public String root() {
//    	
//        return "redirect:/contacts";
//    }

    
    @GetMapping(value = "/order")
    public String getContacts(Model model,
            @RequestParam(value = "page", defaultValue = "1") int pageNumber, HttpServletRequest request) {
    	
        @SuppressWarnings("unchecked")
        
		List<String> logs = (List<String>) request.getSession().getAttribute("LOGS_SESSION");
        //check if notes is present in session or not
        if (logs == null) {
            logs = new ArrayList<>();
            // if notes object is not present in session, set notes in the request session
            request.getSession().setAttribute("LOGS_SESSION", logs);
        }
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        //String log = request.getUserPrincipal().getName() + "/" + timeStamp + "/" + "list orders";
        String log = timeStamp + "/" + "list orders";
        logs.add(log);
        request.getSession().setAttribute("LOGS_SESSION", logs);

        List<Order> orders = orderService.findAll(pageNumber, ROW_PER_PAGE);

        long count = orderService.count();
        boolean hasPrev = pageNumber > 1;
        boolean hasNext = (pageNumber * ROW_PER_PAGE) < count;
        model.addAttribute("contacts", orders);
        model.addAttribute("hasPrev", hasPrev);
        model.addAttribute("prev", pageNumber - 1);
        model.addAttribute("hasNext", hasNext);
        model.addAttribute("next", pageNumber + 1);
        return "contact-list";
    }

    @GetMapping(value = "/contacts/{contactId}")
    public String getContactById(Model model, @PathVariable int contactId) {
        Order order = null;
        try {
            order = orderService.findById(contactId);
        } catch (ResourceNotFoundException ex) {
            model.addAttribute("errorMessage", "Order not found");
        }
        model.addAttribute("contact", order);
        model.addAttribute("contactimg","../images/p"+ contactId + ".jpg");
        return "contact";
    }

    @GetMapping(value = {"/contacts/add"})
    public String showAddContact(Model model) {
        Order order = new Order();
        model.addAttribute("add", true);
        model.addAttribute("contact", order);

        return "contact-edit";
    }

    @PostMapping(value = "/contacts/add")
    public String addContact(Model model,
            @ModelAttribute("contact") Order order) {
        try {
            //Order newContact = contactService.save(order);
        	orderService.save(order);
        	int p = (int) Math.ceil(orderService.count()/ROW_PER_PAGE)+1;
            return "redirect:/contacts?page=" + String.valueOf(p);
        } catch (Exception ex) {
            // log exception first, 
            // then show error
            String errorMessage = ex.getMessage();
            logger.error(errorMessage);
            model.addAttribute("errorMessage", errorMessage);

            //model.addAttribute("order", order);
            model.addAttribute("add", true);
            return "contact-edit";
        }        
    }

    @GetMapping(value = {"/contacts/{contactId}/edit"})
    public String showEditContact(Model model, @PathVariable int contactId) {
        Order order = null;
        try {
            order = orderService.findById(contactId);
        } catch (ResourceNotFoundException ex) {
            model.addAttribute("errorMessage", "Order not found");
        }
        model.addAttribute("add", false);
        model.addAttribute("contact", order);
        return "contact-edit";
    }

    @PostMapping(value = {"/contacts/{contactId}/edit"})
    public String updateContact(Model model,
            @PathVariable int contactId,
            @ModelAttribute("contact") Order order) {
        try {
            order.setOrder_id(contactId);
            orderService.update(order);
            return "redirect:/contacts/" + String.valueOf(order.getOrder_id());
        } catch (Exception ex) {
            // log exception first, 
            // then show error
            String errorMessage = ex.getMessage();
            logger.error(errorMessage);
            model.addAttribute("errorMessage", errorMessage);

             model.addAttribute("add", false);
            return "contact-edit";
        }
    }

    @GetMapping(value = {"/contacts/{contactId}/delete"})
    public String showDeleteContactById(
            Model model, @PathVariable int contactId) {
        Order order = null;
        try {
            order = orderService.findById(contactId);
        } catch (ResourceNotFoundException ex) {
            model.addAttribute("errorMessage", "Order not found");
        }
        model.addAttribute("allowDelete", true);
        model.addAttribute("contact", order);
        return "contact";
    }

    @PostMapping(value = {"/contacts/{contactId}/delete"})
    public String deleteContactById(
            Model model, @PathVariable int contactId) {
        try {
            orderService.deleteById(contactId);
            return "redirect:/contacts";
        } catch (ResourceNotFoundException ex) {
            String errorMessage = ex.getMessage();
            logger.error(errorMessage);
            model.addAttribute("errorMessage", errorMessage);
            return "contact";
        }
    }
}
