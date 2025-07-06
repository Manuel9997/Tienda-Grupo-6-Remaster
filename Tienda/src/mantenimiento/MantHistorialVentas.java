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
	
	public ArrayList<HistorialVentas> ConsultarHistorialVentasFiltrado(String filtro) {
	    ArrayList<HistorialVentas> lista = new ArrayList<>();
	    Connection conexion = null;
	    CallableStatement cs = null; // Usar CallableStatement para llamar a Stored Procedures
	    ResultSet rs = null;

	    try {
	        conexion = ConexionMySQL.getConexion();
	        String sql = "{CALL sp_MostrarHistorialVentasconfiltro(?)}"; 
	        cs = conexion.prepareCall(sql);
	        cs.setString(1, filtro); 
	        rs = cs.executeQuery();


	        while (rs.next()) {

	            String codigoVentaStr = String.valueOf(rs.getInt("codigo_venta")); 
	            String categoriaProducto = rs.getString("categoria_producto");
	            String nombreCliente = rs.getString("nombre_cliente");
	            String dniCliente = rs.getString("dni_cliente");
	            String idEmpleadoStr = String.valueOf(rs.getInt("id_empleado"));
	            String nombreEmpleado = rs.getString("nombre_empleado");

	            if (codigoVentaStr.contains(filtro) ||
	                categoriaProducto.contains(filtro) ||
	                nombreCliente.contains(filtro) ||
	                dniCliente.contains(filtro) ||
	                idEmpleadoStr.contains(filtro) ||
	                nombreEmpleado.contains(filtro))
	            {
	                Cliente cliente = new Cliente(
	                    dniCliente,
	                    nombreCliente,
	                    rs.getString("telefono_cliente")
	                );

	                Empleado empleado = new Empleado(
	                    rs.getInt("id_empleado"),
	                    nombreEmpleado
	                );

	                Producto producto = new Producto(
	                    rs.getInt("id_producto"),
	                    categoriaProducto,
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
	        }

	    } catch (Exception e) {
	        System.err.println("ERROR general al consultar historial de ventas: " + e.getMessage());
	        e.printStackTrace();
	
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
	

	public void EliminarHistorial(int idventa) {
	    try {
	        Connection cnx = ConexionMySQL.getConexion();
	        CallableStatement csta = cnx.prepareCall("{call sp_EliminarHistorialVentas(?)}");
	        csta.setInt(1, idventa);
	        csta.executeUpdate();
	    } catch (Exception ex) {
	        System.out.println("ERROR al eliminar las dos tablas: " + ex);
	    }
	}
	
	
}
