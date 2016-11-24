package com.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.util.MyBatisUtil;
import com.bean.Blog;
import com.bean.Post;
import com.mapper.BlogMapper;

public class BlogService {

	public void insertBlog(Blog blog) {

		try (SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession()) {
			BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);
			blogMapper.insertBlog(blog);
			sqlSession.commit();
		}
	}

	public Blog getBlogById(Integer blogId) {

		try (SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession()) {
			BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);
			return blogMapper.getBlogById(blogId);
		}
	}

	public List<Blog> getAllBlogs() {

		try (SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession()) {
			BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);
			return blogMapper.getAllBlogs();
		}
	}

	public void updateBlog(Blog blog) {

		try (SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession()) {
			BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);
			blogMapper.updateBlog(blog);
			sqlSession.commit();
		}
	}

	public void deleteBlog(Integer blogId) {

		try (SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession()) {
			BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);
			blogMapper.deleteBlog(blogId);
			sqlSession.commit();
		}
	}

	public List<Post> getPostsByBlog(Blog blog) {
		try (SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession()) {
			BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);
			return blogMapper.getPostsByBlog(blog);
		}
	}
}
