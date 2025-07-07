package clase;

import java.sql.Date;

public class Empleado {
private int idEmpleado;
private String dniEmpleado, nombreEmpleado, telefonoEmpleado;
private Date fechaEmpleado;
private String cargoEmpleado, jornadaEmpleado, horarioEmpleado;
private double sueldoEmpleado;
private String estadoEmpleado;

public Empleado(int idEmpleado, String dniEmpleado, String nombreEmpleado, String telefonoEmpleado, Date fechaEmpleado,
		String cargoEmpleado, String jornadaEmpleado, String horarioEmpleado, double sueldoEmpleado,
		String estadoEmpleado) {

	this.idEmpleado = idEmpleado;
	this.dniEmpleado = dniEmpleado;
	this.nombreEmpleado = nombreEmpleado;
	this.telefonoEmpleado = telefonoEmpleado;
	this.fechaEmpleado = fechaEmpleado;
	this.cargoEmpleado = cargoEmpleado;
	this.jornadaEmpleado = jornadaEmpleado;
	this.horarioEmpleado = horarioEmpleado;
	this.sueldoEmpleado = sueldoEmpleado;
	this.estadoEmpleado = estadoEmpleado;
}

public Empleado(int idEmpleado) {
	this.idEmpleado = idEmpleado;
}

public Empleado(int idEmpleado, String nombreEmpleado) {

	this.idEmpleado = idEmpleado;
	this.nombreEmpleado = nombreEmpleado;
}

public int getIdEmpleado() {
	return idEmpleado;
}

public void setIdEmpleado(int idEmpleado) {
	this.idEmpleado = idEmpleado;
}

public String getDniEmpleado() {
	return dniEmpleado;
}

public void setDniEmpleado(String dniEmpleado) {
	this.dniEmpleado = dniEmpleado;
}

public String getNombreEmpleado() {
	return nombreEmpleado;
}

public void setNombreEmpleado(String nombreEmpleado) {
	this.nombreEmpleado = nombreEmpleado;
}

public String getTelefonoEmpleado() {
	return telefonoEmpleado;
}

public void setTelefonoEmpleado(String telefonoEmpleado) {
	this.telefonoEmpleado = telefonoEmpleado;
}

public Date getFechaEmpleado() {
	return fechaEmpleado;
}

public void setFechaEmpleado(Date fechaEmpleado) {
	this.fechaEmpleado = fechaEmpleado;
}

public String getCargoEmpleado() {
	return cargoEmpleado;
}

public void setCargoEmpleado(String cargoEmpleado) {
	this.cargoEmpleado = cargoEmpleado;
}

public String getJornadaEmpleado() {
	return jornadaEmpleado;
}

public void setJornadaEmpleado(String jornadaEmpleado) {
	this.jornadaEmpleado = jornadaEmpleado;
}

public String getHorarioEmpleado() {
	return horarioEmpleado;
}

public void setHorarioEmpleado(String horarioEmpleado) {
	this.horarioEmpleado = horarioEmpleado;
}

public double getSueldoEmpleado() {
	return sueldoEmpleado;
}

public void setSueldoEmpleado(double sueldoEmpleado) {
	this.sueldoEmpleado = sueldoEmpleado;
}

public String getEstadoEmpleado() {
	return estadoEmpleado;
}

public void setEstadoEmpleado(String estadoEmpleado) {
	this.estadoEmpleado = estadoEmpleado;
}
}
