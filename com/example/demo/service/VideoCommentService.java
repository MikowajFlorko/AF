package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.VideoComment;


public interface VideoCommentService {
	
	void save(VideoComment videoComment);
	List<VideoComment> findAll();
	VideoComment findOne(int id);
	void delete(int id);

}
