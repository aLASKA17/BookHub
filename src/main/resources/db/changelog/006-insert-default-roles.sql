--liquibase formatted sql

--changeset a1aska17:1

INSERT INTO roles (role_name, role_created_at)
VALUES
    ('USER', CURRENT_TIMESTAMP),
    ('ADMIN', CURRENT_TIMESTAMP);