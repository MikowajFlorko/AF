package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.NewsComment;

public interface NewsCommentService {
	
	void save(NewsComment newsComment);
	List<NewsComment> findAll();
	NewsComment findOne(int id);
	void delete(int id);

}
