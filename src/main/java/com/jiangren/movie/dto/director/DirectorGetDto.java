package com.jiangren.movie.dto.director;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@NoArgsConstructor
public class DirectorGetDto {
    private Long id;

    private String firstname;

    private String lastname;

    private LocalDate dateOfBirth;

    private String nationality;
}
