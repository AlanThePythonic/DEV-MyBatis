package com.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.bean.Blog;
import com.bean.Post;
@Mapper
public interface BlogMapper {

	@Insert("INSERT INTO BLOG(BLOG_NAME, CREATED_ON) VALUES(#{blogName}, #{createdOn})")
	@Options(useGeneratedKeys = true, keyProperty = "blogId")
	public void insertBlog(Blog blog);

	@Select("SELECT BLOG_ID AS blogId, BLOG_NAME as blogName, CREATED_ON as createdOn FROM BLOG WHERE BLOG_ID=#{blogId}")
	public Blog getBlogById(@Param("blogId") Integer blogId);

	@Select("SELECT * FROM BLOG ")
	@Results({ @Result(id = true, property = "blogId", column = "BLOG_ID"),
			@Result(property = "blogName", column = "BLOG_NAME"),
			@Result(property = "createdOn", column = "CREATED_ON") })
	public List<Blog> getAllBlogs();

	@Update("UPDATE BLOG SET BLOG_NAME=#{blogName}, CREATED_ON=#{createdOn} WHERE BLOG_ID=#{blogId}")
	public void updateBlog(Blog blog);

	@Delete("DELETE FROM BLOG WHERE BLOG_ID=#{blogId}")
	public void deleteBlog(@Param("blogId") Integer blogId);

	@Select("SELECT POST_ID AS postId, TITLE as title, CREATED_ON as createdOn FROM POST WHERE BLOG_ID=#{blogId}")
	@Results({ @Result(id = true, property = "postId", column = "POST_ID"),
			@Result(property = "title", column = "TITLE"), @Result(property = "createdOn", column = "CREATED_ON") })
	public List<Post> getPostsByBlog(Blog blog);
}
