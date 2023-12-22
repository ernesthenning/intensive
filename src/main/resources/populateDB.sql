DELETE FROM users;
DELETE FROM cars;
DELETE FROM girls;

INSERT INTO users (name)
VALUES ('Ivan'),
       ('Vasily');

INSERT INTO girls (id, name, age, user_id)
VALUES (1, 'Anna', 20, 100001),
       (2, 'Irina', 21, 100001),
       (3, 'Oksana', 20, 100001),
       (4, 'Marina', 22, 100002),
       (5, 'Zina', 19, 100002);

INSERT INTO cars (id, manufacturer, model, user_id)
VALUES (1, 'VAZ', '2101', 100001),
       (2, 'VOLGA', '3110', 100001),
       (3, 'ZAZ', 'Zaporozhets', 100002);