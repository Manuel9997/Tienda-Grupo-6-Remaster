package arreglo;

import java.util.ArrayList;

import clase.Producto;

public class ArregloProducto {

private ArrayList<Producto>pro;
	
public ArregloProducto () {
	pro = new ArrayList<Producto>();
	Adicionar(new Producto(189, "Laptop", "Asus TUF Gaming F15", "1 año", 3500, 5)); 
	Adicionar(new Producto(146, "Laptop", "HP Pavilion x360", "1 año", 2800, 3));
	Adicionar(new Producto(378, "Mouse", "Logitech G502 Hero", "6 meses", 180, 15));
	Adicionar(new Producto(873, "Teclado", "Redragon Kumara K552", "6 meses", 150, 10)); 
	Adicionar(new Producto(489, "Celular", "Samsung Galaxy S23", "1 año", 3600, 4));
	Adicionar(new Producto(151, "Tablet", "iPad 9na Generación", "6 meses", 2200, 6));
	Adicionar(new Producto(512, "Impresora", "HP Ink Tank 415", "1 año", 600, 2));
	Adicionar(new Producto(458, "Cámara Web", "Logitech C920 HD", "6 meses", 250, 8));
	Adicionar(new Producto(155, "Router", "TP-Link Archer AX10 Wi-Fi 6", "1 año", 450, 9));
	Adicionar(new Producto(156, "Laptop", "Dell Inspiron 15 3000", "1 año", 2900, 4));
	Adicionar(new Producto(158, "Teclado", "Logitech K380 Inalámbrico", "6 meses", 130, 10));
	Adicionar(new Producto(163, "Consola", "PlayStation 5      ", "3 meses", 3600, 2));
	Adicionar(new Producto(164, "Impresora", "Epson EcoTank L3250", "1 año", 850, 3));
	Adicionar(new Producto(165, "Laptop", "Lenovo IdeaPad 3 Ryzen 5", "1 año", 3100, 6));
	Adicionar(new Producto(166, "Celular", "iPhone 13             ", "1 año", 4200, 3));
	Adicionar(new Producto(167, "Mouse", "Razer DeathAdder Essential", "6 meses", 160, 12));
	Adicionar(new Producto(168, "Tablet", "Samsung Galaxy Tab A8", "6 meses", 1700, 5));
	Adicionar(new Producto(169, "Audífonos", "JBL Tune 510BT", "6 meses", 240, 9));
	Adicionar(new Producto(170, "Teclado", "Corsair K55 RGB", "6 meses", 200, 7));
	Adicionar(new Producto(173, "Cámara Web", "Microsoft LifeCam HD-3000", "6 meses", 220, 6));
	Adicionar(new Producto(174, "Impresora", "Canon PIXMA G2160", "1 año", 750, 2));
	Adicionar(new Producto(190, "Cargador", "Samsung C-C 25w", "6 meses", 89, 5));
}
	
public void Adicionar(Producto x) {
	pro.add(x);
}
	
public int Tamaño() {
	return pro.size();
}
	
public Producto Obtener(int x) {
	return pro.get(x);
}

public Producto Buscar(int id) {
	for(int i = 0; i < Tamaño(); i++) {
		if(Obtener(i).getId_producto() == id)
			return Obtener(i);
	}
	return null;
}
}