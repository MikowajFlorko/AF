package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Enter;


public interface EnterService {
	
	void save(Enter enter);
	List<Enter> findAll();
	Enter findOne(int id);
	void delete(int id);

}
