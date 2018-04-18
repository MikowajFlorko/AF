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
public class Video {
	
	@Id
	@GeneratedValue(strategy  = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	@OneToMany(mappedBy = "video")
	private List<VideoComment> videoComment = new ArrayList<VideoComment>();
	
	@OneToOne
	private VideoName videoName;
	
	@ManyToOne
	private Club club;
	
	public Video() {}
	
	public Video(String name, List<VideoComment> videoComment, VideoName videoName, Club club) {
		this.name = name;
		this.videoComment = videoComment;
		this.club = club;
		this.videoName = videoName;
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

	public List<VideoComment> getVideoComment() {
		return videoComment;
	}

	public void setVideoComment(List<VideoComment> videoComment) {
		this.videoComment = videoComment;
	}

	public VideoName getVideoName() {
		return videoName;
	}

	public void setVideoName(VideoName videoName) {
		this.videoName = videoName;
	}

	public Club getClub() {
		return club;
	}

	public void setClub(Club club) {
		this.club = club;
	}
	@Override
	public String toString() {
		return "Video [id=" + id + ", name=" + name + ", videoComment=" + videoComment + ", videoName=" + videoName
				+ ", club=" + club + "]";
	}
	
}
