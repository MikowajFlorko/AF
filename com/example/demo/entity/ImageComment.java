package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ImageComment {
	
	@Id
	@GeneratedValue(strategy  = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	@ManyToOne
	private Image image;
	
	public ImageComment() {}

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

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}
	
	@Override
	public String toString() {
		return "ImageComment [id=" + id + ", name=" + name + ", image=" + image + "]";
	}
	
	

}
