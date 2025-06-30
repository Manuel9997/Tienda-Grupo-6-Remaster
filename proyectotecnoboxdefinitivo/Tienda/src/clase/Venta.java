package clase;

import java.time.LocalDate;
import java.time.LocalTime;

public class Venta {
private int codigoVenta;
private String dnicliente;
private LocalDate fechaVenta;
private LocalTime horaVenta;
private String tipopagoVenta, comprobanteVenta;
private String idEmpleado;
private double totalVenta;

public Venta(int codigoVenta, String dnicliente, LocalDate fechaVenta, LocalTime horaVenta, String tipopagoVenta,
		String comprobanteVenta, String idEmpleado, double totalVenta) {

	this.codigoVenta = codigoVenta;
	this.dnicliente = dnicliente;
	this.fechaVenta = fechaVenta;
	this.horaVenta = horaVenta;
	this.tipopagoVenta = tipopagoVenta;
	this.comprobanteVenta = comprobanteVenta;
	this.idEmpleado = idEmpleado;
	this.totalVenta = totalVenta;
}

public int getCodigoVenta() {
	return codigoVenta;
}

public void setCodigoVenta(int codigoVenta) {
	this.codigoVenta = codigoVenta;
}

public String getDnicliente() {
	return dnicliente;
}

public void setDnicliente(String dnicliente) {
	this.dnicliente = dnicliente;
}

public LocalDate getFechaVenta() {
	return fechaVenta;
}

public void setFechaVenta(LocalDate fechaVenta) {
	this.fechaVenta = fechaVenta;
}

public LocalTime getHoraVenta() {
	return horaVenta;
}

public void setHoraVenta(LocalTime horaVenta) {
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

public String getIdEmpleado() {
	return idEmpleado;
}

public void setIdEmpleado(String idEmpleado) {
	this.idEmpleado = idEmpleado;
}

public double getTotalVenta() {
	return totalVenta;
}

public void setTotalVenta(double totalVenta) {
	this.totalVenta = totalVenta;
}

}
