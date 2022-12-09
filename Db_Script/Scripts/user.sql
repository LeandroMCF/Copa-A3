create database db_base;
use db_base;

create table tb_users
(
	id int primary key auto_increment,
    nome varchar(200),
    email varchar(200) unique,
    senha varchar(200)
);

insert into tb_users(nome, email, senha) values
("Nome", "email@email.com", "Senha");

drop table tb_users;

SELECT * FROM db_base.tb_users;