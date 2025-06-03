package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import arreglo.ArregloEmpleado;
import arreglo.ArregloHistorialVentas;
import arreglo.ArregloProducto;
import clase.Empleado;
import clase.Producto;
import clase.Venta;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.UIManager;

public class VenAdministrador extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblNombreCompleto;
	private JLabel lblTelfono;
	private JLabel lblCargo;
	private JLabel lblId;
	private JTextField txtIdEmpleado;
	private JTextField txtNombreEmpleado;
	private JTextField txtDniEmpleado;
	private JTextField txtTelefono;
	private JComboBox cboCargo;
	private JLabel lblJornada;
	private JComboBox cboJornada;
	private JLabel lblHorario;
	private JComboBox cboHorario;
	private JLabel lblPagoPorHora;
	private JTextField txtPago;
	private JLabel lblHorasTrabajadas;
	private JTextField txtHoras;
	private JLabel lblDescuento;
	private JTextField txtDescuento;
	private JButton btnRegistrarEmpleado;
	private JButton btnModificarEmpleado;
	private JLabel lblRegistrarEmpleado;
	private JButton btnMostrarEmpleado;
	private JButton btnHistorialVentas;
	private JLabel lblId_1;
	private JTextField txtID_Cod;
	private JButton btnBuscar;
	public int day;
	public int year;
	public int month;
	public int second;
	public int minute;
	public int hour;
	public String tmam;
	public int Switch=0;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VenAdministrador frame = new VenAdministrador();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void clock() {
		Thread clock =new Thread() {
			public void run() {
				try {
					for(;;) {
					Calendar cal= new GregorianCalendar();
					 day= cal.get(Calendar.DAY_OF_MONTH);
					month= cal.get(Calendar.MONTH);
					year= cal.get(Calendar.YEAR);
					
					 second= cal.get(Calendar.SECOND);
					 minute= cal.get(Calendar.MINUTE);
					 hour= cal.get(Calendar.HOUR);
					
					int ampm= cal.get(Calendar.AM_PM);

				if(ampm == 0) {
					
					tmam= "am";
				}
				else {
					tmam= "pm";
				}
					
					
					lblclock.setText("Fecha: "+ day+"/"+month+"/"+year+" Hora: "+hour+":"+minute+":"+second+tmam);
					sleep(1000);
					}
				}
				catch(InterruptedException e) {
					e.printStackTrace();
				}
				
			}
		};

		clock.start();
	}
	
	/**
	 * Create the frame.
	 */
	public VenAdministrador() {
		setAlwaysOnTop(true);
		setTitle("Administrador");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 930, 730);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("Button.light"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		

		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			lblNewLabel = new JLabel("DNI:");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblNewLabel.setBounds(400, 110, 45, 19);
			contentPane.add(lblNewLabel);
		}
		{
			lblNombreCompleto = new JLabel("Nombre completo:");
			lblNombreCompleto.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblNombreCompleto.setBounds(242, 149, 140, 19);
			contentPane.add(lblNombreCompleto);
		}
		{
			lblTelfono = new JLabel("Teléfono:");
			lblTelfono.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblTelfono.setBounds(242, 187, 69, 19);
			contentPane.add(lblTelfono);
		}
		{
			lblCargo = new JLabel("Cargo:");
			lblCargo.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblCargo.setBounds(455, 189, 69, 19);
			contentPane.add(lblCargo);
		}
		{
			lblId = new JLabel("ID:");
			lblId.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblId.setBounds(242, 110, 45, 19);
			contentPane.add(lblId);
		}
		{
			txtIdEmpleado = new JTextField();
			txtIdEmpleado.setColumns(10);
			txtIdEmpleado.setBounds(274, 109, 96, 25);
			contentPane.add(txtIdEmpleado);
		}
		{
			txtNombreEmpleado = new JTextField();
			txtNombreEmpleado.setColumns(10);
			txtNombreEmpleado.setBounds(373, 148, 349, 25);
			contentPane.add(txtNombreEmpleado);
		}
		{
			txtDniEmpleado = new JTextField();
			txtDniEmpleado.setColumns(10);
			txtDniEmpleado.setBounds(438, 109, 117, 25);
			contentPane.add(txtDniEmpleado);
		}
		{
			txtTelefono = new JTextField();
			txtTelefono.setColumns(10);
			txtTelefono.setBounds(321, 186, 117, 25);
			contentPane.add(txtTelefono);
		}
		{
			cboCargo = new JComboBox();
			cboCargo.setModel(new DefaultComboBoxModel(new String[] {"Cajero", "Vendedor"}));
			cboCargo.setFont(new Font("Tahoma", Font.PLAIN, 15));
			cboCargo.setBounds(507, 187, 117, 25);
			contentPane.add(cboCargo);
		}
		{
			lblJornada = new JLabel("Jornada:");
			lblJornada.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblJornada.setBounds(242, 228, 69, 19);
			contentPane.add(lblJornada);
		}
		{
			cboJornada = new JComboBox();
			cboJornada.setModel(new DefaultComboBoxModel(new String[] {"Tiempo completo", "Medio tiempo"}));
			cboJornada.setFont(new Font("Tahoma", Font.PLAIN, 15));
			cboJornada.setBounds(320, 225, 146, 25);
			contentPane.add(cboJornada);
		}
		{
			lblHorario = new JLabel("Horario:");
			lblHorario.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblHorario.setBounds(486, 228, 69, 19);
			contentPane.add(lblHorario);
		}
		{
			cboHorario = new JComboBox();
			cboHorario.setModel(new DefaultComboBoxModel(new String[] {"8:00 a.m. - 5:00 p.m.", "8:00 a.m. - 12:00 a.m.", "12:00 a.m. - 4:00 p.m."}));
			cboHorario.setFont(new Font("Tahoma", Font.PLAIN, 15));
			cboHorario.setBounds(549, 225, 173, 25);
			contentPane.add(cboHorario);
		}
		{
			lblPagoPorHora = new JLabel("Pago/hora:");
			lblPagoPorHora.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblPagoPorHora.setBounds(242, 266, 87, 19);
			contentPane.add(lblPagoPorHora);
		}
		{
			txtPago = new JTextField();
			txtPago.setColumns(10);
			txtPago.setBounds(321, 265, 117, 25);
			contentPane.add(txtPago);
		}
		{
			lblHorasTrabajadas = new JLabel("Horas trabajadas:");
			lblHorasTrabajadas.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblHorasTrabajadas.setBounds(455, 266, 124, 19);
			contentPane.add(lblHorasTrabajadas);
		}
		{
			txtHoras = new JTextField();
			txtHoras.setColumns(10);
			txtHoras.setBounds(580, 265, 117, 25);
			contentPane.add(txtHoras);
		}
		{
			lblDescuento = new JLabel("Descuento:");
			lblDescuento.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblDescuento.setBounds(242, 307, 87, 19);
			contentPane.add(lblDescuento);
		}
		{
			txtDescuento = new JTextField();
			txtDescuento.setColumns(10);
			txtDescuento.setBounds(321, 306, 117, 25);
			contentPane.add(txtDescuento);
		}
		{
			btnRegistrarEmpleado = new JButton("Registrar");
			btnRegistrarEmpleado.addActionListener(this);
			btnRegistrarEmpleado.setFont(new Font("Tahoma", Font.PLAIN, 13));
			btnRegistrarEmpleado.setBounds(408, 363, 116, 25);
			contentPane.add(btnRegistrarEmpleado);
		}
		{
			btnModificarEmpleado = new JButton("Modificar");
			btnModificarEmpleado.addActionListener(this);
			btnModificarEmpleado.setFont(new Font("Tahoma", Font.PLAIN, 13));
			btnModificarEmpleado.setBounds(541, 363, 116, 25);
			contentPane.add(btnModificarEmpleado);
		}
		{
			lblRegistrarEmpleado = new JLabel("REGISTRAR EMPLEADO");
			lblRegistrarEmpleado.setFont(new Font("Tahoma", Font.PLAIN, 18));
			lblRegistrarEmpleado.setBounds(242, 70, 203, 19);
			contentPane.add(lblRegistrarEmpleado);
		}
		{
			btnMostrarEmpleado = new JButton("Mostrar");
			btnMostrarEmpleado.addActionListener(this);
			btnMostrarEmpleado.setFont(new Font("Tahoma", Font.PLAIN, 13));
			btnMostrarEmpleado.setBounds(274, 363, 116, 25);
			contentPane.add(btnMostrarEmpleado);
		}
		{
			btnHistorialVentas = new JButton("Historial de ventas");
			btnHistorialVentas.addActionListener(this);
			btnHistorialVentas.setFont(new Font("Tahoma", Font.PLAIN, 13));
			btnHistorialVentas.setBounds(10, 391, 154, 25);
			contentPane.add(btnHistorialVentas);
		}
		{
			lblId_1 = new JLabel("ID:");
			lblId_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblId_1.setBounds(171, 21, 45, 19);
			contentPane.add(lblId_1);
		}
		{
			txtID_Cod = new JTextField();
			txtID_Cod.setColumns(10);
			txtID_Cod.setBounds(203, 20, 447, 25);
			contentPane.add(txtID_Cod);
		}
		{
			btnBuscar = new JButton("Buscar");
			btnBuscar.addActionListener(this);
			btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 13));
			btnBuscar.setBounds(668, 20, 116, 25);
			contentPane.add(btnBuscar);
		}
		{
			lblclock = new JLabel("");
			lblclock.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblclock.setBounds(455, 307, 256, 19);
			contentPane.add(lblclock);
			{
				scrollPane = new JScrollPane();
				scrollPane.setBounds(10, 424, 896, 256);
				contentPane.add(scrollPane);
				{
					txtS = new JTextArea();
					scrollPane.setViewportView(txtS);
				}
			}
			{
				jlabelmodo = new JButton("Modo Oscuro");
				jlabelmodo.addActionListener(this);
				jlabelmodo.setBounds(31, 228, 133, 33);
				contentPane.add(jlabelmodo);
			}
			
		    clock();
		}
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == jlabelmodo) {
			do_btnNewButton_actionPerformed(e);
		}
		if (e.getSource() == btnModificarEmpleado) {
			do_btnModificarEmpleado_actionPerformed(e);
		}
		if (e.getSource() == btnRegistrarEmpleado) {
			do_btnRegistrarEmpleado_actionPerformed(e);
		}
		if (e.getSource() == btnBuscar) {
			do_btnBuscar_actionPerformed(e);
		}
		if (e.getSource() == btnMostrarEmpleado) {
			do_btnMostrarEmpleado_actionPerformed(e);
		}
		if (e.getSource() == btnHistorialVentas) {
			do_btnHistorialVentas_actionPerformed(e);
		}
	}
	
	ArregloHistorialVentas ahv = new ArregloHistorialVentas();
	ArregloEmpleado ae = new ArregloEmpleado();
	private JLabel lblclock;
	private JScrollPane scrollPane;
	private JTextArea txtS;
	private JButton jlabelmodo;
	
	protected void do_btnHistorialVentas_actionPerformed(ActionEvent e) {
		ListadoHistorialVentas();
	}
	void Imprimir(String s) {
		txtS.append(s+"\n");
	}
	
	void ListadoHistorialVentas() {
		txtS.setText("");
		Imprimir("Código\tDNI\tNombres y apellidos\tTeléfono\tFecha\tID Producto\tProducto\tNombre del modelo\tGarantia\tPrecio unitario\tCantidad\tTipo de pago\tVendedor\tTotal");
		for(int i = 0; i < ahv.Tamaño(); i++) {
			Venta v = ahv.Obtener(i);
			Imprimir("" + v.getCodigo_venta() + "\t" +
			"" + v.getCliente().getDni() + "\t" + 
			"" + v.getCliente().getNombre_apellido() + "\t" +
			"" + v.getCliente().getTelefono() + "\t" +
			"" + v.getFecha() + "\t" +
			"" + v.getProducto().getId_producto() + "\t" +
			"" + v.getProducto().getCat_producto() + "\t" +
			"" + v.getProducto().getNombre() + "\t"+
			"" + v.getProducto().getGarantia() + "\t" +
			"" + v.getProducto().getPrecio() + "\t" +
			"" + v.getCantidad() + "\t" + 
			"" + v.getTipo_pago() + "\t" +
			"" + v.getVendedor().getNombre_apellido() + "\t" + 
			"" + v.SubTotal());
		}
	}
	
	protected void do_btnMostrarEmpleado_actionPerformed(ActionEvent e) {
		ListadoEmpleados();
	}
	void ListadoEmpleados() {
		txtS.setText("");
		Imprimir("ID\tDNI\tNombre completo\tTeléfono\tCargo\tJornada laboral\t\tFecha\tHora\tHorario laboral\t\tPago por hora\tHoras trab.\tDescuento\tSueldo");
		for(int i = 0; i < ae.Tamaño(); i++) {
			Empleado e = ae.Obtener(i);
			Imprimir("" + e.getId_empleado() + "\t" +
			"" + e.getDni() + "\t" + "" +
			"" + e.getNombre_apellido() + "\t" +
			"" + e.getTelefono() + "\t" +
			"" + e.getCargo() + "\t" +
			"" + e.getJornada() + "\t" + 
			"" + e.getFechacreada() + "\t" + 
			"" + e.getHoracreada() + "\t" + 
			"" + e.getHorario() + "\t" + 
			"" + e.getPago_hora() + "\t" + 
			"" + e.getHoras_trabajadas() + "\t" + 
			"" + e.getDescuento() + "\t" +
			"" + e.Sueldo());
	}
}

	protected void do_btnBuscar_actionPerformed(ActionEvent e) {
		try {
			int codigo= Integer.parseInt(txtID_Cod.getText());
			Empleado empleadoEncontrado = ae.Buscar(codigo);
			if(empleadoEncontrado== null) {
				txtS.setText("");
				JOptionPane.showMessageDialog(this, "EL código no se encuentra en el sistema");
				
			}
			else{
				 txtS.setText(""); 
				 Imprimir("ID\tDNI\tNombre completo\tTeléfono\tCargo\tJornada laboral\tFecha de creación\tHora de creación\tHorario laboral\t\tPago por hora\tHoras trab.\tDescuento\tSueldo");
				    Imprimir("" + empleadoEncontrado.getId_empleado() + "\t" +
							"" + empleadoEncontrado.getDni() + "\t" + "" +
							"" + empleadoEncontrado.getNombre_apellido() + "\t" +
							"" + empleadoEncontrado.getTelefono() + "\t" +
							"" + empleadoEncontrado.getCargo() + "\t" +
							"" + empleadoEncontrado.getJornada() + "\t" + 
							"" + empleadoEncontrado.getFechacreada() + "\t" + 
							"" + empleadoEncontrado.getHoracreada() + "\t" +
							"" + empleadoEncontrado.getHorario() + "\t" + 
							"" + empleadoEncontrado.getPago_hora() + "\t" + 
							"" + empleadoEncontrado.getHoras_trabajadas() + "\t" + 
							"" + empleadoEncontrado.getDescuento() + "\t" +
							"" + empleadoEncontrado.Sueldo());
			};
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(this, "El valor ingresado no es válido. Intente de nuevo.");	
		}
				
	}
	protected void do_btnRegistrarEmpleado_actionPerformed(ActionEvent e) {
		try {		
			int idempleado= Integer.parseInt(txtIdEmpleado.getText());
			String dniempleado= txtDniEmpleado.getText();
			  if (dniempleado.length() != 8) {
			        JOptionPane.showMessageDialog(this, "El DNI debe tener 8 números. Por favor, verifique.");
			        txtDniEmpleado.setText("");
			        txtDniEmpleado.requestFocus();
			        return; 
			    }
			String nomempleado= txtNombreEmpleado.getText();
			String teleempleado = txtTelefono.getText();
			String carempleado= cboCargo.getSelectedItem().toString();
			String jorempleado= cboJornada.getSelectedItem().toString();
			String horaempleado= cboHorario.getSelectedItem().toString();
			double pxhempleado= Double.parseDouble(txtPago.getText());
			double htempleado= Double.parseDouble(txtHoras.getText());;
			double descuento=  Double.parseDouble(txtDescuento.getText());;		
			
			if(nomempleado.isEmpty() || teleempleado.isEmpty() || carempleado.isEmpty() ||
					jorempleado.isEmpty() || horaempleado.isEmpty() ) {
				
				JOptionPane.showMessageDialog(this, "Porfavor coloque datos");
				return;		
			}
							
			String fecha= day+"/"+month+"/"+year;
			String hora= hour+":"+minute+":"+second+tmam;
			Empleado nuevoempleado= new Empleado(idempleado, dniempleado, nomempleado, teleempleado, carempleado, jorempleado,fecha, hora,horaempleado, pxhempleado, htempleado, descuento);
			if( ae.Buscar(idempleado) == null) {
				ae.Adicionar(nuevoempleado);	
				JOptionPane.showMessageDialog(this, "Nuevo empleado registrado éxitosamente");
			}
			else {
				JOptionPane.showMessageDialog(this, "Empleado ya registrado en el sistema");
				return;		
			}

		} catch (Exception e2) {
			JOptionPane.showMessageDialog(this, "Verifique los datos ingresados. Intente de nuevo.");
		}
	
	}
	protected void do_btnModificarEmpleado_actionPerformed(ActionEvent e) {
		try {
			txtS.setText("");
			int codigo= Integer.parseInt(txtIdEmpleado.getText());
			Empleado empleadoEncontrado = ae.Buscar(codigo);
			if(empleadoEncontrado== null) {
				txtS.setText("");
				JOptionPane.showMessageDialog(this, "EL código no se encuentra en el sistema");
				return;
			}
			else {
				txtS.setText("");
				empleadoEncontrado.setDni(txtDniEmpleado.getText());
				empleadoEncontrado.setNombre_apellido(txtNombreEmpleado.getText());
				empleadoEncontrado.setTelefono(txtTelefono.getText());
				empleadoEncontrado.setCargo(cboCargo.getSelectedItem().toString());
				empleadoEncontrado.setJornada(cboJornada.getSelectedItem().toString() + "\t");
				empleadoEncontrado.setHorario(cboHorario.getSelectedItem().toString());
				empleadoEncontrado.setPago_hora( Double.parseDouble(txtPago.getText()));
				empleadoEncontrado.setHoras_trabajadas(Double.parseDouble(txtHoras.getText()));
				empleadoEncontrado.setDescuento(Double.parseDouble(txtDescuento.getText()));
				ListadoEmpleados();
			}
	
		}
		catch(Exception e2){
			JOptionPane.showMessageDialog(this, "Verifique el ID ingresado. Intente de nuevo.");
		}
	}
	protected void do_btnNewButton_actionPerformed(ActionEvent e) {
		Switch++;
		if(Switch %2== 0) {		
			contentPane.setBackground(UIManager.getColor("Button.light"));
			jlabelmodo.setText("Modo Oscuro");
		}
		else {
			contentPane.setBackground(UIManager.getColor("Button.focus"));
			jlabelmodo.setText("Modo Normal");
		}	
	}
}
