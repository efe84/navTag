DROP TABLE IF EXISTS Location;
DROP TABLE IF EXISTS Command;
DROP TABLE IF EXISTS Tag;
DROP TABLE IF EXISTS User;

CREATE TABLE User (
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(30),
    name VARCHAR(30),
    email VARCHAR(100),
    password VARCHAR(100),
    version SMALLINT NOT NULL
);

CREATE TABLE Tag (
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT,
    name VARCHAR(60),
    description VARCHAR(255),
    FOREIGN KEY (user_id) REFERENCES User(id)
);

CREATE TABLE Location (
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    tag_id BIGINT,
    latitude DECIMAL(10, 8),
    longitude DECIMAL(11, 8),
    time TIMESTAMP,
    FOREIGN KEY (tag_id) REFERENCES Tag(id)
);

CREATE TABLE Command (
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    tag_id BIGINT,
    type VARCHAR(50),
    state VARCHAR(50),
    time TIMESTAMP,
    FOREIGN KEY (tag_id) REFERENCES Tag(id)
);