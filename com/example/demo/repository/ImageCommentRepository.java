package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.ImageComment;


public interface ImageCommentRepository extends JpaRepository<ImageComment, Integer>{

}
