package com.example.demo.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Image {
	
	@Id
	@GeneratedValue(strategy  = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	@OneToMany(mappedBy = "image")
	private List<ImageComment> imageComment = new ArrayList<ImageComment>();
	
	@OneToOne
	private ImageName imageName;
	
	@ManyToOne
	private Club club;
	
	@ManyToOne
	private Users users;
	
	public Image() {}
	
	public Image(String name) {
		this.name = name;
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

	public List<ImageComment> getImageComment() {
		return imageComment;
	}

	public void setImageComment(List<ImageComment> imageComment) {
		this.imageComment = imageComment;
	}

	public ImageName getImageName() {
		return imageName;
	}

	public void setImageName(ImageName imageName) {
		this.imageName = imageName;
	}

	public Club getClub() {
		return club;
	}

	public void setClub(Club club) {
		this.club = club;
	}
	
		public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

		@Override
	public String toString() {
		return "Image [id=" + id + ", name=" + name + ", imageComment=" + imageComment + ", imageName=" + imageName
				+ ", club=" + club + "]";
	}	
	
}
