package com.moviesdb.repositories;

import org.springframework.data.repository.CrudRepository;

import com.moviesdb.entities.Genre;

public interface GenreRepository extends CrudRepository<Genre, Integer>{
	Genre findByType(String type);
}
