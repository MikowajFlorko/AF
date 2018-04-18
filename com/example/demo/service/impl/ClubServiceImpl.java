package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.demo.entity.City;
import com.example.demo.entity.Club;
import com.example.demo.entity.Country;
import com.example.demo.entity.Enter;
import com.example.demo.entity.League;
import com.example.demo.entity.Role;
import com.example.demo.entity.Users;
import com.example.demo.repository.CityRepository;
import com.example.demo.repository.ClubRepository;
import com.example.demo.repository.CountryRepository;
import com.example.demo.repository.EnterRepository;
import com.example.demo.repository.LeagueRepository;
import com.example.demo.request.ClubRegistRequest;
import com.example.demo.request.LoginRequest;
import com.example.demo.request.MyPageRequest;
import com.example.demo.response.ClubResponse;
import com.example.demo.response.UsersResponse;
import com.example.demo.service.ClubService;

@Service
public class ClubServiceImpl implements ClubService {
	
	
	@Autowired
	private ClubRepository clubRepository;
	@Autowired
	private CityRepository cityRepository;
	@Autowired
	private CountryRepository countryRepository;
	@Autowired
	private LeagueRepository leagueRepository;
	@Autowired
	private EnterRepository enterRepository;

	@Override
	public void save(Club club) {
		clubRepository.save(club);
	}
	@Override
	public List<Club> findAll() {
		return clubRepository.findAll();
	}
	@Override
	public Club findOne(int id) {
		return clubRepository.findOne(id);
	}
	@Override
	public void delete(int id) {
		cityRepository.delete(id);
		
	}
	@Override
	public Club register(ClubRegistRequest clubRegistRequest) {
		Enter findEnter = enterRepository.findByEmail(clubRegistRequest.getEmail());
		if(findEnter == null) {
		City findCity = cityRepository.findByCityName(clubRegistRequest.getCityName());
		Country findCountry = countryRepository.findByCountryName(clubRegistRequest.getCountryName());
		League findLeague = leagueRepository.findByLeagueName(clubRegistRequest.getLeague());
		if(findCountry != null && findCity != null && findLeague !=null) {
			Role role = Role.ROLE_USER;
			Enter enter = new Enter(clubRegistRequest.getEmail(), clubRegistRequest.getPassword());
			Club club = new Club(clubRegistRequest.getName(), clubRegistRequest.getEstablishment(), findCity, findCountry, enter, findLeague, role);
			club.setCountry(findCountry);
			club.setCity(findCity);
			club.setLeague(findLeague);			
			return clubRepository.save(club);
			}else if(findCountry != null && findCity != null && findLeague == null) {
				Role role = Role.ROLE_USER;
				League league = new League(clubRegistRequest.getLeague(), findCountry);
				Enter enter = new Enter(clubRegistRequest.getEmail(), clubRegistRequest.getPassword());
				Club club = new Club(clubRegistRequest.getName(), clubRegistRequest.getEstablishment(), findCity, findCountry, enter, league, role);
			    club.setCountry(findCountry);
				club.setCity(findCity);
				leagueRepository.save(club.getLeague());
				enterRepository.save(enter);
				return clubRepository.save(club);
				}
		    else if(findCountry != null && findLeague != null && findCity == null) {
		    	Role role = Role.ROLE_USER;
		    	City city = new City(clubRegistRequest.getCityName(), findCountry);
		    	Enter enter = new Enter(clubRegistRequest.getEmail(), clubRegistRequest.getPassword());
				Club club = new Club(clubRegistRequest.getName(), clubRegistRequest.getEstablishment(), city, findCountry, enter, findLeague, role);
			    club.setCountry(findCountry);
			    club.setLeague(findLeague);
			    cityRepository.save(club.getCity());
			    enterRepository.save(enter);
				return clubRepository.save(club);
			}
			else if(findCountry != null && findCity == null && findLeague == null){
				Role role = Role.ROLE_USER;
				League league = new League(clubRegistRequest.getLeague(), findCountry);
				City city = new City(clubRegistRequest.getCityName(), findCountry);
		    	Enter enter = new Enter(clubRegistRequest.getEmail(), clubRegistRequest.getPassword());
				Club club = new Club(clubRegistRequest.getName(), clubRegistRequest.getEstablishment(), city, findCountry, enter, league, role);
			    club.setCountry(findCountry);
				leagueRepository.save(club.getLeague());
				city.setCountry(findCountry);
				cityRepository.save(club.getCity());
				enterRepository.save(enter);
				return clubRepository.save(club);
			}else {				
				Country country = new Country(clubRegistRequest.getCountryName());
				City city = new City(clubRegistRequest.getCityName(), country);
				Role role = Role.ROLE_USER;
				League league = new League(clubRegistRequest.getLeague(), country);
				Enter enter = new Enter(clubRegistRequest.getEmail(), clubRegistRequest.getPassword());
				Club club = new Club(clubRegistRequest.getName(), clubRegistRequest.getEstablishment(), city, country, enter, league, role);
			    countryRepository.save(country);
				leagueRepository.save(league);
				cityRepository.save(city);
				enterRepository.save(enter);
				return clubRepository.save(club);
			}
		}else{
			throw new IllegalArgumentException("Login or password is incorrect");
		}
		
}
//	@Override
//	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//		return clubRepository.findByEnterEmail(email);
//	}
	@Override
	public boolean loginClub(LoginRequest loginRequest) {
		if (loginRequest != null) {
			Enter enter = enterRepository.findByEmail(loginRequest.getEmail());
			if (enter != null) {
				if (enter.getPassword().equals(loginRequest.getPassword())) {
					clubRepository.findOne(enter.getId());
				return true;
				} else {
					throw new IllegalArgumentException("Login or password is incorrect");
				}
			} else {
				throw new IllegalArgumentException("Login or password is incorrect");
			}
		} else {
			throw new IllegalArgumentException("LoginRequest not be null");
		}
	}
	private ClubResponse convert(Club club) {
		return new ClubResponse(club);
	}
	@Override
	public Page<ClubResponse> findAll(MyPageRequest page) {
		PageRequest pageRequest = new PageRequest(page.getNumberPage(),page.getSizePage());
		Page<Club> pageClub =  clubRepository.findAll(pageRequest);
		Page<ClubResponse> pageClubResponse = pageClub.map(this::convert);
		return pageClubResponse;
	}
	@Override
	public boolean deleteClub(Integer id) {
		clubRepository.delete(id);
		return true;
	}
	
	@Override
	public List<ClubResponse> findAllResp() {
		List<Club> findAll = clubRepository.findAll();
		List<ClubResponse> us = new ArrayList();
		for (Club clubs : findAll) {
	    ClubResponse response = convert(clubs);
		us.add(response);
	}
		return us;
}
}
