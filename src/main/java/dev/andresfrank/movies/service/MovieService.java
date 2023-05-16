package dev.andresfrank.movies.service;

import dev.andresfrank.movies.dto.MovieDTO;
import dev.andresfrank.movies.model.Movie;
import dev.andresfrank.movies.repository.MovieRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MovieService implements IMovieService {
    private ModelMapper modelMapper = new ModelMapper();
    private MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public List<MovieDTO> getAllMovies() {
        return movieRepository.findAll()
                .stream()
                .map(m -> modelMapper.map(m, MovieDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<MovieDTO> findMovieById(String id) {
        /* TODO: exception */
        MovieDTO movieDTO = modelMapper.map(movieRepository.findMovieByImdbId(id).get(), MovieDTO.class);
        return Optional.of(movieDTO);
    }
}
