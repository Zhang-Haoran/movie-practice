package com.jiangren.movie.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "directors")
public class Director {
    @Id
    @GeneratedValue
    @Column(name = "director_id")
    private Long id;

    @Column(name = "first_name")
    private String fistname;

    @Column(name = "last_name")
    private String lastname;

    @Column(name = "date_of_birth")
    private String dateOfBirth;

    @Column(name = "nationality")
    private String nationality;

    @OneToMany(mappedBy = "director")
    private Set<Movie> movies;
}
