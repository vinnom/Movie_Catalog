package com.venturus.general.venturusflix.controller;

import com.venturus.general.venturusflix.dto.MovieDTO;
import com.venturus.general.venturusflix.model.Movie;
import com.venturus.general.venturusflix.repository.MoviesRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private static final boolean DEBUG = false;
    @Autowired
    private MoviesRepository repository;

    @PostMapping
    @Transactional
    public void insert(@RequestBody MovieDTO movie) {
        if (DEBUG) System.out.println(movie);
        repository.save(new Movie(movie));
    }
}
