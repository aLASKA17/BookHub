--liquibase formatted sql

--changeset a1aska17:1

ALTER TABLE books
    ADD COLUMN owner_id BIGINT;

ALTER TABLE books
    ADD CONSTRAINT fk_books_owner
        FOREIGN KEY (owner_id)
            REFERENCES users(user_id)
            ON DELETE CASCADE;