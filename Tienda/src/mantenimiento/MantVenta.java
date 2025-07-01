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
			e = new Empleado(rs.getString("nombre_empleado"));
			
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
public void calcularTotalVenta(int codigoVenta) {
    try {
        Connection cnx = ConexionMySQL.getConexion();
        CallableStatement csta = cnx.prepareCall("{call sp_CalcularTotalVenta(?)}");
        csta.setInt(1, codigoVenta);
        csta.executeUpdate();
    } catch (Exception e) {
        System.out.println("ERROR" + e);
    }
}
}
