package com.mybatis;

import java.util.Date;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import com.bean.Post;
import com.service.BlogService;
import com.service.PostService;

public class PostServiceTest {

	private static PostService postService;
	private static BlogService blogService;

	@BeforeClass
	public static void setup() {
		postService = new PostService();
		blogService = new BlogService();
	}

	@AfterClass
	public static void teardown() {
		postService = null;
		blogService = null;
	}

	@Test
	public void testGetPostById() {
		Post post = postService.getAllPostByPostId(1);
		Assert.assertNotNull(post);
		System.out.println("Get post by ID : " + post);
		System.out.println();
	}

	@Test
	public void testInsertPost() {
		Post post = new Post();
		post.setTitle("Day 3");
		post.setContent("I am not happy today");
		post.setCreatedOn(new Date());
		post.setBlog(blogService.getBlogById(1));
		Assert.assertNotNull(post);
		postService.insertPost(post);
		System.out.println(post);
		Assert.assertTrue(post.getPostId() != 0);
		Post createdPost = postService.getAllPostByPostId(post.getPostId());
		Assert.assertNotNull(createdPost);
		System.out.println();
	}
}
