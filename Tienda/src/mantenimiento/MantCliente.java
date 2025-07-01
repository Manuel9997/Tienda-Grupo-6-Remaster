package mantenimiento;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import Conexion.ConexionMySQL;
import clase.Cliente;

public class MantCliente {
public ArrayList<Cliente> MostrarCliente() {
	ArrayList<Cliente> lista = new ArrayList<>();
	try {
		Connection cnx = ConexionMySQL.getConexion();
		CallableStatement csta = cnx.prepareCall("{call sp_MostrarCliente()}");
		ResultSet rs = csta.executeQuery();
		Cliente c;
		while (rs.next()) {
			c = new Cliente(
					rs.getString("dni_cliente"),
                    rs.getString("nombre_cliente"),
                    rs.getString("telefono_cliente")
                    );
			lista.add(c);
			}
	} catch (Exception e) {
			System.out.println("ERROR al listar clientes: " + e);
	}
	
	return lista;
}
public void AgregarCliente(Cliente c) {
    try {
        Connection cnx = ConexionMySQL.getConexion();
        CallableStatement csta = cnx.prepareCall("{call sp_AgregarCliente(?, ?, ?)}");
        csta.setString(1, c.getDniCliente());
        csta.setString(2, c.getNombreCliente());
        csta.setString(3, c.getTelefonoCliente());
        csta.executeUpdate();
    } catch (Exception e) {
        System.out.println("ERROR al agregar cliente: " + e);
    }
}
public void ModificarCliente(Cliente c) {
    try {
        Connection cnx = ConexionMySQL.getConexion();
        CallableStatement csta = cnx.prepareCall("{call sp_ModificarCliente(?, ?, ?)}");
        csta.setString(1, c.getDniCliente());
        csta.setString(2, c.getNombreCliente());
        csta.setString(3, c.getTelefonoCliente());
        csta.executeUpdate();
    } catch (Exception e) {
        System.out.println("ERROR al modificar cliente: " + e);
    }
}
public Cliente BuscarCliente(String dni) {
    Cliente c = null;
    try {
        Connection cnx = ConexionMySQL.getConexion();
        CallableStatement csta = cnx.prepareCall("{call sp_BuscarCliente(?)}");
        csta.setString(1, dni);
        ResultSet rs = csta.executeQuery();
        if (rs.next()) {
            c = new Cliente(
                rs.getString("dni_cliente"),
                rs.getString("nombre_cliente"),
                rs.getString("telefono_cliente")
            );
        }
    } catch (Exception e) {
        System.out.println("ERROR al buscar cliente: " + e);
    }
    return c;
}
public ArrayList<Cliente> ConsultarCliente(String filtro) {
    ArrayList<Cliente> lista = new ArrayList<>();
    try {
        java.sql.Statement sta = ConexionMySQL.getConexion().createStatement();
        ResultSet rs = sta.executeQuery("select * from Cliente " +
                          "where dni_cliente like '%" + filtro + "%' " +
                          "or nombre_cliente like '%" + filtro + "%'");
        Cliente c;
        while (rs.next()) {
            c = new Cliente(
                rs.getString("dni_cliente"),
                rs.getString("nombre_cliente"),
                rs.getString("telefono_cliente")
            );
            lista.add(c);
        }
    } catch (Exception e) {
        System.out.println("ERROR al buscar cliente: " + e);
    }
    return lista;
}
}
