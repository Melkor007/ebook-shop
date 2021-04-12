/**
 * Spring Boot + Thymeleaf Example 
 */
package edu.bjtu.sei.simplecrud.service;

import edu.bjtu.sei.simplecrud.domain.Order;
import edu.bjtu.sei.simplecrud.exception.BadResourceException;
import edu.bjtu.sei.simplecrud.exception.ResourceAlreadyExistsException;
import edu.bjtu.sei.simplecrud.exception.ResourceNotFoundException;
import edu.bjtu.sei.simplecrud.mapper.OrderMapper;
//import edu.bjtu.sei.simplecrud.repository.ContactRepository;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class OrderService {
    
    @Autowired
    //private ContactRepository orderRepository;
    private OrderMapper orderRepository;
    
    private boolean existsById(int id) {
    	Order order = (Order) orderRepository.find(id);
        if (order ==null) {
            return false;
        }
        else return true;    
    }
    
    public Order findById(int id) throws ResourceNotFoundException {
        Order order = (Order) orderRepository.find(id);
        if (order ==null) {
            throw new ResourceNotFoundException("Cannot find Order with id: " + id);
        }
        else return order;
    }
    
    public List<Order> findAll(int pageNumber, int rowPerPage) {
        List<Order> orders = new ArrayList<>();
//        Pageable sortedByIdAsc = PageRequest.of(pageNumber - 1, rowPerPage, 
//                Sort.by("id").ascending());
        orderRepository.findAll().forEach(orders::add);
		int size = orders.size();
		int fromidx = (pageNumber-1)*rowPerPage;
		if (fromidx>size) fromidx = 0;
		int toidx = fromidx + rowPerPage;
		if (toidx > size) toidx = size;
		
		return orders.subList(fromidx, toidx);

//        return orders;
    }
    
    @SuppressWarnings("deprecation")
	public void save(Order order) throws BadResourceException, ResourceAlreadyExistsException {
        if (String.valueOf(order.getOrder_id()) != null) {
            if (existsById(order.getOrder_id())) {
                throw new ResourceAlreadyExistsException("Order with id: " + order.getOrder_id() +
                        " already exists");
            }
            orderRepository.save(order);
            //return order;
        }
        else {
            BadResourceException exc = new BadResourceException("Failed to save order");
            exc.addErrorMessage("Order is null or empty");
            throw exc;
        }
    }
    
    @SuppressWarnings("deprecation")
	public void update(Order order)
            throws BadResourceException, ResourceNotFoundException {
        if (String.valueOf(order.getOrder_id()) != null) {
            if (!existsById(order.getOrder_id())) {
                throw new ResourceNotFoundException("Cannot find Order with id: " + order.getOrder_id());
            }
            orderRepository.update(order);
        }
        else {
            BadResourceException exc = new BadResourceException("Failed to save order");
            exc.addErrorMessage("Order is null or empty");
            throw exc;
        }
    }
    
    public void deleteById(int id) throws ResourceNotFoundException {
        if (!existsById(id)) { 
            throw new ResourceNotFoundException("Cannot find contact with id: " + id);
        }
        else {
            orderRepository.delete(id);
        }
    }
    
    public int count() {
    	
        return orderRepository.findAll().size();
    }
}
