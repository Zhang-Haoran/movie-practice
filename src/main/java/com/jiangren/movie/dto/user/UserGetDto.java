package com.jiangren.movie.dto.user;

import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@Setter
@Getter
public class UserGetDto {
    private long id;
    private String name;
    private String email;
    private OffsetDateTime createdTime;
    private OffsetDateTime updatedTime;
}
