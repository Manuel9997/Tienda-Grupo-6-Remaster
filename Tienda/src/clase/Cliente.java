package clase;

public class Cliente {

private String dni, nombre_apellido, telefono;

public Cliente(String dni, String nombre_apellido, String telefono) {

	this.dni = dni;
	this.nombre_apellido = nombre_apellido;
	this.telefono = telefono;
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

}
