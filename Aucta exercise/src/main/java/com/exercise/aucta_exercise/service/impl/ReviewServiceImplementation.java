package com.exercise.aucta_exercise.service.impl;

import com.exercise.aucta_exercise.model.Movie;
import com.exercise.aucta_exercise.model.Review;
import com.exercise.aucta_exercise.repository.ReviewRepository;
import com.exercise.aucta_exercise.service.MovieService;
import com.exercise.aucta_exercise.service.ReviewService;
import org.springframework.stereotype.Service;

@Service
public class ReviewServiceImplementation implements ReviewService {
    private final ReviewRepository reviewRepository;
    private final MovieService movieService;

    public ReviewServiceImplementation(ReviewRepository reviewRepository, MovieService movieService) {
        this.reviewRepository = reviewRepository;
        this.movieService = movieService;
    }

    @Override
    public Review addReview(Long id, String reviewText) {
        Movie movie=movieService.findById(id);
        return reviewRepository.save(new Review(movie,reviewText));
    }
}
