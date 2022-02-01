package com.jiangren.movie.controller;

import com.jiangren.movie.dto.director.DirectorGetDto;
import com.jiangren.movie.dto.director.DirectorPostDto;
import com.jiangren.movie.dto.director.DirectorPutDto;
import com.jiangren.movie.service.DirectorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/directors")
@RequiredArgsConstructor
public class DirectorController {
    private final DirectorService directorService;

    @GetMapping
    public ResponseEntity<List<DirectorGetDto>> find(@RequestParam(required = false) String firstname,
                                                  @RequestParam(required = false) String lastname) {
        if (firstname != null || lastname != null) return ResponseEntity.ok(directorService.getDirectorsByFirstnameOrLastname(firstname, lastname));
        return ResponseEntity.ok(directorService.getAllDirectors());
    }

    @PostMapping
    public ResponseEntity<DirectorGetDto> create(@RequestBody DirectorPostDto directorPostDto) {
        return ResponseEntity.ok(directorService.create(directorPostDto));
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestParam Long id, @RequestBody DirectorPutDto directorPutDto) {
        if (directorService.getById(id).size() == 0) return ResponseEntity.status(404).body("Id not found");
        return ResponseEntity.ok(directorService.update(id, directorPutDto));
    }

    @DeleteMapping
    public ResponseEntity<?> delete(@RequestParam Long id) {
        if (directorService.getById(id).size() == 0) return ResponseEntity.status(404).body("Id not found");
        try {
            directorService.delete(id);
            return ResponseEntity.ok().body("Deleted");
        } catch (Exception e) {
            return ResponseEntity.status(422).body("Foreign key constraint");
        }
    }
}
