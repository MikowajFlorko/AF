package com.example.demo.response;

import javax.persistence.OneToOne;

import com.example.demo.entity.Club;

public class ClubResponse {
	
	private int id;
	
	private String name;
	
	private int establishment;
	
	private String city;
	
	private String country;
	
	private String email;
	
	private String league;

	public ClubResponse(Club club) {
		this.id = club.getId();
		this.name = club.getName();
		this.establishment = club.getEstablishment();
		this.city = club.getCity().getCityName();
		this.country = club.getCountry().getCountryName();
		this.email = club.getEnter().getEmail();
		this.league = club.getLeague().getLeagueName();
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getEstablishment() {
		return establishment;
	}

	public void setEstablishment(int establishment) {
		this.establishment = establishment;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLeague() {
		return league;
	}

	public void setLeague(String league) {
		this.league = league;
	}

	@Override
	public String toString() {
		return "ClubResponse [id=" + id + ", name=" + name + ", establishment=" + establishment + ", city=" + city
				+ ", country=" + country + ", email=" + email + ", league=" + league + "]";
	}
		
}
