package com.jiangren.movie.mapper;

import com.jiangren.movie.dto.movieRevenue.MovieRevenueGetDto;
import com.jiangren.movie.dto.movieRevenue.MovieRevenuePutDto;
import com.jiangren.movie.dto.movieRevenue.MovieRevenuePostDto;
import com.jiangren.movie.entity.MovieRevenue;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MovieRevenueMapper {
    MovieRevenueGetDto fromEntity(MovieRevenue movieRevenue);

    MovieRevenue toEntity(MovieRevenuePostDto moviePostDto);

    void copy(MovieRevenuePutDto moviePutDto, @MappingTarget MovieRevenue movieRevenue);
}
