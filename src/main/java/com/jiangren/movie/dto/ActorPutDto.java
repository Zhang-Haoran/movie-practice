package com.jiangren.movie.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class ActorPutDto {

    private Long id;

    private String firstname;

    private String lastname;

    private String gender;

    private LocalDate dateOfBirth;
}
