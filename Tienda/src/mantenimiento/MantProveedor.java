package mantenimiento;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import Conexion.ConexionMySQL;
import clase.Proveedor;

public class MantProveedor {
public ArrayList<Proveedor> MostrarProveedor() {
	ArrayList<Proveedor> lista = new ArrayList<>();
	try {
		Connection cnx = ConexionMySQL.getConexion();
		CallableStatement csta = cnx.prepareCall("{call sp_MostrarProveedor()}");
		ResultSet rs = csta.executeQuery();
		while (rs.next()) {
			Proveedor proveedor = new Proveedor(
					rs.getInt("id_proveedor"),
                    rs.getString("ruc_proveedor"),
                    rs.getString("nombre_proveedor"),
                    rs.getString("telefono_proveedor"),
                    rs.getString("correo_proveedor"),
                    rs.getString("direccion_proveedor"),
                    rs.getString("estado_proveedor"),
                    rs.getDate("fecha_proveedor")
            );
			lista.add(proveedor);
		}	
	} catch (Exception e) {
		System.out.println("ERROR al listar proveedores: " + e);
		
	}
	
	return lista;	
}
public void AgregarProveedor(Proveedor p) {
	try {
		Connection cnx = ConexionMySQL.getConexion();
		CallableStatement csta = cnx.prepareCall("{call sp_AgregarProveedor(?, ?, ?, ?, ?, ?, ?,?)}");
		csta.setInt(1, p.getIdProveedor());
		csta.setString(2, p.getRucProveedor());
		csta.setString(3, p.getNombreProveedor());
		csta.setString(4, p.getTelefonoProveedor());
		csta.setString(5, p.getCorreoProveedor());
		csta.setString(6, p.getDireccionProveedor());
		csta.setString(7, p.getEstadoProveedor());
		csta.setDate(8, new java.sql.Date(p.getFechaProveedor().getTime()));
		csta.executeUpdate();
		
	} catch (Exception e) {
		System.out.println("ERROR al agregar proveedor: " + e);		
	}    
}
public void ModificarProveedor(Proveedor p) {
	try {
		Connection cnx = ConexionMySQL.getConexion();
		CallableStatement csta = cnx.prepareCall("{call sp_ModificarProveedor(?, ?, ?, ?, ?, ?, ?, ?)}");
		csta.setInt(1, p.getIdProveedor());
		csta.setString(2, p.getRucProveedor());
		csta.setString(3, p.getNombreProveedor());
		csta.setString(4, p.getTelefonoProveedor());
		csta.setString(5, p.getCorreoProveedor());
		csta.setString(6, p.getDireccionProveedor());
		csta.setString(7, p.getEstadoProveedor());
		csta.setDate(8, new java.sql.Date(p.getFechaProveedor().getTime()));
		csta.executeUpdate();
		
	} catch (Exception e) {
		System.out.println("ERROR al modificar proveedor: " + e);		
	}    
}

public void EliminarProveedor(int idproveedor) {
    try {
        Connection cnx = ConexionMySQL.getConexion();
        CallableStatement csta = cnx.prepareCall("{call sp_EliminarProveedor(?)}");
        csta.setInt(1, idproveedor);
        csta.executeUpdate();
    } catch (Exception e) {
        System.out.println("ERROR al eliminar proveedor: " + e);
    }
}



public Proveedor BuscarProveedor(int idProveedor) {
	Proveedor proveedor = null;
	try {
		Connection cnx = ConexionMySQL.getConexion();
		CallableStatement csta = cnx.prepareCall("{call sp_BuscarProveedor(?)}");
		csta.setInt(1, idProveedor);
		ResultSet rs = csta.executeQuery();
		if (rs.next()) {
			proveedor = new Proveedor(
					rs.getInt("id_proveedor"),
                    rs.getString("ruc_proveedor"),
                    rs.getString("nombre_proveedor"),
                    rs.getString("telefono_proveedor"),
                    rs.getString("correo_proveedor"),
                    rs.getString("direccion_proveedor"),
                    rs.getString("estado_proveedor"),
                    rs.getDate("fecha_proveedor")
           );     
		}  
	} catch (Exception e) {
		System.out.println("ERROR al buscar proveedor: " + e);    
	}
       
	return proveedor;   
}
public ArrayList<Proveedor> ConsultarProveedor(String filtro) {
    ArrayList<Proveedor> lista = new ArrayList<>();
    try {
        java.sql.Statement sta = ConexionMySQL.getConexion().createStatement();
        ResultSet rs = sta.executeQuery("SELECT * FROM Proveedor " +
            "WHERE CAST(id_proveedor AS CHAR) LIKE '%" + filtro + "%' " +
            "OR ruc_proveedor LIKE '%" + filtro + "%' " +
            "OR nombre_proveedor LIKE '%" + filtro + "%'");

        while (rs.next()) {
            Proveedor proveedor = new Proveedor(
                rs.getInt("id_proveedor"),
                rs.getString("ruc_proveedor"),
                rs.getString("nombre_proveedor"),
                rs.getString("telefono_proveedor"),
                rs.getString("correo_proveedor"),
                rs.getString("direccion_proveedor"),
                rs.getString("estado_proveedor"),
                rs.getDate("fecha_proveedor")
            );
            lista.add(proveedor);
        }
    } catch (Exception e) {
        System.out.println("ERROR al consultar proveedor: " + e);
    }
    return lista;
}
}
