package arreglo;

import java.util.ArrayList;

import clase.Cliente;

public class ArregloCliente {

private ArrayList<Cliente>clie;
	
public ArregloCliente () {
	clie = new ArrayList<Cliente>();
		
}
	
public void Adicionar(Cliente x) {
	clie.add(x);
}
	
public int Tamaño() {
	return clie.size();
} 
	
public Cliente Obtener(int x) {
	return clie.get(x);
}

}
