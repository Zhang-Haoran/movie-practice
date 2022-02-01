package com.jiangren.movie.controller;

import com.jiangren.movie.dto.movie.MovieGetDto;
import com.jiangren.movie.dto.movie.MoviePostDto;
import com.jiangren.movie.dto.movie.MoviePutDto;
import com.jiangren.movie.service.DirectorService;
import com.jiangren.movie.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/movies")
@RequiredArgsConstructor
public class MovieController {
    private final MovieService movieService;
    private final DirectorService directorService;

    @GetMapping
    public ResponseEntity<List<MovieGetDto>> find() {
        return ResponseEntity.ok(movieService.getAllMovies());
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody MoviePostDto moviePostDto) {
        if (directorService.getById(moviePostDto.getDirectorId()).size() == 0) return ResponseEntity.status(404).body("Director id not found");
        return ResponseEntity.ok(movieService.create(moviePostDto));
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestParam Long id, @RequestBody MoviePutDto moviePutDto) {
        if (directorService.getById(moviePutDto.getDirectorId()).size() == 0) return ResponseEntity.status(404).body("Director id not found");
        if (movieService.getById(id).size() == 0) return ResponseEntity.status(404).body("Id not found");
        return ResponseEntity.ok(movieService.update(id, moviePutDto));
    }

    @DeleteMapping
    public ResponseEntity<?> delete(@RequestParam Long id) {
        if (movieService.getById(id).size() == 0) return ResponseEntity.status(404).body("Id not found");
        try {
            movieService.delete(id);
            return ResponseEntity.ok().body("Deleted");
        } catch (Exception e) {
            return ResponseEntity.status(422).body("Foreign key constraint");
        }
    }
}
