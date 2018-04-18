package com.example.demo.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.example.demo.entity.Users;
import com.example.demo.request.LoginRequest;
import com.example.demo.request.MyPageRequest;
import com.example.demo.request.UserRegistRequest;
import com.example.demo.response.UsersResponse;


public interface UsersService {
	
	Users register(UserRegistRequest registerRequest);
	boolean loginUser(LoginRequest loginRequest);
	void save(Users users);
	List<Users> findAll();
	Users findOne(int id);
	void delete(int id);
	boolean deleteUsers(Integer id);
	Page<UsersResponse> findAll(MyPageRequest page);
	List<UsersResponse> findAllresp();
	
		
}
