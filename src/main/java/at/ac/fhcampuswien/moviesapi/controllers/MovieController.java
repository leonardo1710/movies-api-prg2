package at.ac.fhcampuswien.moviesapi.controllers;

import at.ac.fhcampuswien.moviesapi.models.Genre;
import at.ac.fhcampuswien.moviesapi.models.Movie;
import at.ac.fhcampuswien.moviesapi.services.MovieServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
public class MovieController {
    private final MovieServiceImpl movieService;

    MovieController() {
        this.movieService = new MovieServiceImpl();
    }

    @GetMapping("/movies")
    public List<Movie> getMovies(
            @RequestParam(value = "query", required = false, defaultValue = "") String query,
            @RequestParam(value = "genre", required = false) Genre genre,
            @RequestParam(value = "releaseYear", required = false) Integer releaseYear,
            @RequestParam(value = "rating", required = false) Double rating) {
        return movieService.findAll(query, genre, releaseYear, rating);
    }

    @GetMapping("/movies/{id}")
    public Movie getMovieById(@PathVariable UUID id) {
        Movie x = movieService.findById(id);
        System.out.println(x);
        return x;
    }
}
