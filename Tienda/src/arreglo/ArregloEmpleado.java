package arreglo;

import java.util.ArrayList;

import clase.Empleado;

public class ArregloEmpleado {
	
	private ArrayList<Empleado>emple;
	
	public ArregloEmpleado () {
		emple = new ArrayList<Empleado>();
		Adicionar(new Empleado("74567892","Lucía Fernández Cardenas","555321987","Recepcionista","Media","14:00-20:00",25.0,90.0,150.0));
		Adicionar(new Empleado("75678901","Martín López Juarez","555654321","Técnico","Completa","07:00-16:00",45.0,170.0,300.0));
		Adicionar(new Empleado("76789015","Valentina Ruiz Perez","555789123","Contador","Completa","09:00-18:00",60.0,160.0,500.0));
	}
	
	public void Adicionar(Empleado x) {
		emple.add(x);
	}
	
	public int Tamaño() {
		return emple.size();
	}
	
	public Empleado Obtener(int x) {
		return emple.get(x);
	}	
}