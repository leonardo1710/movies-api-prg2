package at.ac.fhcampuswien.moviesapi.services;

import at.ac.fhcampuswien.moviesapi.models.Genre;
import at.ac.fhcampuswien.moviesapi.models.Movie;

import java.util.List;
import java.util.UUID;

public interface MovieService {
    Movie findById(UUID id);
    List<Movie> findAll(String query, Genre genre, Integer releaseYear, Double rating);
}
