package com.venturus.general.venturusflix.model;

import com.venturus.general.venturusflix.dto.MovieDTO;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity(name = "movie")
@Table(name = "movies")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String title;
    @Pattern(regexp = "(\\d{2}|L)")
    private String maturityRating;
    @ElementCollection
    @CollectionTable(name = "movie_genres", joinColumns = @JoinColumn(name = "movie_id"))
    private List<String> genres;
    private String releaseDate;
    private String duration;

    public Movie(MovieDTO movie) {
        this.title = movie.title();
        this.maturityRating = movie.maturityRating();
        this.genres = movie.genres();
        this.releaseDate = movie.releaseDate();
        this.duration = movie.duration();
    }
}
