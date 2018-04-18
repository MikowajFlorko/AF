package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.ImageName;

public interface ImageNameService {
	
	void save(ImageName imageName);
	List<ImageName> findAll();
	ImageName findOne(int id);
	void delete(int id);

}
