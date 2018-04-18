package com.example.demo.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Club {
	
	@Id
	@GeneratedValue(strategy  = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	private int establishment;
	
	@OneToOne
	private City city;
	
	@OneToOne
	private Country country;
	
	@OneToOne
	private Enter enter;
	
	@OneToOne
	private League league;
	
	@OneToMany(mappedBy = "club")
	private List<News> news = new ArrayList<News>();
	
	private Role role;
	
	@OneToMany(mappedBy="club")
	List<Image> image = new ArrayList<Image>();
	
	@OneToMany(mappedBy="club")
	private List<Video> video = new ArrayList<Video>();
	
	@ManyToMany
	private List<Users> users = new ArrayList<Users>();
	
//	@ManyToMany
//	@JoinTable(name="club_users",joinColumns = @JoinColumn(name="id_club"),inverseJoinColumns = @JoinColumn(name="id_users"))
//	private List<Users> users = new ArrayList<Users>();
	
	public Club() {}

	public Club(String name, int establishment, City city, Country country, Enter enter, League league, Role role) {
	this.name = name;
	this.establishment = establishment;
	this.city = city;
	this.country = country;
	this.enter = enter;
	this.league = league;
	this.role = role;
}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}	

	public List<Image> getImage() {
		return image;
	}

	public void setImage(List<Image> image) {
		this.image = image;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public League getLeague() {
		return league;
	}

	public void setLeague(League league) {
		this.league = league;
	}
		
	public List<Users> getUsers() {
		return users;
	}

	public void setUsers(List<Users> users) {
		this.users = users;
	}

	public int getEstablishment() {
		return establishment;
	}

	public void setEstablishment(int establishment) {
		this.establishment = establishment;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public Enter getEnter() {
		return enter;
	}

	public List<Video> getVideo() {
		return video;
	}

	public void setVideo(List<Video> video) {
		this.video = video;
	}

	public void setEnter(Enter enter) {
		this.enter = enter;
	}
	
	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public List<News> getNews() {
		return news;
	}

	public void setNews(List<News> news) {
		this.news = news;
	}

	@Override
	public String toString() {
		return "Club [id=" + id + ", name=" + name + ", establishment=" + establishment + ", city=" + city
				+ ", country=" + country + ", enter=" + enter + ", league=" + league + ", news=" + news + ", role="
				+ role + "]";
	}
}
