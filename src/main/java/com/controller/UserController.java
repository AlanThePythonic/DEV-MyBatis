package com.controller;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bean.User;
import com.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService service;

	/* Does not work on Rest Controller */
	@RequestMapping("/welcomeAll")
	public String hi(Map<String, Object> model) {
		model.put("user", service.getAllUsers());
		return "welcome";
	}

	@RequestMapping(value = "/getAllUsers", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<User> getAllUsers() {
		List<User> allUserList = service.getAllUsers();
		return allUserList;
	}

	@RequestMapping(value = "/getUserById", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody User getUserById(@RequestParam("userId") Integer userId) {
		User user = service.getUserById(userId);
		return user;
	}
}
