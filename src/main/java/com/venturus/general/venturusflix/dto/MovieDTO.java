package com.venturus.general.venturusflix.dto;

import java.util.List;

public record MovieDTO(String title,
                       String maturityRating,
                       List<String> genres,
                       String releaseDate,
                       String duration
) {
}
