drop database hellobank;
create database hellobank;

use hellobank;

DROP TABLE IF EXISTS `customer`;

CREATE TABLE `customer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome_completo` varchar(64) NOT NULL,
  `cpf` varchar(11) NOT NULL,
  `email` varchar(64) NOT NULL,
  `endereco` varchar(64) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8mb4;




DROP TABLE IF EXISTS `account`;

CREATE TABLE `account` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `agencia` varchar(64) NOT NULL,
  `conta` varchar(11) NOT NULL,
  `saldo` int NOT NULL,
  `customer` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_id_customer` (`customer`),
  CONSTRAINT `fk_id_customer` FOREIGN KEY (`customer`) REFERENCES `customer` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8mb4;


DROP TABLE IF EXISTS `type_movement`;

CREATE TABLE `type_movement` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type_movement` varchar(64) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;


DROP TABLE IF EXISTS `type_transaction`;

CREATE TABLE `type_transaction` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type_transaction` varchar(64) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;



DROP TABLE IF EXISTS `movement`;

CREATE TABLE `movement` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `data` timestamp NOT NULL DEFAULT current_timestamp(),
  `valor` int(11) NOT NULL,
  `type` int(11) NOT NULL,
  `account` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_id_account_m` (`account`),
  KEY `fk_id_type_movement` (`type`),
  CONSTRAINT `fk_id_account_m` FOREIGN KEY (`account`) REFERENCES `account` (`id`),
  CONSTRAINT `fk_id_type_movement` FOREIGN KEY (`type`) REFERENCES `type_movement` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8mb4;


DROP TABLE IF EXISTS `transaction`;

CREATE TABLE `transaction` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `data` timestamp NOT NULL DEFAULT current_timestamp(),
  `valor` int(11) NOT NULL,
  `type` int(11) NOT NULL,
  `account_send` int(11) DEFAULT NULL,
  `account_receive` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_id_account_send` (`account_send`),
  KEY `fk_id_account_receive` (`account_receive`),
  KEY `fk_id__type` (`type`),
  CONSTRAINT `fk_id__type` FOREIGN KEY (`type`) REFERENCES `type_transaction` (`id`),
  CONSTRAINT `fk_id_account_receive` FOREIGN KEY (`account_receive`) REFERENCES `account` (`id`),
  CONSTRAINT `fk_id_account_send` FOREIGN KEY (`account_send`) REFERENCES `account` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4;

