package com.example.demo.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Users implements UserDetails {
	
	@Id
	@GeneratedValue(strategy  = GenerationType.IDENTITY)
	private int id;

	private String name;

	private String surname;
	
	private int dateBorn;

	@OneToOne	
	@JsonIgnore
	private Enter enter;

	@OneToOne
	@JsonIgnore
	private Country country;

	@OneToOne
	@JsonIgnore
	private City city;
	
	@ManyToMany(mappedBy = "users")
	@JsonIgnore
	private List<Club> clubs = new ArrayList<Club>();
//	
//	@ManyToMany
//	@JoinTable(name="club_users",joinColumns =(name="id_users"),inverseJoinColumns = (name="id_club"))
//	private List<Club> club = new ArrayList<Club>();
	
	private Role role;
	
	public Users() {}
	

	public Users(String name, String surname, int dateBorn) {
		this.name = name;
		this.surname = surname;
		this.dateBorn = dateBorn;
	}
	
	public Users(String name, String surname, int dateBorn, Enter enter, Country country, City city, Role role) {
		this.name = name;
		this.surname = surname;
		this.dateBorn = dateBorn;
		this.enter = enter;
		this.country = country;
		this.city = city;
		this.role = role;
	}


	public Users(String name, String surname, int dateBorn, Enter enter, City city, Country country) {
		this.name = name;
		this.surname = surname;
		this.dateBorn = dateBorn;
		this.enter = enter;
		this.country = country;
		this.city = city;
	}


	public int getId() {
		return id;
	}


	public Role getRole() {
		return role;
	}


	public void setRole(Role role) {
		this.role = role;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	
	public List<Club> getClubs() {
		return clubs;
	}


	public void setClubs(List<Club> clubs) {
		this.clubs = clubs;
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


	public Enter getEnter() {
		return enter;
	}


	public void setEnter(Enter enter) {
		this.enter = enter;
	}


	public Country getCountry() {
		return country;
	}


	public void setCountry(Country country) {
		this.country = country;
	}


	public City getCity() {
		return city;
	}


	public void setCity(City city) {
		this.city = city;
	}


	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return new ArrayList<GrantedAuthority>(Arrays.asList(new SimpleGrantedAuthority(role.name())));
	}

	@Override
	public String getPassword() {
		return enter.getPassword();
	}


	@Override
	public String getUsername() {
		return enter.getEmail();
	}


	@Override
	public boolean isAccountNonExpired() {
		return true;
	}


	@Override
	public boolean isAccountNonLocked() {
		return true;
	}


	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}


	@Override
	public boolean isEnabled() {
		return true;
	}
	@Override
	public String toString() {
		return "Users [id=" + id + ", name=" + name + ", surname=" + surname + ", dateBorn=" + dateBorn + ", enter="
				+ enter + ", country=" + country.getCountryName() + ", city=" + city.getCityName() + "]";
	}

}