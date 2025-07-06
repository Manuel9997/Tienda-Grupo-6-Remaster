create database BD_TIENDA_TECNOBOX;
use BD_TIENDA_TECNOBOX;
#------------------------------------------------------- LOGIN ADMINISTRADOR -------------------------------------------------------------
create table LoginAdmi(
usuario char(4) primary key,
contraseña char(5)
);
insert into LoginAdmi values('A001', '12345');
select * from LoginAdmi where usuario = "" and contraseña = '';

#------------------------------------------------------------- CLIENTE -------------------------------------------------------------------
create table Cliente(      
dni_cliente char(8) primary key,
nombre_cliente varchar(30) not null,
telefono_cliente char(9) not null
);
select * from Cliente;
insert into Cliente values('70148392', 'Juan Pérez Bravo', '987654321');
insert into Cliente values('71295048', 'Ana López Delgado', '912345678');
insert into Cliente values('72380417', 'Carlos Gómez Martínez', '998877665');
insert into Cliente values('73421865', 'María Fernanda Ruiz', '987123456');
insert into Cliente values('74539012', 'Luis Alberto Cruz', '912345987');
insert into Cliente values('75604138', 'Daniela Moreno Rojas', '913246578');
insert into Cliente values('76723984', 'Pedro Castillo Palacios', '976543210');
insert into Cliente values('77849230', 'Verónica Salazar Sánchez', '945612378');
insert into Cliente values('78916325', 'Ricardo Alvarado Mendoza', '932165478');
insert into Cliente values('79384071', 'Paola Méndez Peña', '967812345');

create procedure sp_MostrarCliente()
select * from Cliente;

call sp_MostrarCliente();

create procedure sp_AgregarCliente(
dni char(8),
nombre varchar(30),
telefono char(9)
)
insert into Cliente values (dni, nombre, telefono);

call sp_AgregarCliente('75893254', 'Romina Peña Hurtado', '958245646');
call sp_MostrarCliente();

create procedure sp_ModificarCliente( 
dni char(8),
nombre varchar(30),
telefono char(9)
)
update Cliente set nombre_cliente = nombre, telefono_cliente = telefono
where dni_cliente = dni;

call sp_ModificarCliente('79384071', 'Paola Méndez Peña', '952347828');
call sp_MostrarCliente();

create procedure sp_BuscarCliente(
dni char(8)
)
select * from Cliente where dni_cliente = dni;

call sp_BuscarCliente('78916325');

#------------------------------------------------------------- EMPLEADO ------------------------------------------------------------------
create table Empleado(
id_empleado int primary key,         
dni_empleado char(8) not null unique,
nombre_empleado varchar(30) not null,
telefono_empleado char(9) not null,
fecha_empleado date default (current_date) not null,                    
cargo_empleado varchar(10) not null,
jornada_empleado varchar(20) not null,
horario_empleado varchar(25) not null,
sueldo_empleado real not null
);
select * from Empleado;
insert into Empleado values(123, '74567892', 'Lucía Fernández Salas', '955321987', '2025-04-13', 'Cajero', 'Medio tiempo', '8:00 a.m. - 12:00 a.m.', 600);
insert into Empleado values(245, '75678901', 'Ana Torres Benavides', '985654321', '2025-04-13', 'Vendedor', 'Tiempo completo', '8:00 a.m. - 5:00 p.m.', 1200);
insert into Empleado values(378, '76789015', 'Valentina Ruiz Huertas', '935789123', '2025-04-14', 'Cajero', 'Tiempo completo', '8:00 a.m. - 5:00 p.m.', 1200);
insert into Empleado values(412, '77890126', 'Sara Palacios Durand', '954987654', '2025-04-18', 'Vendedor', 'Medio tiempo', '1:00 p.m. - 5:00 p.m.', 600);
insert into Empleado values(533, '78901237', 'Rogelio Vargas Ruiz', '975345678', '2025-05-02', 'Vendedor', 'Tiempo completo', '9:00 a.m. - 6:00 p.m.', 1200);
insert into Empleado values(601, '79012348', 'Fabricio Peña Ramírez', '912432198', '2025-05-02', 'Vendedor', 'Tiempo completo', '7:00 a.m. - 4:00 p.m.', 1200);
insert into Empleado values(714, '70123459', 'María Elena Hinostroza', '958678321', '2025-05-24', 'Cajero', 'Medio tiempo', '2:00 p.m. - 6:00 p.m.', 600);
insert into Empleado values(829, '71234560', 'José Meza Burgos', '963876543', '2025-05-24', 'Vendedor', 'Tiempo completo', '10:00 a.m. - 7:00 p.m.', 1200);

