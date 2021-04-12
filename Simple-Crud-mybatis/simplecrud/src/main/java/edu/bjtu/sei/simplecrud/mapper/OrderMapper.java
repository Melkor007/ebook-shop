package edu.bjtu.sei.simplecrud.mapper;

import java.util.List;

import edu.bjtu.sei.simplecrud.domain.Order;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper {
	
		void save(Order order);
		
		void delete(int id);
		
		void update(Order order);
		
		Order find(int id);
		
		List<Order> findAll();

		boolean existsById(int id);
		
}
