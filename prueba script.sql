-- MySQL Script generated by MySQL Workbench
-- Mon May 30 17:54:44 2022
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema proyecto
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `proyecto` ;

-- -----------------------------------------------------
-- Schema proyecto
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `proyecto` DEFAULT CHARACTER SET utf8 ;
USE `proyecto` ;

-- -----------------------------------------------------
-- Table `Artista`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Artista` ;

CREATE TABLE IF NOT EXISTS `Artista` (
  `nombre` VARCHAR(10) NOT NULL,
  `genero` VARCHAR(10) NULL,
  `pais` VARCHAR(20) NULL,
  `foto` VARCHAR(45) NULL,
  `Partida_nombre_usuario` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`nombre`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Partida`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Partida` ;

CREATE TABLE IF NOT EXISTS `Partida` (
  `nombre_usuario` VARCHAR(20) NOT NULL,
  `cancion_jugada` VARCHAR(15) NULL,
  `cacion` VARCHAR(15) NULL,
  `fecha_hora` DATETIME NULL,
  `acierto` VARCHAR(15) NULL,
  PRIMARY KEY (`nombre_usuario`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Usuario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Usuario` ;

CREATE TABLE IF NOT EXISTS `Usuario` (
  `nombre` VARCHAR(20) NULL,
  `genero` VARCHAR(10) NULL,
  `pais` VARCHAR(45) NULL,
  `idioma` VARCHAR(45) NULL,
  `pass` VARCHAR(45) NULL,
  `email` VARCHAR(45) NOT NULL,
  `Partida_nombre_usuario` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`email`, `Partida_nombre_usuario`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cancion_con_opcion`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cancion_con_opcion` ;

CREATE TABLE IF NOT EXISTS `cancion_con_opcion` (
  `nombre` VARCHAR(25) NOT NULL,
  `artista` VARCHAR(45) NULL,
  `duracion` TIME NULL,
  `audio` VARCHAR(45) NULL,
  `respuesta_posible` VARCHAR(45) NULL,
  `Partida_nombre_usuario` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`nombre`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
