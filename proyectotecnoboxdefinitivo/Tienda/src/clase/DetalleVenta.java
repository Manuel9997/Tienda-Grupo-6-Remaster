package clase;

public class DetalleVenta {
private int idDetalleVenta, codigoVenta, idProducto, cantidadDetalleVenta;
private double subtotalDetalleVenta;

public DetalleVenta(int idDetalleVenta, int codigoVenta, int idProducto, int cantidadDetalleVenta,
		double subtotalDetalleVenta) {
	super();
	this.idDetalleVenta = idDetalleVenta;
	this.codigoVenta = codigoVenta;
	this.idProducto = idProducto;
	this.cantidadDetalleVenta = cantidadDetalleVenta;
	this.subtotalDetalleVenta = subtotalDetalleVenta;
}

public int getIdDetalleVenta() {
	return idDetalleVenta;
}

public void setIdDetalleVenta(int idDetalleVenta) {
	this.idDetalleVenta = idDetalleVenta;
}

public int getCodigoVenta() {
	return codigoVenta;
}

public void setCodigoVenta(int codigoVenta) {
	this.codigoVenta = codigoVenta;
}

public int getIdProducto() {
	return idProducto;
}

public void setIdProducto(int idProducto) {
	this.idProducto = idProducto;
}

public int getCantidadDetalleVenta() {
	return cantidadDetalleVenta;
}

public void setCantidadDetalleVenta(int cantidadDetalleVenta) {
	this.cantidadDetalleVenta = cantidadDetalleVenta;
}

public double getSubtotalDetalleVenta() {
	return subtotalDetalleVenta;
}

public void setSubtotalDetalleVenta(double subtotalDetalleVenta) {
	this.subtotalDetalleVenta = subtotalDetalleVenta;
}

}
