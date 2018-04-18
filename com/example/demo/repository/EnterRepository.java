package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Enter;

public interface EnterRepository extends JpaRepository<Enter, Integer> {

	Enter findByEmail(String email);
		
	
}
