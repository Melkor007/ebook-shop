package simplecrud.mapper;

//import java.util.List;

import org.apache.ibatis.annotations.*;

import simplecrud.domain.Book;
import simplecrud.domain.User;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("select * from user where user.user_id_num = #{user_id}")
    @Results(id = "findById", value = {
            //id表示主键v
            @Result(id = true, column = "user_id", property = "user_id"),
            @Result(column = "user_name", property = "user_name"),
            @Result(column = "user_password", property = "user_password"),
            @Result(column = "user_role", property = "user_role"),
    })
    User findById(int user_id);

    @Select("select * from user where user.user_name = #{user_name}")
    @Results(id = "findByName", value = {
            //id表示主键v
            @Result(id = true, column = "user_id", property = "user_id"),
            @Result(column = "user_name", property = "user_name"),
            @Result(column = "user_password", property = "user_password"),
            @Result(column = "user_role", property = "user_role"),
    })
    User findByName(String user_name);

    @Insert("insert into user values(null,#{user.user_name},#{user.user_password},#{user.user_role})")
    @Options(keyProperty = "user.user_id", useGeneratedKeys = true)
    void save(@Param("user") User user);

    @Delete("Delete * from user, order on user.user_id = order.user_id where user.user_id = #{user_id}")
    void delete(int user_id);

    @Select("select * from user")
    List<User> userList();
}
