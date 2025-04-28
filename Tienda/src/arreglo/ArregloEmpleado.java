package arreglo;

import java.util.ArrayList;

import clase.Empleado;

public class ArregloEmpleado {
	private ArrayList<Empleado>emple;
	
	public ArregloEmpleado () {
		emple = new ArrayList<Empleado>();
		Adicionar_Empleado(new Empleado("3456789","Lucía Fernández Cardenas","555321987","Recepcionista","Media","14:00-20:00",25.0,90.0,150.0));
		Adicionar_Empleado(new Empleado("4567890","Martín López Juarez","555654321","Técnico","Completa","07:00-16:00",45.0,170.0,300.0));
		Adicionar_Empleado(new Empleado("5678901","Valentina Ruiz Perez","555789123","Contador","Completa","09:00-18:00",60.0,160.0,500.0));
	}
	public void Adicionar_Empleado(Empleado x) {
		emple.add(x);
	}
	public int Tamaño_Empleado() {
		return emple.size();
	}
	public Empleado Obtener_Empleado(int x) {
		return emple.get(x);
	}	
}