create procedure sp_MostrarEmpleado()
select * from Empleado;

call sp_MostrarEmpleado();

create procedure sp_AgregarEmpleado(
id int, 
dni char(8),
nombre varchar(30),
telefono char(9),
cargo varchar(10), 
jornada varchar(20),
horario varchar(25), 
sueldo real
)
insert into Empleado (id_empleado, dni_empleado, nombre_empleado, telefono_empleado, cargo_empleado, jornada_empleado, horario_empleado, sueldo_empleado) 
values (id, dni, nombre, telefono, cargo, jornada, horario, sueldo);

call sp_AgregarEmpleado(900, '73547291', 'Carlos Mejía Milla', '927123456', 'Vendedor', 'Tiempo completo', '9:00 a.m. - 6:00 p.m.', 1200);
call sp_MostrarEmpleado();

create procedure sp_ModificarEmpleado( 
id int, 
dni char(8),
nombre varchar(30),
telefono char(9),
fecha date,
cargo varchar(10), 
jornada varchar(20),
horario varchar(25), 
sueldo real
)
update Empleado set dni_empleado = dni, nombre_empleado = nombre, telefono_empleado = telefono, fecha_empleado = fecha, cargo_empleado = cargo, jornada_empleado = jornada, 
horario_empleado = horario, sueldo_empleado = sueldo
where id_empleado = id;

call sp_ModificarEmpleado(123, '74567892', 'Lucía Fernández Salas', '955321987', '2025-04-13', 'Vendedor', 'Medio tiempo', '8:00 a.m. - 12:00 a.m.', 600);
call sp_MostrarEmpleado();

create procedure sp_EliminarEmpleado(
id int
)
delete from Empleado where id_empleado = id;

call sp_EliminarEmpleado(123);
call sp_MostrarEmpleado();

create procedure sp_BuscarEmpleado(
id int
)
select * from Empleado where id_empleado = id;

call sp_BuscarEmpleado(601);

#------------------------------------------------------------- PROVEEDOR ------------------------------------------------------------------
create table Proveedor (
id_proveedor int primary key,
ruc_proveedor char(11) not null unique,
nombre_proveedor varchar(50) not null,
telefono_proveedor char(9) not null,
correo_proveedor varchar(50) not null,
direccion_proveedor varchar(50) not null,
estado_proveedor varchar(10) not null,
fecha_proveedor date default (current_date) not null
);


select * from Proveedor;
insert into Proveedor values(1, '20678901234', 'Electrónica y Cía SAC', '922334455', 'contactoelectronica@gmail.com', 'Calle Los Laureles 321, Chiclayo', 'Activo', '2025-04-10');
insert into Proveedor values(2, '20789012345', 'Andes Tech Distribuciones S.R.L.', '933221100', 'infoandestech@gmail.com', 'Av. Cusco 123, Cusco', 'Activo', '2025-04-10');
insert into Proveedor values(3, '20890123456', 'Componentes del Sur SAC', '988776655', 'ventascompsur@gmail.com', 'Carretera Panamericana Km 45, Tacna', 'Inactivo', '2025-04-10');
insert into Proveedor values(4, '20901234567', 'Lima Electrónica Import S.A.C', '955663322', 'ventasleimport@gmail.com', 'Av. Javier Prado Este 998, Lima', 'Activo', '2025-04-25');
insert into Proveedor values(5, '21012345678', 'Perú Tecnología Global EIRL', '911223344', 'adminperutecglobal@gmail.com', 'Av. Grau 321, Piura', 'Activo', '2025-04-30');
insert into Proveedor values(6, '21123456789', 'Mega Hardware y Accesorios SAC', '944556677', 'contactomegahardware@gmail.com', 'Calle Comercio 456, Iquitos', 'Activo', '2025-05-15');
insert into Proveedor values(7, '21234567890', 'Zona Digital Proveedores SAC', '900112233', 'zonadigitalproveedores@gmail.com', 'Calle 28 de Julio 202, Huancayo', 'Activo', '2025-05-15');

