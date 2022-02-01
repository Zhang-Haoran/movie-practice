package com.jiangren.movie.dao;

import com.jiangren.movie.entity.MovieRevenue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MovieRevenueDao  extends JpaRepository<MovieRevenue, Long> {
    @Query("select a from MovieRevenue a order by a.id desc")
    List<MovieRevenue> findAllByOrderByIdDesc();

    @Query("select a from MovieRevenue a where a.movie.id = :movieId")
    List<MovieRevenue> findByMovieId(@Param("movieId") Long movieId);
}
