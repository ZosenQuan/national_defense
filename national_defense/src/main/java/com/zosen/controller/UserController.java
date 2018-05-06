package com.zosen.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zosen.entity.User;
import com.zosen.service.UserService;

/**
 * 用户管理
 * @author Zosen
 */
@RestController("/user")
public class UserController {
	@Autowired
	private UserService userService;

	@RequestMapping
	@GetMapping
	public List<User> allUsers() {
		return userService.findAll();
	}
}
