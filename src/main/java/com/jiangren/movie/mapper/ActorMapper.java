package com.jiangren.movie.mapper;

import com.jiangren.movie.dto.ActorGetDto;
import com.jiangren.movie.dto.ActorPostDto;
import com.jiangren.movie.dto.ActorPutDto;
import com.jiangren.movie.entity.Actor;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ActorMapper {
    Actor toEntity(ActorPostDto actorPostDto);
    ActorGetDto fromEntity(Actor actor);

    void copy(ActorPutDto actorPutDto, @MappingTarget Actor actor);
}