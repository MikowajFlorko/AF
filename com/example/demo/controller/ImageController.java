package com.example.demo.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Image;
import com.example.demo.service.ImageService;

@RestController
@RequestMapping("/image")
@CrossOrigin
public class ImageController {
	
	@Autowired
	private ImageService imageService;
	
	@PutMapping
	public Image savePhoto(@RequestBody Image image) throws IOException{
		return imageService.savePhoto(image);
	}

}
