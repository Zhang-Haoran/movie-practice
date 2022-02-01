package com.jiangren.movie.controller;

import com.jiangren.movie.dto.movieRevenue.MovieRevenueGetDto;
import com.jiangren.movie.dto.movieRevenue.MovieRevenuePostDto;
import com.jiangren.movie.dto.movieRevenue.MovieRevenuePutDto;
import com.jiangren.movie.service.MovieRevenueService;
import com.jiangren.movie.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/movie-revenues")
@RequiredArgsConstructor
public class MovieRevenueController {
    private final MovieRevenueService movieRevenueService;
    private final MovieService movieService;

    @GetMapping
    public ResponseEntity<List<MovieRevenueGetDto>> find() {
        return ResponseEntity.ok(movieRevenueService.getAllMovieRevenues());
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody MovieRevenuePostDto movieRevenuePostDto) {
        if (movieRevenueService.getByMovieId(movieRevenuePostDto.getMovieId()).size() > 0) return ResponseEntity.status(409).body("Movie has been associated with other revenue");
        if (movieService.getById(movieRevenuePostDto.getMovieId()).size() == 0) return ResponseEntity.status(404).body("Movie id not found");
        return ResponseEntity.ok(movieRevenueService.create(movieRevenuePostDto));
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestParam Long id, @RequestBody MovieRevenuePutDto movieRevenuePutDto) {
        if (movieRevenueService.getByMovieId(movieRevenuePutDto.getMovieId()).size() > 0) return ResponseEntity.status(409).body("Movie has been associated with other revenue");
        if (movieService.getById(movieRevenuePutDto.getMovieId()).size() == 0) return ResponseEntity.status(404).body("Movie id not found");
        if (movieRevenueService.getById(id).size() == 0) return ResponseEntity.status(404).body("Revenue id not found");
        return ResponseEntity.ok(movieRevenueService.update(id, movieRevenuePutDto));
    }

    @DeleteMapping
    public ResponseEntity<?> delete(@RequestParam Long id) {
        if (movieRevenueService.getById(id).size() == 0) return ResponseEntity.status(404).body("Revenue id not found");
        try {
            movieRevenueService.delete(id);
            return ResponseEntity.ok().body("Deleted");
        } catch (Exception e) {
            return ResponseEntity.status(422).body("Foreign key constraint");
        }
    }
}
