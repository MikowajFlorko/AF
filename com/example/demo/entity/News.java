package com.example.demo.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class News {
	
	@Id
	@GeneratedValue(strategy  = GenerationType.IDENTITY)
	private long id;
	
	private String text;

	@ManyToOne
	private Club club;	
	
	@OneToMany(mappedBy = "news")
	private List<ImageNews> imageNews = new ArrayList<ImageNews>();
	
	@OneToMany(mappedBy = "news")
	private List<VideoNews> videoNews = new ArrayList<VideoNews>();
	
	@OneToMany(mappedBy = "news")
	private List<NewsComment> newsComments = new ArrayList<NewsComment>();	
	
	public News() {}
	
	public News(String text, Club club) {
		this.text = text;
		this.club = club;
	}
	
	public News(long id, String title, String text, Club club) {
		this.id = id;
		this.text = text;
		this.club = club;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Club getClub() {
		return club;
	}

	public void setClub(Club club) {
		this.club = club;
	}

    public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public List<ImageNews> getImageNews() {
		return imageNews;
	}

	public void setImageNews(List<ImageNews> imageNews) {
		this.imageNews = imageNews;
	}
	
	public List<VideoNews> getVideoNews() {
		return videoNews;
	}

	public void setVideoNews(List<VideoNews> videoNews) {
		this.videoNews = videoNews;
	}

	public List<NewsComment> getNewsComments() {
		return newsComments;
	}

	public void setNewsComments(List<NewsComment> newsComments) {
		this.newsComments = newsComments;
	}

	@Override
	public String toString() {
		return "News [id=" + id + ", text=" + text + "]";
	}
		
}
