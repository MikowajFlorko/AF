package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Users;
import com.example.demo.response.UsersResponse;
import com.example.demo.service.ClubService;
import com.example.demo.service.UsersService;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class ControllerUsers {
	@Autowired
	private ClubService clubService;
	@Autowired
	private UsersService usersService;
	
	@GetMapping
//	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public Users findOne(int id){
		return usersService.findOne(id);
	}
}
