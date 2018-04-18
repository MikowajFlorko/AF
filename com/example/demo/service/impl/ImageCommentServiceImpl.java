package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.ImageComment;
import com.example.demo.repository.ImageCommentRepository;
import com.example.demo.service.ImageCommentService;

@Service
public class ImageCommentServiceImpl implements ImageCommentService {

	@Autowired
	private ImageCommentRepository imageCommentRepository;
	
	public void save(ImageComment imageComment) {
		imageCommentRepository.save(imageComment);
		
	}

	public List<ImageComment> findAll() {
		return imageCommentRepository.findAll();
	}

	public ImageComment findOne(int id) {
		return imageCommentRepository.findOne(id);
	}

	public void delete(int id) {
		imageCommentRepository.delete(id);
		
	}
	
	
	}
