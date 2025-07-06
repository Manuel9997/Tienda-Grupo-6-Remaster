package mantenimiento;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import Conexion.ConexionMySQL;
import clase.Cliente;
import clase.DetalleVenta;
import clase.Empleado;
import clase.HistorialVentas;
import clase.Producto;
import clase.Proveedor;
import clase.Venta;

public class MantHistorialVentas {
	public ArrayList<HistorialVentas> MostrarHistorialVentas() {
        ArrayList<HistorialVentas> lista = new ArrayList<>();

        try {
            Connection cnx = ConexionMySQL.getConexion();
            CallableStatement csta = cnx.prepareCall("{call sp_MostrarHistorialVentas()}");
            ResultSet rs = csta.executeQuery();

            while (rs.next()) {
                Cliente cliente = new Cliente(
                    rs.getString("dni_cliente"),
                    rs.getString("nombre_cliente"),
                    rs.getString("telefono_cliente")
                );

                Empleado empleado = new Empleado(
                		rs.getInt("id_empleado"),
                		rs.getString("nombre_empleado"));

                Producto producto = new Producto(
                    rs.getInt("id_producto"),
                    rs.getString("categoria_producto"),
                    rs.getString("nombre_producto"),
                    rs.getString("garantia_producto"),
                    rs.getDouble("precio_producto")
                );

                Venta venta = new Venta(
                    rs.getInt("codigo_venta"),
                    cliente,
                    rs.getDate("fecha_venta"),
                    rs.getTime("hora_venta"),
                    rs.getString("tipopago_venta"),
                    rs.getString("comprobante_venta"),
                    empleado,
                    rs.getDouble("total_venta")
                );

                DetalleVenta detalleVenta = new DetalleVenta(
                	rs.getInt("id_detalleVenta"),
                	venta,
                	producto,
                	rs.getInt("cantidad_detalleVenta"),
                	rs.getDouble("subtotal_detalleVenta")	
                );

                HistorialVentas historialVentas = new HistorialVentas(venta, detalleVenta);

                lista.add(historialVentas);
            }

        } catch (Exception e) {
            System.out.println("ERROR al listar historial de ventas: " + e);
        }

        return lista;
    }
	public ArrayList<HistorialVentas> MostrarVentasDelDia() {
	    ArrayList<HistorialVentas> lista = new ArrayList<>();

	    try {
	        CallableStatement csta = ConexionMySQL.getConexion().prepareCall("{call sp_MostrarVentasDelDia()}");
	        ResultSet rs = csta.executeQuery();

	        while (rs.next()) {
	            Cliente cliente = new Cliente(
	                rs.getString("dni_cliente"),
	                rs.getString("nombre_cliente"),
	                rs.getString("telefono_cliente")
	            );

	            Empleado empleado = new Empleado(
	            	rs.getInt("id_empleado"),
	                rs.getString("nombre_empleado")
	            );

	            Producto producto = new Producto(
	                rs.getInt("id_producto"),
	                rs.getString("categoria_producto"),
	                rs.getString("nombre_producto"),
	                rs.getString("garantia_producto"),
	                rs.getDouble("precio_producto")
	            );

	            Venta venta = new Venta(
	                rs.getInt("codigo_venta"),
	                cliente,
	                rs.getDate("fecha_venta"),
	                rs.getTime("hora_venta"),
	                rs.getString("tipopago_venta"),
	                rs.getString("comprobante_venta"),
	                empleado,
	                rs.getDouble("total_venta")
	            );

	            DetalleVenta detalleVenta = new DetalleVenta(
	            	rs.getInt("id_detalleVenta"),
	                venta,
	                producto,
	                rs.getInt("cantidad_detalleVenta"),
	                rs.getDouble("subtotal_detalleVenta")
	            );

	            HistorialVentas historial = new HistorialVentas(venta, detalleVenta);

	            lista.add(historial);
	        }

	    } catch (Exception e) {
	        System.out.println("ERROR al mostrar ventas del día: " + e);
	    }

	    return lista;
	}
}
