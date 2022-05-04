DROP DATABASE IF EXISTS proyecto_departamento_pit2022;
CREATE DATABASE proyecto_departamento_pit2022;
USE proyecto_departamento_pit2022;

/* Login */
create table tb_usuario(
	idUsuario int not null primary key auto_increment ,
    username varchar(30) not null ,
    passw varchar(300) not null ,
    fecha_registro date not null
);

create table tb_administrador(
	idAdmin int not null primary key auto_increment ,
    nombres varchar(60) not null ,
    apellidos varchar(60) not null ,
    email varchar(30) not null ,
    dni char(8) not null ,
    fecha_nacimiento date not null ,
    idUsuario int not null ,
	constraint fk_usuario foreign key (idUsuario) references tb_usuario(idUsuario)
);

/* Departamento */
create table tb_tipo_departamento(
	idTipo int not null primary key auto_increment ,
    nombre varchar(45) not null
);

create table tb_distrito_edi(
	id_dis int not null primary key auto_increment,
    nom_dis varchar(30)
);

create table tb_edificio(
	idEdificio int not null primary key auto_increment,
    nombre varchar(45) not null,
    npisos varchar(2) not null,
    id_dis int not null,
    direccion varchar(40) not null,
    fech_const date not null,
	idAdmin int not null,
	constraint fk_fechconst foreign key (id_dis) references tb_distrito_edi(id_dis),
    constraint fk_adminedi foreign key (idAdmin) references tb_administrador(idAdmin)
);

create table tb_departamento(
	idDepartamento int not null primary key auto_increment ,
    metros double not null ,
    direccion varchar(40) not null,
    fecha_registro date not null ,
    idTipo int not null ,
    idEdificio int not null ,
    estado bit not null,
    idAdmin int not null ,
    constraint fk_admindepa foreign key (idAdmin) references tb_administrador(idAdmin) ,
    constraint fk_tipodepartamento2 foreign key (idTipo) references tb_tipo_departamento(idTipo) ,
    constraint fk_edificio2 foreign key (idEdificio) references tb_edificio(idEdificio)
);

/* Propietario */

create table tb_propietario(
	idPropietario int not null primary key auto_increment ,
    nombres varchar(60) not null ,
    apellidos varchar(60) not null ,
    dni char(8) not null ,
    fecha_nacimiento date not null ,
    fecha_registro date not null ,
    telefono char(9) not null ,
    idDepartamento int not null ,
    estado bit not null ,
	idAdmin int not null ,
    constraint fk_adminpro foreign key (idAdmin) references tb_administrador(idAdmin) ,
    constraint fk_depa foreign key (idDepartamento) references tb_departamento(idDepartamento)
);
/* Mascota */
create table tb_mascota(
	idMascota int not null primary key auto_increment ,
    nombre varchar(20) not null ,
    especie varchar(25) not null ,
    raza varchar(25) not null ,
    idPropietario int not null ,
     idAdmin int not null ,
    constraint fk_adminmascota foreign key (idAdmin) references tb_administrador(idAdmin) ,
    constraint fk_propietario foreign key (idPropietario) references tb_propietario(idPropietario)
);

/* Ocupante */
create table tb_ocupante(
	idOcupante int not null primary key auto_increment ,
    nombres varchar(60) not null ,
    apellidos varchar(60) not null ,
    fecha_nacimiento date not null ,
    dni char(8) not null ,
    telefono char(9) not null ,
    idPropietario int not null ,
	idAdmin int not null ,
    constraint fk_adminocu foreign key (idAdmin) references tb_administrador(idAdmin) ,
    constraint fk_propietario2 foreign key (idPropietario) references tb_propietario(idPropietario)
);

/* Visitas */
create table tb_visitante(
	idVisitante int not null primary key auto_increment ,
	nombres varchar(60) not null ,
    apellidos varchar(60) not null ,
    fecha_nacimiento date not null ,
    dni char(8) not null ,
    telefono char(9) not null ,
    direccion varchar(45) not null ,
    idPropietario int not null ,
	idAdmin int not null ,
    constraint fk_adminvis foreign key (idAdmin) references tb_administrador(idAdmin) ,
    constraint fk_visitantepro foreign key (idPropietario) references tb_propietario(idPropietario)
);

create table tb_visitas(
	idVisita int not null primary key auto_increment ,
    fecha_entrada date not null ,
    fecha_salida date not null ,
    idVisitante int not null ,
    idPropietario int not null ,
    constraint fk_propietario3 foreign key (idPropietario) references tb_propietario(idPropietario),
    constraint fk_visitante foreign key (idVisitante) references tb_visitante(idVisitante)
);

/* Registros */
insert into tb_distrito_edi values(null , "Comas");
insert into tb_distrito_edi values(null , "Los Olivos");
insert into tb_distrito_edi values(null , "Surco");
insert into tb_distrito_edi values(null , "Independencia");
insert into tb_distrito_edi values(null , "Miraflores");
insert into tb_distrito_edi values(null , "La Molina");

insert into tb_tipo_departamento values(null , "Libre");
insert into tb_tipo_departamento values(null , "Alquilado");
/*insert into tb_tipo_departamento values(null , "Comprado");*/

select * from tb_distrito_edi;
select * from tb_edificio;
select * from tb_usuario;
select * from tb_administrador;