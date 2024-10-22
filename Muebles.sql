USE db_muebles;

-- tablas

CREATE TABLE muebles (
  idMuebles int NOT NULL AUTO_INCREMENT,
  nombre varchar(100) NOT NULL,
  precio float NOT NULL,
  fecha_registro date NOT NULL,
  PRIMARY KEY (idMuebles)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;



-- *****************
-- Procedimientos almacenados:
-- ---------------------------------------------------------------
-- Listar muebles:

DELIMITER $$

CREATE PROCEDURE listar_muebles()
BEGIN
select*from muebles;
END$$

DELIMITER



call listar_muebles;
-- ----------------------------------------------------------------
-- Insertar Muebles:

DELIMITER $$

CREATE PROCEDURE insertar_muebles(
in munombre varchar(100), 
in muprecio float,
in mufecha_registro varchar(50)
)
BEGIN
insert into muebles (idMuebles,nombre,precio,fecha_registro) values (null,munombre,muprecio,mufecha_registro);
END$$

DELIMITER;

call insertar_muebles('Mesa de madera',150,'05-04-2024');

-- --------------------------------------------------------------
-- Listar Muebles por id:
DELIMITER $$

CREATE PROCEDURE `listar_por_id` (
in muid int
)
BEGIN
select * from muebles where idMuebles = muid;
END$$

DELIMITER;

call listar_por_id(5);
-- --------------------------------------------------------
-- Actualizar:

DELIMITER $$

CREATE  PROCEDURE `actualizar_muebles`(
in muid int,
in munombre varchar(100), 
in muprecio float,
in mufecha_registro varchar(50)
)
BEGIN
update muebles set nombre = munombre, precio = muprecio, fecha_registro = mufecha_registro where idMuebles = muid;
END$$

DELIMITER;



call actualizar_muebles(3,'Mesa de vidrio','301','20-08-2024');

-- -------------------------------------------------------------
-- Eliminar:

DELIMITER $$

CREATE PROCEDURE `eliminar_mueble` (
   IN muid INT
)
BEGIN
   DELETE FROM muebles WHERE idMuebles = muid;
END $$

DELIMITER ;



call eliminar_mueble(2);
