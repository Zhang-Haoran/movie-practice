package com.jiangren.movie.mapper;

import com.jiangren.movie.dto.movie.MovieGetDto;
import com.jiangren.movie.dto.movie.MoviePostDto;
import com.jiangren.movie.dto.movie.MoviePutDto;
import com.jiangren.movie.entity.Movie;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MovieMapper {
    MovieGetDto fromEntity(Movie movie);

    Movie toEntity(MoviePostDto moviePostDto);

    void copy(MoviePutDto moviePutDto, @MappingTarget Movie movie);
}
