package com.jiangren.movie.dto.movie;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class MoviePostDto {
    private String movie_name;

    private String movie_lang;

    private String age_certificate;

    private Integer movie_length;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate release_date;
}
