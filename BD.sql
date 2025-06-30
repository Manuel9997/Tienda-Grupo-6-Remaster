create database BD_VENTA_ACCESORIOS_2025;
use BD_VENTA_ACCESORIOS_2025;
create table Accesorio(
IDchar(3) primary key,
Producto varchar(20) not null,
NombreDelModelo varchar(40) not null,
Precio real not null,
tiempoGarantía int not null,
Stock int not null);

select * from Accesorio;
IDchar(3) primary key,
Producto varchar(20) not null,
NombreModelo varchar(40) not null,
Precio real not null,
tiempoGarantía int not null,
Stock int not null);

create procedure sp_Listar()
select * from Accesorio;

call sp_Listar();

create procedure sp_Insertar(
IDchar char(3),
Producto varchar(20),
NombreDelModelo varchar(40),
Precio real,
tiempoGaracntía int,
stock int
)
insert into Accesorio values(IDchar, Producto, NombreModelo, Precio,tiempoGarantía, stock);

call sp_Insertar('A05', 'MONITOR', 'LG', 600, 13);
call sp_Listar();

create procedure sp_Eliminar(
codi char(3))
delete from Accesorio where codi_acce=codi;

call sp_Eliminar('A05');
call sp_Listar();

create procedure sp_Editar( 
codi char(3),
nom varchar(20),
marca varchar(40),
precio real,
stock int
)
update Accesorio set nom_acce=nom, marca_acce=marca, precio_acce=precio, stock_acce=stock
where codi_acce=codi;

call sp_Editar('A04', 'PARLANTE', 'ROBERTO', 350, 10);

create procedure sp_ConsultarCod(
codi char(3))
select * from Accesorio where codi_acce=codi;

call sp_ConsultarCod('A03');
