package com.jiangren.movie.dto.movie;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class MovieGetDto {
    private Long id;

    private String movieName;

    private String movieLang;

    private String ageCertificate;

    private Integer movieLength;

    private LocalDate releaseDate;

}

