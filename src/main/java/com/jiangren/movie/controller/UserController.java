package com.jiangren.movie.controller;

import com.jiangren.movie.dto.user.UserGetDto;
import com.jiangren.movie.dto.user.UserPostDto;
import com.jiangren.movie.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    public UserGetDto create(@RequestBody UserPostDto userPostDto){ return userService.create(userPostDto);}

    @GetMapping("/{userId}")
    public UserGetDto findUserById(@PathVariable long userId){
        return userService.findUserById(userId);
    }
}
