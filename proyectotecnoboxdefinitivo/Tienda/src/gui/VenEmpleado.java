package gui;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clase.Cliente;
import clase.Empleado;
import clase.Producto;
import clase.Venta;
import mantenimiento.MantEmpleado;

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
import javax.swing.JTable;

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
	private JButton btnRegistrarVenta;
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
					btnRegistrarVenta = new JButton("Registrar");
					btnRegistrarVenta.setBounds(188, 304, 116, 25);
					panelVenta.add(btnRegistrarVenta);
					btnRegistrarVenta.addActionListener(this);
					btnRegistrarVenta.setFont(new Font("Verdana", Font.PLAIN, 13));
				}
				{
					btnTotalVenta = new JButton("Total");
					btnTotalVenta.setBounds(566, 305, 116, 25);
					panelVenta.add(btnTotalVenta);
					btnTotalVenta.addActionListener(this);
					btnTotalVenta.setFont(new Font("Tahoma", Font.PLAIN, 13));
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
					btnModificarVenta = new JButton("Modificar");
					btnModificarVenta.addActionListener(this);
					btnModificarVenta.setFont(new Font("Verdana", Font.PLAIN, 13));
					btnModificarVenta.setBounds(314, 304, 116, 25);
					panelVenta.add(btnModificarVenta);
				}
				{
					btnEliminarVenta = new JButton("Eliminar");
					btnEliminarVenta.addActionListener(this);
					btnEliminarVenta.setFont(new Font("Verdana", Font.PLAIN, 13));
					btnEliminarVenta.setBounds(440, 304, 116, 25);
					panelVenta.add(btnEliminarVenta);
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
					btnBuscarProducto.setBounds(624, 22, 116, 25);
					panelProducto.add(btnBuscarProducto);
				}
				{
					txtIdProductoBuscar = new JTextField();
					txtIdProductoBuscar.setColumns(10);
					txtIdProductoBuscar.setBounds(174, 23, 406, 25);
					panelProducto.add(txtIdProductoBuscar);
				}
				{
					lblIdProducto = new JLabel("ID Producto:");
					lblIdProducto.setFont(new Font("Verdana", Font.PLAIN, 15));
					lblIdProducto.setBounds(65, 21, 99, 25);
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
					btnRegistrarCliente_1 = new JButton("Registrar");
					btnRegistrarCliente_1.setFont(new Font("Verdana", Font.PLAIN, 13));
					btnRegistrarCliente_1.setBounds(624, 70, 116, 25);
					panelProducto.add(btnRegistrarCliente_1);
				}
				{
					btnModificarCliente_1 = new JButton("Modificar");
					btnModificarCliente_1.setFont(new Font("Verdana", Font.PLAIN, 13));
					btnModificarCliente_1.setBounds(624, 117, 116, 25);
					panelProducto.add(btnModificarCliente_1);
				}
				{
					btnEliminarCliente_1 = new JButton("Eliminar");
					btnEliminarCliente_1.setFont(new Font("Verdana", Font.PLAIN, 13));
					btnEliminarCliente_1.setBounds(624, 163, 116, 25);
					panelProducto.add(btnEliminarCliente_1);
				}
				{
					lblCategoraDelProducto = new JLabel("Categoría:");
					lblCategoraDelProducto.setFont(new Font("Verdana", Font.PLAIN, 15));
					lblCategoraDelProducto.setBounds(30, 56, 99, 25);
					panelProducto.add(lblCategoraDelProducto);
				}
				{
					txtCategoriaProd = new JTextField();
					txtCategoriaProd.setColumns(10);
					txtCategoriaProd.setBounds(139, 58, 99, 25);
					panelProducto.add(txtCategoriaProd);
				}
				{
					lblIdProducto_2 = new JLabel("Nombre:");
					lblIdProducto_2.setFont(new Font("Verdana", Font.PLAIN, 15));
					lblIdProducto_2.setBounds(30, 91, 99, 25);
					panelProducto.add(lblIdProducto_2);
				}
				{
					txtNomProd = new JTextField();
					txtNomProd.setColumns(10);
					txtNomProd.setBounds(139, 93, 99, 25);
					panelProducto.add(txtNomProd);
				}
				{
					txtGarProducto = new JTextField();
					txtGarProducto.setColumns(10);
					txtGarProducto.setBounds(139, 130, 99, 25);
					panelProducto.add(txtGarProducto);
				}
				{
					lblIdProducto_1 = new JLabel("Garantía:");
					lblIdProducto_1.setFont(new Font("Verdana", Font.PLAIN, 15));
					lblIdProducto_1.setBounds(30, 128, 99, 25);
					panelProducto.add(lblIdProducto_1);
				}
				{
					lblIdProducto_3 = new JLabel("Precio:");
					lblIdProducto_3.setFont(new Font("Verdana", Font.PLAIN, 15));
					lblIdProducto_3.setBounds(30, 171, 99, 25);
					panelProducto.add(lblIdProducto_3);
				}
				{
					txtPrecioPrd = new JTextField();
					txtPrecioPrd.setColumns(10);
					txtPrecioPrd.setBounds(139, 168, 99, 25);
					panelProducto.add(txtPrecioPrd);
				}
				{
					lblIdProducto_4 = new JLabel("Stock:");
					lblIdProducto_4.setFont(new Font("Verdana", Font.PLAIN, 15));
					lblIdProducto_4.setBounds(372, 61, 99, 25);
					panelProducto.add(lblIdProducto_4);
				}
				{
					txtStockProd = new JTextField();
					txtStockProd.setColumns(10);
					txtStockProd.setBounds(481, 58, 99, 25);
					panelProducto.add(txtStockProd);
				}
			}
			{
				panelCliente = new JPanel();
				tabbedPane.addTab("Cliente", null, panelCliente, null);
				panelCliente.setLayout(null);
				{
					lblDniCliente = new JLabel("DNI:");
					lblDniCliente.setFont(new Font("Tahoma", Font.PLAIN, 15));
					lblDniCliente.setBounds(62, 66, 99, 25);
					panelCliente.add(lblDniCliente);
				}
				{
					lblIdNombreCliente = new JLabel("Nombre:");
					lblIdNombreCliente.setFont(new Font("Tahoma", Font.PLAIN, 15));
					lblIdNombreCliente.setBounds(62, 113, 99, 25);
					panelCliente.add(lblIdNombreCliente);
				}
				{
					lblTeleCliente = new JLabel("Teléfono:");
					lblTeleCliente.setFont(new Font("Tahoma", Font.PLAIN, 15));
					lblTeleCliente.setBounds(62, 159, 99, 25);
					panelCliente.add(lblTeleCliente);
				}
				{
					textField = new JTextField();
					textField.setColumns(10);
					textField.setBounds(135, 66, 117, 25);
					panelCliente.add(textField);
				}
				{
					textField_1 = new JTextField();
					textField_1.setColumns(10);
					textField_1.setBounds(135, 113, 370, 25);
					panelCliente.add(textField_1);
				}
				{
					textField_2 = new JTextField();
					textField_2.setColumns(10);
					textField_2.setBounds(135, 159, 117, 25);
					panelCliente.add(textField_2);
				}
				{
					scrollPane_2 = new JScrollPane();
					scrollPane_2.setBounds(10, 227, 801, 448);
					panelCliente.add(scrollPane_2);
					{
						tablaCliente = new JTable();
						tablaCliente.setFillsViewportHeight(true);
						scrollPane_2.setViewportView(tablaCliente);
					}
				}
				{
					btnRegistrarCliente = new JButton("Registrar");
					btnRegistrarCliente.setFont(new Font("Verdana", Font.PLAIN, 13));
					btnRegistrarCliente.setBounds(611, 66, 116, 25);
					panelCliente.add(btnRegistrarCliente);
				}
				{
					btnModificarCliente = new JButton("Modificar");
					btnModificarCliente.setFont(new Font("Verdana", Font.PLAIN, 13));
					btnModificarCliente.setBounds(611, 113, 116, 25);
					panelCliente.add(btnModificarCliente);
				}
				{
					btnEliminarCliente = new JButton("Eliminar");
					btnEliminarCliente.setFont(new Font("Verdana", Font.PLAIN, 13));
					btnEliminarCliente.setBounds(611, 159, 116, 25);
					panelCliente.add(btnEliminarCliente);
				}
				{
					btnBuscarCliente = new JButton("Buscar");
					btnBuscarCliente.setFont(new Font("Verdana", Font.PLAIN, 13));
					btnBuscarCliente.setBounds(289, 66, 116, 25);
					panelCliente.add(btnBuscarCliente);
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
		if (e.getSource() == btnModificarVenta) {
			do_btnModificar_actionPerformed(e);
		}
		if (e.getSource() == btnEliminarVenta) {
			do_btnEliminarEmpleado_actionPerformed(e);
		}
		if (e.getSource() == btnBuscarProducto) {
			do_btnBuscarProducto_actionPerformed(e);
		}
		if (e.getSource() == jlabelmodo) {
			do_btnNewButton_actionPerformed(e);
		}
		if (e.getSource() == btnTotalVenta) {
			do_btnTotal_actionPerformed(e);
		}
		if (e.getSource() == btnRegistrarVenta) {
			do_btnRegistrar_actionPerformed(e);
		}
	}
	
	
	private JButton btnTotalVenta;
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
	private JButton btnModificarVenta;
	private JButton btnEliminarVenta;
	private JPanel panelCliente;
	private JLabel lblDniCliente;
	private JLabel lblIdNombreCliente;
	private JLabel lblTeleCliente;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JScrollPane scrollPane_2;
	private JTable tablaCliente;
	private JButton btnRegistrarCliente;
	private JButton btnModificarCliente;
	private JButton btnEliminarCliente;
	private JButton btnBuscarCliente;
	private JButton btnRegistrarCliente_1;
	private JButton btnModificarCliente_1;
	private JButton btnEliminarCliente_1;
	private JLabel lblCategoraDelProducto;
	private JTextField txtCategoriaProd;
	private JLabel lblIdProducto_2;
	private JTextField txtNomProd;
	private JTextField txtGarProducto;
	private JLabel lblIdProducto_1;
	private JLabel lblIdProducto_3;
	private JTextField txtPrecioPrd;
	private JLabel lblIdProducto_4;
	private JTextField txtStockProd;
	
	protected void do_btnRegistrar_actionPerformed(ActionEvent e) {		
		try {	
		
			
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(this, "Uno o más de los valores ingresados no es válido. Intente de nuevo.");	
		}
	}

	protected void do_btnTotal_actionPerformed(ActionEvent e) {
		try {
 
		} catch (Exception e2) {
		    	txtS.setText("");
			JOptionPane.showMessageDialog(this, "Primero debe ingresar valores para usar esta función");
		}
	}
	protected void do_btnBuscarProducto_actionPerformed(ActionEvent e) {
	    try {
	        int id = Integer.parseInt(txtIdProductoBuscar.getText());
	        
	        

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
	protected void do_btnModificar_actionPerformed(ActionEvent e) {
		
	}
	
	public void BuscarEmpleado() {
		String DNI= txtDNI.getText();
		String nombre=txtNombre.getText();
		String teléfono= txtTelefono.getText();
		if (DNI.isEmpty() || nombre.isEmpty()||teléfono.isEmpty()) {
	        JOptionPane.showMessageDialog(this, "Debe los datos del empleado");
	        return;
	    }
		mantEmpleado mantEmpleado= new Mant
		
	}
}

