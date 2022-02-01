package com.jiangren.movie.dto.director;

import com.jiangren.movie.entity.Movie;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Set;

@Data
@NoArgsConstructor
public class DirectorGetDto {
    private Long id;

    private String firstname;

    private String lastname;

    private LocalDate dateOfBirth;

    private String nationality;

    private Set<Movie> movies;
}
