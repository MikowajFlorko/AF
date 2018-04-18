package com.example.demo.response;

import java.text.DateFormat;
import java.util.Calendar;

import com.example.demo.entity.Users;

public class UsersResponse {
	
	private int id;
	
	private String name;

	private String surname;
	
	private int dateBorn;
	
	private String email;
	
	private String country;
	
	private String city;

		
	
	public UsersResponse() {
	}

	public UsersResponse(Users users) {
		this.id = users.getId();
		this.name = users.getName();
		this.surname = users.getSurname();
		this.dateBorn = users.getDateBorn();
		this.email = users.getEnter().getEmail();
		this.country = users.getCountry().getCountryName();
		this.city = users.getCity().getCityName();
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

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public int getDateBorn() {
		return dateBorn;
	}

	public void setDateBorn(int dateBorn) {
		this.dateBorn = dateBorn;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "UsersResponse [id=" + id + ", name=" + name + ", surname=" + surname + ", dateBorn=" + dateBorn
				+ ", email=" + email + ", country=" + country + ", city=" + city + "]";
	}
	
}
