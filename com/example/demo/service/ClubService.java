package com.example.demo.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.example.demo.entity.Club;
import com.example.demo.request.ClubRegistRequest;
import com.example.demo.request.LoginRequest;
import com.example.demo.request.MyPageRequest;
import com.example.demo.response.ClubResponse;


public interface ClubService {
	
	Club register(ClubRegistRequest clubRegistRequest);
	void save(Club club);
	List<Club> findAll();
	Club findOne(int id);
	void delete(int id);
	boolean deleteClub(Integer id);
	boolean loginClub(LoginRequest loginRequest);
	Page<ClubResponse> findAll(MyPageRequest page);
	List<ClubResponse> findAllResp();
	
}
