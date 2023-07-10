package com.example.workindia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.workindia.model.Railways;

public interface RailwaysRepository extends JpaRepository<Railways, Long>{
	 List<Railways> findBySourceAndDestination(String source, String destination);
}
