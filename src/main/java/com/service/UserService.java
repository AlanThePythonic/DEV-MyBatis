package com.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bean.Blog;
import com.bean.PostsByUser;
import com.bean.User;
import com.mapper.UserMapper;

@Service
@Transactional
public class UserService implements BaseService {

	@Autowired
	private UserMapper userService;

	public void insertUser(User user) {
		userService.insertUser(user);
	}

	@Cacheable(value = "getUserById", sync = true)
	public User getUserById(Integer userId) {
		return userService.getUserById(userId);
	}

	@Cacheable(value = "getAllUser", sync = true)
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}

	public void updateUser(User user) {
		userService.updateUser(user);
	}

	public void deleteUser(Integer userId) {
		userService.deleteUser(userId);
	}

	public List<PostsByUser> getPostsByUser(Blog blog, User user) {
		return userService.getPostsByUser(blog.getBlogId(), user.getUserId());
	}
}
