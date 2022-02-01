package com.jiangren.movie.dto.movieRevenue;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Transient;

@Data
@NoArgsConstructor
public class MovieRevenuePutDto {
    private Float domesticTakings;

    private Float internationalTakings;

    @Transient
    private Long movieId;
}
