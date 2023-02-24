package at.ac.fhcampuswien.moviesapi.services;

import at.ac.fhcampuswien.moviesapi.exceptionhandling.MovieNotFoundException;
import at.ac.fhcampuswien.moviesapi.models.Genre;
import at.ac.fhcampuswien.moviesapi.models.Movie;

import java.util.List;
import java.util.UUID;

public class MovieServiceImpl implements MovieService {
    private List<Movie> movies = Movie.generateMovies();

    public Movie findById(UUID id) {
        return this.movies.stream()
                .filter(movie -> movie.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new MovieNotFoundException(id));
    }

    public List<Movie> findAll(String query, Genre genre, Integer releaseYear, Double rating) {

        return this.movies.stream().filter(movie -> {
            if(!query.isEmpty() && !movie.getTitle().toLowerCase().contains(query.toLowerCase())) {
                return false;
            }
            if(genre != null && !movie.getGenres().contains(genre)) {
                return false;
            }
            if(releaseYear != null && movie.getReleaseYear() != releaseYear) {
                return false;
            }
            if(rating != null && movie.getRating() != rating) {
                return false;
            }
            return true;
        }).toList();
    }
}
