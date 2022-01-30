package com.jiangren.movie.mapper;

import com.jiangren.movie.dto.ActorGetDto;
import com.jiangren.movie.entity.Actor;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ActorMapper {
    ActorGetDto fromEntity(Actor actor);
}