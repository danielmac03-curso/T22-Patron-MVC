
CREATE DATABASE IF NOT EXISTS `MVC_db`;
USE `MVC_db`;

DROP TABLE IF EXISTS `cliente`;

CREATE TABLE `cliente` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(250) DEFAULT NULL,
  `apellido` varchar(250) DEFAULT NULL,
  `direccion` varchar(250) DEFAULT NULL,
  `dni` int(11) DEFAULT NULL,
  `fecha` date DEFAULT (CURRENT_DATE),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `cliente` (nombre, apellido, direccion, dni) VALUES 
('Jaume', 'Lopez', 'Reus', 65432100), 
('Joan', 'Marsal', 'Tarragona', 65432100),
('Jordi', 'Rubio', 'Salou', 665321987),
('Arnau', 'Aladid', 'Reus', 98764321),
('Daniel', 'Sopena', 'Tarragona', 65421987),
('Luis', 'Martinez', 'Salou', 65432000),
('Laia', 'Fernandez', 'Tarragona', 65432100);