create procedure sp_MostrarProveedor()
select * from Proveedor;

call sp_MostrarProveedor();

create procedure sp_AgregarProveedor(
id int,
ruc char(11),
nombre varchar(50),
telefono char(9),
correo varchar(50),
direccion varchar(50),
estado varchar(10),
fecha date
)
insert into Proveedor (id_proveedor, ruc_proveedor, nombre_proveedor, telefono_proveedor, correo_proveedor, direccion_proveedor, estado_proveedor,fecha_proveedor) 
values (id, ruc, nombre, telefono, correo, direccion, estado,fecha);

call sp_AgregarProveedor(8, '21335678867', 'Whitrec.SA.C', '917471964', 'tecnoso@gmail.com', 'Mz l4 lt12, Bellavista', 'Activo','2025-05-15');
call sp_MostrarProveedor();

create procedure sp_ModificarProveedor( 
id int,
ruc char(11),
nombre varchar(50),
telefono char(9),
correo varchar(50), 
direccion varchar(50),
estado varchar(10),
fecha date
)
update Proveedor set ruc_proveedor = ruc, nombre_proveedor = nombre, telefono_proveedor = telefono, correo_proveedor = correo, direccion_proveedor = direccion, estado_proveedor = estado
where id_proveedor = id;

call sp_ModificarProveedor(7, '21234567886', 'Zona Digital Proveedores SAC', '900112233', 'zonadigitalproveedores@gmail.com', 'Calle 28 de Julio 202, Huancayo', 'Activo', '2025-05-15');
call sp_MostrarProveedor();

create procedure sp_BuscarProveedor(
id int
)
select * from Proveedor where id_proveedor = id;

call sp_BuscarProveedor(6);

#------------------------------------------------------------- PRODUCTO -----------------------------------------------------------------
create table Producto(
id_producto int primary key,
categoria_producto varchar(15) not null,
nombre_producto varchar(30) not null,
garantia_producto varchar(10) not null,
id_proveedor int not null,
precio_producto real not null,
stock_producto int not null,

foreign key (id_proveedor) references Proveedor(id_proveedor)
);
select * from Producto;
insert into Producto values(189, 'Laptop', 'Asus TUF Gaming F15', '1 año', 1, 3500.00, 5);
insert into Producto values(145, 'Laptop', 'HP Pavilion x360', '1 año', 1, 2800.00, 3);
insert into Producto values(378, 'Mouse', 'Logitech G502 Hero', '6 meses', 6, 180.00, 15);
insert into Producto values(873, 'Teclado', 'Redragon Kumara K552', '6 meses', 6, 150.00, 10);
insert into Producto values(489, 'Celular', 'Samsung Galaxy S23', '1 año', 3, 3600.00, 4);
insert into Producto values(151, 'Tablet', 'iPad 9na Generación', '6 meses', 2, 2200.00, 6);
insert into Producto values(512, 'Impresora', 'HP Ink Tank 415', '1 año', 4, 600.00, 2);
insert into Producto values(458, 'Cámara Web', 'Logitech C920 HD', '6 meses', 5, 250.00, 8);
insert into Producto values(155, 'Router', 'TP-Link Archer AX10 Wi-Fi 6', '1 año', 5, 450.00, 9);
insert into Producto values(156, 'Laptop', 'Dell Inspiron 15 3000', '1 año', 1, 2900.00, 4);
insert into Producto values(158, 'Teclado', 'Logitech K380 Inalámbrico', '6 meses', 6, 130.00, 10);
insert into Producto values(163, 'Consola', 'PlayStation 5', '3 meses', 6, 3600.00, 2);
insert into Producto values(164, 'Impresora', 'Epson EcoTank L3250', '1 año', 4, 850.00, 3);
insert into Producto values(165, 'Laptop', 'Lenovo IdeaPad 3 Ryzen 5', '1 año', 1, 3100.00, 6);
insert into Producto values(166, 'Celular', 'iPhone 13', '1 año', 3, 4200.00, 3);
insert into Producto values(167, 'Mouse', 'Razer DeathAdder Essential', '6 meses', 6, 160.00, 12);
insert into Producto values(168, 'Tablet', 'Samsung Galaxy Tab A8', '6 meses', 2, 1700.00, 5);
insert into Producto values(169, 'Audífonos', 'JBL Tune 510BT', '6 meses', 2, 240.00, 9);
insert into Producto values(170, 'Teclado', 'Corsair K55 RGB', '6 meses', 6, 200.00, 7);
insert into Producto values(173, 'Cámara Web', 'Microsoft LifeCam HD-3000', '6 meses', 5, 220.00, 6);
insert into Producto values(174, 'Impresora', 'Canon PIXMA G2160', '1 año', 4, 750.00, 2);
insert into Producto values(190, 'Cargador', 'Samsung C-C 25w', '6 meses', 7, 89.00, 5);
insert into Producto values(215, 'Cargador', 'Samsung C-C 15w', '6 meses', 7, 69.00, 7);
insert into Producto values(230, 'Cargador', 'Samsung USB-C 25w', '6 meses', 7, 89.00, 5);

