CREATE DATABASE IF NOT EXISTS groups;
USE groups;
CREATE TABLE IF NOT EXISTS users
(
    id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    login VARCHAR(32) NOT NULL
);
CREATE UNIQUE INDEX users_login_uindex ON users (login);
CREATE TABLE IF NOT EXISTS groups
(
    id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    name VARCHAR(32) NOT NULL
);
CREATE UNIQUE INDEX groups_name_uindex ON groups (name);
CREATE TABLE IF NOT EXISTS users_groups
(
    user_id INT NOT NULL,
    group_id INT NOT NULL,   
    PRIMARY KEY (group_id, user_id),
    CONSTRAINT user_id FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT group_id FOREIGN KEY (group_id) REFERENCES groups (id) ON DELETE CASCADE ON UPDATE CASCADE
);
INSERT INTO users (login) VALUES ("petrov");
INSERT INTO users (login) VALUES ("obama");
