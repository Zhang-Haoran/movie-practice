package com.jiangren.movie.service;

import com.jiangren.movie.dao.ActorDao;
import com.jiangren.movie.dto.actor.ActorGetDto;
import com.jiangren.movie.dto.actor.ActorPostDto;
import com.jiangren.movie.dto.actor.ActorPutDto;
import com.jiangren.movie.entity.Actor;
import com.jiangren.movie.mapper.ActorMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ActorService {
    private final ActorDao actorDao;

    private final ActorMapper actorMapper;

    public List<ActorGetDto> getAllActors(){
        return actorDao.findAll().stream().map(actorMapper::fromEntity).collect(Collectors.toList());
    }

    public List<ActorGetDto> getActorsByFirstnameOrLastname(String firstname, String lastname){
        return actorDao.findByFirstnameOrLastname(firstname,lastname).stream().map(actorMapper::fromEntity).collect(Collectors.toList());
    }

    public ActorGetDto create(ActorPostDto actorPostDto){
        Actor actor = actorMapper.toEntity(actorPostDto);
        return actorMapper.fromEntity(actorDao.save(actor));
    }

    public ActorGetDto update(Long id, ActorPutDto actorPutDto){
        Actor actor = new Actor();
        actorMapper.copy(actorPutDto, actor);
        actor.setId(id);
        return actorMapper.fromEntity(actorDao.save(actor));
    }
}
