--liquibase formatted sql

--changeset a1aska17:1

CREATE TABLE books (
                       book_id BIGSERIAL PRIMARY KEY,
                       book_title VARCHAR(255) NOT NULL,
                       book_author VARCHAR(255) NOT NULL,
                       book_description TEXT,
                       book_publication_year INTEGER,
                       book_is_read BOOLEAN NOT NULL DEFAULT FALSE,
                       book_created_at TIMESTAMP NOT NULL,
                       book_update_at TIMESTAMP
);