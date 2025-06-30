package clase;

public class Cliente {

private String dniCliente, nombreCliente, telefonoCliente;

public Cliente(String dniCliente, String nombreCliente, String telefonoCliente) {

	this.dniCliente = dniCliente;
	this.nombreCliente = nombreCliente;
	this.telefonoCliente = telefonoCliente;
}

public String getDniCliente() {
	return dniCliente;
}

public void setDniCliente(String dniCliente) {
	this.dniCliente = dniCliente;
}

public String getNombreCliente() {
	return nombreCliente;
}

public void setNombreCliente(String nombreCliente) {
	this.nombreCliente = nombreCliente;
}

public String getTelefonoCliente() {
	return telefonoCliente;
}

public void setTelefonoCliente(String telefonoCliente) {
	this.telefonoCliente = telefonoCliente;
}

}
