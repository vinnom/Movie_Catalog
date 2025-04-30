ALTER TABLE movies
ADD COLUMN poster_image_url VARCHAR(512) NULL COMMENT 'Movie poster URL';

DESCRIBE movies;