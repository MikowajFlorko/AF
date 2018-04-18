package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.ImageNews;

public interface ImageNewsService {

	void save(ImageNews imageNews);
	List<ImageNews> findAll();
	ImageNews findOne(int id);
	void delete(int id);
}
