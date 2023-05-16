package dev.andresfrank.movies.service;

import dev.andresfrank.movies.dto.MovieDTO;
import dev.andresfrank.movies.model.Movie;
import org.bson.types.ObjectId;

import java.util.List;
import java.util.Optional;

public interface MovieServiceI {
    public List<MovieDTO> getAllMovies();
    public Optional<MovieDTO> findMovieById(String id);
}
