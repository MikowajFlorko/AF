package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.City;



public interface CityService {
	
	void save(City city);
	List<City> findAll();
	City findOne(int id);
	void delete(int id);
	City findByCityName(String cityName);
}
