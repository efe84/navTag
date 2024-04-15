DROP TABLE IF EXISTS location;
DROP TABLE IF EXISTS command;
DROP TABLE IF EXISTS tag;
DROP TABLE IF EXISTS user;

CREATE TABLE user (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(30),
    name VARCHAR(30),
    email VARCHAR(100),
    password VARCHAR(100)
);

CREATE TABLE tag (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    nombre VARCHAR(60),
    descripcion VARCHAR(255),
    FOREIGN KEY (user_id) REFERENCES user(id)
);

CREATE TABLE location (
    id INT AUTO_INCREMENT PRIMARY KEY,
    tag_id INT,
    latitude DECIMAL(10, 8),
    longitude DECIMAL(11, 8),
    time TIMESTAMP,
    FOREIGN KEY (tag_id) REFERENCES tag(id)
);

CREATE TABLE command (
    id INT AUTO_INCREMENT PRIMARY KEY,
    tag_id INT,
    type VARCHAR(50),
    state VARCHAR(50),
    time TIMESTAMP,
    FOREIGN KEY (tag_id) REFERENCES tag(id)
);

INSERT INTO user (username, name, email, password) VALUES
('usuario1', 'Usuario Uno', 'usuario1@example.com', 'contraseña1'),
('usuario2', 'Usuario Dos', 'usuario2@example.com', 'contraseña2');

INSERT INTO tag (user_id, nombre, descripcion) VALUES
(1, 'Tag1', 'Descripción del Tag 1'),
(2, 'Tag2', 'Descripción del Tag 2');

INSERT INTO location (tag_id, latitude, longitude, time) VALUES
(1, 40.7128, -74.0060, NOW()),
(2, 34.0522, -118.2437, NOW());

INSERT INTO command (tag_id, type, state, time) VALUES
(1, 'Type1', 'State1', NOW()),
(2, 'Type2', 'State2', NOW());