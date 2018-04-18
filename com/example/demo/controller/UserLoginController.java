package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.request.LoginRequest;
import com.example.demo.service.UsersService;

@RestController
@RequestMapping("/userLogin")
@CrossOrigin
public class UserLoginController {
	
	@Autowired
	private UsersService usersService;
	
	@PostMapping
	public boolean loginUser(@RequestBody LoginRequest loginRequest){
		return usersService.loginUser(loginRequest);
    }	
}