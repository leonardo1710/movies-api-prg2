package at.ac.fhcampuswien.moviesapi.common;

import at.ac.fhcampuswien.moviesapi.models.Genre;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringToGenreConverter implements Converter<String, Genre> {
    @Override
    public Genre convert(String source) {
        return Genre.valueOf(Genre.class, source.toUpperCase());
    }
}

