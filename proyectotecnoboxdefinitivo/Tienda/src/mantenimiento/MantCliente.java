package mantenimiento;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Conexion.ConexionMySQL;
import clase.Cliente;
import clase.LoginAdmi;
import clase.Producto;

public class MantCliente {
	public Cliente ObtenerCliente(Cliente clien) {
		Cliente cliente=null;
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			con= ConexionMySQL.getConexion();
			String sql = "select * from Cliente";
			pst = con.prepareStatement(sql);
			
			
			pst.setString(1, clien.getDniCliente());
			pst.setString(2, clien.getNombreCliente());
			pst.setString(3, clien.getTelefonoCliente());
			
			rs = pst.executeQuery();
			
			while (rs.next()) {
				cliente = new Cliente(rs.getString(1), rs.getString(2),rs.getString(3));
			}
			
		}catch(Exception e) {
			System.out.println("Error en obtener producto");
		}
		return cliente;
	}
	
	public void EliminarCleinte(String id) {
		try {
			Connection cnx=ConexionMySQL.getConexion();
			CallableStatement csta=cnx.prepareCall("{sp_EliminarProducto(?)} ");
			csta.setString(1,id);
		}
		catch(Exception e) {
			System.out.println("Error "+e);
		}
	}
	
	public void editar(Producto prod) {
		try {
			Connection cnx = ConexionMySQL.getConexion();
			CallableStatement csta = cnx.prepareCall("{call sp_ModificarProducto(?,?,?,?,?)}");
			csta.setString(2, prod.getCategoriaProducto());
			csta.setString(3, prod.getNombreProducto());
			csta.setString(4, prod.getGarantiaProducto());
			csta.setDouble(5, prod.getStockProducto());
			csta.executeUpdate();
		}catch (Exception e) {
			System.out.println("Error "+e);
		}
	}
}
