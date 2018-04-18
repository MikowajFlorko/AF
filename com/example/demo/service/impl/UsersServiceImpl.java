package com.example.demo.service.impl;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyList;
import static org.mockito.Matchers.anyListOf;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.loader.custom.Return;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.entity.City;
import com.example.demo.entity.Country;
import com.example.demo.entity.Enter;
import com.example.demo.entity.Role;
import com.example.demo.entity.Users;
import com.example.demo.repository.CityRepository;
import com.example.demo.repository.CountryRepository;
import com.example.demo.repository.EnterRepository;
import com.example.demo.repository.UsersRepository;
import com.example.demo.request.LoginRequest;
import com.example.demo.request.MyPageRequest;
import com.example.demo.request.UserRegistRequest;
import com.example.demo.response.UsersResponse;
import com.example.demo.service.UsersService;

@Service
public class UsersServiceImpl implements UsersService,UserDetailsService {

	@Autowired
	private UsersRepository usersRepository;
	@Autowired
	private CityRepository cityRepository;
	@Autowired
	private CountryRepository countryRepository;
	@Autowired
	private EnterRepository enterRepository;
	@Autowired
	private UsersService usersService;
	
	@Override
	public void save(Users users) {
		usersRepository.save(users);
	}
	@Override		
	public List<Users> findAll() {
		return usersRepository.findAll();
	}
	
	@Override
	public boolean loginUser(LoginRequest loginRequest) {
		if (loginRequest != null) {
			Enter enter = enterRepository.findByEmail(loginRequest.getEmail());
			if (enter != null) {
				if (enter.getPassword().equals(loginRequest.getPassword())) {
					usersRepository.findOne(enter.getId());
				return true;
				} else {
					throw new IllegalArgumentException("Login or password is incorrect");
				}
			} else {
				throw new IllegalArgumentException("Login or password is incorrect");
			}
		} else {
			throw new IllegalArgumentException("LoginRequest not be null");
		}
	}
	@Override
	public Users findOne(int id) {
		return usersRepository.findOne(id);
	}
	@Override
	public void delete(int id) {	
		Users findUsers = usersRepository.findOne(id);
		usersRepository.delete(id);		
		enterRepository.delete(findUsers.getEnter());
		
	}
	@Override
	public Users register(UserRegistRequest registerRequest) {
		Enter findEnter = enterRepository.findByEmail(registerRequest.getEmail());
		if(findEnter == null) {
		City findCity = cityRepository.findByCityName(registerRequest.getCityName());
		Country findCountry = countryRepository.findByCountryName(registerRequest.getCountryName());
//		Enter findEnter = enterRepository.findByEmail(registerRequest.getEmail());
//		if(findEnter != null) {
		    if(findCountry != null && findCity != null) {
		    	Role role = Role.ROLE_USER;
				Enter enter = new Enter(registerRequest.getEmail(), registerRequest.getPassword());
		    	Users users = new Users(registerRequest.getName(), registerRequest.getSurname(), registerRequest.getDateBorn(), enter,findCountry, findCity, role);
				users.setCountry(findCountry);
				users.setCity(findCity);
				enterRepository.save(enter);
				usersRepository.save(users);				
				return usersRepository.save(users);
			}else if(findCountry != null && findCity == null){
				Country country = new Country(registerRequest.getCountryName());
				City city = new City(registerRequest.getCityName(), country);
				Role role = Role.ROLE_USER;
				Enter enter = new Enter(registerRequest.getEmail(), registerRequest.getPassword());
				Users users = new Users(registerRequest.getName(), registerRequest.getSurname(), registerRequest.getDateBorn(), enter,country, city, role);
				users.setCountry(findCountry);
				city.setCountry(findCountry);
				cityRepository.save(city);				
				enterRepository.save(enter);
				return usersRepository.save(users);
			}else{		
				Country country = new Country(registerRequest.getCountryName());
				City city = new City(registerRequest.getCityName(), country);
				Role role = Role.ROLE_USER;
				Enter enter = new Enter(registerRequest.getEmail(), registerRequest.getPassword());
				Users users = new Users(registerRequest.getName(), registerRequest.getSurname(), registerRequest.getDateBorn(), enter,country, city, role);
				countryRepository.save(city.getCountry());
				cityRepository.save(city);
				enterRepository.save(enter);
				return usersRepository.save(users);
			}
		}
	else{
				throw new IllegalArgumentException("Login or password is incorrect");
			}
	}
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		return usersRepository.findByEnterEmail(email);
	}
	private UsersResponse convert(Users user) {
		return new UsersResponse(user);		
	}
	@Override
	public Page<UsersResponse> findAll(MyPageRequest page) {
		PageRequest pageRequest = new PageRequest(page.getNumberPage(),page.getSizePage());
		Page<Users> pageUsers =  usersRepository.findAll(pageRequest);
		Page<UsersResponse> pageUsersResponse = pageUsers.map(this::convert);
		return pageUsersResponse;
	}
	
	@Override
	public boolean deleteUsers(Integer id) {
		Users findUsers = usersRepository.findOne(id);
		usersRepository.delete(id);
		enterRepository.delete(findUsers.getEnter());
		return true;
	}
	@Override
	public List<UsersResponse> findAllresp() {
		List<Users> findAll = usersRepository.findAll();
		List<UsersResponse> us = new ArrayList();
		for (Users users : findAll) {
		UsersResponse response = convert(users);
		us.add(response);
	}
		return us;
}
}