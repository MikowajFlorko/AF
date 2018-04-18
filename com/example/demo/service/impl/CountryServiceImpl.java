package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Country;
import com.example.demo.repository.CountryRepository;
import com.example.demo.service.CountryService;

@Service
public class CountryServiceImpl implements CountryService{
	
	@Autowired
	private CountryRepository countryRepository;
	
	@Override
	public void save(Country country) {
//		Country findCountry = countryRepository.findByCountryName(country.getCountryName());
//		if(findCountry != null) {
//				return;
//			}else {	
//				countryRepository.save(country);
//			}
		countryRepository.save(country);
		}
	@Override
	public List<Country> findAll() {
		return countryRepository.findAll();
	}
	@Override
	public Country findOne(int id) {
		return countryRepository.findOne(id);
	}
	@Override
	public void delete(int id) {
		countryRepository.delete(id);
	}
	public Country findByCountryName(String countryName) {
		return countryRepository.findByCountryName(countryName);
				
	}
}
