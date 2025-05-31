package arreglo;

import java.util.ArrayList;

import clase.Empleado;

public class ArregloEmpleado {
	
private ArrayList<Empleado>emple;
	
public ArregloEmpleado () {
	emple = new ArrayList<Empleado>();
	Adicionar(new Empleado(123, "74567892","Lucía Fernández Salas","555321987","Cajero","Medio tiempo", "01/03/2023", "09:10:1am","8:00 a.m.- 12:00 a.m.",6.0,90.0,10.0));
	Adicionar(new Empleado(245, "75678901","Ana Torres Benavides","555654321","Vendedor","Tiempo completo","04/03/2023", "10:10:23am","8:00 a.m. - 5:00 p.m.",5.0,170.0,0.0));
	Adicionar(new Empleado(378, "76789015","Valentina Ruiz Huertas","555789123","Cajero","Tiempo completo","04/06/2023", "8:40:11pm","8:00 a.m. - 5:00 p.m.",7.0,160.0,7.0));
	Adicionar(new Empleado(412, "77890126", "Sara Palacios Durand", "555987654", "Vendedor", "Medio tiempo", "5/06/2023", "09:30:16am","1:00 p.m. - 5:00 p.m.", 5.0, 100.0, 9.0));
	Adicionar(new Empleado(533, "78901237", "Rogelio Vargas Ruiz", "555345678", "Vendedor", "Tiempo completo","05/06/2023", "9:10:1am", "9:00 a.m. - 6:00 p.m.", 6.0, 150.0, 0.0));
	Adicionar(new Empleado(601, "79012348", "Fabricio Peña Ramirez", "555432198", "Vendedor", "Tiempo completo", "05/10/2023", "7:10:17pm","7:00 a.m. - 4:00 p.m.", 7.0, 140.0, 0.0));
	Adicionar(new Empleado(714, "80123459", "María Elena Hinostroza", "555678321", "Cajero", "Medio tiempo", "01/03/2025", "9:30:17pm","2:00 p.m. - 6:00 p.m.", 6.0, 110.0, 0.0));
	Adicionar(new Empleado(829, "81234560", "José Meza Burgos", "555876543", "Vendedor", "Tiempo completo", "07/03/2025", "3:10:56pm","10:00 a.m. - 7:00 p.m.", 5.0, 160.0, 15.0));
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

public Empleado Buscar(int id) {
	for(int i = 0; i < Tamaño(); i++) {
		if(Obtener(i).getId_empleado() == id)
			return Obtener(i);
	}
	return null;
}

}