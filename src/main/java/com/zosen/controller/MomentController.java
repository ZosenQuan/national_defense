package com.zosen.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.zosen.entity.Moment;
import com.zosen.service.MomentService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * 朋友圈管理
 * 
 * @author Zosen
 */
@RestController
@RequestMapping("/moments")
public class MomentController {

	@Autowired
	private MomentService momentService;

	@ApiOperation("获取用户朋友圈")
	@GetMapping
	public List<Moment> findAll(
			@ApiParam(required = true, value = "用户id") @RequestParam(required = true) Integer userId) {
		return momentService.findByUserId(userId);
	}

	@ApiOperation("根据id获取朋友圈记录")
	@GetMapping("/{id}")
	public Moment findOne(@ApiParam(required = true, value = "朋友圈记录id") @PathVariable Integer id) {
		return momentService.findById(id);
	}

	@ApiOperation("保存朋友圈记录")
	@PostMapping("/save")
	public Moment saveMoment(
			@ApiParam(required = true, value = "朋友圈文件") @RequestParam(value = "file", required = false) MultipartFile file,
			@ApiParam(required = true, value = "用户id") @RequestParam(required = true) Integer userId,
			@ApiParam(required = true, value = "内容") @RequestParam(required = true) String content) {
		return momentService.saveMoment(file, userId, content);
	}
}
