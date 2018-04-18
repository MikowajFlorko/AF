package com.example.demo.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Country {
	
	@Id
	@GeneratedValue(strategy  = GenerationType.IDENTITY)
	private int id;
	
	private String countryName;
	
	@OneToMany(mappedBy = "country")
	private List<City> city = new ArrayList<City>();
	
	@OneToMany(mappedBy = "country")
	private List<League> league = new ArrayList<League>();
	
	public Country() {}
	
	public Country(String countryName) {
	this.countryName = countryName;
}
	
	public Country(String countryName, List<League> league) {
		this.countryName = countryName;
		this.league = league;
	}

	public Country(String countryName, List<City> city, List<League> league) {
		this.countryName = countryName;
		this.city = city;
		this.league = league;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public List<City> getCity() {
		return city;
	}

	public void setCity(List<City> city) {
		this.city = city;
	}
	public List<League> getLeague() {
		return league;
	}

	public void setLeague(List<League> league) {
		this.league = league;
	}


	public Country(int id, String countryName, List<City> city) {
		this.id = id;
		this.countryName = countryName;
		this.city = city;
	}

	@Override
	public String toString() {
		return "Country [id=" + id + ", countryName=" + countryName + "]";
	}

}