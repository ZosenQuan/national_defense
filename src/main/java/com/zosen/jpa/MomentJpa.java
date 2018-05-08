package com.zosen.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zosen.entity.Moment;

public interface MomentJpa extends JpaRepository<Moment, Integer>{
}
