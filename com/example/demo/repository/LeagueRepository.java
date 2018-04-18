package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.League;


public interface LeagueRepository extends JpaRepository<League, Integer> {
	
	League findByLeagueName(String leagueName);
}
