package com.jiangren.movie.controller;

import com.jiangren.movie.dto.actor.ActorGetDto;
import com.jiangren.movie.service.ActorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
@RequestMapping("/actors")
@RequiredArgsConstructor
public class ActorController {
    private final ActorService actorService;

    @GetMapping
    public ResponseEntity<List<ActorGetDto>> find(@RequestParam(required = false) String firstname,
                                                  @RequestParam(required = false) String lastname) {
        if (firstname != null || lastname != null) {
            return ResponseEntity.ok(actorService.getActorsByFirstnameOrLastname(firstname, lastname));
        }
        return ResponseEntity.ok(actorService.getAllActors());
    }
}
