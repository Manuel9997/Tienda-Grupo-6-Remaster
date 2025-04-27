package clase;

public class Empleado {
	
	public String Dni,Nombre_Apellido,Telefono,Cargo,Jornada,Horario;
	public int Pago_Hora,Horas_trabajadas;
	public double Sueldo_Total,Descuento;
	
	
	public Empleado(String dni, String nombre_Apellido, String telefono, String cargo, String jornada, String horario,
			int pago_Hora, int horas_trabajadas, double sueldo_Total, double descuento) {
		Dni = dni;
		Nombre_Apellido = nombre_Apellido;
		Telefono = telefono;
		Cargo = cargo;
		Jornada = jornada;
		Horario = horario;
		Pago_Hora = pago_Hora;
		Horas_trabajadas = horas_trabajadas;
		Sueldo_Total = sueldo_Total;
		Descuento = descuento;
	}


	public String getDni() {
		return Dni;
	}


	public void setDni(String dni) {
		Dni = dni;
	}


	public String getNombre_Apellido() {
		return Nombre_Apellido;
	}


	public void setNombre_Apellido(String nombre_Apellido) {
		Nombre_Apellido = nombre_Apellido;
	}


	public String getTelefono() {
		return Telefono;
	}


	public void setTelefono(String telefono) {
		Telefono = telefono;
	}


	public String getCargo() {
		return Cargo;
	}


	public void setCargo(String cargo) {
		Cargo = cargo;
	}


	public String getJornada() {
		return Jornada;
	}


	public void setJornada(String jornada) {
		Jornada = jornada;
	}


	public String getHorario() {
		return Horario;
	}


	public void setHorario(String horario) {
		Horario = horario;
	}


	public int getPago_Hora() {
		return Pago_Hora;
	}


	public void setPago_Hora(int pago_Hora) {
		Pago_Hora = pago_Hora;
	}


	public int getHoras_trabajadas() {
		return Horas_trabajadas;
	}


	public void setHoras_trabajadas(int horas_trabajadas) {
		Horas_trabajadas = horas_trabajadas;
	}


	public double getSueldo_Total() {
		return Pago_Hora*Horas_trabajadas;
	}
	
	public double getSueldo_Total(int Desc) {
		return Sueldo_Total-(Desc*Sueldo_Total);
	}



	public void setSueldo_Total(double sueldo_Total) {
		Sueldo_Total = sueldo_Total;
	}


	public double getDescuento() {
		return Descuento;
	}


	public void setDescuento(double descuento) {
		Descuento = descuento;
	}

	
}
