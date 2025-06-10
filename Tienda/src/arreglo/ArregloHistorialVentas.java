package arreglo;

import java.time.LocalDate;
import java.util.ArrayList;

import clase.Cliente;
import clase.Empleado;
import clase.Producto;
import clase.Venta;

public class ArregloHistorialVentas {
	
private ArrayList<Venta>histoVen;

public ArregloHistorialVentas(){
	histoVen = new ArrayList<Venta>();
	
	Cliente c1 = new Cliente("12345678", "Juan Pérez Bravo", "987654321");
    Cliente c2 = new Cliente("87654321", "Ana López Delgado", "912345678");
    Cliente c3 = new Cliente("11223344", "Carlos Gómez Martínez", "998877665");
    Cliente c4 = new Cliente("44332211", "María Fernanda Ruiz", "987123456");
    Cliente c5 = new Cliente("55667788", "Luis Alberto Cruz", "912345987");
    Cliente c6 = new Cliente("66778899", "Daniela Moreno Rojas", "913246578");
    Cliente c7 = new Cliente("99887766", "Pedro Castillo Palacios", "976543210");
    Cliente c8 = new Cliente("33445566", "Verónica Salazar Sánchez", "945612378");
    Cliente c9 = new Cliente("22113344", "Ricardo Alvarado Mendoza", "932165478");
    Cliente c10 = new Cliente("77889900", "Paola Méndez Peña", "967812345");
    
    Producto p1 = new Producto(145, "Laptop", "Asus TUF Gaming F15", "1 año", 3500.0);
    Producto p2 = new Producto(276, "Mouse", "Razer DeathAdder Essential", "6 meses", 160.0);
    Producto p3 = new Producto(398, "Teclado", "Corsair K55 RGB", "6 meses", 200.0);
    Producto p4 = new Producto(456, "Laptop", "HP Pavilion x360", "1 año", 2800.0);
    Producto p5 = new Producto(542, "Audífonos", "JBL Tune 510BT", "6 meses", 150.0);
    Producto p6 = new Producto(694, "Tablet", "iPad 9na Generación", "6 meses", 1600.0);
    Producto p7 = new Producto(756, "Impresora", "Epson EcoTank L3250", "1 año", 1500.0);
    Producto p8 = new Producto(877, "Laptop", "Lenovo IdeaPad 3 Ryzen 5","1 año", 3100.0);
    Producto p9 = new Producto(914, "Celular", "Samsung Galaxy S23", "1 año", 1300);
    Producto p10 = new Producto(980, "Cargador", "Samsung C-C 25w", "6 meses", 89);
    
    Empleado e1 = new Empleado("Ana Torres");
    Empleado e2 = new Empleado("José Meza");
    Empleado e3 = new Empleado("Sara Palacios");
    Empleado e4 = new Empleado("Fabricio Peña");
    Empleado e5 = new Empleado("Rogelio Vargas");
    Empleado e6 = new Empleado("Ana Torres");
    Empleado e7 = new Empleado("Rogelio Vargas");
    Empleado e8 = new Empleado("Fabricio Peña");
    Empleado e9 = new Empleado("Sara Palacios");
    Empleado e10 = new Empleado("Ana Torres");
    
    Adicionar(new Venta(14, c1, LocalDate.of(2025, 5, 24), p1, 1, "Efectivo", "Boleta", e1, "12:10:05pm"));
    Adicionar(new Venta(35, c2, LocalDate.of(2025, 5, 24), p2, 1, "Efectivo", "Boleta", e2,"10:20:05am"));
    Adicionar(new Venta(40, c3, LocalDate.of(2025, 5, 24), p3, 2, "Débito", "Factura", e3,"02:10:12pm"));
    Adicionar(new Venta(55, c4, LocalDate.of(2025, 5, 24), p4, 1, "Efectivo", "Boleta", e4, "07:18:15pm"));
    Adicionar(new Venta(60, c5, LocalDate.of(2025, 5, 24), p5, 3, "Crédito", "Factura", e5,"09:08:34pm"));
    Adicionar(new Venta(65, c6, LocalDate.of(2025, 5, 24), p6, 1, "Efectivo", "Factura", e6,"12:10:05pm"));
    Adicionar(new Venta(70, c7, LocalDate.of(2025, 5, 24), p7, 1, "Crédito", "Boleta", e7,"12:10:05pm"));
    Adicionar(new Venta(75, c8, LocalDate.of(2025, 5, 24), p8, 2, "Efectivo", "Factura", e8,"12:10:05pm"));
    Adicionar(new Venta(80, c9, LocalDate.of(2025, 5, 24), p9, 1, "Débito", "Boleta", e9, "12:10:05pm"));
    Adicionar(new Venta(85, c10, LocalDate.of(2025, 5, 24), p10, 3, "Efectivo", "Factura", e10,"12:10:05pm"));

}
public void Adicionar(Venta x) {
	histoVen.add(x);
}
public int Tamaño() {
	return histoVen.size();
}
public Venta Obtener(int x) {
	return histoVen.get(x);
}
public Venta Buscar(int cod) {
	for(int i = 0; i < Tamaño(); i++) {
		if(Obtener(i).getCodigo_venta() == cod)
			return Obtener(i);
	}
	return null;
}
}
