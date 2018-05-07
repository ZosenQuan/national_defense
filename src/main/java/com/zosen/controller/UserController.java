package com.zosen.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zosen.entity.User;
import com.zosen.service.UserService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * 用户管理
 * 
 * @author Zosen
 */
@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;

	@ApiOperation("获取用户列表")
	@GetMapping
	public List<User> allUsers() {
		return userService.findAll();
	}

	@ApiOperation("根据id获取用户")
	@GetMapping("/{id}")
	public User findOne(@ApiParam(required = true, value = "用户id") @PathVariable Integer id) {
		return userService.findOne(id);
	}

	@ApiOperation("用户注册")
	@PostMapping("/register")
	public User register(@ApiParam(required = true, value = "用户信息") @RequestBody User user) {
		return userService.register(user);
	}
}
