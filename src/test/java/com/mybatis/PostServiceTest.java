package com.mybatis;

import java.util.Date;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.bean.Post;
import com.service.BlogService;
import com.service.PostService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class PostServiceTest {

	@Autowired
	private PostService postService;
	@Autowired
	private BlogService blogService;

	@Test
	@Ignore
	public void testGetPostById() {
		Post post = postService.getAllPostByPostId(1);
		Assert.assertNotNull(post);
		System.out.println("Get post by ID : " + post);
		System.out.println();
	}

	@Test
	@Ignore
	public void testInsertPost() {
		Post post = new Post();
		post.setTitle("Day 3");
		post.setContent("I am not happy today");
		post.setCreatedOn(new Date());
		post.setBlog(blogService.getBlogById(1));
		Assert.assertNotNull(post);
		postService.insertPost(post);
		System.out.println(post);
	}
}
