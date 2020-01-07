package com.moviesdb.repositories;

import org.springframework.data.repository.CrudRepository;

import com.moviesdb.entities.MovieId;
import com.moviesdb.entities.Movies;

public interface MovieRepository extends CrudRepository<Movies, Integer> {
	
}
