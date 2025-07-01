package clase;

public class DetalleVenta {
private int idDetalleVenta;
private Venta venta;
private Producto producto;
private int cantidadDetalleVenta;
private double subtotalDetalleVenta;

public DetalleVenta(int idDetalleVenta, Venta venta, Producto producto, int cantidadDetalleVenta,
		double subtotalDetalleVenta) {

	this.idDetalleVenta = idDetalleVenta;
	this.venta = venta;
	this.producto = producto;
	this.cantidadDetalleVenta = cantidadDetalleVenta;
	this.subtotalDetalleVenta = subtotalDetalleVenta;
}

public DetalleVenta(Venta venta, Producto producto, int cantidadDetalleVenta, double subtotalDetalleVenta) {

	this.venta = venta;
	this.producto = producto;
	this.cantidadDetalleVenta = cantidadDetalleVenta;
	this.subtotalDetalleVenta = subtotalDetalleVenta;
}

public int getIdDetalleVenta() {
	return idDetalleVenta;
}

public void setIdDetalleVenta(int idDetalleVenta) {
	this.idDetalleVenta = idDetalleVenta;
}

public Venta getVenta() {
	return venta;
}

public void setVenta(Venta venta) {
	this.venta = venta;
}

public Producto getProducto() {
	return producto;
}

public void setProducto(Producto producto) {
	this.producto = producto;
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
