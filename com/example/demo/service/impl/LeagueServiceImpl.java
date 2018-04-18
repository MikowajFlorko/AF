package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Country;
import com.example.demo.entity.League;
import com.example.demo.repository.CountryRepository;
import com.example.demo.repository.LeagueRepository;
import com.example.demo.service.LeagueService;

@Service
public class LeagueServiceImpl implements LeagueService {
	
	@Autowired
	private LeagueRepository leagueRepository;
	@Autowired
	private CountryRepository countryRepository;

	@Override
	public void save(League league) {
		League findLeague = leagueRepository.findByLeagueName(league.getLeagueName());
		Country findCountry = countryRepository.findByCountryName(league.getCountry().getCountryName());
		if(findCountry != null && findLeague !=null) {
			     return;			   
		}
		else if(findCountry != null) {
			     league.setCountry(findCountry);
			     leagueRepository.save(league);
		}else {	
				countryRepository.save(league.getCountry());
				leagueRepository.save(league);
			}
		}	

	@Override
	public List<League> findAll() {
		return leagueRepository.findAll();
	}

	@Override
	public League findOne(int id) {
		return leagueRepository.findOne(id);
	}

	@Override
	public void delete(int id) {
		leagueRepository.delete(id);
		
	}
	@Override
	public League findByNameLeague(String leagueName) {
		return leagueRepository.findByLeagueName(leagueName);
	}
}