create procedure sp_MostrarProducto()
select
p.id_producto,
p.categoria_producto,
p.nombre_producto,
p.garantia_producto,
prov.nombre_proveedor,
p.precio_producto,
p.stock_producto

from Producto as p
join Proveedor as prov on p.id_proveedor = prov.id_proveedor
order by p.id_producto ASC;

call sp_MostrarProducto();

create procedure sp_AgregarProducto(
id int,
categoria varchar(15),
nombre varchar(30),
garantia varchar(10),
idProveedor int,
precio real,
stock int
)
insert into Producto values(id, categoria, nombre, garantia, idProveedor, precio, stock);

call sp_AgregarProducto(245, 'Tablet', 'Samsung Galaxy Tab S9 FE', '6 meses', 8, 1500, 10);
call sp_MostrarProducto();

create procedure sp_ModificarProducto(  
id int,
categoria varchar(15),
nombre varchar(30),
garantia varchar(10),
idProveedor int,
precio real
)
update Producto set categoria_producto = categoria, nombre_producto = nombre, garantia_producto = garantia, id_proveedor = idProveedor, precio_producto = precio
where id_producto = id;

call sp_ModificarProducto(174, 'Impresora', 'Canon PIXMA G2160', '6 meses', 4, 750.00);
call sp_MostrarProducto();

create procedure sp_EliminarProducto(
id int
)
delete from Producto where id_producto = id;

call sp_EliminarProducto(190);
call sp_MostrarProducto();

create procedure sp_BuscarProducto(
id int
)
select * from Producto where id_producto = id;

call sp_BuscarProducto(168);

DELIMITER $$
create procedure sp_AumentarStock(
in idProducto int,
in cantidad int
)
begin
update Producto
set stock_producto = stock_producto + cantidad
where id_producto = idProducto;
end $$

DELIMITER ;

call sp_AumentarStock(215, 3);
call sp_MostrarProducto();

