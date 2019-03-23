CREATE SCHEMA `school` ;

CREATE TABLE `school`.`student` (
  `id` INT NOT NULL,
  `name` VARCHAR(64) NOT NULL,
  `email` VARCHAR(32) NULL,
  PRIMARY KEY (`id`));

ALTER TABLE student MODIFY id INT(11) NOT NULL AUTO_INCREMENT;
