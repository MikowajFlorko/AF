package com.example.demo.service;

import java.io.IOException;
import java.util.List;

import com.example.demo.entity.Image;


public interface ImageService {
	
	Image savePhoto(Image image) throws IOException;
	List<Image> findAll();
	Image findOne(int id);
	void delete(int id);

}
