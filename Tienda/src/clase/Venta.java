package clase;

import java.time.LocalDate;
import java.time.LocalTime;

public class Venta {
private int codigo_venta;
private Cliente cliente;
private LocalDate fecha;
private LocalTime hora;
private Producto producto;
private int cantidad;
private String tipo_pago, comprobante;
private Empleado vendedor;

public Venta(int codigo_venta, Cliente cliente, LocalDate fecha, LocalTime hora, Producto producto, int cantidad,
		String tipo_pago, String comprobante, Empleado vendedor) {

	this.codigo_venta = codigo_venta;
	this.cliente = cliente;
	this.fecha = fecha;
	this.hora = hora;
	this.producto = producto;
	this.cantidad = cantidad;
	this.tipo_pago = tipo_pago;
	this.comprobante = comprobante;
	this.vendedor = vendedor;
}

public int getCodigo_venta() {
	return codigo_venta;
}

public void setCodigo_venta(int codigo_venta) {
	this.codigo_venta = codigo_venta;
}

public Cliente getCliente() {
	return cliente;
}

public void setCliente(Cliente cliente) {
	this.cliente = cliente;
}

public LocalDate getFecha() {
	return fecha;
}

public void setFecha(LocalDate fecha) {
	this.fecha = fecha;
}

public LocalTime getHora() {
	return hora;
}

public void setHora(LocalTime hora) {
	this.hora = hora;
}

public Producto getProducto() {
	return producto;
}

public void setProducto(Producto producto) {
	this.producto = producto;
}

public int getCantidad() {
	return cantidad;
}

public void setCantidad(int cantidad) {
	this.cantidad = cantidad;
}

public String getTipo_pago() {
	return tipo_pago;
}

public void setTipo_pago(String tipo_pago) {
	this.tipo_pago = tipo_pago;
}

public String getComprobante() {
	return comprobante;
}

public void setComprobante(String comprobante) {
	this.comprobante = comprobante;
}

public Empleado getVendedor() {
	return vendedor;
}

public void setVendedor(Empleado vendedor) {
	this.vendedor = vendedor;
}

public double SubTotal() {
	return cantidad * producto.getPrecio();
}

}
