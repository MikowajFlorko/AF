package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class City {
	
	@Id
	@GeneratedValue(strategy  = GenerationType.IDENTITY)
	private int id;
	
	private String cityName;
	
	@ManyToOne
	private Country country;
		
	public City() {}
	
	public City(String cityName, Country country) {
		this.cityName = cityName;
		this.country = country;
	}
	public City(String cityName) {
	    this.cityName = cityName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
    }

	@Override
	public String toString() {
		return "City [id=" + id + ", cityName=" + cityName + "]";
	}
		
}