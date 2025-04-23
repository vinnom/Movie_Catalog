CREATE TABLE movie_genres (
    movie_id BIGINT NOT NULL,
    genres VARCHAR(255) NOT NULL,
    FOREIGN KEY (movie_id) REFERENCES movies(id) ON DELETE CASCADE,
    PRIMARY KEY (movie_id, genres)
);