package mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Conexion.ConexionMySQL;
import clase.LoginAdmi;

public class MantLoginAdmi {
	
public LoginAdmi ObtenerUsuario(LoginAdmi usu) {
	LoginAdmi usuario = null;
	Connection con = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	
	try {
		con = ConexionMySQL.getConexion();
		String sql = "select * from LoginAdmi where usuario = ? and contraseña = ?";
		pst = con.prepareStatement(sql);
		
		pst.setString(1, usu.getUsuario());
		pst.setString(2, usu.getContraseña());
		
		rs = pst.executeQuery();
		
		while (rs.next()) {
			usuario = new LoginAdmi(rs.getString(1), rs.getString(2));
		}
		
	} catch (Exception e) {
		System.out.println("Error en obtener usuario");
	}
	
	return usuario;
}

}
