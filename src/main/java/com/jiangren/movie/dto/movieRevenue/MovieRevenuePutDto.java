package com.jiangren.movie.dto.movieRevenue;

import com.jiangren.movie.entity.Movie;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MovieRevenuePutDto {
    private Number domesticTakings;

    private Number internationalTakings;

    private Movie movie;
}
