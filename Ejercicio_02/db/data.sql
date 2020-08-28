CREATE DATABASE IF NOT EXISTS `MVC_db02`;

USE `MVC_db02`;

DROP TABLE IF EXISTS `cliente`;

CREATE TABLE `cliente` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(250) DEFAULT NULL,
  `apellido` varchar(250) DEFAULT NULL,
  `direccion` varchar(250) DEFAULT NULL,
  `dni` int(11) DEFAULT NULL,
  `fecha` date DEFAULT (CURRENT_DATE),
  PRIMARY KEY (`id`)
);

INSERT INTO `cliente` (nombre, apellido, direccion, dni) VALUES ('Jaume', 'Lopez', 'Lubowitz Valleys', '12048599'), ('Joan', 'Marsal', 'Darion Summit', '31245198'), 
('Jordi', 'Rubio', 'Darrel Skyway', '16248579'), ('Arnau', 'Aladid', 'Jacobson Crossroad', '15249963'), ('Daniel', 'Sopena', 'Jewel Spurs', '12345625'),
('Luis', 'Martinez', 'Christiansen Crest', '93846273'), ('Laia', 'fernandez', 'Paris Gateway', '1624852');


DROP TABLE IF EXISTS `videos`;

CREATE TABLE `videos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(250) DEFAULT NULL,
  `director` varchar(250) DEFAULT NULL,
  `cli_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `videos_fk` FOREIGN KEY (`cli_id`) REFERENCES `cliente` (`id`)
);

INSERT INTO `videos` (title, director, cli_id) VALUES ('Salt', 'Phillip Noyce', '1'), ('Takers', 'John Luessenhop', '2'), ('Hereafter', 'Clint Eastwood', '3'), 
('Flipped', 'Rob Reiner', '4'), ('Inception', 'Christopher Nolan', '5'), ('Killers', 'Robert Luketic', '6'), ('Togi Bear', 'Eric Brevig', '7');
