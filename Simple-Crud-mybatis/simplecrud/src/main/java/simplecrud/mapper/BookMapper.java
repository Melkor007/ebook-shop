package simplecrud.mapper;

//import java.util.List;

import simplecrud.domain.Book;
import org.apache.ibatis.annotations.*;
//import org.apache.ibatis.mapping.FetchType;
//import org.apache.ibatis.annotations.Results;
//import org.apache.ibatis.annotations.Result;
//import org.apache.ibatis.annotations.Insert;
//import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
//import org.apache.ibatis.annotations.Options;
//import org.apache.ibatis.annotations.Param;


@Mapper
public interface BookMapper {
	@Select("select * from book where id = #{book_id}")
    @Results(id = "findById", value = {
            //id表示主键v
            @Result(id = true, column = "book_id", property = "book_id"),
            @Result(column = "book_name", property = "book_name"),
            @Result(column = "book_author", property = "book_author"),
            @Result(column = "book_price", property = "book_price"),
    })
    Book findById(int book_id);

    @Select("select * from book where id = #{book_name}")
    @Results(id = "findByName", value = {
            //id表示主键v
            @Result(id = true, column = "book_id", property = "book_id"),
            @Result(column = "book_name", property = "book_name"),
            @Result(column = "book_author", property = "book_author"),
            @Result(column = "book_price", property = "book_price"),
    })
    Book findByName(String book_name);

    @Insert("insert into book values(null,#{book.book_name},#{book.book_author},#{book.book_price})")
    @Options(keyProperty = "book.book_id)", useGeneratedKeys = true)
    void save(@Param("book") Book book);

    @Delete("delete * from book, order on book.book_id = order.book_id where book.book_id = #{book_id}")
    void delete(int book_id);

    @Update("update book set book.book_price = #{book_price} where book.book_id = #{book_id}")
    void update(int book_id, double book_price);

    @Select("select * from book")
    List<Book> bookList();
}
