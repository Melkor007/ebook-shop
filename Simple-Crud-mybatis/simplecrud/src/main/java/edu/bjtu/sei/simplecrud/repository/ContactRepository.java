package edu.bjtu.sei.simplecrud.repository;

import edu.bjtu.sei.simplecrud.domain.Order;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class ContactRepository {

	private List<Order> lista = new ArrayList<Order>();

	public ContactRepository() {
		Order s = new Order();

	}


	public boolean existsById(Long id) {
		// TODO Auto-generated method stub
		boolean isExist = false;
		for (int i = 0; i < lista.size(); i++) {
			if (lista.get(i).getOrder_id() == id) {
				isExist = true;
				break;
			}
		}

		return isExist;
	}

	public Object findById(int id) {
		// TODO Auto-generated method stub
		Order s = null;
		for (int i = 0; i < lista.size(); i++) {
			if (lista.get(i).getOrder_id() == id) {
				s = lista.get(i);
				break;
			}
		}
		return s;
	}

	public Order save(Order order) {
		// TODO Auto-generated method stub
		order.setOrder_id((int)lista.size());
		lista.add(order);
		return order;
	}

	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}

	public Long count() {
		// TODO Auto-generated method stub
		
		return (long) lista.size();
	}

	public Iterable<Order> findAll() {
		// TODO Auto-generated method stub
		return lista;
	}


	public Iterable<Order> findAll(int pageNumber, int rowPerPage) {
		// TODO Auto-generated method stub
		int size = lista.size();
		int fromidx = (pageNumber-1)*rowPerPage;
		if (fromidx>size) fromidx = 0;
		int toidx = fromidx + rowPerPage;
		if (toidx > size) toidx = size;
		
		return lista.subList(fromidx, toidx);
	}
}

