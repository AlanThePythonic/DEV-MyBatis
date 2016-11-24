package com.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import com.bean.Post;
import com.bean.Blog;

public interface PostMapper {

	@Select("SELECT post_id as postId, title, content, created_on as createOn, blog_id as blogId FROM POST WHERE POST_ID = #{postId}")
	@Results({ @Result(id = true, property = "postId", column = "post_id"),
			@Result(property = "title", column = "title"), @Result(property = "content", column = "content"),
			@Result(property = "createdOn", column = "created_on"),
			@Result(property = "blogId", column = "blog_id", javaType = Blog.class, one = @One(select = "com.mapper.BlogMapper.getBlogById")) })
	public Post getAllPostByPostId(@Param("postId") int postId);

	@Insert("INSERT INTO POST(title, content, created_on, blog_id) VALUES (#{title}, #{content}, #{createdOn}, #{blog.blogId})")
	@Options(useGeneratedKeys = true, keyProperty = "postId")
	public void insertPost(Post post);
}
