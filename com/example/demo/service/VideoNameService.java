package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.VideoName;


public interface VideoNameService {
	
	void save(VideoName videoName);
	List<VideoName> findAll();
	VideoName findOne(int id);
	void delete(int id);

}
