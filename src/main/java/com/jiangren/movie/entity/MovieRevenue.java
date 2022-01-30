package com.jiangren.movie.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "movie_revenues")
public class MovieRevenue {
    @Id
    @GeneratedValue
    @Column(name = "revenue_id")
    private Long id;

    @Column(name = "domestic_takings")
    private Float domesticTakings;

    @Column(name = "international_takings")
    private Float internationalTakings;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "movie_id", referencedColumnName = "movie_id")
    private Movie movie;
}
