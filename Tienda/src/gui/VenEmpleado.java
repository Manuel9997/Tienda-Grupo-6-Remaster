package gui;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import arreglo.ArregloEmpleado;
import arreglo.ArregloProducto;
import arreglo.ArregloVenta;
import clase.Cliente;
import clase.Empleado;
import clase.Producto;
import clase.Venta;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class VenEmpleado extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JComboBox cboTipoPago;
	private JComboBox cboComprobante;
	private JLabel lblNewLabel;
	private JLabel lblComprobante;
	private JLabel lblId;
	private JTextField txtIdProducto;
	private JLabel lblDni;
	private JLabel lblNombresYApellidos;
	private JTextField txtDNI;
	private JTextField txtNombre;
	private JTextField txtCod;
	private JLabel lblCdcompra;
	private JLabel lblTelfono;
	private JTextField txtTelefono;
	private JLabel lblCantidad;
	private JTextField txtCantidad;
	private JButton btnRegistrar;
	public int day;
	public int year;
	public int month;
	public int second;
	public int minute;
	public int hour;
	public String tmam;
	public String fecha;
	public String hora;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VenEmpleado frame = new VenEmpleado();
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
					 int dai= cal.get(Calendar.DAY_OF_MONTH);
					 String day, month, second,minute,hour;
					 if(dai<10) {
						 day="0"+Integer.toString(dai);
					 }
					 else {
						 day=Integer.toString(dai);
					 }
					int mont= cal.get(Calendar.MONTH);
					 if(mont<10) {
						 month="0"+Integer.toString(mont);
					 }
					 else {
						 month=Integer.toString(mont);
					 }
					
					
					year= cal.get(Calendar.YEAR);
					
					 int secon= cal.get(Calendar.SECOND);
					 if(secon<10) {
						 second="0"+Integer.toString(secon);
					 }
					 else {
						 second=Integer.toString(secon);
					 }
					 
					 int minut= cal.get(Calendar.MINUTE);
					 
					 if(minut<10) {
						 minute="0"+Integer.toString(minut);
					 }
					 else {
						 minute=Integer.toString(minut);
					 }
					 
					 int hou= cal.get(Calendar.HOUR);
					 
					 
					 if(hou == 0) { 
						    hour = "12";
						}
					 else if(hou<10) {
						 hour="0"+Integer.toString(hou);
					 }
					 else {
						 hour=Integer.toString(hou);
					 }
					
					int ampm= cal.get(Calendar.AM_PM);

				if(ampm == 0) {
					
					tmam= "am";
				}
				else {
					tmam= "pm";
				}
					
					
					lblclock.setText("Fecha: "+ day+"/"+month+"/"+year+"  Hora: "+hour+":"+minute+":"+second+tmam);
					sleep(1000);
					fecha= day+"/"+month+"/"+year;
					hora= hour+":"+minute+":"+second+tmam;
					}
				}
				catch(InterruptedException e) {
					e.printStackTrace();
				}
			

				
			}
		};

		clock.start();
		
	}
	ArrayList<String> Arrayem = new ArrayList<>();
	
	ArregloEmpleado em = new ArregloEmpleado();
	
	 void ObtenerVendedores() {
		 for (int i = 0; i < em.Tamaño(); i++) {
			 Empleado e = em.Obtener(i);
			 if("Vendedor".equals(e.getCargo())) {
				 Arrayem.add(e.getNombre_apellido());
			 }
		
		}
		
		}

	/**
	 * Create the frame.
	 */
	public VenEmpleado() {
		setAlwaysOnTop(true);
		setTitle("Empleado");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 960, 885);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			cboTipoPago = new JComboBox();
			cboTipoPago.setFont(new Font("Verdana", Font.PLAIN, 15));
			cboTipoPago.setModel(new DefaultComboBoxModel(new String[] {"Efectivo", "Débito", "Crédito", "Yape/Plin"}));
			cboTipoPago.setBounds(388, 211, 116, 25);
			contentPane.add(cboTipoPago);
		}
		{
			cboComprobante = new JComboBox();
			cboComprobante.setFont(new Font("Verdana", Font.PLAIN, 15));
			cboComprobante.setModel(new DefaultComboBoxModel(new String[] {"Boleta", "Factura"}));
			cboComprobante.setBounds(682, 211, 116, 25);
			contentPane.add(cboComprobante);
		}
		{
			lblNewLabel = new JLabel("Tipo de pago:");
			lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 15));
			lblNewLabel.setBounds(262, 211, 116, 25);
			contentPane.add(lblNewLabel);
		}
		{
			lblComprobante = new JLabel("Comprobante:");
			lblComprobante.setFont(new Font("Verdana", Font.PLAIN, 15));
			lblComprobante.setBounds(546, 211, 116, 25);
			contentPane.add(lblComprobante);
		}
		{
			lblId = new JLabel("ID Producto:");
			lblId.setFont(new Font("Verdana", Font.PLAIN, 15));
			lblId.setBounds(546, 156, 99, 25);
			contentPane.add(lblId);
		}
		{
			txtIdProducto = new JTextField();
			txtIdProducto.setBounds(664, 158, 96, 25);
			contentPane.add(txtIdProducto);
			txtIdProducto.setColumns(10);
		}
		{
			lblDni = new JLabel("DNI:");
			lblDni.setFont(new Font("Verdana", Font.PLAIN, 15));
			lblDni.setBounds(658, 101, 44, 25);
			contentPane.add(lblDni);
		}
		{
			lblNombresYApellidos = new JLabel("Nombre completo:");
			lblNombresYApellidos.setFont(new Font("Verdana", Font.PLAIN, 15));
			lblNombresYApellidos.setBounds(35, 101, 147, 25);
			contentPane.add(lblNombresYApellidos);
		}
		{
			txtDNI = new JTextField();
			txtDNI.setBounds(724, 103, 117, 25);
			contentPane.add(txtDNI);
			txtDNI.setColumns(10);
		}
		{
			txtNombre = new JTextField();
			txtNombre.setColumns(10);
			txtNombre.setBounds(202, 103, 416, 25);
			contentPane.add(txtNombre);
		}
		{
			txtCod = new JTextField();
			txtCod.setColumns(10);
			txtCod.setBounds(399, 158, 96, 25);
			contentPane.add(txtCod);
		}
		{
			lblCdcompra = new JLabel("Cód.Venta:");
			lblCdcompra.setFont(new Font("Verdana", Font.PLAIN, 15));
			lblCdcompra.setBounds(293, 156, 96, 25);
			contentPane.add(lblCdcompra);
		}
		{
			lblTelfono = new JLabel("Teléfono:");
			lblTelfono.setFont(new Font("Verdana", Font.PLAIN, 15));
			lblTelfono.setBounds(35, 154, 73, 25);
			contentPane.add(lblTelfono);
		}
		{
			txtTelefono = new JTextField();
			txtTelefono.setColumns(10);
			txtTelefono.setBounds(130, 158, 117, 25);
			contentPane.add(txtTelefono);
		}
		{
			lblCantidad = new JLabel("Cantidad:");
			lblCantidad.setFont(new Font("Verdana", Font.PLAIN, 15));
			lblCantidad.setBounds(35, 211, 99, 25);
			contentPane.add(lblCantidad);
		}
		{
			txtCantidad = new JTextField();
			txtCantidad.setColumns(10);
			txtCantidad.setBounds(130, 213, 96, 25);
			contentPane.add(txtCantidad);
		}
		{
			btnRegistrar = new JButton("Registrar");
			btnRegistrar.addActionListener(this);
			btnRegistrar.setFont(new Font("Verdana", Font.PLAIN, 13));
			btnRegistrar.setBounds(293, 337, 116, 25);
			contentPane.add(btnRegistrar);
		}
		{
			btnTotal = new JButton("Total");
			btnTotal.addActionListener(this);
			btnTotal.setFont(new Font("Tahoma", Font.PLAIN, 13));
			btnTotal.setBounds(502, 337, 116, 25);
			contentPane.add(btnTotal);
		}
		{
			lblVendedor = new JLabel("Vendedor:");
			lblVendedor.setFont(new Font("Verdana", Font.PLAIN, 15));
			lblVendedor.setBounds(35, 266, 84, 25);
			contentPane.add(lblVendedor);
		}
		{
			ObtenerVendedores();
			cboVendedor = new JComboBox();
			cboVendedor.setFont(new Font("Verdana", Font.PLAIN, 15));
			cboVendedor.setModel(new DefaultComboBoxModel<>(Arrayem.toArray(new String[0])));
			cboVendedor.setBounds(130, 266, 195, 25);
			contentPane.add(cboVendedor);
		}
		{
			btnMostrarProductos = new JButton("Mostrar productos");
			btnMostrarProductos.addActionListener(this);
			btnMostrarProductos.setFont(new Font("Tahoma", Font.PLAIN, 13));
			btnMostrarProductos.setBounds(739, 454, 147, 25);
			contentPane.add(btnMostrarProductos);
		}
		{
			btnBuscar = new JButton("Buscar");
			btnBuscar.addActionListener(this);
			btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 13));
			btnBuscar.setBounds(603, 454, 116, 25);
			contentPane.add(btnBuscar);
		}
		{
			txtID = new JTextField();
			txtID.setColumns(10);
			txtID.setBounds(163, 455, 406, 25);
			contentPane.add(txtID);
		}
		{
			lblId_1 = new JLabel("ID Producto:");
			lblId_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblId_1.setBounds(54, 453, 99, 25);
			contentPane.add(lblId_1);
		}
		{
			lblRegistroDeVentas = new JLabel("REGISTRO DE VENTAS");
			lblRegistroDeVentas.setFont(new Font("Verdana", Font.PLAIN, 23));
			lblRegistroDeVentas.setBounds(307, 33, 284, 38);
			contentPane.add(lblRegistroDeVentas);
		}
		{
			jlabelmodo = new JButton("Modo Oscuro");
			jlabelmodo.addActionListener(this);
			jlabelmodo.setFont(new Font("Verdana", Font.PLAIN, 14));
			jlabelmodo.setBounds(35, 334, 147, 38);
			contentPane.add(jlabelmodo);
		}
		{
			scrollPane = new JScrollPane();
			scrollPane.setBounds(35, 523, 859, 287);
			contentPane.add(scrollPane);
			{
				txtS = new JTextArea();
				scrollPane.setViewportView(txtS);
			}
		}
	/*	{
			lblNewLabel_1 = new JLabel("");
			lblNewLabel_1.setIcon(new ImageIcon(VenEmpleado.class.getResource("/recursos/check.png")));
			lblNewLabel_1.setBounds(256, 30, 54, 47);
			contentPane.add(lblNewLabel_1);
		} */
		{
			lblclock = new JLabel("");
			lblclock.setFont(new Font("Verdana", Font.PLAIN, 14));
			lblclock.setBounds(449, 266, 284, 25);
			contentPane.add(lblclock);
		}
		 clock();
		
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == jlabelmodo) {
			do_btnNewButton_actionPerformed(e);
		}
		if (e.getSource() == btnBuscar) {
			do_btnBuscar_actionPerformed(e);
		}
		if (e.getSource() == btnMostrarProductos) {
			do_btnMostrarProductos_actionPerformed(e);
		}
		if (e.getSource() == btnTotal) {
			do_btnTotal_actionPerformed(e);
		}
		if (e.getSource() == btnRegistrar) {
			do_btnRegistrar_actionPerformed(e);
		}
	}
	
	ArregloVenta av = new ArregloVenta();
	private JButton btnTotal;
	private JLabel lblVendedor;
	private JComboBox cboVendedor;
	private JButton btnMostrarProductos;
	
	ArregloProducto ap = new ArregloProducto();
	private JButton btnBuscar;
	private JTextField txtID;
	private JLabel lblId_1;
	private JLabel lblRegistroDeVentas;
	private JButton jlabelmodo;
	private JScrollPane scrollPane;
	private JTextArea txtS;
	private JLabel lblNewLabel_1;
	private JLabel lblclock;
	
	protected void do_btnRegistrar_actionPerformed(ActionEvent e) {		
		try {	
			Producto p = ap.Buscar(LeerIdProducto());
		
	    if (p == null) {
	        JOptionPane.showMessageDialog(this, "El ID del producto no existe");
	        return;
	    }
	    
	    if (LeerCantidad() > p.getStock()) {
	        JOptionPane.showMessageDialog(this, "Stock insuficiente. Stock actual: " + p.getStock());
	        return;
	    }
	    
	    if (LeerDNI().length() != 8) {
	        JOptionPane.showMessageDialog(this, "El DNI debe tener 8 números. Por favor, verifique.");
	        txtDNI.setText("");
	        txtDNI.requestFocus();
	        return; 
	    }
		
		Cliente c = new Cliente(LeerDNI(), LeerNombre(), LeerTelefono());
		Empleado vendedor = new Empleado(LeerVendedor());
		Venta v = new Venta(LeerCodigo(), c, LocalDate.now(), LocalTime.now(), p, LeerCantidad(), LeerTipoPago(), LeerComprobante(), vendedor);
		
		p.reducirStock(LeerCantidad());
		av.Adicionar(v); 
        ListadoVentas();
			
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(this, "Uno o más de los valores ingresados no es válido. Intente de nuevo.");	
		}
	}
	
	void Imprimir(String s) {
		txtS.append(s+"\n");
	}
	
	void ListadoVentas() {
		txtS.setText("");
		Imprimir("Código\tDNI\tNombres y apellidos\tTeléfono\tFecha\tHora\tID Producto\tProducto\tNombre del modelo\tGarantia\tPrecio unitario\tCantidad\tTipo de pago\tVendedor\t\tSub Total");

		for (int i = 0; i < av.Tamaño(); i++) {
			Venta v = av.Obtener(i);
			Producto prod = ap.Buscar(v.getProducto().getId_producto());
			
			Imprimir("" + v.getCodigo_venta() + "\t" +
			v.getCliente().getDni() + "\t" + 
			v.getCliente().getNombre_apellido() + "\t" +
			v.getCliente().getTelefono() + "\t" +
			v.getFecha() + "\t" +
			v.getHora().withNano(0) + "\t" +
			prod.getId_producto() + "\t" +
			prod.getCat_producto() + "\t" +
			prod.getNombre() + "\t" +
			prod.getGarantia() + "\t" +
			prod.getPrecio() + "\t" +
			v.getCantidad() + "\t" +
			v.getTipo_pago() + "\t" +
			v.getVendedor().getNombre_apellido() + "\t" + 
			v.SubTotal());
		} 
	}
	
	int LeerCodigo() {
		return Integer.parseInt(txtCod.getText());
	}
	String LeerDNI() {
		return txtDNI.getText();
	}
	String LeerNombre() {
		return txtNombre.getText();
	}
	String LeerTelefono() {
		return txtTelefono.getText();
	}
	int LeerIdProducto() {
		return Integer.parseInt(txtIdProducto.getText());
	}
	int LeerCantidad() {
		return Integer.parseInt(txtCantidad.getText());
	}
	String LeerTipoPago() {
		return cboTipoPago.getSelectedItem().toString();
	}
	String LeerComprobante() {
		return cboComprobante.getSelectedItem().toString();
	}
	String LeerVendedor() {
		return cboVendedor.getSelectedItem().toString();
	}

	protected void do_btnTotal_actionPerformed(ActionEvent e) {
		try {
			txtS.setText("");
			ListadoVentas();
		    double total =0;
			int cod = Integer.parseInt(txtCod.getText());
		    for (int i = 0; i < av.Tamaño(); i++) {
		        Venta v = av.Obtener(i);
		        if (v.getCodigo_venta() == cod) {
		            total += v.SubTotal();
		    	    txtS.append("Total: " + total);}
			
		    } } catch (Exception e2) {
		    	txtS.setText("");
			JOptionPane.showMessageDialog(this, "Primero debe ingresar valores para usar esta función");
			
		}

	}
	protected void do_btnMostrarProductos_actionPerformed(ActionEvent e) {
		txtS.setText("");
		ListadoProductos();
	}
	void ListadoProductos() {
		txtS.setText("");
		Imprimir("ID\tProducto\tNombre del modelo\tGarantía\tPrecio\tStock");
		for(int i = 0; i < ap.Tamaño(); i++) {
			Producto p = ap.Obtener(i);
			Imprimir("" + p.getId_producto() + "\t" +
			"" + p.getCat_producto() + "\t" + 
			"" + p.getNombre() + "\t" +
			"" + p.getGarantia() + "\t" +
			"" + p.getPrecio() + "\t" +
			"" + p.getStock()); 
	}
}
	protected void do_btnBuscar_actionPerformed(ActionEvent e) {
		txtS.setText("");
		    try {
		        int id = Integer.parseInt(txtID.getText().trim());

		        Producto producto = ap.Buscar(id);
		        if (producto != null) {
		        	Imprimir("ID\tProducto\tNombre del modelo\tGarantía\tPrecio\tStock");
		            Imprimir(producto.getId_producto()+ "\t"
		            + "" + producto.getCat_producto()+ "\t"
		        	+ "" + producto.getNombre()+ "\t" 
		        	+ "" + producto.getGarantia() + "\t" 
		        	+ "" + producto.getPrecio()+ "\t" 
		            + "" + producto.getStock());
		        } else {
		            JOptionPane.showMessageDialog(this, "Ingrese dato válido");
		        }

		    } catch (NumberFormatException ex) {
		        JOptionPane.showMessageDialog(this, "Ingrese dato válido");
		    }
		}
	protected void do_btnNewButton_actionPerformed(ActionEvent e) {
		String actual = jlabelmodo.getText();
		if(actual == "Modo Normal") {        
		    contentPane.setBackground(UIManager.getColor("Button.light"));
		    lblRegistroDeVentas.setForeground(Color.BLACK);
		    txtNombre.setBackground(Color.WHITE);
		    txtS.setBackground(Color.WHITE);
		    lblNombresYApellidos.setForeground(Color.BLACK);
		    lblDni.setForeground(Color.BLACK);
		    lblTelfono.setForeground(Color.BLACK);
		    lblCdcompra.setForeground(Color.BLACK);
		    lblclock.setForeground(Color.BLACK);
		    lblId.setForeground(Color.BLACK);
		    lblCantidad.setForeground(Color.BLACK);
		    lblNewLabel.setForeground(Color.BLACK);
		    lblComprobante.setForeground(Color.BLACK);
		    lblVendedor.setForeground(Color.BLACK);
		    lblId_1.setForeground(Color.BLACK);
		    txtTelefono.setBackground(Color.WHITE);
		    txtDNI.setBackground(Color.WHITE);
		    txtCod.setBackground(Color.WHITE);
		    txtIdProducto.setBackground(Color.WHITE);
		    cboTipoPago.setBackground(Color.WHITE);
		    cboComprobante.setBackground(Color.WHITE);
		    cboVendedor.setBackground(Color.WHITE);
		    txtCantidad.setBackground(Color.WHITE);
		    txtID.setBackground(Color.WHITE);
		    
		    txtNombre.setForeground(Color.BLACK);
		    txtS.setForeground(Color.BLACK);
		    txtDNI.setForeground(Color.BLACK);
		    txtTelefono.setForeground(Color.BLACK);
		    txtCod.setForeground(Color.BLACK);
		    txtIdProducto.setForeground(Color.BLACK);
		    txtCantidad.setForeground(Color.BLACK);
		    txtID.setForeground(Color.BLACK);
		    cboTipoPago.setForeground(Color.BLACK);
		    cboComprobante.setForeground(Color.BLACK);
		    cboVendedor.setForeground(Color.BLACK);
		    jlabelmodo.setText("Modo Oscuro");
		}
		else if(actual == "Modo Oscuro"){
		    contentPane.setBackground(Color.BLACK);
		    lblRegistroDeVentas.setForeground(Color.LIGHT_GRAY);
		    txtNombre.setBackground(Color.DARK_GRAY);
		    txtS.setBackground(Color.DARK_GRAY);
		    lblNombresYApellidos.setForeground(Color.LIGHT_GRAY);
		    lblDni.setForeground(Color.LIGHT_GRAY);
		    lblTelfono.setForeground(Color.LIGHT_GRAY);
		    lblCdcompra.setForeground(Color.LIGHT_GRAY);
		    lblId.setForeground(Color.LIGHT_GRAY);
		    lblCantidad.setForeground(Color.LIGHT_GRAY);
		    lblclock.setForeground(Color.LIGHT_GRAY);
		    lblNewLabel.setForeground(Color.LIGHT_GRAY);
		    lblComprobante.setForeground(Color.LIGHT_GRAY);
		    lblVendedor.setForeground(Color.LIGHT_GRAY);
		    lblId_1.setForeground(Color.LIGHT_GRAY);
		    txtTelefono.setBackground(Color.DARK_GRAY);
		    txtDNI.setBackground(Color.DARK_GRAY);
		    txtCod.setBackground(Color.DARK_GRAY);
		    txtIdProducto.setBackground(Color.DARK_GRAY);
		    cboTipoPago.setBackground(Color.DARK_GRAY);
		    cboComprobante.setBackground(Color.DARK_GRAY);
		    cboVendedor.setBackground(Color.DARK_GRAY);
		    txtCantidad.setBackground(Color.DARK_GRAY);
		    txtID.setBackground(Color.DARK_GRAY);
		    
		    txtNombre.setForeground(Color.WHITE);
		    txtS.setForeground(Color.WHITE);
		    txtDNI.setForeground(Color.WHITE);
		    txtTelefono.setForeground(Color.WHITE);
		    txtCod.setForeground(Color.WHITE);
		    txtIdProducto.setForeground(Color.WHITE);
		    txtCantidad.setForeground(Color.WHITE);
		    txtID.setForeground(Color.WHITE);
		    cboTipoPago.setForeground(Color.WHITE);
		    cboComprobante.setForeground(Color.WHITE);
		    cboVendedor.setForeground(Color.WHITE);
		    jlabelmodo.setText("Modo Frío");
		}   
		else if(actual == "Modo Frío") {
		    contentPane.setBackground(new Color(10, 25, 45));
		    lblRegistroDeVentas.setForeground(new Color(150, 220, 255));
		    txtNombre.setBackground(new Color(30, 80, 120));
		    txtS.setBackground(new Color(30, 80, 120));
		    lblNombresYApellidos.setForeground(new Color(150, 220, 255));
		    lblDni.setForeground(new Color(150, 220, 255));
		    lblTelfono.setForeground(new Color(150, 220, 255));
		    lblCdcompra.setForeground(new Color(150, 220, 255));
		    lblId.setForeground(new Color(150, 220, 255));
		    lblCantidad.setForeground(new Color(150, 220, 255));
		    lblclock.setForeground(new Color(150, 220, 255));
		    lblNewLabel.setForeground(new Color(150, 220, 255));
		    lblComprobante.setForeground(new Color(150, 220, 255));
		    lblVendedor.setForeground(new Color(150, 220, 255));
		    lblId_1.setForeground(new Color(150, 220, 255));
		    txtTelefono.setBackground(new Color(30, 80, 120));
		    txtDNI.setBackground(new Color(30, 80, 120));
		    txtCod.setBackground(new Color(30, 80, 120));
		    txtIdProducto.setBackground(new Color(30, 80, 120));
		    cboTipoPago.setBackground(new Color(30, 80, 120));
		    cboComprobante.setBackground(new Color(30, 80, 120));
		    cboVendedor.setBackground(new Color(30, 80, 120));
		    txtCantidad.setBackground(new Color(30, 80, 120));
		    txtID.setBackground(new Color(30, 80, 120));	    
		    txtNombre.setForeground(Color.WHITE);
		    txtS.setForeground(Color.WHITE);
		    txtDNI.setForeground(Color.WHITE);
		    txtTelefono.setForeground(Color.WHITE);
		    txtCod.setForeground(Color.WHITE);
		    txtIdProducto.setForeground(Color.WHITE);
		    txtCantidad.setForeground(Color.WHITE);
		    txtID.setForeground(Color.WHITE);
		    cboTipoPago.setForeground(Color.WHITE);
		    cboComprobante.setForeground(Color.WHITE);
		    cboVendedor.setForeground(Color.WHITE);
		    jlabelmodo.setText("Modo Normal");
		}
	}
}

