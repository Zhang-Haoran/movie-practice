package com.jiangren.movie.service;

import com.jiangren.movie.dao.DirectorDao;
import com.jiangren.movie.dto.director.DirectorGetDto;
import com.jiangren.movie.dto.director.DirectorPostDto;
import com.jiangren.movie.dto.director.DirectorPutDto;
import com.jiangren.movie.entity.Director;
import com.jiangren.movie.mapper.DirectorMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DirectorService {
    private final DirectorDao directorDao;

    private final DirectorMapper directorMapper;

    public List<DirectorGetDto> getAllDirectors(){
        return directorDao.findAllByOrderByIdDesc().stream().map(directorMapper::fromEntity).collect(Collectors.toList());
    }

    public List<DirectorGetDto> getDirectorsByFirstnameOrLastname(String firstname, String lastname){
        return directorDao.findByFirstnameOrLastname(firstname,lastname).stream().map(directorMapper::fromEntity).collect(Collectors.toList());
    }

    public DirectorGetDto create(DirectorPostDto directorPostDto){
        Director director = directorMapper.toEntity(directorPostDto);
        return directorMapper.fromEntity(directorDao.save(director));
    }

    public DirectorGetDto update(Long id, DirectorPutDto directorPutDto){
        Director director = new Director();
        directorMapper.copy(directorPutDto, director);
        director.setId(id);
        return directorMapper.fromEntity(directorDao.save(director));
    }

    public void delete(Long id){
        directorDao.deleteById(id);
    }

    public List<DirectorGetDto> getById(Long id){
        return directorDao.findById(id).stream().map(directorMapper::fromEntity).collect(Collectors.toList());
    }
}
