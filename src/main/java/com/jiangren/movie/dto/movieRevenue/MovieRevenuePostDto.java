package com.jiangren.movie.dto.movieRevenue;

import com.jiangren.movie.entity.Movie;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MovieRevenuePostDto {
    private Float domesticTakings;

    private Float internationalTakings;

    private Movie movie;
}
