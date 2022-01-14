package com.project.dsmovie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.dsmovie.entities.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long>{

	
}
