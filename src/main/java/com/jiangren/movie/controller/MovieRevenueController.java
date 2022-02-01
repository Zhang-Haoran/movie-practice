package com.jiangren.movie.controller;

import com.jiangren.movie.dto.movieRevenue.MovieRevenueGetDto;
import com.jiangren.movie.dto.movieRevenue.MovieRevenuePostDto;
import com.jiangren.movie.dto.movieRevenue.MovieRevenuePutDto;
import com.jiangren.movie.service.MovieRevenueService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/movies-revenues")
@RequiredArgsConstructor
public class MovieRevenueController {
    private final MovieRevenueService movieRevenueService;

    @GetMapping
    public ResponseEntity<List<MovieRevenueGetDto>> find(@RequestParam(required = false) String firstname,
                                                     @RequestParam(required = false) String lastname) {
        return ResponseEntity.ok(movieRevenueService.getAllMovieRevenues());
    }

    @PostMapping
    public ResponseEntity<MovieRevenueGetDto> create(@RequestBody MovieRevenuePostDto movieRevenuePostDto) {
        return ResponseEntity.ok(movieRevenueService.create(movieRevenuePostDto));
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestParam Long id, @RequestBody MovieRevenuePutDto movieRevenuePutDto) {
        if (movieRevenueService.getById(id).size() == 0) return ResponseEntity.status(404).body("Id not found");
        return ResponseEntity.ok(movieRevenueService.update(id, movieRevenuePutDto));
    }

    @DeleteMapping
    public ResponseEntity<?> delete(@RequestParam Long id) {
        if (movieRevenueService.getById(id).size() == 0) return ResponseEntity.status(404).body("Id not found");
        try {
            movieRevenueService.delete(id);
            return ResponseEntity.ok().body("Deleted");
        } catch (Exception e) {
            return ResponseEntity.status(422).body("Foreign key constraint");
        }
    }
}