#-------------------------------------------------------------- VENTA --------------------------------------------------------------------
create table Venta(
codigo_venta int primary key auto_increment,
dni_cliente char(8) not null,
fecha_venta date default (current_date) not null, 
hora_venta time default (current_time) not null,
tipopago_venta varchar(15) not null,
comprobante_venta varchar(10) not null,
id_empleado int null,
total_venta real null,

foreign key (dni_cliente) references Cliente(dni_cliente),
foreign key (id_empleado) references Empleado(id_empleado)
);
select * from Venta;
insert into Venta values(1, '70148392', '2025-04-13', '9:00:12', 'Efectivo', 'Boleta', 245, 3160);
insert into Venta values(2, '71295048', '2025-04-13', '10:00:17', 'Efectivo', 'Boleta', 601, 3500);
insert into Venta values(3, '72380417', '2025-04-13', '10:10:45', 'Débito', 'Factura', 601, 3600);
insert into Venta values(4, '73421865', '2025-04-13', '10:18:50', 'Efectivo', 'Boleta', 245, 180);
insert into Venta values(5, '74539012', '2025-04-13', '11:00:03', 'Crédito', 'Factura', 533, 4200);
insert into Venta values(6, '75604138', '2025-04-13', '11:30:16', 'Efectivo', 'Factura', 245, 890);
insert into Venta values(7, '76723984', '2025-04-13', '11:45:47', 'Crédito', 'Boleta', 601, 267);
insert into Venta values(8, '77849230', '2025-04-13', '12:00:23', 'Efectivo', 'Factura', 533, 360);
insert into Venta values(9, '78916325', '2025-04-13', '12:15:41', 'Débito', 'Boleta', 601, 2950);
insert into Venta values(10, '79384071', '2025-04-13', '12:45:17', 'Efectivo', 'Factura', 533, 480);

#---------------------------------------------------------- DETALLE VENTA -----------------------------------------------------------------
create table DetalleVenta(
id_detalleVenta int primary key auto_increment,
codigo_venta int not null,
id_producto int not null,
cantidad_detalleVenta int not null,
subtotal_detalleVenta real not null,

foreign key (codigo_venta) references Venta(codigo_venta),
foreign key (id_producto) references Producto(id_producto)
);
select * from DetalleVenta;
insert into DetalleVenta values(1, 1, 145, 1, 2800);
insert into DetalleVenta values(2, 2, 378, 2, 360);
insert into DetalleVenta values(3, 3, 189, 1, 3500);
insert into DetalleVenta values(4, 4, 489, 1, 3600);
insert into DetalleVenta values(5, 5, 378, 1, 180);
insert into DetalleVenta values(6, 6, 166, 1, 4200);
insert into DetalleVenta values(7, 7, 378, 3, 540);
insert into DetalleVenta values(8, 8, 158, 1, 130);
insert into DetalleVenta values(9, 9, 173, 1, 220);
insert into DetalleVenta values(10, 10, 230, 3, 267);




#------------------------------------------------- PROCEDURES DE VENTA Y DETALLE VENTA -----------------------------------------------------
create procedure sp_MostrarVenta()
select
v.codigo_venta,
c.dni_cliente, 
c.nombre_cliente,
c.telefono_cliente,
v.fecha_venta,
v.hora_venta,
v.tipopago_venta,
v.comprobante_venta,
e.id_empleado,
e.nombre_empleado,
v.total_venta

from Venta as v
join Cliente as c on v.dni_cliente = c.dni_cliente
join Empleado as e on v.id_empleado = e.id_empleado
order by v.codigo_venta ASC;

call sp_MostrarVenta();

create procedure sp_MostrarDetalleVenta()
select
dv.id_detalleVenta,
v.codigo_venta,
p.id_producto,
p.categoria_producto,
p.nombre_producto,
p.garantia_producto,
p.precio_producto,
dv.cantidad_detalleVenta,
dv.subtotal_detalleVenta

from Venta as v
join DetalleVenta as dv on v.codigo_venta = dv.codigo_venta
join Producto as p on dv.id_producto = p.id_producto
order by v.codigo_venta ASC, dv.id_detalleVenta ASC;

call sp_MostrarDetalleVenta();

create procedure sp_MostrarHistorialVentas()
select
v.codigo_venta,
dv.id_detalleVenta,
c.dni_cliente,
c.nombre_cliente,
c.telefono_cliente,
v.fecha_venta,
v.hora_venta,
p.id_producto,
p.categoria_producto,
p.nombre_producto,
p.garantia_producto,
p.precio_producto,
dv.cantidad_detalleVenta,
v.tipopago_venta,
v.comprobante_venta,
e.id_empleado,
e.nombre_empleado,
dv.subtotal_detalleVenta,
v.total_venta
from Venta as v
join Cliente as c on v.dni_cliente = c.dni_cliente
join Empleado as e on v.id_empleado = e.id_empleado
join DetalleVenta as dv on v.codigo_venta = dv.codigo_venta
join Producto as p on dv.id_producto = p.id_producto
order by v.codigo_venta ASC;

