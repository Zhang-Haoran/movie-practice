package com.jiangren.movie.dto.actor;

import com.jiangren.movie.entity.Movie;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Set;

@Data
@NoArgsConstructor
public class ActorGetDto {
    private Long id;

    private String firstname;

    private String lastname;

    private String gender;

    private LocalDate dateOfBirth;

    private Set<Movie> movies;
}
