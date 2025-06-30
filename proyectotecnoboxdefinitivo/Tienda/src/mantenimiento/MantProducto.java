package mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//import com.mysql.cj.jdbc.CallableStatement;
import java.sql.CallableStatement;
import Conexion.ConexionMySQL;
import clase.LoginAdmi;
import clase.Producto;

public class MantProducto{
	public Producto ObtenerProducto(Producto prod) {
		Producto producto=null;
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			con= ConexionMySQL.getConexion();
			String sql = "select * from Producto";
			pst = con.prepareStatement(sql);
			
			pst.setInt(1, prod.getIdProducto());
			pst.setString(2, prod.getCategoriaProducto());
			pst.setString(3, prod.getNombreProducto());
			pst.setString(4, prod.getGarantiaProducto());
			pst.setDouble(5, prod.getPrecioProducto());
			pst.setInt(6, prod.getStockProducto());
			rs = pst.executeQuery();
			
			while (rs.next()) {
				prod = new Producto(rs.getInt(1), rs.getString(2),rs.getString(3),rs.getString(4),rs.getDouble(5),rs.getInt(6));
			}
			
		}catch(Exception e) {
			System.out.println("Error en obtener producto");
		}
		return producto;
	}
	
	public void EliminarProducto(String id) {
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

