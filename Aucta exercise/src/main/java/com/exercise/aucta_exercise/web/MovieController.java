package com.exercise.aucta_exercise.web;

import com.exercise.aucta_exercise.model.Genre;
import com.exercise.aucta_exercise.model.Movie;
import com.exercise.aucta_exercise.service.MovieService;
import com.exercise.aucta_exercise.service.RatingService;
import com.exercise.aucta_exercise.service.ReviewService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MovieController {
    private final MovieService movieService;
    private final RatingService ratingService;
    private final ReviewService reviewService;

    public MovieController(MovieService movieService, RatingService ratingService, ReviewService reviewService) {
        this.movieService = movieService;
        this.ratingService = ratingService;
        this.reviewService = reviewService;
    }
    @GetMapping({"/","/movies"})
    public String showMovies(@RequestParam(required = false) String title,
                             @RequestParam(required = false) Genre genre,
                             @RequestParam(required = false) Integer year,
                             Model model) {
        List<Movie> movieList;
        if (title == null && genre == null && year == null) {
            movieList = movieService.listAllMovies();
        } else {
            movieList = movieService.listMovies(title, genre, year);
        }
        model.addAttribute("movies", movieList);
        model.addAttribute("genres", Genre.values());
        return "list";
    }
    @GetMapping("/movies/add")
    public String showAdd(Model model) {
        model.addAttribute("genres", Genre.values());
        return "form";
    }
    @GetMapping("/movies/{id}")
    public String showDetails(@PathVariable Long id, Model model){
        model.addAttribute("movie",movieService.findById(id));
        return "details";
    }
    @GetMapping("/reviews")
    public String showReviews(Model model){
        List<Movie> movieList;
        movieList=this.movieService.listAllMovies();
        model.addAttribute("movies",movieList);
        return "reviews";
    }
    @PostMapping("/movies")
    public String create(@RequestParam String title,
                         @RequestParam String description,
                         @RequestParam Genre genre,
                         @RequestParam String year) {
        int yearRelease=Integer.parseInt(year);
        this.movieService.create(title, description,genre, yearRelease);
        return "redirect:/movies";
    }
    @PostMapping("/movies/{id}/rate")
    public String rateMovie(@PathVariable Long id,@RequestParam String rating )
    {
        Double r=Double.parseDouble(String.valueOf(rating));
        ratingService.addRating(id,r);
        return "redirect:/movies";
    }
    @PostMapping("/movies/{id}/review")
    public String reviewMovie(@PathVariable Long id,@RequestParam String review )
    {
        reviewService.addReview(id,review);
        return "redirect:/movies";
    }
}
