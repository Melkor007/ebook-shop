package edu.bjtu.sei.simplecrud.mapper;

//import java.util.List;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import edu.bjtu.sei.simplecrud.domain.User;

@Mapper
public interface UserMapper {

	  @Select("select * from user where user.user_id_num = #{user_id_num}")
	  @Results(id = "userMap",value = {
		  //id表示主键v
		  @Result(id = true,column = "user_id_num",property = "user_id_num"),
		  @Result(column = "user_password",property = "user_password"),
		  @Result(column = "user_name",property = "user_name"),
		  @Result(column = "user_phone_num",property = "user_phone_num"),
		  @Result(column = "user_role",property = "user_role"),
	  })
	  User findById(String user_id_num);

	@Select("select * from user where user.user_name = #{user_name}")
	@Results(id = "userMap",value = {
			//id表示主键v
			@Result(id = true,column = "user_id_num",property = "user_id_num"),
			@Result(column = "user_password",property = "user_password"),
			@Result(column = "user_name",property = "user_name"),
			@Result(column = "user_phone_num",property = "user_phone_num"),
			@Result(column = "user_role",property = "user_role"),
	})
	User findByName(String user_name);

	  @Insert("insert into user values(null,#{user.user_name},#{user.user_phone_num},#{user.user_role},#{user.user_password})")
	  @Options(keyProperty="user.user_id_num",useGeneratedKeys=true)
	  void save(@Param("user")User user);

	  @Delete("Delete * from user, order on user.user_id_num = order.user_id_num where user.user_id_num = #{user_id_num}")
	  void delete(String user_id_num);
}
