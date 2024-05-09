create database inventario;

use inventario;

CREATE TABLE marca (
idMarca INTEGER PRIMARY KEY AUTO_INCREMENT,
nombre VARCHAR(30),
descripcion VARCHAR(100)
);

create table prenda (
idPrenda integer PRIMARY KEY AUTO_INCREMENT,
idMarca integer, 
talla VARCHAR(5),
costo DOUBLE,
venta DOUBLE,
modelo VARCHAR(30),
tipo VARCHAR(30),
stock integer,
descripcion VARCHAR (100),
FOREIGN KEY (idMarca) REFERENCES marca(idMarca) 
);


CREATE TABLE imagenes(
idImagen INTEGER PRIMARY KEY AUTO_INCREMENT,
idPrenda INTEGER,
nombre VARCHAR(100),
datos_imagen BLOB,
FOREIGN KEY (idPrenda) REFERENCES prenda(idPrenda) 
);