call sp_MostrarHistorialVentas();

create procedure sp_AgregarVenta(
dniCliente char(8),
tipopago varchar(15),
comprobante varchar(10),
idEmpleado int
)
insert into Venta (dni_cliente, tipopago_venta, comprobante_venta, id_empleado, total_venta)
values (dniCliente, tipopago, comprobante, idEmpleado, 0);

call sp_AgregarVenta('74539012', 'Débito', 'Boleta', 412);
call sp_MostrarVenta(); 

DELIMITER $$
create procedure sp_AgregarDetalleVenta(
codigoVenta int,
idProducto int,
cantidad int
)
begin
declare precio real;
declare subtotal real;

-- Obtener el precio del producto
select precio_producto into precio
from Producto
where id_producto = idProducto;

-- Calcular subtotal
set subtotal = cantidad * precio;

insert into DetalleVenta (codigo_venta, id_producto, cantidad_detalleVenta, subtotal_detalleVenta)
values (codigoVenta, idProducto, cantidad, subtotal);

 -- Actualizar el stock del producto (reducir)
update Producto
set stock_producto = stock_producto - cantidad
where id_producto = idProducto;
end $$
DELIMITER ;

call sp_AgregarDetalleVenta(11, 151, 2);
call sp_AgregarDetalleVenta(12, 489, 2);
call sp_MostrarDetalleVenta();
DELIMITER $$

create procedure sp_CalcularTotalVenta(
in codVenta int
)
begin
declare total real;

-- Calcular la suma de todos los subtotales del detalle de esa venta
select sum(subtotal_detalleVenta)
into total
from DetalleVenta
where codigo_venta = codVenta;

-- Actualizar el total en la tabla Venta
update Venta
set total_venta = total
where codigo_venta = codVenta;
end $$
DELIMITER ;

call sp_CalcularTotalVenta(11);
call sp_MostrarHIstorialVentas();

create procedure sp_ModificarVenta(
codVenta int,
dniCliente char(8),
tipopago varchar(15),
comprobante varchar(10),
idEmpleado int
)
update Venta set dni_cliente = dniCliente, tipopago_venta = tipopago, comprobante_venta = comprobante, id_empleado = idEmpleado
where codigo_venta = codVenta;

call sp_ModificarVenta(5, '74539012', 'Débito', 'Factura', 533);
call sp_MostrarVenta();

DELIMITER $$
create procedure sp_ModificarDetalleVenta(
iddetalle int,
nuevoidproducto int,
nuevacantidad int
)
begin
declare cantidadanterior int;
declare idproductoanterior int;
declare nuevoprecio real;
declare nuevosubtotal real;

-- obtener cantidad y producto anteriores
select cantidad_detalleVenta, id_producto
into cantidadanterior, idproductoanterior
from DetalleVenta
where id_detalleVenta = iddetalle;

-- restaurar stock del producto anterior
update Producto
set stock_producto = stock_producto + cantidadanterior
where id_producto = idproductoanterior;

-- obtener nuevo precio del producto
select precio_producto into nuevoprecio
from Producto
where id_producto = nuevoidproducto;

-- calcular nuevo subtotal
set nuevosubtotal = nuevacantidad * nuevoprecio;

-- actualizar el detalle de venta (sin cambiar codigo_venta)
update DetalleVenta
set id_producto = nuevoidproducto, cantidad_detalleVenta = nuevacantidad, subtotal_detalleVenta = nuevosubtotal
where id_detalleventa = iddetalle;

-- reducir stock del nuevo producto
update Producto
set stock_producto = stock_producto - nuevacantidad
where id_producto = nuevoidproducto;

-- recalcular total
call sp_CalcularTotalVenta(5);

end $$
DELIMITER ;

call sp_ModificarDetalleVenta(5, 245, 2);
call sp_MostrarDetalleVenta();
call sp_MostrarHIstorialVentas();


