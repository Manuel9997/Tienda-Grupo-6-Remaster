package clase;

import java.time.LocalDate;

public class Empleado {
private int id_empleado;	
private String dni, nombre_apellido, telefono;
private LocalDate fecha;
private String cargo, jornada, horario;
private double pago_hora, horas_trabajadas, descuento;

public Empleado(int id_empleado, String dni, String nombre_apellido, String telefono, LocalDate fecha, String cargo,
		String jornada, String horario, double pago_hora, double horas_trabajadas, double descuento) {

	this.id_empleado = id_empleado;
	this.dni = dni;
	this.nombre_apellido = nombre_apellido;
	this.telefono = telefono;
	this.fecha = fecha;
	this.cargo = cargo;
	this.jornada = jornada;
	this.horario = horario;
	this.pago_hora = pago_hora;
	this.horas_trabajadas = horas_trabajadas;
	this.descuento = descuento;
}

public Empleado(String nombre_apellido) {

	this.nombre_apellido = nombre_apellido;
}

public int getId_empleado() {
	return id_empleado;
}

public void setId_empleado(int id_empleado) {
	this.id_empleado = id_empleado;
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

public String getTelefono() {
	return telefono;
}

public void setTelefono(String telefono) {
	this.telefono = telefono;
}

public LocalDate getFecha() {
	return fecha;
}

public void setFecha(LocalDate fecha) {
	this.fecha = fecha;
}

public String getCargo() {
	return cargo;
}

public void setCargo(String cargo) {
	this.cargo = cargo;
}

public String getJornada() {
	return jornada;
}

public void setJornada(String jornada) {
	this.jornada = jornada;
}

public String getHorario() {
	return horario;
}

public void setHorario(String horario) {
	this.horario = horario;
}

public double getPago_hora() {
	return pago_hora;
}

public void setPago_hora(double pago_hora) {
	this.pago_hora = pago_hora;
}

public double getHoras_trabajadas() {
	return horas_trabajadas;
}

public void setHoras_trabajadas(double horas_trabajadas) {
	this.horas_trabajadas = horas_trabajadas;
}

public double getDescuento() {
	return descuento;
}

public void setDescuento(double descuento) {
	this.descuento = descuento;
}

//SOBRECARGA DE MÉTODOS
public double Sueldo() {
	return pago_hora * horas_trabajadas;
}
public double Sueldo(double descuento) {
	return Sueldo() - descuento;
}

}
