package com.jiangren.movie.dto.movie;

import com.jiangren.movie.entity.Actor;
import com.jiangren.movie.entity.Director;
import com.jiangren.movie.entity.MovieRevenue;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Set;

@Data
@NoArgsConstructor
public class MovieGetDto {
    private Long id;

    private String movieName;

    private String movieLang;

    private String ageCertificate;

    private Integer movieLength;

    private LocalDate releaseDate;

    private Director director;

    private Set<Actor> actors;

    private MovieRevenue movieRevenue;

}

