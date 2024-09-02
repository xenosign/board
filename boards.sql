create database module_db;
use module_db;
CREATE TABLE boards
(
    id       INTEGER AUTO_INCREMENT PRIMARY KEY,
    title    VARCHAR(200) NOT NULL,
    content  VARCHAR(200) NOT NULL,
    author   VARCHAR(50)  NOT NULL,
    reg_date DATETIME DEFAULT CURRENT_TIMESTAMP
);

INSERT INTO boards(title, content, author)
VALUES ('테스트 제목1', '테스트 내용1', 'user0'),
       ('테스트 제목2', '테스트 내용2', 'user0'),
       ('테스트 제목3', '테스트 내용3', 'user0'),
       ('테스트 제목4', '테스트 내용4', 'user0'),
       ('테스트 제목5', '테스트 내용5', 'user0');


SELECT *
FROM boards;
