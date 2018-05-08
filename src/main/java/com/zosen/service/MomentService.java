package com.zosen.service;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.zosen.entity.Moment;
import com.zosen.jpa.MomentJpa;

/**
 * 朋友圈管理
 * 
 * @author Zosen
 */
@Service
public class MomentService {

	@Autowired
	private MomentJpa momentJpa;

	public List<Moment> findByUserId(Integer userId) {
		Moment moment = new Moment();
		moment.setUserId(userId);
		Example<Moment> example = Example.of(moment);
		return momentJpa.findAll(example);
	}

	public Moment findById(Integer id) {
		return momentJpa.findOne(id);
	}

	@Transactional
	public Moment saveMoment(MultipartFile file, Integer userId, String content) {
		String image = null;
		if (file != null) {
			String fileName = file.getOriginalFilename();
			fileName = fileName.substring(fileName.indexOf(".") + 1);
			String front = "data:image/" + fileName + ";base64,";
			try {
				image = front + Base64.getEncoder().encodeToString(file.getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		Moment moment = new Moment();
		moment.setImage(image);
		moment.setUserId(userId);
		moment.setContent(content);
		return momentJpa.save(moment);
	}
}
