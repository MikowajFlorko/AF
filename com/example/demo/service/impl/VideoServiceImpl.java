package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Video;
import com.example.demo.repository.VideoCommentRepository;
import com.example.demo.repository.VideoNameRepository;
import com.example.demo.repository.VideoRepository;
import com.example.demo.service.VideoService;

@Service
public class VideoServiceImpl implements VideoService {

	@Autowired
	private VideoRepository videoRepository;
	@Autowired
	private VideoNameRepository videoNameRepository;
	@Autowired
	private VideoCommentRepository videoCommentRepository;
	
	public void save(Video video) {
		videoCommentRepository.save(video.getVideoComment());
		videoNameRepository.save(video.getVideoName());
		videoRepository.save(video);
		
	}

	public List<Video> findAll() {
		return videoRepository.findAll();
	}

	public Video findOne(int id) {
		return videoRepository.findOne(id);
	}

	public void delete(int id) {
		videoRepository.delete(id);		
	}

}
