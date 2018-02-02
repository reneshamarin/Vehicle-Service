-- MySQL Script generated by MySQL Workbench
-- Sun Sep 24 00:00:36 2017
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema vehicle
-- -----------------------------------------------------


USE `vehicle` ;

-- -----------------------------------------------------
-- Table `vehicle`.`brand`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `vehicle`.`brand` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(50) NULL,
  `description` VARCHAR(100) NULL,
  `sortorder` INT NULL,
  `active` TINYINT(1) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `vehicle`.`model`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `vehicle`.`model` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NULL,
  `description` VARCHAR(200) NULL,
  `type_id` INT UNSIGNED NOT NULL,
  `brand_id` INT UNSIGNED NOT NULL,
  `active` TINYINT(1) NULL,
  `sortorder` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `mode_brand_id_idx` (`brand_id` ASC),
  CONSTRAINT `mode_brand_id`
    FOREIGN KEY (`brand_id`)
    REFERENCES `vehicle`.`brand` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `vehicle`.`insurance`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `vehicle`.`insurance` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `policy_num` VARCHAR(100) NULL,
  `company_name` VARCHAR(100) NULL,
  `expiry_date` DATE NULL,
  `active` TINYINT(1) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `vehicle`.`vehicle`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `vehicle`.`vehicle` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `registration_number` VARCHAR(10) NULL,
  `model_id` INT UNSIGNED NULL,
  `insurance_id` INT UNSIGNED NULL,
  `color` VARCHAR(45) NULL,
  `owner_id` INT UNSIGNED NULL,
  `driver_id` INT UNSIGNED NULL,
  PRIMARY KEY (`id`),
  INDEX `vehicle_model_id_idx` (`model_id` ASC),
  INDEX `vehicle_insurance_id_idx` (`insurance_id` ASC),
  CONSTRAINT `vehicle_model_id`
    FOREIGN KEY (`model_id`)
    REFERENCES `vehicle`.`model` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `vehicle_insurance_id`
    FOREIGN KEY (`insurance_id`)
    REFERENCES `vehicle`.`insurance` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `vehicle`.`type`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `vehicle`.`type` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `vehicle`.`service`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `vehicle`.`service` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NULL,
  `description` VARCHAR(200) NULL,
  `cost` DOUBLE NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `vehicle`.`job`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `vehicle`.`job` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `vehicle_id` INT UNSIGNED NULL,
  `in_time` TIMESTAMP NULL,
  `estimated_delivery` TIMESTAMP NULL,
  `out_time` TIMESTAMP NULL,
  `estimated_cost` DOUBLE NULL,
  `total_cost` DOUBLE NULL,
  `status` VARCHAR(45) NULL,
  `service_advisor_id` INT UNSIGNED NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `vehicle`.`job_line_items`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `vehicle`.`job_line_items` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `job_id` INT UNSIGNED NOT NULL,
  `service_id` INT UNSIGNED NULL,
  `description` VARCHAR(200) NULL,
  `estimated_cost` DOUBLE NULL,
  `actual_cost` DOUBLE NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
