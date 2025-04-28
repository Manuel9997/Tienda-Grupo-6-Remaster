package arreglo;

import java.util.ArrayList;

import clase.Cliente;

public class ArregloCliente {

	private ArrayList<Cliente>clie;
	
	public ArregloCliente () {
		clie = new ArrayList<Cliente>();
		Adicionar_Cliente(new Cliente("C001","1234567","Mario Paredes Rosas","Laptop","555123456","2025-04-27","Efectivo",2));
		Adicionar_Cliente(new Cliente("C002","7654321","Ana Gómez Sánchez","Smartphone","555987654","2025-05-10","Crédito",1));
		Adicionar_Cliente(new Cliente("C003","2345678","Carlos Díaz Moreno","Tablet","555567890","2025-06-01","Débito",3));
	}
	public void Adicionar_Cliente(Cliente x) {
		clie.add(x);
	}
	public int Tamaño_Cliente() {
		return clie.size();
	}
	public Cliente Obtener_Cliente(int x) {
		return clie.get(x);
	}
}
