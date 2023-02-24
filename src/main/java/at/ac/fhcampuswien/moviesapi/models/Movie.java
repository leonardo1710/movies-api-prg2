package at.ac.fhcampuswien.moviesapi.models;

import com.google.gson.Gson;
import org.springframework.javapoet.ClassName;

import java.io.File;
import java.util.*;

public class Movie {

    private final UUID id;
    private final String title;
    private final List<Genre> genres;
    private final int releaseYear;
    private final String description;
    private final String imgUrl;
    private final int lengthInMinutes; // in minutes
    private final List<String> directors;
    private final List<String> writers;
    private final List<String> mainCast;
    private double rating; // 0-10

    public Movie() {
        this.id = UUID.randomUUID();
        this.title = "";
        this.genres = new ArrayList<>();
        this.releaseYear = 0;
        this.description = "";
        this.imgUrl = "";
        this.lengthInMinutes = 0;
        this.directors = new ArrayList<>();
        this.writers = new ArrayList<>();
        this.mainCast = new ArrayList<>();
        this.rating = 0;
    }
    public Movie(String title, List<Genre> genres, int releaseYear, String description, String imgUrl, int length, List<String> directors, List<String> writers, List<String> mainCast, double rating)  throws IllegalArgumentException {
        this.id = UUID.randomUUID();
        this.title = title;
        this.genres = genres;
        this.releaseYear = releaseYear;
        this.description = description;
        this.imgUrl = imgUrl;
        this.lengthInMinutes = length;
        this.directors = directors;
        this.writers = writers;
        this.mainCast = mainCast;
        setRating(rating);
    }

    private void setRating(double rating) throws IllegalArgumentException {
        if(rating >= 0 && rating <= 10) {
            this.rating = rating;
        } else {
            throw new IllegalArgumentException("Rating must be between 0 and 10");
        }
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null) {
            return false;
        }
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof Movie other)) {
            return false;
        }
        return this.id.equals(other.id);
    }

    public static List<Movie> generateMovies() {
        List<Movie> movies = new ArrayList<>();
        try {
            Gson gson = new Gson();
            File movieData = new File(Objects.requireNonNull(ClassName.class.getClassLoader().getResource("data.json")).getFile());
            movies = Arrays.asList(gson.fromJson(new String(java.nio.file.Files.readAllBytes(movieData.toPath())), Movie[].class));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return movies;
    }

    public UUID getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public List<Genre> getGenres() {
        return this.genres;
    }

    public int getReleaseYear() {
        return this.releaseYear;
    }

    public double getRating() {
        return this.rating;
    }

    public String getDescription() {
        return description;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public int getLengthInMinutes() {
        return lengthInMinutes;
    }

    public List<String> getDirectors() {
        return directors;
    }

    public List<String> getWriters() {
        return writers;
    }

    public List<String> getMainCast() {
        return mainCast;
    }
}
