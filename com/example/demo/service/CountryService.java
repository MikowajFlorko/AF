package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Country;

public interface CountryService {
	
	void save(Country country);
	List<Country> findAll();
	Country findOne(int id);
	void delete(int id);
	Country findByCountryName(String countryName);
}
