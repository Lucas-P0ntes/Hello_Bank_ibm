# Hello_Bank_IBM
´´´
create database hellobank;
use hellobank;

create table custumer (
id Integer AUTO_INCREMENT ,
nome_completo varchar(64) not null,
cpf varchar(11) not null ,
email varchar(64) not null,
endereco varchar(64) not null,
custumer_account Integer not null,
PRIMARY KEY (id)
);

create table custumerAccount (
id Integer AUTO_INCREMENT not null,
agencia varchar(64) not null,
conta varchar(11) not null ,
saldo Integer not null,
custumer Integer,
PRIMARY KEY (id)
);

create table transaction (
id Integer AUTO_INCREMENT not null,
data datetime  not null,
valor Integer not null ,
type Integer not null,
account_send Integer,
account_receive Integer,
PRIMARY KEY (id)
);

create table movement (
id Integer AUTO_INCREMENT not null,
data datetime  not null,
valor Integer not null ,
type Integer not null,
account_custumer Integer,
PRIMARY KEY (id)
);


create table type_transaction (
id Integer AUTO_INCREMENT not null,
type_transaction varchar(64)  not null,
PRIMARY KEY (id)
);

create table type_movement (
id Integer AUTO_INCREMENT not null,
type_movement varchar(64)  not null,
PRIMARY KEY (id)
);


ALTER TABLE hellobank.custumer ADD CONSTRAINT fk_id_Account FOREIGN KEY (custumer_account) REFERENCES hellobank.custumerAccount(id);
ALTER TABLE hellobank.custumerAccount ADD CONSTRAINT fk_id_custumer FOREIGN KEY (custumer) REFERENCES hellobank.custumer(id);
ALTER TABLE hellobank.transaction ADD CONSTRAINT fk_id_account_send FOREIGN KEY (account_send) REFERENCES hellobank.custumerAccount(id);
ALTER TABLE hellobank.transaction ADD CONSTRAINT fk_id_account_receive FOREIGN KEY (account_receive) REFERENCES hellobank.custumerAccount(id);
ALTER TABLE hellobank.movement ADD CONSTRAINT fk_id_account_m FOREIGN KEY (account_custumer) REFERENCES hellobank.custumerAccount(id);


ALTER TABLE hellobank.transaction ADD CONSTRAINT fk_id__type FOREIGN KEY (type) REFERENCES hellobank.type_transaction(id);
ALTER TABLE hellobank.movement ADD CONSTRAINT fk_id_type_movement FOREIGN KEY (type) REFERENCES hellobank.type_movement(id);


´´´