package com.jiangren.movie.service;

import com.jiangren.movie.dao.ActorDao;
import com.jiangren.movie.dto.ActorGetDto;
import com.jiangren.movie.mapper.ActorMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
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
}
