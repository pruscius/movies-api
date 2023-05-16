package dev.andresfrank.movies.controller;

import dev.andresfrank.movies.dto.MovieDTO;
import dev.andresfrank.movies.service.MovieService;
import org.bson.types.ObjectId;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/movies")
public class MoviesController {

    private MovieService movieService;

    public MoviesController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/")
    public ResponseEntity<List<MovieDTO>> getAllMovies() {
        return new ResponseEntity<List<MovieDTO>>(movieService.getAllMovies(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<MovieDTO>> getMovie(@PathVariable String id) {
        return new ResponseEntity<Optional<MovieDTO>>(movieService.findMovieById(id), HttpStatus.OK);
    }
}
