DROP TABLE IF EXISTS users CASCADE;
DROP SEQUENCE IF EXISTS global_seq CASCADE;

CREATE SEQUENCE GLOBAL_SEQ START WITH 100000;
CREATE TABLE users
(
    id               INT PRIMARY KEY DEFAULT nextval('GLOBAL_SEQ'),
    name             VARCHAR(255)            NOT NULL
);
CREATE TABLE girls
(
    id               INT PRIMARY KEY DEFAULT nextval('GLOBAL_SEQ'),
    name             VARCHAR(255)            NOT NULL,
    age              INT NOT NULL,
    user_id          INT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
);
CREATE TABLE cars
(
    id               INT PRIMARY KEY DEFAULT nextval('GLOBAL_SEQ'),
    manufacturer     VARCHAR(255)            NOT NULL,
    model            VARCHAR(255)            NOT NULL,
    user_id          INT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
);