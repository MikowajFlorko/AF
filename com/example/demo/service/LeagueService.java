package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.League;


public interface LeagueService {
	
	void save(League league);
	List<League> findAll();
	League findOne(int id);
	void delete(int id);
	League findByNameLeague(String leagueName);

}
