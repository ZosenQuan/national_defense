package com.zosen.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zosen.entity.User;
import com.zosen.jpa.UserJpa;

/**
 * 用户管理
 * 
 * @author Zosen
 */
@Service
public class UserService {

	@Autowired
	private UserJpa userJpa;

	public List<User> findAll() {
		return userJpa.findAll();
	}

	public User findOne(Integer id) {
		return userJpa.getOne(id);
	}

	@Transactional
	public User register(User user) {
		return userJpa.save(user);
	}
}
