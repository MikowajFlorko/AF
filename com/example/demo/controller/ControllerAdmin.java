package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.request.DeleteClubRequest;
import com.example.demo.request.DeleteUserRequest;
import com.example.demo.request.MyPageRequest;
import com.example.demo.response.ClubResponse;
import com.example.demo.response.UsersResponse;
import com.example.demo.service.ClubService;
import com.example.demo.service.UsersService;

@CrossOrigin
@RestController
@RequestMapping("/admin")
public class ControllerAdmin {
	
	@Autowired
	private ClubService clubService;
	@Autowired
	private UsersService usersService;
		
	@PostMapping("/pageUser")
//	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public Page<UsersResponse> users(@RequestBody MyPageRequest myPageRequest){
		return usersService.findAll(myPageRequest);
	}
	
	
	@GetMapping
//	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public List<UsersResponse> findAlluser(){
		return usersService.findAllresp(); 
	}
	
	@GetMapping("/club")
//	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public List<ClubResponse> findAllclub(){
		return clubService.findAllResp(); 
	}
	
	@PostMapping("/pageClub")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public Page<ClubResponse> Club(@RequestBody MyPageRequest myPageRequest){
		return clubService.findAll(myPageRequest);
    }
	@DeleteMapping("/pageUser")
//	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public boolean deleteUser(@RequestBody DeleteUserRequest request){
		return usersService.deleteUsers(request.getId());
	}
	@DeleteMapping("/pageClub")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public boolean deleteClub(@RequestBody DeleteClubRequest request){
		return clubService.deleteClub(request.getId());
	}
 }