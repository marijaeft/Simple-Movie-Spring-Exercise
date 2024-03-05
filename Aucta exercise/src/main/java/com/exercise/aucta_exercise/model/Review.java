package com.exercise.aucta_exercise.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Review {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne(fetch = FetchType.EAGER)
    private Movie movie;
    private String reviewText;

    public Review(Movie movie, String reviewText) {
        this.movie = movie;
        this.reviewText = reviewText;
    }

    public Review() {

    }
}
