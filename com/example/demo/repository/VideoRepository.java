package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Video;


public interface VideoRepository extends JpaRepository<Video, Integer> {

}
