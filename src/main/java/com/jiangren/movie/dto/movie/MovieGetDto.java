package com.jiangren.movie.dto.movie;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class MovieGetDto {
    private Long id;

    private String movie_name;

    private String movie_lang;

    private String age_certificate;

    private Integer movie_length;

    private LocalDate release_date;

}

