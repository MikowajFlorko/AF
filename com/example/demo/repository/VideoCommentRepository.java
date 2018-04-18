package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.VideoComment;


public interface VideoCommentRepository extends JpaRepository<VideoComment, Integer> {

}
