package com.zosen.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zosen.entity.User;

public interface UserJpa extends JpaRepository<User, Integer>{
}
