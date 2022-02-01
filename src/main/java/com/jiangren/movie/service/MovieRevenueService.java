package com.jiangren.movie.service;

import com.jiangren.movie.dao.MovieRevenueDao;
import com.jiangren.movie.dto.movieRevenue.MovieRevenueGetDto;
import com.jiangren.movie.dto.movieRevenue.MovieRevenuePostDto;
import com.jiangren.movie.dto.movieRevenue.MovieRevenuePutDto;
import com.jiangren.movie.entity.MovieRevenue;
import com.jiangren.movie.mapper.MovieRevenueMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
@RequiredArgsConstructor
public class MovieRevenueService {
    private final MovieRevenueDao movieRevenueDao;

    private final MovieRevenueMapper movieRevenueMapper;

    public List<MovieRevenueGetDto> getAllMovieRevenues(){
        return movieRevenueDao.findAllByOrderByIdDesc().stream().map(movieRevenueMapper::fromEntity).collect(Collectors.toList());
    }

    public MovieRevenueGetDto create(MovieRevenuePostDto movieRevenuePostDto){
        MovieRevenue movieRevenue = movieRevenueMapper.toEntity(movieRevenuePostDto);
        return movieRevenueMapper.fromEntity(movieRevenueDao.save(movieRevenue));
    }

    public MovieRevenueGetDto update(Long id, MovieRevenuePutDto movieRevenuePutDto){
        MovieRevenue movieRevenue = new MovieRevenue();
        movieRevenueMapper.copy(movieRevenuePutDto, movieRevenue);
        movieRevenue.setId(id);
        return movieRevenueMapper.fromEntity(movieRevenueDao.save(movieRevenue));
    }

    public void delete(Long id){
        movieRevenueDao.deleteById(id);
    }

    public List<MovieRevenueGetDto> getById(Long id){
        return movieRevenueDao.findById(id).stream().map(movieRevenueMapper::fromEntity).collect(Collectors.toList());
    }
}
