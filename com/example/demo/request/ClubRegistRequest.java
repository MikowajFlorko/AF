package com.example.demo.request;

public class ClubRegistRequest {
	
	private String name;
	
	private int establishment;
	
	private String cityName;
	
	private String countryName;
		
	private String league;
	
	private String email;
	
	private String password;

	public ClubRegistRequest() {}
	

	public ClubRegistRequest(String name, int establishment, String cityName, String countryName, String league,
			String email, String password) {
		this.name = name;
		this.establishment = establishment;
		this.cityName = cityName;
		this.countryName = countryName;
		this.league = league;
		this.email = email;
		this.password = password;
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

	public String getLeague() {
		return league;
	}

	public void setLeague(String league) {
		this.league = league;
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
		return "ClubRegistRequest [name=" + name + ", establishment=" + establishment + ", cityName=" + cityName
				+ ", countryName=" + countryName + ", league=" + league + ", email=" + email + ", password=" + password
				+ "]";
	}
}
	