package mantenimiento;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import Conexion.ConexionMySQL;
import clase.Cliente;
import clase.Empleado;
import clase.LoginAdmi;
import clase.Producto;

public class MantEmpleado {
	public Empleado ObtenerEmpleado(Empleado emp) {
		Empleado empleado=null;
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			con= ConexionMySQL.getConexion();
			String sql = "select * from Cliente";
			pst = con.prepareStatement(sql);
			
			
			pst.setString(1, emp.getIdEmpleado());
			pst.setString(2, emp.getDniEmpleado());
			pst.setString(3, emp.getNombreEmpleado());
			pst.setString(4, emp.getTelefonoEmpleado());
			pst.setDate(5, emp.getFechaEmpleado());
			pst.setString(6, emp.getCargoEmpleado());
			pst.setString(7, emp.getJornadaEmpleado());
			pst.setString(8, emp.getHorarioEmpleado());
			pst.setDouble(9, emp.getSueldoEmpleado());
			
			
			
			rs = pst.executeQuery();
			
			while (rs.next()) {
				empleado = new Empleado(rs.getString(1), rs.getString(2),rs.getString(3),rs.getString(4),rs.getDate(5)
						,rs.getString(6),rs.getString(7),rs.getString(8),rs.getDouble(0));
				
				
			}
			
		}catch(Exception e) {
			System.out.println("Error en obtener producto");
		}
		return empleado;
	}
	
	public void EliminarEmpleado(String DNI) {
		try {
			Connection cnx=ConexionMySQL.getConexion();
			CallableStatement csta=cnx.prepareCall("{sp_EliminarEmpleado(?)} ");
			csta.setString(1,DNI);
		}
		catch(Exception e) {
			System.out.println("Error "+e);
		}
	}
	
	public void editar(Empleado emp) {
		try {
			Connection cnx = ConexionMySQL.getConexion();
			CallableStatement csta = cnx.prepareCall("{?,?,?,?,?,?,?,?,?);}");
			csta.setString(2, emp.getDniEmpleado());
			csta.setString(3, emp.getDniEmpleado());
			csta.setString(4, emp.getNombreEmpleado());
			csta.setDate(5, emp.getFechaEmpleado());
			csta.setString(6, emp.getCargoEmpleado());
			csta.setString(7, emp.getJornadaEmpleado());
			csta.setString(8, emp.getHorarioEmpleado());
			csta.setDouble(9, emp.getSueldoEmpleado());
			csta.executeUpdate();
		}catch (Exception e) {
			System.out.println("Error "+e);
		}
	}
}
