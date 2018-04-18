package com.example.demo.service.impl;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.City;
import com.example.demo.repository.CityRepository;
import com.example.demo.service.CityService;

@Service
public class CityServiceImpl implements CityService {
	
	@Autowired
	private CityRepository cityRepository;
	
	@Override
	public void save(City city) {
		cityRepository.save(city);
	}
		@Override
	public List<City> findAll() {
		return cityRepository.findAll();
	}
		@Override
	public City findOne(int id) {
		return cityRepository.findOne(id); 
	}
		@Override
	public void delete(int id) {
		cityRepository.delete(id);
		
	}
	@Override
	public City findByCityName(String cityName) {
		return cityRepository.findByCityName(cityName);
	}
}
