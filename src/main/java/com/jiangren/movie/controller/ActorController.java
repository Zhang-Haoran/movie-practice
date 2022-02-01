package com.jiangren.movie.controller;

import com.jiangren.movie.dto.actor.ActorGetDto;
import com.jiangren.movie.dto.actor.ActorPostDto;
import com.jiangren.movie.dto.actor.ActorPutDto;
import com.jiangren.movie.service.ActorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/actors")
@RequiredArgsConstructor
public class ActorController {
    private final ActorService actorService;

    @GetMapping
    public ResponseEntity<List<ActorGetDto>> find(@RequestParam(required = false) String firstname,
                                                  @RequestParam(required = false) String lastname) {
        if (firstname != null || lastname != null) return ResponseEntity.ok(actorService.getActorsByFirstnameOrLastname(firstname, lastname));
        return ResponseEntity.ok(actorService.getAllActors());
    }

    @PostMapping
    public ResponseEntity<ActorGetDto> create(@RequestBody ActorPostDto actorPostDto) {
        return ResponseEntity.ok(actorService.create(actorPostDto));
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestParam Long id, @RequestBody ActorPutDto actorPutDto) {
        if (actorService.getById(id).size() == 0) return ResponseEntity.status(404).body("Id not found");
        return ResponseEntity.ok(actorService.update(id, actorPutDto));
    }

    @DeleteMapping
    public ResponseEntity<?> delete(@RequestParam Long id) {
        if (actorService.getById(id).size() == 0) return ResponseEntity.status(404).body("Id not found");
        try {
            actorService.delete(id);
            return ResponseEntity.ok().body("Deleted");
        } catch (Exception e) {
            return ResponseEntity.status(422).body("Foreign key constraint");
        }
    }
}
