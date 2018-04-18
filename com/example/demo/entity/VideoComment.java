package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class VideoComment {
	
	@Id
	@GeneratedValue(strategy  = GenerationType.IDENTITY)
	private int id;
	
	private String comment;
	
	@ManyToOne
	private Video video;
	
	public VideoComment() {}
	
	public VideoComment(String comment, Video video) {
		this.comment = comment;
		this.video = video;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Video getVideo() {
		return video;
	}

	public void setVideo(Video video) {
		this.video = video;
	}
	
	@Override
	public String toString() {
		return "VideoComment [id=" + id + ", comment=" + comment + ", video=" + video + "]";
	}
	
	

}
