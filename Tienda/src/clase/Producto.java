package clase;

public class Producto {
private int id_producto;
private String cat_producto, nombre, garantia;
private double precio;
private int stock;

public Producto(int id_producto, String cat_producto, String nombre, String garantia, double precio, int stock) {

	this.id_producto = id_producto;
	this.cat_producto = cat_producto;
	this.nombre = nombre; 
	this.garantia = garantia;
	this.precio = precio;
	this.stock = stock;
}

public Producto(int id_producto, String cat_producto, String nombre, String garantia, double precio) {

	this.id_producto = id_producto;
	this.cat_producto = cat_producto;
	this.nombre = nombre;
	this.garantia = garantia;
	this.precio = precio;
}

public Producto(int id_producto) {

	this.id_producto = id_producto;
}

public int getId_producto() {
	return id_producto;
}

public void setId_producto(int id_producto) {
	this.id_producto = id_producto;
}

public String getCat_producto() {
	return cat_producto;
}

public void setCat_producto(String cat_producto) {
	this.cat_producto = cat_producto;
}

public String getNombre() {
	return nombre;
}

public void setNombre(String nombre) {
	this.nombre = nombre;
}

public String getGarantia() {
	return garantia;
}

public void setGarantia(String garantia) {
	this.garantia = garantia;
}

public double getPrecio() {
	return precio;
}

public void setPrecio(double precio) {
	this.precio = precio;
}

public int getStock() {
	return stock;
}

public void setStock(int stock) {
	this.stock = stock;
}

public void reducirStock(int cantidad) {
    this.stock -= cantidad;
}

public void aumentarStock(int cantidad) {
    this.stock += cantidad;
}

}
