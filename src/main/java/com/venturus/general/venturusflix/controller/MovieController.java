package com.venturus.general.venturusflix.controller;

import com.venturus.general.venturusflix.dto.MovieDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @PostMapping
    public void insert(@RequestBody MovieDTO movie) {
        System.out.println(movie);
    }
}
