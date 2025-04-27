package clase;

public class Producto {
	public String ID_Producto,Nombre,Categoria;
	public int Entrada,Salida,Stock;
	
	public Producto(String iD_Producto, String nombre, String categoria, int entrada, int salida, int stock) {
		ID_Producto = iD_Producto;
		Nombre = nombre;
		Categoria = categoria;
		Entrada = entrada;
		Salida = salida;
		Stock = stock;
	}

	public String getID_Producto() {
		return ID_Producto;
	}

	public void setID_Producto(String iD_Producto) {
		ID_Producto = iD_Producto;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getCategoria() {
		return Categoria;
	}

	public void setCategoria(String categoria) {
		Categoria = categoria;
	}

	public int getEntrada() {
		return Entrada;
	}

	public void setEntrada(int entrada) {
		Entrada = entrada;
	}

	public int getSalida() {
		return Salida;
	}

	public void setSalida(int salida) {
		Salida = salida;
	}

	public int getStock() {
		return Stock;
	}
	
	public int getStock(int Stock_int, boolean Stock_Boo) {
		if(Stock_Boo) {
			return Stock_int;
		}
		else {
		return 0;
		}
	}

	public void setStock(int stock) {
		Stock = stock;
	}

	
}
