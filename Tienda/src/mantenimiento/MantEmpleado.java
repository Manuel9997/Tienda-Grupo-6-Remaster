package mantenimiento;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import Conexion.ConexionMySQL;
import clase.Empleado;

public class MantEmpleado {
public ArrayList<Empleado> MostrarEmpleado() {
	ArrayList<Empleado> lista = new ArrayList<>();
	try {
		CallableStatement csta = ConexionMySQL.getConexion().prepareCall("{call sp_MostrarEmpleado()}");
		ResultSet rs = csta.executeQuery();
		Empleado e;
		while (rs.next()) {
			e = new Empleado(
					rs.getInt("id_empleado"),
                    rs.getString("dni_empleado"),
                    rs.getString("nombre_empleado"),
                    rs.getString("telefono_empleado"),
                    rs.getDate("fecha_empleado"),
                    rs.getString("cargo_empleado"),
                    rs.getString("jornada_empleado"),
                    rs.getString("horario_empleado"),
                    rs.getDouble("sueldo_empleado"),
                    rs.getString("estado_empleado")
                );
			
			lista.add(e);
		}
	} catch (Exception e) {
		System.out.println("ERROR al listar empleados: " + e);
	}
		
	return lista;
}
public void AgregarEmpleado(Empleado e) {
    try {
        Connection cnx = ConexionMySQL.getConexion();
        CallableStatement csta = cnx.prepareCall("{call sp_AgregarEmpleado(?, ?, ?, ?, ?, ?, ?, ?)}");
        csta.setInt(1, e.getIdEmpleado());
        csta.setString(2, e.getDniEmpleado());
        csta.setString(3, e.getNombreEmpleado());
        csta.setString(4, e.getTelefonoEmpleado());
        csta.setString(5, e.getCargoEmpleado());
        csta.setString(6, e.getJornadaEmpleado());
        csta.setString(7, e.getHorarioEmpleado());
        csta.setDouble(8, e.getSueldoEmpleado());
        csta.setString(9, e.getEstadoEmpleado());
        csta.executeUpdate();
        
    } catch (Exception ex) {
        System.out.println("ERROR al agregar empleado: " + ex);
    }
}
public void ModificarEmpleado(Empleado e) {
    try {
        Connection cnx = ConexionMySQL.getConexion();
        CallableStatement csta = cnx.prepareCall("{call sp_ModificarEmpleado(?, ?, ?, ?, ?, ?, ?, ?, ?)}");
        csta.setInt(1, e.getIdEmpleado());
        csta.setString(2, e.getDniEmpleado());
        csta.setString(3, e.getNombreEmpleado());
        csta.setString(4, e.getTelefonoEmpleado());
        csta.setDate(5, new java.sql.Date(e.getFechaEmpleado().getTime()));
        csta.setString(6, e.getCargoEmpleado());
        csta.setString(7, e.getJornadaEmpleado());
        csta.setString(8, e.getHorarioEmpleado());
        csta.setDouble(9, e.getSueldoEmpleado());
        csta.setString(9, e.getEstadoEmpleado());
        csta.executeUpdate();
    } catch (Exception ex) {
        System.out.println("ERROR al modificar empleado: " + ex);
    }
}

public Empleado BuscarEmpleado(int idEmpleado) {
    Empleado e = null;
    try {
        Connection cnx = ConexionMySQL.getConexion();
        CallableStatement csta = cnx.prepareCall("{call sp_BuscarEmpleado(?)}");
        csta.setInt(1, idEmpleado);
        ResultSet rs = csta.executeQuery();
        if (rs.next()) {
            e = new Empleado(
                rs.getInt("id_empleado"),
                rs.getString("dni_empleado"),
                rs.getString("nombre_empleado"),
                rs.getString("telefono_empleado"),
                rs.getDate("fecha_empleado"),
                rs.getString("cargo_empleado"),
                rs.getString("jornada_empleado"),
                rs.getString("horario_empleado"),
                rs.getDouble("sueldo_empleado"),
                rs.getString("estado_empleado")
            );
        }
    } catch (Exception ex) {
        System.out.println("ERROR al buscar empleado: " + ex);
    }
    return e;
}
public ArrayList<Empleado> ConsultarEmpleado(String texto) {
    ArrayList<Empleado> lista = new ArrayList<>();
    try {
        java.sql.Statement sta = ConexionMySQL.getConexion().createStatement();
        ResultSet rs = sta.executeQuery("select * from Empleado " +
            "where cast(id_empleado as char) like '%" + texto + "%' " +
            "or dni_empleado like '%" + texto + "%' " +
            "or nombre_empleado like '%" + texto + "%'");

        Empleado e;
        while (rs.next()) {
            e = new Empleado(
                rs.getInt("id_empleado"),
                rs.getString("dni_empleado"),
                rs.getString("nombre_empleado"),
                rs.getString("telefono_empleado"),
                rs.getDate("fecha_empleado"),
                rs.getString("cargo_empleado"),
                rs.getString("jornada_empleado"),
                rs.getString("horario_empleado"),
                rs.getDouble("sueldo_empleado"),
                rs.getString("estado_empleado")
            );
            lista.add(e);
        }
    } catch (Exception e) {
        System.out.println("ERROR al buscar empleado: " + e);
    }
    return lista;
}
}
