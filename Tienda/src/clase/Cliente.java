package clase;

public class Cliente {

private int codigo_compra;
private String dni, nombre_apellido, producto, telefono, fecha, tipo_pago;
private int cantidad;

public Cliente(int codigo_compra, String dni, String nombre_apellido, String producto, String telefono, String fecha,
		String tipo_pago, int cantidad) {
	
	this.codigo_compra = codigo_compra;
	this.dni = dni;
	this.nombre_apellido = nombre_apellido;
	this.producto = producto;
	this.telefono = telefono;
	this.fecha = fecha;
	this.tipo_pago = tipo_pago;
	this.cantidad = cantidad;
}

public int getCodigo_compra() {
	return codigo_compra;
}

public void setCodigo_compra(int codigo_compra) {
	this.codigo_compra = codigo_compra;
}

public String getDni() {
	return dni;
}

public void setDni(String dni) {
	this.dni = dni;
}

public String getNombre_apellido() {
	return nombre_apellido;
}

public void setNombre_apellido(String nombre_apellido) {
	this.nombre_apellido = nombre_apellido;
}

public String getProducto() {
	return producto;
}

public void setProducto(String producto) {
	this.producto = producto;
}

public String getTelefono() {
	return telefono;
}

public void setTelefono(String telefono) {
	this.telefono = telefono;
}

public String getFecha() {
	return fecha;
}

public void setFecha(String fecha) {
	this.fecha = fecha;
}

public String getTipo_pago() {
	return tipo_pago;
}

public void setTipo_pago(String tipo_pago) {
	this.tipo_pago = tipo_pago;
}

public int getCantidad() {
	return cantidad;
}

public void setCantidad(int cantidad) {
	this.cantidad = cantidad;
}
}
