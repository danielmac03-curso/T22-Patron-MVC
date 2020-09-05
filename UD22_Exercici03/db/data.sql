DROP DATABASE IF EXISTS `MVC_03`;
CREATE DATABASE IF NOT EXISTS `MVC_03`;

USE `MVC_03`;

CREATE TABLE `cientifico` (
  `dni` varchar(8) NOT NULL DEFAULT '',
  `nomApels` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`dni`)
);

INSERT INTO `cientifico` (dni,nomApels) VALUES 
('48752136', 'Alba Gras'),
('85967253', 'Raquel Balada'),
('78549623', 'Berta Gras');


CREATE TABLE `proyecto` (
  `id` char(4) NOT NULL DEFAULT '',
  `nombre` varchar(250) DEFAULT NULL,
  `horas` int DEFAULT NULL,
  PRIMARY KEY (`id`)
);

INSERT INTO `proyecto` (id,nombre,horas) VALUES 
('1234', 'Fluidos',300),
('4321', 'Termodinámica',298),
('5678', 'Electromagnetismo',345);

CREATE TABLE `Asignado_A` (
  `cientifico` varchar(8) NOT NULL DEFAULT '',
  `proyecto` char(4) NOT NULL DEFAULT '',
  PRIMARY KEY (`cientifico`,`proyecto`),
  CONSTRAINT `asignado_fk` FOREIGN KEY (`proyecto`) REFERENCES `proyecto` (`id`),
  CONSTRAINT `asignado1_fk` FOREIGN KEY (`cientifico`) REFERENCES `cientifico` (`dni`)
);

INSERT INTO `Asignado_A` (cientifico, proyecto) VALUES 
('48752136', '1234'), 
('85967253', '1234');



