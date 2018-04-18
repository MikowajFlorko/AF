package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.entity.Club;
import com.example.demo.request.ClubRegistRequest;
import com.example.demo.service.ClubService;

@RestController
@RequestMapping("/clubRegist")
@CrossOrigin
public class ClubRegistController {
	
	@Autowired
	private ClubService clubService;
	
	@PutMapping
	public Club register(@RequestBody ClubRegistRequest clubRegistRequest){
		return clubService.register(clubRegistRequest);
  }
}