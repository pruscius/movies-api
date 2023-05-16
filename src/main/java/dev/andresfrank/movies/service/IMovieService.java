package dev.andresfrank.movies.service;

import dev.andresfrank.movies.dto.MovieDTO;

import java.util.List;
import java.util.Optional;

public interface IMovieService {
    public List<MovieDTO> getAllMovies();
    public Optional<MovieDTO> findMovieById(String id);
}
