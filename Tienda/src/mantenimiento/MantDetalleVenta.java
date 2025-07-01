package mantenimiento;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import Conexion.ConexionMySQL;
import clase.DetalleVenta;
import clase.Producto;
import clase.Venta;

public class MantDetalleVenta {
public ArrayList<DetalleVenta> MostrarDetalleVenta() {
	ArrayList<DetalleVenta> lista = new ArrayList<>();
	try {
    	CallableStatement csta = ConexionMySQL.getConexion().prepareCall("{call sp_MostrarDetalleVenta()}");
    	ResultSet rs = csta.executeQuery();
    	Venta v;
    	Producto p;
    	DetalleVenta dv;
        while (rs.next()) {
        	v = new Venta(rs.getInt("codigo_venta"));
        	p = new Producto(
        			rs.getInt("id_producto"), 
        			rs.getString("categoria_producto"), 
        			rs.getString("nombre_producto"), 
        			rs.getString("garantia_producto"), 
        			rs.getDouble("precio_producto"));
        	dv = new DetalleVenta(
        			rs.getInt("id_detalleVenta"),
                    v,
                    p,
                    rs.getInt("cantidad_detalleVenta"),
                    rs.getDouble("subtotal_detalleVenta")
                );
        	lista.add(dv);
        }
    } catch (Exception e) {}
	
	return lista;
	
    }
public void AgregarDetalleVenta(DetalleVenta dv) {
    try {
    	Connection cnx = ConexionMySQL.getConexion();
        CallableStatement csta = ConexionMySQL.getConexion().prepareCall("{call sp_AgregarDetalleVenta(?,?,?)}");
        csta.setInt(1, dv.getVenta().getCodigoVenta());
        csta.setInt(2, dv.getProducto().getIdProducto());
        csta.setInt(3, dv.getCantidadDetalleVenta());
        csta.executeUpdate();
    } catch (Exception e) {
        System.out.println("ERROR" + e);
    }
}
}
