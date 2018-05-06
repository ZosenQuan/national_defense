package com.zosen.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zosen.entity.User;
import com.zosen.jpa.UserJpa;

/**
 * 用户管理
 * @author Zosen
 */
@Service
public class UserService {
	
	@Autowired
	private UserJpa userJpa;
	
	public List<User> findAll(){
		return userJpa.findAll();
	}
}
