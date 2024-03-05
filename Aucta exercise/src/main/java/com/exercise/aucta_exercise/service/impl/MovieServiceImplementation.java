package com.exercise.aucta_exercise.service.impl;

import com.exercise.aucta_exercise.model.Genre;
import com.exercise.aucta_exercise.model.Movie;
import com.exercise.aucta_exercise.model.exceptions.InvalidMovieIdException;
import com.exercise.aucta_exercise.repository.MovieRepository;
import com.exercise.aucta_exercise.service.MovieService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImplementation implements MovieService {
    private final MovieRepository movieRepository;

    public MovieServiceImplementation(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public List<Movie> listMovies(String title, Genre genre, Integer year) {
        if (title != null && genre != null && year != null) {
            return movieRepository.findMoviesByTitleContainingIgnoreCaseAndGenreAndYear(title, genre, year);
        }
        if (title != null && genre != null && year == null) {
            return movieRepository.findMoviesByTitleContainingIgnoreCaseAndGenre(title, genre);
        }
        if (title == null && genre != null && year != null) {
            return movieRepository.findMoviesByGenreAndYear(genre, year);
        }
        if (title != null && genre == null && year != null) {
            return movieRepository.findMoviesByTitleContainingIgnoreCaseAndYear(title, year);
        }
        if (title != null) {
            return movieRepository.findMoviesByTitleContainingIgnoreCase(title);
        }
        if (genre != null) {
            return movieRepository.findMoviesByGenre(genre);
        }
        if (year != null) {
            return movieRepository.findMoviesByYear(year);
        }
        return this.listAllMovies();
    }

    @Override
    public Movie findById(Long id) {
        return movieRepository.findById(id).orElseThrow(InvalidMovieIdException::new);
    }

    @Override
    public Movie create(String title, String description, Genre genre, int year) {
        return movieRepository.save(new Movie(title, description, genre, year));
    }

    @Override
    public List<Movie> listAllMovies() {
        return movieRepository.findAll();
    }


}
