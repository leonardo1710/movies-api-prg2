package at.ac.fhcampuswien.moviesapi.exceptionhandling;

import java.util.UUID;

public class MovieNotFoundException extends RuntimeException {
    public MovieNotFoundException(UUID id) {
        super("Could not find movie with id: " + id);
    }
}

