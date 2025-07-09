package mantenimiento;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import Conexion.ConexionMySQL;
import clase.Producto;
import clase.Proveedor;

public class MantProducto {
public ArrayList<Producto> MostrarProducto() {
	ArrayList<Producto> lista = new ArrayList<>();
	try {
		Connection cnx = ConexionMySQL.getConexion();
		CallableStatement csta = cnx.prepareCall("{call sp_MostrarProducto()}");
		ResultSet rs = csta.executeQuery();
		while (rs.next()) {
			
			Proveedor proveedor = new Proveedor(rs.getInt("id_proveedor"), rs.getString("nombre_proveedor"));
			Producto producto = new Producto(
					rs.getInt("id_producto"),
                    rs.getString("categoria_producto"),
                    rs.getString("nombre_producto"),
                    rs.getString("garantia_producto"),
                    proveedor,
                    rs.getDouble("precio_producto"),
                    rs.getInt("stock_producto")
			);
			
			lista.add(producto);
		}
	} catch (Exception e) {
            System.out.println("ERROR al listar productos: " + e);
    }
	
	return lista;
}

public void AgregarProducto(Producto p) {
    try {
        Connection cnx = ConexionMySQL.getConexion();
        CallableStatement csta = cnx.prepareCall("{call sp_AgregarProducto(?, ?, ?, ?, ?, ?, ?)}");
        csta.setInt(1, p.getIdProducto());
        csta.setString(2, p.getCategoriaProducto());
        csta.setString(3, p.getNombreProducto());
        csta.setString(4, p.getGarantiaProducto());
        csta.setInt(5, p.getProveedor().getIdProveedor());
        csta.setDouble(6, p.getPrecioProducto());
        csta.setInt(7, p.getStockProducto());
        csta.executeUpdate();
    } catch (Exception e) {
        System.out.println("ERROR al agregar producto: " + e);
    }
}

public void ModificarProducto(Producto p) {
    try {
        Connection cnx = ConexionMySQL.getConexion();
        CallableStatement csta = cnx.prepareCall("{call sp_ModificarProducto(?, ?, ?, ?, ?, ?)}");
        csta.setInt(1, p.getIdProducto());
        csta.setString(2, p.getCategoriaProducto());
        csta.setString(3, p.getNombreProducto());
        csta.setString(4, p.getGarantiaProducto());
        csta.setInt(5, p.getProveedor().getIdProveedor());
        csta.setDouble(6, p.getPrecioProducto());
        csta.executeUpdate();
    } catch (Exception e) {
        System.out.println("ERROR al modificar producto: " + e);
    }
}
public void EliminarProducto(int idProducto) {
    try {
        Connection cnx = ConexionMySQL.getConexion();
        CallableStatement csta = cnx.prepareCall("{call sp_EliminarProducto(?)}");
        csta.setInt(1, idProducto);
        csta.executeUpdate();
    } catch (Exception e) {
        System.out.println("ERROR al eliminar producto: " + e);
    }
}

public Producto BuscarProducto(int idProducto) {
	Producto producto = null;
    try {
        Connection cnx = ConexionMySQL.getConexion();
        CallableStatement csta = cnx.prepareCall("{call sp_BuscarProducto(?)}");
        csta.setInt(1, idProducto);
        ResultSet rs = csta.executeQuery();
        if (rs.next()) {
        	Proveedor proveedor = new Proveedor(rs.getInt("id_proveedor"));
            producto = new Producto(
                rs.getInt("id_producto"),
                rs.getString("categoria_producto"),
                rs.getString("nombre_producto"),
                rs.getString("garantia_producto"),
                proveedor,
                rs.getDouble("precio_producto"),
                rs.getInt("stock_producto")
            );
        }
    } catch (Exception e) {
        System.out.println("ERROR al buscar producto: " + e);
    }
    return producto;
}

public ArrayList<Producto> ConsultarProducto(String filtro) {
    ArrayList<Producto> lista = new ArrayList<>();
    try {
        java.sql.Statement sta = ConexionMySQL.getConexion().createStatement();
        ResultSet rs = sta.executeQuery( "SELECT p.id_producto, p.categoria_producto, p.nombre_producto, " +
        		"p.garantia_producto, " + 
        	    "prov.id_proveedor, prov.nombre_proveedor, p.precio_producto, p.stock_producto " +
        	    "FROM Producto p " +
        	    "JOIN Proveedor prov ON p.id_proveedor = prov.id_proveedor " +
        	    "WHERE CAST(p.id_producto AS CHAR) LIKE '%" + filtro + "%' " +
        	    "OR p.categoria_producto LIKE '%" + filtro + "%'"
        	);
    
        while (rs.next()) {
        	Proveedor proveedor = new Proveedor(rs.getInt("id_proveedor"), rs.getString("nombre_proveedor"));
        	Producto producto = new Producto(
                rs.getInt("id_producto"),
                rs.getString("categoria_producto"),
                rs.getString("nombre_producto"),
                rs.getString("garantia_producto"),
                proveedor,
                rs.getDouble("precio_producto"),
                rs.getInt("stock_producto")
            );
            lista.add(producto);
        }
    } catch (Exception e) {
        System.out.println("ERROR al buscar producto: " + e);
    }
    return lista;
}

public void AumentarStock(Producto p) {
    try {
        Connection cnx = ConexionMySQL.getConexion();
        CallableStatement csta = cnx.prepareCall("{call sp_AumentarStock(?, ?)}");
        csta.setInt(1, p.getIdProducto());
        csta.setInt(2, p.getStockProducto());
        csta.executeUpdate();
    } catch (Exception e) {
        System.out.println("ERROR al aumentar stock: " + e);
    }
}
}
