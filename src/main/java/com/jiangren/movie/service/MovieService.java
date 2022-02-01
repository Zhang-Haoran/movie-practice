package com.jiangren.movie.service;

import com.jiangren.movie.dao.DirectorDao;
import com.jiangren.movie.dao.MovieDao;
import com.jiangren.movie.dto.movie.MovieGetDto;
import com.jiangren.movie.dto.movie.MoviePostDto;
import com.jiangren.movie.dto.movie.MoviePutDto;
import com.jiangren.movie.entity.Movie;
import com.jiangren.movie.mapper.MovieMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MovieService {
    private final MovieDao movieDao;
    private final DirectorDao directorDao;

    private final MovieMapper movieMapper;

    public List<MovieGetDto> getAllMovies() {
        return movieDao.findAllByOrderByIdDesc().stream().map(movieMapper::fromEntity).collect(Collectors.toList());
    }

    public MovieGetDto create(MoviePostDto moviePostDto) {
        Movie movie = movieMapper.toEntity(moviePostDto);
        directorDao.findById(moviePostDto.getDirectorId()).ifPresent(
                director -> {
                    movie.setDirector(director);
                    movieDao.save(movie);
                });
        return movieMapper.fromEntity(movie);
    }

    public MovieGetDto update(Long id, MoviePutDto moviePutDto) {
        Movie movie = new Movie();
        directorDao.findById(moviePutDto.getDirectorId()).ifPresent(
                movie::setDirector);
        movieMapper.copy(moviePutDto, movie);
        movie.setId(id);
        return movieMapper.fromEntity(movieDao.save(movie));
    }

    public void delete(Long id) {
        movieDao.deleteById(id);
    }

    public List<MovieGetDto> getById(Long id) {
        return movieDao.findById(id).stream().map(movieMapper::fromEntity).collect(Collectors.toList());
    }
}