DELIMITER $$
create procedure sp_BuscarHistorialVentas(IN codVenta INT)
begin
select
v.codigo_venta,
dv.id_detalleVenta,
c.dni_cliente,
c.nombre_cliente,
c.telefono_cliente,
v.fecha_venta,
v.hora_venta,
p.id_producto,
p.categoria_producto,
p.nombre_producto,
p.garantia_producto,
p.precio_producto,
dv.cantidad_detalleVenta,
v.tipopago_venta,
v.comprobante_venta,
e.id_empleado,
e.nombre_empleado,
dv.subtotal_detalleVenta,
v.total_venta
from Venta as v
join Cliente as c on v.dni_cliente = c.dni_cliente
join Empleado as e on v.id_empleado = e.id_empleado
join DetalleVenta as dv on v.codigo_venta = dv.codigo_venta
join Producto as p on dv.id_producto = p.id_producto
where v.codigo_venta = codVenta;
end $$
DELIMITER ;

call sp_BuscarHistorialVentas(9);

DELIMITER $$
create procedure sp_MostrarVentasDelDia()
begin
select
v.codigo_venta,
dv.id_detalleVenta,
c.dni_cliente,
c.nombre_cliente,
c.telefono_cliente,
v.fecha_venta,
v.hora_venta,
p.id_producto,
p.categoria_producto,
p.nombre_producto,
p.garantia_producto,
p.precio_producto,
dv.cantidad_detalleVenta,
v.tipopago_venta,
v.comprobante_venta,
e.id_empleado,
e.nombre_empleado,
dv.subtotal_detalleVenta,
v.total_venta
from Venta as v
join Cliente as c on v.dni_cliente = c.dni_cliente
join Empleado as e on v.id_empleado = e.id_empleado
join DetalleVenta as dv on v.codigo_venta = dv.codigo_venta
join Producto as p on dv.id_producto = p.id_producto
where v.fecha_venta = current_date()
order by v.codigo_venta asc;
end $$
DELIMITER ;

call sp_MostrarVentasDelDia();


DELIMITER $$
CREATE PROCEDURE sp_MostrarHistorialVentasconfiltro(
    IN p_filtro VARCHAR(50) 
)
BEGIN
    SELECT
        v.codigo_venta,
        dv.id_detalleVenta,
        c.dni_cliente,
        c.nombre_cliente,
        c.telefono_cliente,
        v.fecha_venta,
        v.hora_venta,
        p.id_producto,
        p.categoria_producto,
        p.nombre_producto,
        p.garantia_producto,
        p.precio_producto,
        dv.cantidad_detalleVenta,
        v.tipopago_venta,
        v.comprobante_venta,
        e.id_empleado,
        e.nombre_empleado,
        dv.subtotal_detalleVenta,
        v.total_venta
    FROM
        DetalleVenta dv
    JOIN
        Venta v ON dv.codigo_venta = v.codigo_venta
    JOIN
        Cliente c ON v.dni_cliente = c.dni_cliente 
    JOIN
        Empleado e ON v.id_empleado = e.id_empleado
    JOIN
        Producto p ON dv.id_producto = p.id_producto
    WHERE
        CAST(v.codigo_venta AS CHAR) LIKE CONCAT('%', p_filtro, '%') OR
        p.categoria_producto LIKE CONCAT('%', p_filtro, '%') OR
        c.nombre_cliente LIKE CONCAT('%', p_filtro, '%') OR
        c.dni_cliente LIKE CONCAT('%', p_filtro, '%') OR
        CAST(e.id_empleado AS CHAR) LIKE CONCAT('%', p_filtro, '%') OR
        e.nombre_empleado LIKE CONCAT('%', p_filtro, '%');
END $$
DELIMITER ;


DELIMITER $$
CREATE PROCEDURE sp_EliminarHistorialVentas(
    IN p_id INT
)
BEGIN
    DELETE FROM DetalleVenta WHERE id_detalleVenta = p_id;
    DELETE FROM Venta WHERE codigo_venta = p_id;
END $$
DELIMITER ;















