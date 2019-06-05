

CREATE TABLE usuario (
    nombre character varying(255) NOT NULL,
    apaterno character varying(255)not null,
    amaterno character varying(255),
    contrasenia character varying(255) NOT NULL,
    correo character varying(255) NOT NULL unique,
    rol character varying(255) NOT NULL,
    cif char(32),
    idUsuario character varying(30)not null primary key
);

CREATE TABLE tema (
    nombre character varying(255) NOT NULL primary key,
    usuario character varying(255) NOT NULL,   color character varying(255) NOT NULL
);

CREATE TABLE marcador (
    id_marcador integer NOT NULL primary key,
    tema character varying(255)not null,
    idUsuario character varying(255)not null,
    nombre character varying(255) NOT NULL,
    correo character varying(255) NOT NULL,
    latitud double precision,
    longitud double precision,
    descripcion character varying(255),
    datos character varying(255),
    foreign key(idUsuario)references usuario(idUsuario),
    foreign key(tema)references tema(nombre)
);

CREATE TABLE comentario (
    id_marcador integer NOT NULL,
    idUsuario character varying(30) NOT NULL,
    idComentario integer not null primary key, 
    comentario character varying(255),
    calificacion integer NOT NULL,
    foreign key(id_marcador)references marcador(id_marcador),
    foreign key(idUsuario)references usuario(idUsuario)
);
