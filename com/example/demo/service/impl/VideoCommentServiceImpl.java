package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.VideoComment;
import com.example.demo.repository.VideoCommentRepository;
import com.example.demo.service.VideoCommentService;

@Service
public class VideoCommentServiceImpl implements VideoCommentService {

	@Autowired
	private VideoCommentRepository videoCommentRepository;

	public void save(VideoComment videoComment) {
		videoCommentRepository.save(videoComment);
		
	}

	public List<VideoComment> findAll() {
		return videoCommentRepository.findAll();
	}

	public VideoComment findOne(int id) {
		return findOne(id);
	}

	public void delete(int id) {
		videoCommentRepository.delete(id);		
	}


	
	
}
