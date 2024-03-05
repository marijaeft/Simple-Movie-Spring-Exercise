package com.exercise.aucta_exercise.repository;

import com.exercise.aucta_exercise.model.Genre;
import com.exercise.aucta_exercise.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie,Long> {
List<Movie> findMoviesByTitleContainingIgnoreCase(String title);
    List<Movie> findMoviesByGenre(Genre genres);
    List<Movie> findMoviesByYear(Integer year);
    List<Movie> findMoviesByTitleContainingIgnoreCaseAndGenreAndYear(String title,Genre genre,Integer year);
    List<Movie> findMoviesByTitleContainingIgnoreCaseAndGenre(String title,Genre genre);
    List<Movie> findMoviesByTitleContainingIgnoreCaseAndYear(String title,Integer year);
    List<Movie> findMoviesByGenreAndYear(Genre genre,Integer year);

}
