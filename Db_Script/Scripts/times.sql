use db_base;

create table tb_times
(
	id int primary key auto_increment,
    nome varchar(200),
    status boolean,
    pontos int
);

insert into tb_times(nome, pontos, status) values
("Suiça", 0, 1);

drop table tb_times;

SELECT nome FROM db_base.tb_times;