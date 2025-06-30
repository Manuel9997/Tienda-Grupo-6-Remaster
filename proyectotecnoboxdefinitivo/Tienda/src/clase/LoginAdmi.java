package clase;

public class LoginAdmi {
private String usuario, contraseña;

public LoginAdmi(String usuario, String contraseña) {

	this.usuario = usuario;
	this.contraseña = contraseña;
}

public LoginAdmi() {
	
}

public String getUsuario() {
	return usuario;
}

public void setUsuario(String usuario) {
	this.usuario = usuario;
}

public String getContraseña() {
	return contraseña;
}

public void setContraseña(String contraseña) {
	this.contraseña = contraseña;
}

}
