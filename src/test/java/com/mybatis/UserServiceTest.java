package com.mybatis;

import java.time.Duration;
import java.time.Instant;
import java.util.List;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.bean.Blog;
import com.bean.PostsByUser;
import com.bean.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.service.BlogService;
import com.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserServiceTest {

	protected final ObjectMapper objectMapper = new ObjectMapper();

	@Autowired
	private UserService userService;

	@Autowired
	private BlogService blogService;

	@Test
	public void testGetUserById() {
		User user = userService.getUserById(1);
		Assert.assertNotNull(user);
		System.out.println("Find User id (1) : " + user);
		System.out.println();
	}

	@Test
	@Ignore
	public void testGetAllUsers() {
		List<User> users = userService.getAllUsers();
		Assert.assertNotNull(users);
		System.out.println("Find all users : ");
		for (User user : users) {
			System.out.println(user);
		}
		System.out.println();
	}

	@Test
	@Ignore
	public void testGetPostsByUser() {
		Blog blog = blogService.getBlogById(2);
		User user = userService.getUserById(7);
		List<PostsByUser> postsByUser = userService.getPostsByUser(blog, user);
		Assert.assertNotNull(postsByUser);
		for (PostsByUser userPost : postsByUser) {
			System.out.println(userPost);
		}
		System.out.println();
	}

	@Test
	@Ignore
	public void testInsertUsers() {
		User user = new User();
		user.setEmailId("test_email_" + System.currentTimeMillis() + "@gmail.com");
		user.setPassword("secretTest");
		user.setFirstName("TestFirstName");
		user.setLastName("TestLastName");
		user.setBlog(blogService.getBlogById(1));
		userService.insertUser(user);
		Assert.assertTrue(user.getUserId() != 0);
		User createdUser = userService.getUserById(user.getUserId());
		Assert.assertNotNull(createdUser);
		Assert.assertEquals(user.getEmailId(), createdUser.getEmailId());
		Assert.assertEquals(user.getPassword(), createdUser.getPassword());
		Assert.assertEquals(user.getFirstName(), createdUser.getFirstName());
		Assert.assertEquals(user.getLastName(), createdUser.getLastName());
	}

	@Ignore
	@Test
	public void testUpdateUser() {
		long timestamp = System.currentTimeMillis();
		User user = userService.getUserById(2);
		user.setFirstName("TestFirstName" + timestamp);
		user.setLastName("TestLastName" + timestamp);
		userService.updateUser(user);
		User updatedUser = userService.getUserById(2);
		Assert.assertEquals(user.getFirstName(), updatedUser.getFirstName());
		Assert.assertEquals(user.getLastName(), updatedUser.getLastName());
	}

	@Ignore
	@Test
	public void testDeleteUser() {
		User user = userService.getUserById(4);
		userService.deleteUser(user.getUserId());
		User deletedUser = userService.getUserById(4);
		Assert.assertNull(deletedUser);
	}

	@Test
	public void localCacheTest() throws JsonProcessingException, InterruptedException {

		Thread.sleep(5000);

		System.out.println("First："); // Get data from database initially
		Instant start = Instant.now();
		List<User> users = userService.getAllUsers();
		Instant end = Instant.now();
		System.out.println("1st time: {}" + objectMapper.writeValueAsString(users));
		System.out.println("Duration : " + Duration.between(start, end).getNano());

		System.out.println("Second："); // Get data from cache
		start = Instant.now();
		users = userService.getAllUsers();
		end = Instant.now();
		System.out.println("2nd time: {}" + objectMapper.writeValueAsString(users));
		System.out.println("Duration : " + Duration.between(start, end).getNano());

		Thread.sleep(5000);

		System.out.println("Third："); // After 5 s, Get from database
		start = Instant.now();
		System.out.println("3rd time: {}" + objectMapper.writeValueAsString(users));
		end = Instant.now();
		System.out.println("Duration : " + Duration.between(start, end).getNano());

		System.out.println("Fouth："); // Get from cache
		start = Instant.now();
		System.out.println("4th time: {}" + objectMapper.writeValueAsString(users));
		end = Instant.now();
		System.out.println("Duration : " + Duration.between(start, end).getNano());
	}
}