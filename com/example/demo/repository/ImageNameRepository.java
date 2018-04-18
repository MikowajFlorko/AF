package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.ImageName;


public interface ImageNameRepository extends JpaRepository<ImageName, Integer> {

}
