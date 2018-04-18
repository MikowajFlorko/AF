package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Enter;
import com.example.demo.repository.EnterRepository;
import com.example.demo.service.EnterService;

@Service
public class EnterServiceImpl implements EnterService {
	
	@Autowired
	private EnterRepository enterRepository;

	@Override
	public void save(Enter enter) {
		enterRepository.save(enter);
	}

	@Override
	public List<Enter> findAll() {
		return enterRepository.findAll();
	}

	@Override
	public Enter findOne(int id) {
		return enterRepository.findOne(id);
	}
	@Override
	public void delete(int id) {
		enterRepository.delete(id);		
	}
}
