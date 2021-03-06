package com.jiangren.movie.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @ManyToOne
    @JoinColumn(name = "director_id", nullable = false)
    @JsonBackReference
    private Director director;

    @ManyToMany
    @JoinTable(name = "movies_actors", joinColumns = @JoinColumn(name = "actor_id"), inverseJoinColumns = @JoinColumn(name = "movie_id"))
    @JsonBackReference
    private Set<Actor> actors;

    @OneToOne(mappedBy = "movie")
    @JsonBackReference
    private MovieRevenue movieRevenue;
}
