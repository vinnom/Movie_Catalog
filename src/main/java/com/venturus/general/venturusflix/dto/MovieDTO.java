package com.venturus.general.venturusflix.dto;

import java.util.List;

public record MovieDTO(String title,
                       int maturityRating,
                       List<String> genres,
                       String releaseDate,
                       String duration
) {
}
