package clase;

public class HistorialVentas {
private Venta venta;
private DetalleVenta detalleVenta;

public HistorialVentas(Venta venta, DetalleVenta detalleVenta) {

	this.venta = venta;
	this.detalleVenta = detalleVenta;
}

public Venta getVenta() {
	return venta;
}

public void setVenta(Venta venta) {
	this.venta = venta;
}

public DetalleVenta getDetalleVenta() {
	return detalleVenta;
}

public void setDetalleVenta(DetalleVenta detalleVenta) {
	this.detalleVenta = detalleVenta;
}

}
