package com.exercise.aucta_exercise.service;

import com.exercise.aucta_exercise.model.Genre;
import com.exercise.aucta_exercise.model.Movie;

import java.util.List;

public interface MovieService {
    List<Movie> listMovies(String title, Genre genres, Integer year);

    Movie findById(Long id);
    Movie create(String title, String description,Genre genre, int year);

    List<Movie> listAllMovies();

}
