# Hello_Bank_IBM

## Comandos para criar o Banco de Dados
 
````
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


``````
         <div class="card">
                <h4>Customer: &#x1F33B</h4>
                <hr/>
                <h5>GET- /customer/{Id}" </h5>
                <h5>GETALL- "/customer"  </h5>
                <h5>PUT- "/customer" </h5>
                <h5>POST- "/customer"  </h5>
                <h5>DELETE- "/customer/{Id}"  </h5>

            </div>
            <div class="card">
                <h4>CustomerAccount: &#x1F33B</h4>
                <hr/>
                <h5>GET- "/account/{Id}" </h5>
                <h5>GETALL- "/account"  </h5>
                <h5>DELETE- "/account/{Id}"  </h5>

            </div>
            <div class="card">
                <h4>Movement: &#x1F33B</h4>
                <hr/>
                <h5>GET- "/movements/{Id}" </h5>
                <h5>GETALL- "/movements"  </h5>
                <h5>POST- "/movements"  </h5>
                <h5>GET-"/movements/customer/{Id}"</h5>


            </div>
            <div class="card">
                <h4> Transaction: &#x1F33B</h4>
                <hr/>
                <h5>GET- "/transaction/{Id}" </h5>
                <h5>GETALL- "/transaction"  </h5>
                <h5>POST- "/transaction"  </h5>
                <h5>GET-"/transaction/customer/{Id}"</h5>


            </div>
            <div class="card">
                <h4> TypeTransaction: &#x1F33B</h4>
                <hr/>
                <h5>GET- "/TypeTransaction/{Id}" </h5>
                <h5>GETALL- "/TypeTransaction"  </h5>
                <h5>POST- "/TypeTransaction"  </h5>
                <h5>PUT-"/TypeTransaction"</h5>


            </div>
            <div class="card">
                <h4> TypeMovement: &#x1F33B</h4>
                <hr/>
                <h5>GET- "/TypeMovement/{Id}" </h5>
                <h5>GETALL- "/TypeMovement"  </h5>
                <h5>POST- "/TypeMovement"  </h5>
                <h5>PUT-"/TypeMovement"</h5>


            </div>