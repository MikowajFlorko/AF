package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Club;

public interface ClubRepository extends JpaRepository<Club, Integer> {
	
	Club findByEnterEmail(String email);

}
