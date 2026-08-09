--liquibase formatted sql

--changeset a1aska17:1

CREATE TABLE books (
                       id_book BIGSERIAL PRIMARY KEY,
                       title_book VARCHAR(255) NOT NULL,
                       author_book VARCHAR(255) NOT NULL,
                       description_book TEXT,
                       publication_year_book INTEGER,
                       is_read BOOLEAN NOT NULL DEFAULT FALSE,
                       created_at_book TIMESTAMP NOT NULL,
                       update_at_book TIMESTAMP
);