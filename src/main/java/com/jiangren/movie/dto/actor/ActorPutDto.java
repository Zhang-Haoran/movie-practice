package com.jiangren.movie.dto.actor;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class ActorPutDto {
    private String firstname;

    private String lastname;

    private String gender;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate dateOfBirth;
}
