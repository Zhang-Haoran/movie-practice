package com.jiangren.movie.dao;

import com.jiangren.movie.entity.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ActorDao extends JpaRepository<Actor, Long> {
    List<Actor> findByFirstnameOrLastname(String firstname, String lastname);

}
