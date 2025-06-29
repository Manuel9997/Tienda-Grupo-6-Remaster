create database BD_VENTA_ACCESORIOS_2025;
use BD_VENTA_ACCESORIOS_2025;
create table Accesorio(
codi_acce char(3) primary key,
nom_acce varchar(20) not null,
marca_acce varchar(40) not null,
precio_acce real not null,
stock_acce int not null);

select * from Accesorio;
insert into Accesorio values('A01', 'MOUSE', 'GENIUS', 50, 20);
insert into Accesorio values('A02', 'TECLADO', 'LENOVO', 40, 15);
insert into Accesorio values('A03', 'IMPRESORA', 'HP', 300, 5);
insert into Accesorio values('A04', 'PARLANTE', 'SONY', 350, 10);

create procedure sp_Listar()
select * from Accesorio;

call sp_Listar();

create procedure sp_Insertar(
codi char(3),
nom varchar(20),
marca varchar(40),
precio real,
stock int
)
insert into Accesorio values(codi, nom, marca, precio, stock);

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