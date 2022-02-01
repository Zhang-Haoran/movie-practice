package com.jiangren.movie.dto.movie;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jiangren.movie.entity.Director;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Transient;
import java.time.LocalDate;

@Data
@NoArgsConstructor
public class MoviePostDto {
    private String movieName;

    private String movieLang;

    private String ageCertificate;

    private Integer movieLength;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate releaseDate;

    @Transient
    private Long directorId;
}
