package com.moviesdb.repositories;

import org.springframework.data.repository.CrudRepository;

import com.moviesdb.entities.MoviesGenre;
import com.moviesdb.entities.MovieGenreId;

public interface MovieGenreRepository extends CrudRepository<MoviesGenre, MovieGenreId> {
	
}
