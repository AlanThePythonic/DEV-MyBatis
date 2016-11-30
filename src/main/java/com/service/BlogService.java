package com.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.bean.Blog;
import com.bean.Post;
import com.mapper.BlogMapper;

@Service
@Transactional
public class BlogService implements BaseService {

	@Autowired
	private BlogMapper blogService;

	public void insertBlog(Blog blog) {
		blogService.insertBlog(blog);
	}

	public Blog getBlogById(Integer blogId) {
		return blogService.getBlogById(blogId);
	}

	public List<Blog> getAllBlogs() {
		return blogService.getAllBlogs();
	}

	public void updateBlog(Blog blog) {
		blogService.updateBlog(blog);
	}

	public void deleteBlog(Integer blogId) {
		blogService.deleteBlog(blogId);
	}

	@Cacheable(value = "getPostsByBlog", sync = true)
	public List<Post> getPostsByBlog(Blog blog) {
		return blogService.getPostsByBlog(blog);
	}
}
