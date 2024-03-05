package com.exercise.aucta_exercise.repository;

import com.exercise.aucta_exercise.model.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RatingRepository extends JpaRepository<Rating,Long> {
}
