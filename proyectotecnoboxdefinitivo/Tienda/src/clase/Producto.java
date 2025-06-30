package clase;

public class Producto {
private int idProducto;
private String categoriaProducto, nombreProducto, garantiaProducto;
private double precioProducto;
private int stockProducto;

public Producto(int idProducto, String categoriaProducto, String nombreProducto, String garantiaProducto,
		double precioProducto, int stockProducto) {

	this.idProducto = idProducto;
	this.categoriaProducto = categoriaProducto;
	this.nombreProducto = nombreProducto;
	this.garantiaProducto = garantiaProducto;
	this.precioProducto = precioProducto;
	this.stockProducto = stockProducto;
}

public int getIdProducto() {
	return idProducto;
}

public void setIdProducto(int idProducto) {
	this.idProducto = idProducto;
}

public String getCategoriaProducto() {
	return categoriaProducto;
}

public void setCategoriaProducto(String categoriaProducto) {
	this.categoriaProducto = categoriaProducto;
}

public String getNombreProducto() {
	return nombreProducto;
}

public void setNombreProducto(String nombreProducto) {
	this.nombreProducto = nombreProducto;
}

public String getGarantiaProducto() {
	return garantiaProducto;
}

public void setGarantiaProducto(String garantiaProducto) {
	this.garantiaProducto = garantiaProducto;
}

public double getPrecioProducto() {
	return precioProducto;
}

public void setPrecioProducto(double precioProducto) {
	this.precioProducto = precioProducto;
}

public int getStockProducto() {
	return stockProducto;
}

public void setStockProducto(int stockProducto) {
	this.stockProducto = stockProducto;
}

}
