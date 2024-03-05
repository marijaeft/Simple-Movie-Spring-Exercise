package com.exercise.aucta_exercise.model;

import jakarta.persistence.*;
import lombok.Data;

import java.text.DecimalFormat;
import java.util.List;

@Entity
@Data
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    @Enumerated(EnumType.STRING)
    private Genre genre;
    private Integer year;
    @OneToMany(mappedBy = "movie")
    private List<Rating> ratings;
    @OneToMany(mappedBy = "movie")
    private List<Review> reviews;


    public Movie(String title, String description, Genre genre, Integer year) {
        this.title = title;
        this.description = description;
        this.genre = genre;
        this.year = year;
    }

    public Movie() {

    }
    public Double getAverageRating() {
        if (ratings == null || ratings.isEmpty()) {
            return 0.0;
        }
        double sum = 0;
        for (Rating rating : ratings) {
            sum += rating.getRating();
        }
        double average = sum / ratings.size();
        DecimalFormat df = new DecimalFormat("#.##");
        return Double.parseDouble(df.format(average));
    }
}
