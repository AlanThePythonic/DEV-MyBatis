package com.mybatis;

import java.util.Date;
import java.util.List;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import com.bean.Blog;
import com.bean.Post;
import com.service.BlogService;
import com.service.PostService;

public class BlogServiceTest {

	private static BlogService blogService;
	private static PostService postService;

	@BeforeClass
	public static void setup() {
		blogService = new BlogService();
		postService = new PostService();
	}

	@AfterClass
	public static void teardown() {
		blogService = null;
		postService = null;
	}

	@Test
	@Ignore
	public void testGetBlogById() {
		Blog blog = blogService.getBlogById(1);
		Assert.assertNotNull(blog);
		System.out.println(blog);
	}

	@Test
	@Ignore
	public void testGetAllBlogs() {
		List<Blog> blogs = blogService.getAllBlogs();
		Assert.assertNotNull(blogs);
		for (Blog blog : blogs) {
			System.out.println(blog);
		}
	}
	@Test
	public void testGetPostsByBlog() {
		List<Post> posts = blogService.getPostsByBlog(blogService.getBlogById(1));
		Assert.assertNotNull(posts);
		for (Post post : posts) {
			System.out.println(post);
		}
	}

	@Test
	@Ignore
	public void testInsertBlog() {
		Blog blog = new Blog();
		blog.setBlogName("test_blog_" + System.currentTimeMillis());
		blog.setCreatedOn(new Date());
		blogService.insertBlog(blog);
		Assert.assertTrue(blog.getBlogId() != 0);
		Blog createdBlog = blogService.getBlogById(blog.getBlogId());
		Assert.assertNotNull(createdBlog);
		Assert.assertEquals(blog.getBlogName(), createdBlog.getBlogName());
	}

	@Test
	@Ignore
	public void testUpdateBlog() {
		long timestamp = System.currentTimeMillis();
		Blog blog = blogService.getBlogById(2);
		blog.setBlogName("TestBlogName" + timestamp);
		blogService.updateBlog(blog);
		Blog updatedBlog = blogService.getBlogById(2);
		Assert.assertEquals(blog.getBlogName(), updatedBlog.getBlogName());
	}

	@Test
	@Ignore
	public void testDeleteBlog() {
		Blog blog = blogService.getBlogById(4);
		blogService.deleteBlog(blog.getBlogId());
		Blog deletedBlog = blogService.getBlogById(4);
		Assert.assertNull(deletedBlog);
	}
}