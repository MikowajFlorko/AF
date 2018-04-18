package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;


@Entity
public class VideoName {
	
	@Id
	@GeneratedValue(strategy  = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	@OneToOne
	private Video video;
	
	public VideoName() {}

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

	public Video getVideo() {
		return video;
	}

	public void setVideo(Video video) {
		this.video = video;
	}

	@Override
	public String toString() {
		return "VideoName [id=" + id + ", name=" + name + ", video=" + video + "]";
	}	

}
