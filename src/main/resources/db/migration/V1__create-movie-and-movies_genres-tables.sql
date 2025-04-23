USE movies_database;

CREATE TABLE movies (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    maturity_rating VARCHAR(2),
    release_date VARCHAR(20) NOT NULL,
    duration VARCHAR(20) NOT NULL
);

CREATE TABLE movie_genres (
    movie_id BIGINT NOT NULL,
    genre VARCHAR(100) NOT NULL,
    FOREIGN KEY (movie_id) REFERENCES movies(id) ON DELETE CASCADE,
    PRIMARY KEY (movie_id, genre)
);
