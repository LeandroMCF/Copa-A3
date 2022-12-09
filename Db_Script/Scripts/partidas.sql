use db_base;

create table tb_partidas
(
	id int primary key auto_increment,
    time1 int NOT NULL,
    time2 int NOT NULL,
    placar_time1 int,
    placar_time2 int,
    data_partida datetime,
    local varchar(200),
    FOREIGN KEY (time1) REFERENCES tb_times(id),
    FOREIGN KEY (time2) REFERENCES tb_times(id)
);

insert into tb_partidas(time1, time2, placar_time1, placar_time2, data_partida, local) values
(1, 2, 0, 3, "2015-11-05 14:29:36", "Estadio");

drop table tb_partidas;

SELECT * FROM db_base.tb_partidas;