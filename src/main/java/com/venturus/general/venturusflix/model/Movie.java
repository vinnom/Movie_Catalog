package com.venturus.general.venturusflix.model;

import com.venturus.general.venturusflix.dto.MovieDTO;
import com.venturus.general.venturusflix.util.DataUtils;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
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

import java.util.LinkedHashSet;
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
    @Column(name = "poster_image_url", length = 512)
    private String posterImageUrl;

    public Movie(MovieDTO movie) {
        this.title = movie.title();
        this.maturityRating = movie.maturityRating();
        this.genres = movie.genres();
        this.releaseDate = movie.releaseDate();
        this.duration = movie.duration();
        this.posterImageUrl = movie.posterImageUrl();
    }

    public void update(MovieDTO data) {
        if (DataUtils.validString(data.title())) {
            this.title = data.title();
        }

        if (DataUtils.validString(data.maturityRating())) {
            this.maturityRating = data.maturityRating();
        }

        if (DataUtils.validList(data.genres())) {
            var currentGenres = new LinkedHashSet<>(this.genres);
            currentGenres.addAll(data.genres());
            this.genres.clear();
            this.genres.addAll(currentGenres);
        }

        if (DataUtils.validString(data.releaseDate())) {
            this.releaseDate = data.releaseDate();
        }

        if (DataUtils.validString(data.duration())) {
            this.duration = data.duration();
        }

        if (DataUtils.validString(data.posterImageUrl())) {
            this.posterImageUrl = data.posterImageUrl();
        }
    }

}
