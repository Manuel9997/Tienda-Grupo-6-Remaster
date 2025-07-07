package clase;

import java.sql.Date;

public class Proveedor {
private int idProveedor;
private String rucProveedor, nombreProveedor, telefonoProveedor, correoProveedor, direccionProveedor, estadoProveedor;
private Date fechaProveedor;

public Proveedor(int idProveedor, String rucProveedor, String nombreProveedor, String telefonoProveedor,
		String correoProveedor, String direccionProveedor, String estadoProveedor, Date fechaProveedor) {

	this.idProveedor = idProveedor;
	this.rucProveedor = rucProveedor;
	this.nombreProveedor = nombreProveedor;
	this.telefonoProveedor = telefonoProveedor;
	this.correoProveedor = correoProveedor;
	this.direccionProveedor = direccionProveedor;
	this.estadoProveedor = estadoProveedor;
	this.fechaProveedor = fechaProveedor;
}

public Proveedor(int idProveedor, String nombreProveedor) {

	this.idProveedor = idProveedor;
	this.nombreProveedor = nombreProveedor;
}

public Proveedor(int idProveedor) {

	this.idProveedor = idProveedor;
}

public int getIdProveedor() {
	return idProveedor;
}

public void setIdProveedor(int idProveedor) {
	this.idProveedor = idProveedor;
}

public String getRucProveedor() {
	return rucProveedor;
}

public void setRucProveedor(String rucProveedor) {
	this.rucProveedor = rucProveedor;
}

public String getNombreProveedor() {
	return nombreProveedor;
}

public void setNombreProveedor(String nombreProveedor) {
	this.nombreProveedor = nombreProveedor;
}

public String getTelefonoProveedor() {
	return telefonoProveedor;
}

public void setTelefonoProveedor(String telefonoProveedor) {
	this.telefonoProveedor = telefonoProveedor;
}

public String getCorreoProveedor() {
	return correoProveedor;
}

public void setCorreoProveedor(String correoProveedor) {
	this.correoProveedor = correoProveedor;
}

public String getDireccionProveedor() {
	return direccionProveedor;
}

public void setDireccionProveedor(String direccionProveedor) {
	this.direccionProveedor = direccionProveedor;
}

public String getEstadoProveedor() {
	return estadoProveedor;
}

public void setEstadoProveedor(String estadoProveedor) {
	this.estadoProveedor = estadoProveedor;
}

public Date getFechaProveedor() {
	return fechaProveedor;
}

public void setFechaProveedor(Date fechaProveedor) {
	this.fechaProveedor = fechaProveedor;
}

}
