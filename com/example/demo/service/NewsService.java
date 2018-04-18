package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.News;

public interface NewsService {
	
	void save(News news);
	List<News> findAll();
	News findOne(int id);
	void delete(int id);

}
