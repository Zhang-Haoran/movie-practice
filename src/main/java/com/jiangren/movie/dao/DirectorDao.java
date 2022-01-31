package com.jiangren.movie.dao;

import com.jiangren.movie.entity.Director;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DirectorDao extends JpaRepository<Director, Long>{
    @Query("select a from Director a where (:firstname is null or a.firstname = :firstname)"
            + "and (:lastname is null or a.lastname = :lastname)")
    List<Director> findByFirstnameOrLastname(@Param("firstname") String firstname,
                                             @Param("lastname") String lastname);

    @Query("select a from Director a order by a.id desc")
    List<Director> findAllByOrderByIdDesc();
}
