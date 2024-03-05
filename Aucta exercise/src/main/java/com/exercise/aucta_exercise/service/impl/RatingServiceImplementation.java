package com.exercise.aucta_exercise.service.impl;

import com.exercise.aucta_exercise.model.Movie;
import com.exercise.aucta_exercise.model.Rating;
import com.exercise.aucta_exercise.repository.MovieRepository;
import com.exercise.aucta_exercise.repository.RatingRepository;
import com.exercise.aucta_exercise.service.MovieService;
import com.exercise.aucta_exercise.service.RatingService;
import org.springframework.stereotype.Service;

@Service
public class RatingServiceImplementation implements RatingService {
    private final RatingRepository ratingRepository;
    private final MovieService movieService;

    public RatingServiceImplementation(RatingRepository ratingRepository, MovieRepository movieRepository, MovieService movieService) {
        this.ratingRepository = ratingRepository;
        this.movieService = movieService;
    }

    @Override
    public Rating addRating(Long id, Double rating) {
        Movie movie=movieService.findById(id);
        return ratingRepository.save(new Rating(movie,rating)) ;
    }
}
