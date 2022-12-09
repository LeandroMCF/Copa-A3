use db_base;

create table tb_chave
(
	id int primary key auto_increment,
    time1 int NOT NULL,
    time2 int NOT NULL,
    time3 int NOT NULL,
    time4 int NOT NULL,
    nome varchar(200),
    FOREIGN KEY (time1) REFERENCES tb_times(id),
    FOREIGN KEY (time2) REFERENCES tb_times(id),
    FOREIGN KEY (time3) REFERENCES tb_times(id),
    FOREIGN KEY (time4) REFERENCES tb_times(id)
);

insert into tb_chave(time1, time2, time3, time4, nome) values
(1, 2, 3, 4, "A");

drop table tb_chave;

SELECT * FROM db_base.tb_chave;