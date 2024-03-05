package com.exercise.aucta_exercise.repository;

import com.exercise.aucta_exercise.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review,Long> {
}
