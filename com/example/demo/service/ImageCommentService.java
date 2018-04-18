package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.ImageComment;

public interface ImageCommentService {
	
	void save(ImageComment imageComment);
	List<ImageComment> findAll();
	ImageComment findOne(int id);
	void delete(int id);

}
