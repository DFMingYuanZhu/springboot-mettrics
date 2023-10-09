DROP TABLE IF EXISTS `PERSON`;
CREATE TABLE `PERSON` (
`id` varchar(100) NOT NULL DEFAULT '',
`age` int(4) NOT NULL DEFAULT '0',
`name` varchar(100) NOT NULL DEFAULT ''
);

DROP TABLE IF EXISTS `CLASSROOM`;
CREATE TABLE `CLASSROOM` (
    `id` varchar(100) NOT NULL DEFAULT '',
    `name` varchar(32) NOT NULL DEFAULT '',
    `location` varchar(100) NOT NULL DEFAULT ''
);

INSERT INTO person (name, age, id) VALUES
  ('nick', '28', '12345A'),
  ('bob', '21', '98765B');
