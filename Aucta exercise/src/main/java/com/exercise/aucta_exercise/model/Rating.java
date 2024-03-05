package com.exercise.aucta_exercise.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Rating {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne(fetch = FetchType.EAGER)
    private Movie movie;
    private Double Rating;

    public Rating(Movie movie, Double rating) {
        this.movie = movie;
        Rating = rating;
    }

    public Rating() {

    }
}
