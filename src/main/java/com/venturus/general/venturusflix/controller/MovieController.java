package com.venturus.general.venturusflix.controller;

import com.venturus.general.venturusflix.dto.MovieDTO;
import com.venturus.general.venturusflix.model.Movie;
import com.venturus.general.venturusflix.repository.MoviesRepository;
import jakarta.transaction.Transactional;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private static final boolean DEBUG = false;
    @Autowired
    private MoviesRepository repository;

    @PostMapping
    @Transactional
    public void insert(@RequestBody MovieDTO data) {
        if (DEBUG) System.out.println(data);
        repository.save(new Movie(data));
    }

    @PostMapping("/batch")
    @Transactional
    public void insertBatch(@RequestBody List<MovieDTO> data) {
        if (DEBUG) {
            System.out.println("Received movies batch: " + data.size() + "movies");
        }

        val movieList = data.stream().map(Movie::new).toList();
        repository.saveAll(movieList);
    }

    @GetMapping
    public Page<MovieDTO> listAll(@PageableDefault Pageable pageable) {
        return repository.findAll(pageable).map(MovieDTO::new);
    }

    @PutMapping
    @Transactional
    public void update(@RequestBody MovieDTO data) {
        var movie = repository.getReferenceById(data.id());
        movie.update(data);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void delete(@PathVariable("id") Long id) {
        repository.deleteById(id);
    }
}
