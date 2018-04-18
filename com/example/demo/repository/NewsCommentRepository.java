package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.NewsComment;

public interface NewsCommentRepository extends JpaRepository<NewsComment, Integer> {
	
	

}
