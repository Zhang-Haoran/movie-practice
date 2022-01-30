package com.jiangren.movie.dto.actor;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class ActorPostDto {
    private String firstname;

    private String lastname;

    private String gender;

    private LocalDate dateOfBirth;
}
