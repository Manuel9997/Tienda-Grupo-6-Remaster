package clase;

public class Producto {
private String id_producto, nombre, categoria, garantia;
private double precio;
private int entrada, salida, stock = 0;

public Producto(String id_producto, String nombre, String categoria, String garantia, double precio, int entrada,
		int salida) {
	
	this.id_producto = id_producto;
	this.nombre = nombre;
	this.categoria = categoria;
	this.garantia = garantia;
	this.precio = precio;
	this.entrada = entrada;
	this.salida = salida;
}

public String getId_producto() {
	return id_producto;
}

public void setId_producto(String id_producto) {
	this.id_producto = id_producto;
}

public String getNombre() {
	return nombre;
}

public void setNombre(String nombre) {
	this.nombre = nombre;
}

public String getCategoria() {
	return categoria;
}

public void setCategoria(String categoria) {
	this.categoria = categoria;
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

public int getEntrada() {
	return entrada;
}

public void setEntrada(int entrada) {
	this.entrada = entrada;
}

public int getSalida() {
	return salida;
}

public void setSalida(int salida) {
	this.salida = salida;
}

public int getStock() {
	return stock;
}

public void setStock(int stock) {
	this.stock = stock;
}
//SOBRECARGA DE MÉTODOS
public int Stock() {
	stock += entrada;
    stock -= salida;
    return stock;
}
public String Stock(int stock) {
	if(stock <= 0) {
		return "No disponible";
	}
	else {
		return "Disponible";
	}
}
}
