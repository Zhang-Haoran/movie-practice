package com.jiangren.movie.dao;

import com.jiangren.movie.entity.MovieRevenue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRevenueDao  extends JpaRepository<MovieRevenue, Long> {
}
