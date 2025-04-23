package com.venturus.general.venturusflix.repository;

import com.venturus.general.venturusflix.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MoviesRepository extends JpaRepository<Movie, Long> {
}
