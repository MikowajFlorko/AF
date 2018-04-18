package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.VideoName;
import com.example.demo.repository.VideoNameRepository;
import com.example.demo.service.VideoNameService;

@Service
public class VideoNameServiceImpl implements VideoNameService {

	@Autowired
	private VideoNameRepository videoNameRepository;
	
	public void save(VideoName videoName) {
		videoNameRepository.save(videoName);
		
	}

	public List<VideoName> findAll() {
		return videoNameRepository.findAll();
	}

	public VideoName findOne(int id) {
		return videoNameRepository.findOne(id);
	}

	public void delete(int id) {
		videoNameRepository.delete(id);
		
	}

}
