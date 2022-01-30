package com.jiangren.movie.dto.actor;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class ActorPutDto {
    private Long id;

    private String firstname;

    private String lastname;

    private LocalDate dateOfBirth;
}
