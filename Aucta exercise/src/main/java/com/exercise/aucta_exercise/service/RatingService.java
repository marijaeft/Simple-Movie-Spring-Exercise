package com.exercise.aucta_exercise.service;

import com.exercise.aucta_exercise.model.Movie;
import com.exercise.aucta_exercise.model.Rating;

public interface RatingService {
    Rating addRating(Long id, Double rating);
}
