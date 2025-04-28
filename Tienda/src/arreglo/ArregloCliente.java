package arreglo;

import java.util.ArrayList;

import clase.Cliente;

public class ArregloCliente {

	private ArrayList<Cliente>clie;
	
	public ArregloCliente () {
		clie = new ArrayList<Cliente>();
		Adicionar(new Cliente(111,"72345676","Mario Paredes Rosas","Laptop","555123456","2025-04-27","Efectivo",2));
		Adicionar(new Cliente(222,"76543215","Ana Gómez Sánchez","Smartphone","555987654","2025-05-10","Crédito",1));
		Adicionar(new Cliente(333,"73456784","Carlos Díaz Moreno","Tablet","555567890","2025-06-01","Débito",3));
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
	public Cliente Buscar(int cod) {
		for(int i = 0; i < Tamaño(); i++) {
			if(Obtener(i).getCodigo_compra() == cod)
				return Obtener(i);
		}
		return null;
	}
}
