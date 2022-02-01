package com.jiangren.movie.dao;

import com.jiangren.movie.entity.Actor;
import com.jiangren.movie.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MovieDao extends JpaRepository<Movie, Long> {
    @Query("select a from Movie a order by a.id desc")
    List<Movie> findAllByOrderByIdDesc();
}
