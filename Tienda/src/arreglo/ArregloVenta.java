package arreglo;

import java.util.ArrayList;

import clase.Venta;

public class ArregloVenta {
	
private ArrayList<Venta>ven;

public ArregloVenta() {
	ven = new ArrayList<Venta>();
}

public void Adicionar(Venta x) {
	ven.add(x); 
}
public int Tamaño() { 
	return ven.size();
}
public Venta Obtener(int x) {
	return ven.get(x);
}

public Venta Buscar(int cod) {
	for(int i = 0; i < Tamaño(); i++) {
		if(Obtener(i).getCodigo_venta() == cod)
			return Obtener(i);
	}
	return null;
}
}

