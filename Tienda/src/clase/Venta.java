package clase;

import java.sql.Date;
import java.sql.Time;

public class Venta {
private int codigoVenta;
private Cliente cliente;
private Date fechaVenta;
private Time horaVenta;
private String tipopagoVenta, comprobanteVenta;
private Empleado empleado;
private double totalVenta;

public Venta(int codigoVenta, Cliente cliente, Date fechaVenta, Time horaVenta, String tipopagoVenta,
		String comprobanteVenta, Empleado empleado, double totalVenta) {

	this.codigoVenta = codigoVenta;
	this.cliente = cliente;
	this.fechaVenta = fechaVenta;
	this.horaVenta = horaVenta;
	this.tipopagoVenta = tipopagoVenta;
	this.comprobanteVenta = comprobanteVenta;
	this.empleado = empleado;
	this.totalVenta = totalVenta;
}

public Venta(int codigoVenta) {

	this.codigoVenta = codigoVenta;
}

public Venta() {

}

public int getCodigoVenta() {
	return codigoVenta;
}

public void setCodigoVenta(int codigoVenta) {
	this.codigoVenta = codigoVenta;
}

public Cliente getCliente() {
	return cliente;
}

public void setCliente(Cliente cliente) {
	this.cliente = cliente;
}

public Date getFechaVenta() {
	return fechaVenta;
}

public void setFechaVenta(Date fechaVenta) {
	this.fechaVenta = fechaVenta;
}

public Time getHoraVenta() {
	return horaVenta;
}

public void setHoraVenta(Time horaVenta) {
	this.horaVenta = horaVenta;
}

public String getTipopagoVenta() {
	return tipopagoVenta;
}

public void setTipopagoVenta(String tipopagoVenta) {
	this.tipopagoVenta = tipopagoVenta;
}

public String getComprobanteVenta() {
	return comprobanteVenta;
}

public void setComprobanteVenta(String comprobanteVenta) {
	this.comprobanteVenta = comprobanteVenta;
}

public Empleado getEmpleado() {
	return empleado;
}

public void setEmpleado(Empleado empleado) {
	this.empleado = empleado;
}

public double getTotalVenta() {
	return totalVenta;
}

public void setTotalVenta(double totalVenta) {
	this.totalVenta = totalVenta;
}

}
