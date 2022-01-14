package com.project.dsmovie.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.dsmovie.dto.MovieDTO;
import com.project.dsmovie.dto.ScoreDTO;
import com.project.dsmovie.services.ScoreService;

@RestController
@RequestMapping(value = "/scores")
public class ScoreController {
	
	@Autowired
	private ScoreService scoreService;

	@PutMapping
	public MovieDTO saveScore(@RequestBody ScoreDTO scoreDTO) {
		MovieDTO movieDTO = scoreService.saveScore(scoreDTO);
		
		return movieDTO;
	}
}
