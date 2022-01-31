package com.jiangren.movie.mapper;

import com.jiangren.movie.dto.director.DirectorGetDto;
import com.jiangren.movie.dto.director.DirectorPostDto;
import com.jiangren.movie.dto.director.DirectorPutDto;
import com.jiangren.movie.entity.Director;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DirectorMapper {
    DirectorGetDto fromEntity(Director director);

    Director toEntity(DirectorPostDto directorPostDto);

    void copy(DirectorPutDto directorPutDto, @MappingTarget Director director);
}
