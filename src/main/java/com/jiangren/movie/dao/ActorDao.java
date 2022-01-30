package com.jiangren.movie.dao;

import com.jiangren.movie.entity.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActorDao extends JpaRepository<Actor, Long> {
    @Query("select a from Actor a where (:firstname is null or a.firstname = :firstname)"
            + "and (:lastname is null or a.lastname = :lastname)")
    List<Actor> findByFirstnameOrLastname(@Param("firstname") String firstname,
                                          @Param("lastname") String lastname);

}
