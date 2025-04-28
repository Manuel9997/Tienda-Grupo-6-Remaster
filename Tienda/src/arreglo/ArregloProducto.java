package arreglo;

import java.util.ArrayList;

import clase.Producto;

public class ArregloProducto {

	private ArrayList<Producto>pro;
	
	public ArregloProducto () {
		pro = new ArrayList<Producto>();
		Adicionar_Producto(new Producto("P001","Laptop","Electrónica","1 año",1200.0,50,10));
		Adicionar_Producto(new Producto("P002","Smartphone","Electrónica","6 meses",800.0,100,30));
		Adicionar_Producto(new Producto("P003","Impresora","Oficina","1 año",300.0,40,5));
	}
	
	public void Adicionar_Producto(Producto x) {
		pro.add(x);
	}
	
	public int Tamaño_Producto() {
		return pro.size();
	}
	
	public Producto Obtener_Producto(int x) {
		return pro.get(x);
	}
}
