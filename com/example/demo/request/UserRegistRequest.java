package com.example.demo.request;

import java.text.DateFormat;
import java.util.Calendar;

public class UserRegistRequest {
	
	private String name;

	private String surname;
	
	private int dateBorn;

	private String cityName;
	
	private String countryName;
	
	private String email;
	
	private String password;
	
	public UserRegistRequest() {};
	
	public UserRegistRequest(String name, String surname, int dateBorn, String cityName, String email, String countryName,
			String password) {
		this.name = name;
		this.surname = surname;
		this.dateBorn = dateBorn;
		this.cityName = cityName;
		this.countryName = countryName;
		this.email = email;
		this.password = password;
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

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	

	@Override
	public String toString() {
		return "RegisterRequest [name=" + name + ", surname=" + surname + ", dateBorn=" + dateBorn + ", cityName="
				+ cityName + ", countryName=" + countryName + ", email=" + email + ", password=" + password + "]";
	}
		
}
