package mantenimiento;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import Conexion.ConexionMySQL;
import clase.Cliente;
import clase.Empleado;
import clase.Venta;

public class MantVenta {
public ArrayList<Venta> MostrarVenta() {
	ArrayList<Venta> lista = new ArrayList<>();
	try {
		CallableStatement csta = ConexionMySQL.getConexion().prepareCall("{call sp_MostrarVenta()}");
		ResultSet rs = csta.executeQuery();
		Venta v;
		Cliente c;
		Empleado e;
		while (rs.next()) {
			c = new Cliente(
					rs.getString("dni_cliente"),
					rs.getString("nombre_cliente"),
					rs.getString("telefono_cliente")
			);
			
			e = new Empleado(
					rs.getInt("id_empleado"),
					rs.getString("nombre_empleado")
			);
					
			v = new Venta(
                    rs.getInt("codigo_venta"),
                    c,
                    rs.getDate("fecha_venta"),
                    rs.getTime("hora_venta"),
                    rs.getString("tipopago_venta"),
                    rs.getString("comprobante_venta"),
                    e,
                    rs.getDouble("total_venta")
            );
                lista.add(v);    
            }
	
        } catch (Exception e) {}
	
        return lista; 
}
public void AgregarVenta(Venta v) {
    try {
        Connection cnx = ConexionMySQL.getConexion();
        CallableStatement csta = cnx.prepareCall("{call sp_AgregarVenta(?, ?, ?, ?)}");
        csta.setString(1, v.getCliente().getDniCliente());
        csta.setString(2, v.getTipopagoVenta());
        csta.setString(3, v.getComprobanteVenta());
        csta.setInt(4, v.getEmpleado().getIdEmpleado());
        csta.executeUpdate();
    } catch (Exception e) {
        System.out.println("ERROR" + e);
    }
}
public void CalcularTotalVenta(int codigoVenta) {
    try {
        Connection cnx = ConexionMySQL.getConexion();
        CallableStatement csta = cnx.prepareCall("{call sp_CalcularTotalVenta(?)}");
        csta.setInt(1, codigoVenta);
        csta.executeUpdate();
    } catch (Exception e) {
        System.out.println("ERROR" + e);
    }
}
public void ModificarVenta(Venta v) {
    try {
        Connection cnx = ConexionMySQL.getConexion();
        CallableStatement csta = cnx.prepareCall("{call sp_ModificarVenta(?, ?, ?, ?, ?)}");
        csta.setInt(1, v.getCodigoVenta());
        csta.setString(2, v.getCliente().getDniCliente());
        csta.setString(3, v.getTipopagoVenta());
        csta.setString(4, v.getComprobanteVenta());
        csta.setInt(5, v.getEmpleado().getIdEmpleado());
        csta.executeUpdate();
    } catch (Exception e) {
        System.out.println("ERROR al modificar venta: " + e);
    }
}
public boolean BuscarVenta(String codigo) {
    boolean existe = false;
    try {
        Connection cnx = ConexionMySQL.getConexion();
        CallableStatement csta = cnx.prepareCall("{call sp_BuscarVenta(?)}");
        csta.setString(1, codigo);
        ResultSet rs = csta.executeQuery();
        if (rs.next()) {
            existe = true; // si hay alguna fila, la venta existe
        }
    } catch (Exception e) {
        System.out.println("ERROR al verificar venta: " + e);
    }
    return existe;
}
}
