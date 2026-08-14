--liquibase formatted sql

--changeset a1aska17:1

CREATE TABLE users (
                       user_id BIGSERIAL PRIMARY KEY,
                       user_name VARCHAR(100) NOT NULL,
                       user_email VARCHAR(255) NOT NULL UNIQUE,
                       user_password VARCHAR(255) NOT NULL,
                       user_created_at TIMESTAMP NOT NULL,
                       user_update_at TIMESTAMP
);