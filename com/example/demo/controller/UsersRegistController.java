package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Users;
import com.example.demo.request.DeleteUserRequest;
import com.example.demo.request.LoginRequest;
import com.example.demo.request.MyPageRequest;
import com.example.demo.request.UserRegistRequest;
import com.example.demo.response.UsersResponse;
import com.example.demo.service.UsersService;

@RestController
@RequestMapping("/userRegist")
@CrossOrigin
public class UsersRegistController {
	
	@Autowired
	private UsersService usersService;
	
	@PostMapping("/page")
	@PreAuthorize("hasRole('ROLE_USER')")
	public Page<UsersResponse> users(@RequestBody MyPageRequest myPageRequest){
		return usersService.findAll(myPageRequest);
	}
	
	@PutMapping
	public Users register(@RequestBody UserRegistRequest registerRequest){
		return usersService.register(registerRequest);
	}
	@PostMapping
	public boolean login(@RequestBody LoginRequest loginRequest){
		return usersService.loginUser(loginRequest);
	}
	
	@DeleteMapping
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public boolean delete(@RequestBody DeleteUserRequest request){
		return usersService.deleteUsers(request.getId());
	}
	
}
