package com.jiangren.movie.dto.movieRevenue;

import com.jiangren.movie.entity.Movie;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MovieRevenueGetDto {
    private Long id;

    private Number domesticTakings;

    private Number internationalTakings;

    private Movie movie;
}
