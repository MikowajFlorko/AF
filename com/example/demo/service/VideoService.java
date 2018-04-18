package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Video;


public interface VideoService {
	
	void save(Video video);
	List<Video> findAll();
	Video findOne(int id);
	void delete(int id);

}
