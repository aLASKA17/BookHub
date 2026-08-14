--liquibase formatted sql

--changeset a1aska17:1

CREATE TABLE roles (
                       role_id BIGSERIAL PRIMARY KEY,
                       role_name VARCHAR(50) NOT NULL UNIQUE,
                       role_created_at TIMESTAMP NOT NULL,
                       role_update_at TIMESTAMP
);
