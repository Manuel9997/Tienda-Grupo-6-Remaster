package clase;

public class Cliente {
	public String Codigo_compra,Dni,Nombre_apellido,Producto,
	Telefono,Fecha,Tipo_pago;
	public int Cantidad, Total;
	
	
	public Cliente(String codigo_compra, String dni, String nombre_apellido, String producto, String telefono,
			String fecha, String tipo_pago, int cantidad, int total) {
		Codigo_compra = codigo_compra;
		Dni = dni;
		Nombre_apellido = nombre_apellido;
		Producto = producto;
		Telefono = telefono;
		Fecha = fecha;
		Tipo_pago = tipo_pago;
		Cantidad = cantidad;
		Total = total;
	}


	public String getCodigo_compra() {
		return Codigo_compra;
	}


	public void setCodigo_compra(String codigo_compra) {
		Codigo_compra = codigo_compra;
	}


	public String getDni() {
		return Dni;
	}


	public void setDni(String dni) {
		Dni = dni;
	}


	public String getNombre_apellido() {
		return Nombre_apellido;
	}


	public void setNombre_apellido(String nombre_apellido) {
		Nombre_apellido = nombre_apellido;
	}


	public String getProducto() {
		return Producto;
	}


	public void setProducto(String producto) {
		Producto = producto;
	}


	public String getTelefono() {
		return Telefono;
	}


	public void setTelefono(String telefono) {
		Telefono = telefono;
	}


	public String getFecha() {
		return Fecha;
	}


	public void setFecha(String fecha) {
		Fecha = fecha;
	}


	public String getTipo_pago() {
		return Tipo_pago;
	}


	public void setTipo_pago(String tipo_pago) {
		Tipo_pago = tipo_pago;
	}


	public int getCantidad() {
		return Cantidad;
	}


	public void setCantidad(int cantidad) {
		Cantidad = cantidad;
	}


	public int getTotal() {
		return Total;
	}


	public void setTotal(int total) {
		Total = total;
	}
	

}
