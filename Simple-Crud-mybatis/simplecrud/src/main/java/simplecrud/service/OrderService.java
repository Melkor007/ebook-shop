/**
 * Spring Boot + Thymeleaf Example 
 */
package simplecrud.service;

import simplecrud.domain.Book;
import simplecrud.domain.Order;
import simplecrud.exception.BadResourceException;
import simplecrud.exception.ResourceAlreadyExistsException;
import simplecrud.exception.ResourceNotFoundException;
import simplecrud.mapper.BookMapper;
import simplecrud.mapper.OrderMapper;
//import ContactRepository;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private BookMapper bookMapper;

    public List<Order> orderList(int user_id){
        return orderMapper.orderList(user_id);
    }

    public void insert(int book_id, int user_id){
        Book b = bookMapper.findById(book_id);
        String book_name = b.getBook_name();
        double book_price = b.getBook_price();
        orderMapper.insert(user_id, book_id, book_name, book_price);
    }

    public void delete(int order_id) {
        orderMapper.delete(order_id);
    }
//
//    private boolean existsById(int id) {
//    	Order order = (Order) orderRepository.findById(id);
//        return order != null;
//    }
//
//    public List<Order> findById(int id) throws ResourceNotFoundException {
//        List<Order> order = orderRepository.findById(id);
//        if (order ==null) {
//            throw new ResourceNotFoundException("Cannot find Order with id: " + id);
//        }
//        else return order;
//    }
//
//    public List<Order> findAll(int pageNumber, int rowPerPage) {
//        //        Pageable sortedByIdAsc = PageRequest.of(pageNumber - 1, rowPerPage,
////                Sort.by("id").ascending());
//        List<Order> orders = new ArrayList<>(orderRepository.findAll());
//		int size = orders.size();
//		int fromidx = (pageNumber-1)*rowPerPage;
//		if (fromidx>size) fromidx = 0;
//		int toidx = fromidx + rowPerPage;
//		if (toidx > size) toidx = size;
//
//		return orders.subList(fromidx, toidx);
//
////        return orders;
//    }
//
//    public void save(Order order) throws BadResourceException, ResourceAlreadyExistsException {
//        if (String.valueOf(order.getOrder_id()) != null) {
//            if (existsById(order.getOrder_id())) {
//                throw new ResourceAlreadyExistsException("Order with id: " + order.getOrder_id() +
//                        " already exists");
//            }
//            orderRepository.save(order);
//            //return order;
//        }
//        else {
//            BadResourceException exc = new BadResourceException("Failed to save order");
//            exc.addErrorMessage("Order is null or empty");
//            throw exc;
//        }
//    }
//
//    public void update(Order order)
//            throws BadResourceException, ResourceNotFoundException {
//        if (String.valueOf(order.getOrder_id()) != null) {
//            if (!existsById(order.getOrder_id())) {
//                throw new ResourceNotFoundException("Cannot find Order with id: " + order.getOrder_id());
//            }
//            orderRepository.update(order);
//        }
//        else {
//            BadResourceException exc = new BadResourceException("Failed to save order");
//            exc.addErrorMessage("Order is null or empty");
//            throw exc;
//        }
//    }
//
//    public void deleteById(int id) throws ResourceNotFoundException {
//        if (!existsById(id)) {
//            throw new ResourceNotFoundException("Cannot find contact with id: " + id);
//        }
//        else {
//            orderRepository.delete(id);
//        }
//    }
//
//    public int count() {
//
//        return orderRepository.findAll().size();
//    }
}
