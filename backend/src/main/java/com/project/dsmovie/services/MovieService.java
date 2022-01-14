package com.project.dsmovie.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.dsmovie.dto.MovieDTO;
import com.project.dsmovie.entities.Movie;
import com.project.dsmovie.repositories.MovieRepository;

@Service
public class MovieService {

	@Autowired
	private MovieRepository movieRepository;
	
	@Transactional(readOnly = true)
	public Page<MovieDTO> findAll(Pageable pageable) {
		Page<Movie> movie = movieRepository.findAll(pageable);
		Page<MovieDTO> pageMv = movie.map(mv -> new MovieDTO(mv));
		
		return pageMv;
	}
	
	@Transactional(readOnly = true)
	public MovieDTO findById(Long id) {
		Movie movie = movieRepository.findById(id).get();
		MovieDTO movieDTO = new MovieDTO(movie);
		
		return movieDTO;
	}
}
