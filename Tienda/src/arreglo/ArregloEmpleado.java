package arreglo;

import java.time.LocalDate;
import java.util.ArrayList;

import clase.Empleado;

public class ArregloEmpleado {
	
private ArrayList<Empleado>emple;
	
public ArregloEmpleado () {
	emple = new ArrayList<Empleado>();
	Adicionar(new Empleado(123, "74567892","Lucía Fernández Salas","555321987", LocalDate.of(2025, 4, 13),"Cajero","Medio tiempo\t","8:00 a.m.- 12:00 a.m.",6.0,90.0,10.0));
	Adicionar(new Empleado(245, "75678901","Ana Torres Benavides","555654321", LocalDate.of(2025, 4, 13),"Vendedor","Tiempo completo" ,"8:00 a.m. - 5:00 p.m.",5.0,170.0,0.0));
	Adicionar(new Empleado(378, "76789015","Valentina Ruiz Huertas","555789123", LocalDate.of(2025, 4, 14),"Cajero","Tiempo completo","8:00 a.m. - 5:00 p.m.",7.0,160.0,7.0));
	Adicionar(new Empleado(412, "77890126", "Sara Palacios Durand", "555987654", LocalDate.of(2025, 4, 18), "Vendedor", "Medio tiempo\t","1:00 p.m. - 5:00 p.m.", 5.0, 100.0, 9.0));
	Adicionar(new Empleado(533, "78901237", "Rogelio Vargas Ruiz", "555345678", LocalDate.of(2025, 5, 2), "Vendedor", "Tiempo completo", "9:00 a.m. - 6:00 p.m.", 6.0, 150.0, 0.0));
	Adicionar(new Empleado(601, "79012348", "Fabricio Peña Ramirez", "555432198", LocalDate.of(2025, 5, 2), "Vendedor", "Tiempo completo","7:00 a.m. - 4:00 p.m.", 7.0, 140.0, 0.0));
	Adicionar(new Empleado(714, "80123459", "María Elena Hinostroza", "555678321", LocalDate.of(2025, 5, 24), "Cajero", "Medio tiempo\t","2:00 p.m. - 6:00 p.m.", 6.0, 110.0, 0.0));
	Adicionar(new Empleado(829, "81234560", "José Meza Burgos", "555876543", LocalDate.of(2025, 5, 24), "Vendedor", "Tiempo completo","10:00 a.m. - 7:00 p.m.", 5.0, 160.0, 15.0));
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