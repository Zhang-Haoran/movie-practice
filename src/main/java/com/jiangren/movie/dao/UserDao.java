package com.jiangren.movie.dao;
import com.jiangren.movie.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Long> {
}

