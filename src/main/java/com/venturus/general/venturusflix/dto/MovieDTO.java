package com.venturus.general.venturusflix.dto;

import com.venturus.general.venturusflix.model.Movie;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record MovieDTO(@NotNull Long id,
                       String title,
                       String maturityRating,
                       List<String> genres,
                       String releaseDate,
                       String duration,
                       String posterImageUrl
) {
    public MovieDTO(Movie movie) {
        this(movie.getId(),
                movie.getTitle(),
                movie.getMaturityRating(),
                movie.getGenres(),
                movie.getReleaseDate(),
                movie.getDuration(),
                movie.getPosterImageUrl()
        );
    }
}
