package com.mybatis;

import java.util.List;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import com.bean.User;
import com.service.BlogService;
import com.service.UserService;

public class UserServiceTest {
	
	private static UserService userService;
	private static BlogService blogService;

	@BeforeClass
	public static void setup() {
		userService = new UserService();
		blogService = new BlogService();
	}

	@AfterClass
	public static void teardown() {
		userService = null;
		blogService = null;
	}

	@Test
	public void testGetUserById() {
		User user = userService.getUserById(1);
		Assert.assertNotNull(user);
		System.out.println("Find User id (1) : " + user);
		System.out.println();
	}

	@Test
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
	public void testInsertUserz() {
		User user = new User();
		user.setEmailId("test_email_" + System.currentTimeMillis() + "@gmail.com");
		user.setPassword("secret");
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
}