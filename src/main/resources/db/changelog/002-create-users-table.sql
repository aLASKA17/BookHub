--liquibase formatted sql

--changeset a1aska17:1

CREATE TABLE users (
                       id_user BIGSERIAL PRIMARY KEY,
                       user_name VARCHAR(100) NOT NULL,
                       email_user VARCHAR(255) NOT NULL UNIQUE,
                       password_user VARCHAR(255) NOT NULL,
                       created_at_user TIMESTAMP NOT NULL,
                       update_at_user TIMESTAMP
);