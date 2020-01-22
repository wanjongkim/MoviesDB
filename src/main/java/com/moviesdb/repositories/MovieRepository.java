package com.moviesdb.repositories;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.moviesdb.entities.Genre;
import com.moviesdb.entities.Images;
import com.moviesdb.entities.Movies;
import com.moviesdb.entities.Videos;

public interface MovieRepository extends CrudRepository<Movies, Integer> {
	
	@Query("SELECT v FROM Videos v WHERE v.videoId.movie.id = :id")
	List<Videos> findAllMatchingVideos(@Param("id") Integer id);
	@Query("SELECT u FROM Genre u, MoviesGenre mg WHERE u.id = mg.id.genreId.id AND :id = mg.id.moviesId.id")
	List<Genre> findAllMatchingGenres(@Param("id") Integer id);
	@Query("SELECT img FROM Images img WHERE img.imageId.movie.id=:id")
	List<Images> findSingleImage(@Param("id") Integer id, Pageable pageable);
	@Query("SELECT img FROM Images img WHERE img.imageId.movie.id=:id")
	List<Images> findAllMatchingImages(@Param("id") Integer id);
}
