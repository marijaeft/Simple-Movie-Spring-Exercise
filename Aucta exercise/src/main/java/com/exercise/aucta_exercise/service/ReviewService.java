package com.exercise.aucta_exercise.service;

import com.exercise.aucta_exercise.model.Movie;
import com.exercise.aucta_exercise.model.Review;

public interface ReviewService {
    Review addReview(Long id, String reviewText);
}
