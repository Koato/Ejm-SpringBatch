drop table persona if exists;

create table persona(
	id bigint identity primary key,
	nombre varchar(20),
	apellido varchar(20),
	telefono char(8)
);