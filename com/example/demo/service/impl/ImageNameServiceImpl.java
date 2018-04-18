package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.ImageName;
import com.example.demo.repository.ImageNameRepository;

import com.example.demo.service.ImageNameService;

@Service
public class ImageNameServiceImpl implements ImageNameService {
	
	@Autowired
	private ImageNameRepository imageNameRepository;

	public void save(ImageName imageName) {
		imageNameRepository.save(imageName);
		
	}

	public List<ImageName> findAll() {
		return imageNameRepository.findAll();
	}

	public ImageName findOne(int id) {
		return findOne(id);
	}

	public void delete(int id) {
		imageNameRepository.delete(id);
		
	}

	}
