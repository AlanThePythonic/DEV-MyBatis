package com.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.One;
import com.bean.Blog;
import com.bean.User;

public interface UserMapper {

	@Insert("INSERT INTO USER(user_id, email_id, password, first_name, last_name, blog_id) VALUES (#{userId}, #{emailId}, #{password}, #{firstName}, #{lastName}, #{blog.blogId})")
	@Options(useGeneratedKeys = true, keyProperty = "userId")
	public void insertUser(User user);

	@Select("SELECT user_id as userId, email_id as emailId , password, first_name as firstName, last_name as lastName, blog_id FROM USER WHERE USER_ID = #{userId}")
	@Results({ @Result(property = "userId", column = "user_id"), @Result(property = "emailId", column = "email_id"),
			@Result(property = "password", column = "password"), @Result(property = "firstName", column = "first_name"),
			@Result(property = "lastName", column = "last_name"),
			@Result(property = "blog", column = "blog_id", javaType = Blog.class, one = @One(select = "com.mapper.BlogMapper.getBlogById")) })
	public User getUserById(Integer userId);

	@Select("SELECT * FROM USER")
	@Results({ @Result(property = "userId", column = "user_id"), @Result(property = "emailId", column = "email_id"),
			@Result(property = "password", column = "password"), @Result(property = "firstName", column = "first_name"),
			@Result(property = "lastName", column = "last_name"),
			@Result(property = "blog", column = "blog_id", javaType = Blog.class, one = @One(select = "com.mapper.BlogMapper.getBlogById")) })
	public List<User> getAllUsers();

	@Update("UPDATE USER SET PASSWORD= #{password}, FIRST_NAME = #{firstName}, LAST_NAME = #{lastName} WHERE USER_ID = #{userId}")
	public void updateUser(User user);

	@Delete("DELETE FROM USER WHERE USER_ID = #{userId}")
	public void deleteUser(Integer userId);

}