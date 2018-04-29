create database asico;
use asico;

drop table calendariobase;

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

-- select * from calendariobase;
-- select count(*) from calendariobase;
-- truncate calendariobase;