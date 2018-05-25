create database asico;
use asico;

drop table calendariobase;
drop table planificacionCalendarios;

create table CalendarioBase(
	id varchar(8) primary key,
    id_universitat int,
    desc_spa varchar(20),
    desc_cat varchar(20),
    week_day int,
    isSummer boolean,
    isFestivo boolean,
    isActive boolean,
    curso_academico varchar(20)
    
);

create table planificacionCalendarios(
    id_dia int,
    id_universitat int,
    id_master int,
    id_sesion int,
    id_task1 int,
    id_task2 int,
    notaDia varchar(50),
    version int,
    PRIMARY KEY(id_dia, id_universitat, id_master)
);


-- select * from calendariobase;
-- select count(*) from calendariobase;
-- truncate calendariobase;