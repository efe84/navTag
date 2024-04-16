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

INSERT INTO User (username, name, email, password, version) VALUES
('user1', 'user one', 'user1@example.com', 'password1', 0),
('user1', 'user two', 'user2@example.com', 'password2', 0);

INSERT INTO Tag (user_id, name, description) VALUES
(1, 'Tag1', 'Description of Tag 1'),
(2, 'Tag2', 'Description of Tag 2');

INSERT INTO Location (tag_id, latitude, longitude, time) VALUES
(1, 40.7128, -74.0060, NOW()),
(2, 34.0522, -118.2437, NOW());

INSERT INTO Command (tag_id, type, state, time) VALUES
(1, 'Type1', 'State1', NOW()),
(2, 'Type2', 'State2', NOW());