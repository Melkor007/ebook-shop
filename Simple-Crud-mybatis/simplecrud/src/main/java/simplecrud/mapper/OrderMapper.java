package simplecrud.mapper;

import java.util.List;

import simplecrud.domain.Order;
import org.apache.ibatis.annotations.*;

@Mapper
public interface OrderMapper {

//	@Select("select * from order where order.order_id = #{order_id}")
//	@Results(id = "orderMap", value = {
//			//id表示主键v
//			@Result(id = true, column = "order_id", property = "order_id"),
//			@Result(column = "user_id", property = "user_id"),
//			@Result(column = "book_id", property = "book_id"),
//			@Result(column = "book_name", property = "book_name"),
//			@Result(column = "book_price", property = "book_price"),
//	})
//	List<Order> findById(int order_id);

	@Insert("insert into order values(null,#{user_id},#{book_id},#{book_name},#{book_price})")
	@Options(keyProperty = "order.order_id", useGeneratedKeys = true)
	void save(@Param("order") Order order);

	@Delete("delete * from order where order.order_id = #{order_id}")
	void delete(int order_id);


//	@Results(id = "orderMap", value = {
//			//id表示主键v
//			@Result(id = true, column = "order_id", property = "order_id"),
//			@Result(column = "user_id", property = "user_id"),
//			@Result(column = "book_id", property = "book_id"),
//			@Result(column = "book_name", property = "book_name"),
//			@Result(column = "book_price", property = "book_price"),
//	})
	@Select("select * from `order` where user_id = #{user_id}")
	List<Order> orderList(int user_id);
}
