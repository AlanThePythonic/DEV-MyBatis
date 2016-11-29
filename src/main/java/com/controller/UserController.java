package com.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.bean.User;
import com.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService service;

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

	@RequestMapping(value = "/getUserById", method = RequestMethod.GET)
	public @ResponseBody User getUserById(@RequestParam("userId") Integer userId) {
		User user = service.getUserById(userId);
		return user;
	}
}
