use db_base;

create table tb_players
(
	id int primary key auto_increment,
    times_id int NOT NULL,
    nome varchar(200),
    numero int,
    FOREIGN KEY (times_id) REFERENCES tb_times(id)
);

insert into tb_players(times_id, nome, numero) values
(2, "Vini Jr", 11);

drop table tb_players;

SELECT * FROM db_base.tb_players where times_id = 2;