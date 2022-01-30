package com.jiangren.movie.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "movies")
public class Movie {
    @Id
    @GeneratedValue
    @Column(name = "movie_id")
    private Long id;

    @Column(name = "movie_name")
    private String movieName;

    @Column(name = "movie_length")
    private Integer movieLength;

    @Column(name = "movie_lang")
    private String movieLang;

    @Column(name = "release_date")
    private LocalDate releaseDate;

    @Column(name = "age_certificate")
    private String ageCertificate;
}
