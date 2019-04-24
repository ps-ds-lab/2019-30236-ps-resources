CREATE SCHEMA `school` ;

CREATE TABLE `school`.`student` (
                                  `id` int(11) NOT NULL AUTO_INCREMENT,
                                  `name` VARCHAR(64) NOT NULL,
                                  `email` VARCHAR(32) NULL,
                                  PRIMARY KEY (`id`));

CREATE TABLE `address` (
                         `id` int(11) NOT NULL AUTO_INCREMENT,
                         `city` varchar(32) NOT NULL,
                         `street` varchar(32) NOT NULL,
                         `number` varchar(8) NOT NULL,
                         PRIMARY KEY (`id`)
);

CREATE TABLE `student_address` (
                                 `student_id` int(11) NOT NULL,
                                 `address_id` int(11) NOT NULL,
                                 KEY `student_address_student_fk` (`student_id`),
                                 KEY `student_address_address_fk` (`address_id`),
                                 CONSTRAINT `student_address_address_fk` FOREIGN KEY (`address_id`) REFERENCES `address` (`id`),
                                 CONSTRAINT `student_address_student_fk` FOREIGN KEY (`student_id`) REFERENCES `student` (`id`)
);