-- -----------------------------------------------------
-- Schema devcamp
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `devcamp` DEFAULT CHARACTER SET utf8 ;
USE `devcamp` ;


-- -----------------------------------------------------
-- Table `devcamp`.`url`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `devcamp`.`url` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `origin_url` MEDIUMTEXT NOT NULL,
  PRIMARY KEY (`id`));

ALTER TABLE `url` AUTO_INCREMENT=10000;
