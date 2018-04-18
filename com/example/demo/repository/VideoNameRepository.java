package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.VideoName;


public interface VideoNameRepository extends JpaRepository<VideoName, Integer> {

}
