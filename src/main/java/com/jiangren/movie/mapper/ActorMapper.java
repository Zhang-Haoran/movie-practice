package com.jiangren.movie.mapper;

import com.jiangren.movie.dto.actor.ActorGetDto;
import com.jiangren.movie.dto.actor.ActorPostDto;
import com.jiangren.movie.dto.actor.ActorPutDto;
import com.jiangren.movie.entity.Actor;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ActorMapper {
    ActorGetDto fromEntity(Actor actor);

    Actor toEntity(ActorPostDto actorPostDto);

    void copy(ActorPutDto actorPutDto, @MappingTarget Actor actor);
}