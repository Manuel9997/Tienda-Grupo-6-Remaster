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
import javax.swing.JTabbedPane;

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
		setBounds(100, 100, 859, 770);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			ObtenerVendedores();
		}
		{
			tabbedPane = new JTabbedPane(JTabbedPane.TOP);
			tabbedPane.setBounds(10, 13, 826, 712);
			contentPane.add(tabbedPane);
			{
				panelVenta = new JPanel();
				tabbedPane.addTab("Venta", null, panelVenta, null);
				panelVenta.setLayout(null);
				{
					cboTipoPago = new JComboBox();
					cboTipoPago.setBounds(384, 191, 116, 25);
					panelVenta.add(cboTipoPago);
					cboTipoPago.setFont(new Font("Verdana", Font.PLAIN, 15));
					cboTipoPago.setModel(new DefaultComboBoxModel(new String[] {"Efectivo", "Débito", "Crédito", "Yape/Plin"}));
				}
				{
					cboComprobante = new JComboBox();
					cboComprobante.setBounds(678, 191, 116, 25);
					panelVenta.add(cboComprobante);
					cboComprobante.setFont(new Font("Verdana", Font.PLAIN, 15));
					cboComprobante.setModel(new DefaultComboBoxModel(new String[] {"Boleta", "Factura"}));
				}
				{
					lblNewLabel = new JLabel("Tipo de pago:");
					lblNewLabel.setBounds(258, 191, 116, 25);
					panelVenta.add(lblNewLabel);
					lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 15));
				}
				{
					lblComprobante = new JLabel("Comprobante:");
					lblComprobante.setBounds(542, 191, 116, 25);
					panelVenta.add(lblComprobante);
					lblComprobante.setFont(new Font("Verdana", Font.PLAIN, 15));
				}
				{
					lblId = new JLabel("ID Producto:");
					lblId.setBounds(532, 134, 99, 25);
					panelVenta.add(lblId);
					lblId.setFont(new Font("Verdana", Font.PLAIN, 15));
				}
				{
					txtIdProducto = new JTextField();
					txtIdProducto.setBounds(650, 136, 96, 25);
					panelVenta.add(txtIdProducto);
					txtIdProducto.setColumns(10);
				}
				{
					lblDni = new JLabel("DNI:");
					lblDni.setBounds(623, 81, 44, 25);
					panelVenta.add(lblDni);
					lblDni.setFont(new Font("Verdana", Font.PLAIN, 15));
				}
				{
					lblNombresYApellidos = new JLabel("Nombre completo:");
					lblNombresYApellidos.setBounds(31, 81, 147, 25);
					panelVenta.add(lblNombresYApellidos);
					lblNombresYApellidos.setFont(new Font("Verdana", Font.PLAIN, 15));
				}
				{
					txtDNI = new JTextField();
					txtDNI.setBounds(667, 83, 117, 25);
					panelVenta.add(txtDNI);
					txtDNI.setColumns(10);
				}
				{
					txtNombre = new JTextField();
					txtNombre.setBounds(188, 83, 416, 25);
					panelVenta.add(txtNombre);
					txtNombre.setColumns(10);
				}
				{
					txtCod = new JTextField();
					txtCod.setBounds(385, 136, 96, 25);
					panelVenta.add(txtCod);
					txtCod.setColumns(10);
				}
				{
					lblCdcompra = new JLabel("Cód.Venta:");
					lblCdcompra.setBounds(279, 134, 96, 25);
					panelVenta.add(lblCdcompra);
					lblCdcompra.setFont(new Font("Verdana", Font.PLAIN, 15));
				}
				{
					lblTelfono = new JLabel("Teléfono:");
					lblTelfono.setBounds(31, 134, 89, 25);
					panelVenta.add(lblTelfono);
					lblTelfono.setFont(new Font("Verdana", Font.PLAIN, 15));
				}
				{
					txtTelefono = new JTextField();
					txtTelefono.setBounds(116, 136, 117, 25);
					panelVenta.add(txtTelefono);
					txtTelefono.setColumns(10);
				}
				{
					lblCantidad = new JLabel("Cantidad:");
					lblCantidad.setBounds(31, 191, 99, 25);
					panelVenta.add(lblCantidad);
					lblCantidad.setFont(new Font("Verdana", Font.PLAIN, 15));
				}
				{
					txtCantidad = new JTextField();
					txtCantidad.setBounds(126, 193, 96, 25);
					panelVenta.add(txtCantidad);
					txtCantidad.setColumns(10);
				}
				{
					btnRegistrar = new JButton("Registrar");
					btnRegistrar.setBounds(188, 304, 116, 25);
					panelVenta.add(btnRegistrar);
					btnRegistrar.addActionListener(this);
					btnRegistrar.setFont(new Font("Verdana", Font.PLAIN, 13));
				}
				{
					btnTotal = new JButton("Total");
					btnTotal.setBounds(566, 305, 116, 25);
					panelVenta.add(btnTotal);
					btnTotal.addActionListener(this);
					btnTotal.setFont(new Font("Tahoma", Font.PLAIN, 13));
				}
				{
					lblVendedor = new JLabel("Vendedor:");
					lblVendedor.setBounds(31, 246, 84, 25);
					panelVenta.add(lblVendedor);
					lblVendedor.setFont(new Font("Verdana", Font.PLAIN, 15));
				}
				cboVendedor = new JComboBox();
				cboVendedor.setBounds(126, 246, 195, 25);
				panelVenta.add(cboVendedor);
				cboVendedor.setFont(new Font("Verdana", Font.PLAIN, 15));
				cboVendedor.setModel(new DefaultComboBoxModel<>(Arrayem.toArray(new String[0])));
				{
					lblRegistroDeVentas = new JLabel("REGISTRO DE VENTAS");
					lblRegistroDeVentas.setBounds(309, 13, 284, 38);
					panelVenta.add(lblRegistroDeVentas);
					lblRegistroDeVentas.setFont(new Font("Verdana", Font.PLAIN, 23));
				}
				{
					jlabelmodo = new JButton("Modo Oscuro");
					jlabelmodo.setBounds(10, 297, 147, 38);
					panelVenta.add(jlabelmodo);
					jlabelmodo.addActionListener(this);
					jlabelmodo.setFont(new Font("Verdana", Font.PLAIN, 14));
				}
				{
					scrollPane = new JScrollPane();
					scrollPane.setBounds(10, 355, 801, 320);
					panelVenta.add(scrollPane);
					{
						txtS = new JTextArea();
						scrollPane.setViewportView(txtS);
					}
				}
				{
					lblNewLabel_1 = new JLabel("");
					lblNewLabel_1.setBounds(258, 10, 54, 47);
					panelVenta.add(lblNewLabel_1);
					lblNewLabel_1.setIcon(new ImageIcon(VenEmpleado.class.getResource("/recursos/check.png")));
				} 
				{
					btnModificar = new JButton("Modificar");
					btnModificar.setFont(new Font("Verdana", Font.PLAIN, 13));
					btnModificar.setBounds(314, 304, 116, 25);
					panelVenta.add(btnModificar);
				}
				{
					btnEliminar = new JButton("Eliminar");
					btnEliminar.addActionListener(this);
					btnEliminar.setFont(new Font("Verdana", Font.PLAIN, 13));
					btnEliminar.setBounds(440, 304, 116, 25);
					panelVenta.add(btnEliminar);
				}
			}
			{
				panelProducto = new JPanel();
				tabbedPane.addTab("Producto", null, panelProducto, null);
				panelProducto.setLayout(null);
				{
					btnBuscarProducto = new JButton("Buscar");
					btnBuscarProducto.addActionListener(this);
					btnBuscarProducto.setFont(new Font("Tahoma", Font.PLAIN, 13));
					btnBuscarProducto.setBounds(618, 80, 116, 25);
					panelProducto.add(btnBuscarProducto);
				}
				{
					txtIdProductoBuscar = new JTextField();
					txtIdProductoBuscar.setColumns(10);
					txtIdProductoBuscar.setBounds(178, 81, 406, 25);
					panelProducto.add(txtIdProductoBuscar);
				}
				{
					lblIdProducto = new JLabel("ID Producto:");
					lblIdProducto.setFont(new Font("Tahoma", Font.PLAIN, 15));
					lblIdProducto.setBounds(69, 79, 99, 25);
					panelProducto.add(lblIdProducto);
				}
				{
					scrollPane_1 = new JScrollPane();
					scrollPane_1.setBounds(10, 246, 801, 429);
					panelProducto.add(scrollPane_1);
					{
						txtS2 = new JTextArea();
						scrollPane_1.setViewportView(txtS2);
					}
				}
				{
					btnMostrarProducto = new JButton("Mostrar productos");
					btnMostrarProducto.addActionListener(this);
					btnMostrarProducto.setFont(new Font("Tahoma", Font.PLAIN, 13));
					btnMostrarProducto.setBounds(10, 211, 147, 25);
					panelProducto.add(btnMostrarProducto);
				}
			}
		}
		{
			lblclock = new JLabel("");
			lblclock.setBounds(551, 10, 284, 25);
			contentPane.add(lblclock);
			lblclock.setFont(new Font("Verdana", Font.PLAIN, 14));
		}
		 clock();
		
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnEliminar) {
			do_btnEliminarEmpleado_actionPerformed(e);
		}
		if (e.getSource() == btnBuscarProducto) {
			do_btnBuscarProducto_actionPerformed(e);
		}
		if (e.getSource() == btnMostrarProducto) {
			do_btnMostrarProducto_actionPerformed(e);
		}
		if (e.getSource() == jlabelmodo) {
			do_btnNewButton_actionPerformed(e);
		}
		if (e.getSource() == btnTotal) {
			do_btnTotal_actionPerformed(e);
		}
		if (e.getSource() == btnRegistrar) {
			do_btnRegistrar_actionPerformed(e);
		}
	}
	
	
	private JButton btnTotal;
	private JLabel lblVendedor;
	private JComboBox cboVendedor;
	
	private JLabel lblRegistroDeVentas;
	private JButton jlabelmodo;
	private JScrollPane scrollPane;
	private JTextArea txtS;
	private JLabel lblNewLabel_1;
	private JLabel lblclock;
	private JTabbedPane tabbedPane;
	private JPanel panelVenta;
	private JPanel panelProducto;
	private JButton btnBuscarProducto;
	private JTextField txtIdProductoBuscar;
	private JLabel lblIdProducto;
	private JScrollPane scrollPane_1;
	private JTextArea txtS2;
	private JButton btnMostrarProducto;
	private JButton btnModificar;
	private JButton btnEliminar;
	
	ArregloVenta av = new ArregloVenta();
	ArregloProducto ap = new ArregloProducto();
	
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
	
	void ImprimirVenta(String s) {
		txtS.append(s+"\n");
	}
	
	void ListadoVentas() {
		txtS.setText("");
		ImprimirVenta("Código\tDNI\tNombres y apellidos\tTeléfono\tFecha\tHora\tID Producto\tProducto\tNombre del modelo\tGarantia\tPrecio unitario\tCantidad\tTipo de pago\tVendedor\t\tSub Total");

		for (int i = 0; i < av.Tamaño(); i++) {
			Venta v = av.Obtener(i);
			Producto prod = ap.Buscar(v.getProducto().getId_producto());
			
			ImprimirVenta("" + v.getCodigo_venta() + "\t" +
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
	protected void do_btnMostrarProducto_actionPerformed(ActionEvent e) {
		txtS2.setText("");
		ListadoProductos();
	}
	void ImprimirProducto(String s) {
		txtS2.append(s+"\n");
	}
	void ListadoProductos() {
		txtS2.setText("");
		ImprimirProducto("ID\tProducto\tNombre del modelo\tGarantía\tPrecio\tStock");
		for(int i = 0; i < ap.Tamaño(); i++) {
			Producto p = ap.Obtener(i);
			ImprimirProducto("" + p.getId_producto() + "\t" +
			"" + p.getCat_producto() + "\t" + 
			"" + p.getNombre() + "\t" +
			"" + p.getGarantia() + "\t" +
			"" + p.getPrecio() + "\t" +
			"" + p.getStock()); 
	}
}	protected void do_btnBuscarProducto_actionPerformed(ActionEvent e) {
		txtS2.setText("");
	    try {
	        int id = Integer.parseInt(txtIdProductoBuscar.getText());

	        Producto producto = ap.Buscar(id);
	        if (producto != null) {
	        	ImprimirProducto("ID\tProducto\tNombre del modelo\tGarantía\tPrecio\tStock");
	            ImprimirProducto(producto.getId_producto()+ "\t"
	            + "" + producto.getCat_producto()+ "\t"
	        	+ "" + producto.getNombre()+ "\t" 
	        	+ "" + producto.getGarantia() + "\t" 
	        	+ "" + producto.getPrecio()+ "\t" 
	            + "" + producto.getStock());
	        } else {
	            JOptionPane.showMessageDialog(this, "Ingrese dato válido");
	        }

	    } catch (Exception e2) {
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
		    txtTelefono.setBackground(Color.WHITE);
		    txtDNI.setBackground(Color.WHITE);
		    txtCod.setBackground(Color.WHITE);
		    txtIdProducto.setBackground(Color.WHITE);
		    cboTipoPago.setBackground(Color.WHITE);
		    cboComprobante.setBackground(Color.WHITE);
		    cboVendedor.setBackground(Color.WHITE);
		    txtCantidad.setBackground(Color.WHITE);
		    
		    txtNombre.setForeground(Color.BLACK);
		    txtS.setForeground(Color.BLACK);
		    txtDNI.setForeground(Color.BLACK);
		    txtTelefono.setForeground(Color.BLACK);
		    txtCod.setForeground(Color.BLACK);
		    txtIdProducto.setForeground(Color.BLACK);
		    txtCantidad.setForeground(Color.BLACK);
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
		    txtTelefono.setBackground(Color.DARK_GRAY);
		    txtDNI.setBackground(Color.DARK_GRAY);
		    txtCod.setBackground(Color.DARK_GRAY);
		    txtIdProducto.setBackground(Color.DARK_GRAY);
		    cboTipoPago.setBackground(Color.DARK_GRAY);
		    cboComprobante.setBackground(Color.DARK_GRAY);
		    cboVendedor.setBackground(Color.DARK_GRAY);
		    txtCantidad.setBackground(Color.DARK_GRAY);
		    
		    txtNombre.setForeground(Color.WHITE);
		    txtS.setForeground(Color.WHITE);
		    txtDNI.setForeground(Color.WHITE);
		    txtTelefono.setForeground(Color.WHITE);
		    txtCod.setForeground(Color.WHITE);
		    txtIdProducto.setForeground(Color.WHITE);
		    txtCantidad.setForeground(Color.WHITE);
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
		    txtTelefono.setBackground(new Color(30, 80, 120));
		    txtDNI.setBackground(new Color(30, 80, 120));
		    txtCod.setBackground(new Color(30, 80, 120));
		    txtIdProducto.setBackground(new Color(30, 80, 120));
		    cboTipoPago.setBackground(new Color(30, 80, 120));
		    cboComprobante.setBackground(new Color(30, 80, 120));
		    cboVendedor.setBackground(new Color(30, 80, 120));
		    txtCantidad.setBackground(new Color(30, 80, 120));    
		    txtNombre.setForeground(Color.WHITE);
		    txtS.setForeground(Color.WHITE);
		    txtDNI.setForeground(Color.WHITE);
		    txtTelefono.setForeground(Color.WHITE);
		    txtCod.setForeground(Color.WHITE);
		    txtIdProducto.setForeground(Color.WHITE);
		    txtCantidad.setForeground(Color.WHITE);
		    cboTipoPago.setForeground(Color.WHITE);
		    cboComprobante.setForeground(Color.WHITE);
		    cboVendedor.setForeground(Color.WHITE);
		    jlabelmodo.setText("Modo Normal");
		}
	}
	protected void do_btnEliminarEmpleado_actionPerformed(ActionEvent e) {
	}
}

