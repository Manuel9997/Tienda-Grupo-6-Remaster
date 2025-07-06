package gui;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import clase.Cliente;
import clase.DetalleVenta;
import clase.Empleado;
import clase.HistorialVentas;
import clase.Producto;
import clase.Proveedor;
import clase.Venta;
import mantenimiento.MantCliente;
import mantenimiento.MantDetalleVenta;
import mantenimiento.MantEmpleado;
import mantenimiento.MantHistorialVentas;
import mantenimiento.MantProducto;
import mantenimiento.MantProveedor;
import mantenimiento.MantVenta;

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
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseListener;
import java.sql.Date;
import java.awt.event.MouseEvent;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.JSplitPane;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class VenEmpleado extends JFrame implements ActionListener, KeyListener, MouseListener, ItemListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JComboBox cboTipoPago;
	private JComboBox cboComprobante;
	private JLabel lblNewLabel;
	private JLabel lblComprobante;
	private JLabel lblId;
	private JLabel lblDni;
	private JLabel lblCantidad;
	private JTextField txtCantidadVenta;
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
		setBounds(100, 100, 1370, 770);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		{
			tabbedPane = new JTabbedPane(JTabbedPane.TOP);
			tabbedPane.setBounds(10, 13, 1336, 712);
			contentPane.add(tabbedPane);
			{
				panelVenta = new JPanel();
				panelVenta.setBackground(UIManager.getColor("Button.light"));
				tabbedPane.addTab("Venta", null, panelVenta, null);
				panelVenta.setLayout(null);
				{
					cboTipoPago = new JComboBox();
					cboTipoPago.setBounds(387, 132, 116, 25);
					panelVenta.add(cboTipoPago);
					cboTipoPago.setFont(new Font("Verdana", Font.PLAIN, 15));
					cboTipoPago.setModel(new DefaultComboBoxModel(new String[] {"Efectivo", "Débito", "Crédito", "Yape/Plin"}));
				}
				{
					cboComprobante = new JComboBox();
					cboComprobante.setBounds(387, 167, 116, 25);
					panelVenta.add(cboComprobante);
					cboComprobante.setFont(new Font("Verdana", Font.PLAIN, 15));
					cboComprobante.setModel(new DefaultComboBoxModel(new String[] {"Boleta", "Factura"}));
				}
				{
					lblNewLabel = new JLabel("Tipo de pago:");
					lblNewLabel.setBounds(265, 132, 116, 25);
					panelVenta.add(lblNewLabel);
					lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 15));
				}
				{
					lblComprobante = new JLabel("Comprobante:");
					lblComprobante.setBounds(265, 167, 116, 25);
					panelVenta.add(lblComprobante);
					lblComprobante.setFont(new Font("Verdana", Font.PLAIN, 15));
				}
				{
					lblId = new JLabel("ID Producto:");
					lblId.setBounds(697, 137, 99, 25);
					panelVenta.add(lblId);
					lblId.setFont(new Font("Verdana", Font.PLAIN, 15));
				}
				{
					lblDni = new JLabel("DNI:");
					lblDni.setBounds(265, 99, 44, 25);
					panelVenta.add(lblDni);
					lblDni.setFont(new Font("Verdana", Font.PLAIN, 15));
				}
				{
					lblCantidad = new JLabel("Cantidad:");
					lblCantidad.setBounds(697, 170, 99, 25);
					panelVenta.add(lblCantidad);
					lblCantidad.setFont(new Font("Verdana", Font.PLAIN, 15));
				}
				{
					txtCantidadVenta = new JTextField();
					txtCantidadVenta.addKeyListener(this);
					txtCantidadVenta.setBounds(806, 172, 96, 25);
					panelVenta.add(txtCantidadVenta);
					txtCantidadVenta.setColumns(10);
				}
				{
					lblVendedor = new JLabel("Vendedor:");
					lblVendedor.setBounds(265, 237, 84, 25);
					panelVenta.add(lblVendedor);
					lblVendedor.setFont(new Font("Verdana", Font.PLAIN, 15));
				}
				{
					lblRegistroDeVentas = new JLabel("REGISTRO DE VENTAS");
					lblRegistroDeVentas.setBounds(436, 13, 284, 38);
					panelVenta.add(lblRegistroDeVentas);
					lblRegistroDeVentas.setFont(new Font("Verdana", Font.PLAIN, 23));
				}
				{
					jlabelmodo = new JButton("Modo Oscuro");
					jlabelmodo.setBounds(10, 307, 147, 38);
					panelVenta.add(jlabelmodo);
					jlabelmodo.addActionListener(this);
					jlabelmodo.setFont(new Font("Verdana", Font.PLAIN, 14));
				}
				{
					scrollPane = new JScrollPane();
					scrollPane.setBounds(10, 355, 1311, 320);
					panelVenta.add(scrollPane);
					{
						tablaVenta = new JTable();
						tablaVenta.addMouseListener(this);
						tablaVenta.setFillsViewportHeight(true);
						scrollPane.setViewportView(tablaVenta);
					}
				}
				{
					lblNewLabel_1 = new JLabel("");
					lblNewLabel_1.setBounds(385, 10, 54, 47);
					panelVenta.add(lblNewLabel_1);
					lblNewLabel_1.setIcon(new ImageIcon(VenEmpleado.class.getResource("/recursos/check.png")));
				}
				{
					lblCod = new JLabel("Cód:");
					lblCod.setFont(new Font("Verdana", Font.PLAIN, 15));
					lblCod.setBounds(697, 99, 44, 25);
					panelVenta.add(lblCod);
				}
				{
					txtCodEditable = new JTextField();
					txtCodEditable.addKeyListener(this);
					txtCodEditable.setColumns(10);
					txtCodEditable.setBounds(751, 102, 96, 25);
					panelVenta.add(txtCodEditable);
				}
				{
					lblIdVendedor = new JLabel("ID Vendedor:");
					lblIdVendedor.setFont(new Font("Verdana", Font.PLAIN, 15));
					lblIdVendedor.setBounds(265, 202, 116, 25);
					panelVenta.add(lblIdVendedor);
				}
				{
					cboIdVendedor = new JComboBox();
					cboIdVendedor.addItemListener(this);
					cboIdVendedor.setFont(new Font("Verdana", Font.PLAIN, 15));
					cboIdVendedor.setBounds(386, 202, 117, 25);
					panelVenta.add(cboIdVendedor);
				}
				{
					txtNombreVendedor =  new JTextField();
					txtNombreVendedor.setEnabled(false);
					txtNombreVendedor.setColumns(10);
					txtNombreVendedor.setBounds(348, 239, 155, 25);
					panelVenta.add(txtNombreVendedor);
				}
				{
					txtDniClienteVenta = new JTextField();
					txtDniClienteVenta.addKeyListener(this);
					txtDniClienteVenta.setColumns(10);
					txtDniClienteVenta.setBounds(348, 99, 117, 25);
					panelVenta.add(txtDniClienteVenta);
				}
				{
					txtIdProductoVenta = new JTextField();
					txtIdProductoVenta.addKeyListener(this);
					txtIdProductoVenta.setColumns(10);
					txtIdProductoVenta.setBounds(806, 137, 96, 25);
					panelVenta.add(txtIdProductoVenta);
				}
				{
					btnRegistrarDetalleVentas = new JButton("Registrar");
					btnRegistrarDetalleVentas.addActionListener(this);
					btnRegistrarDetalleVentas.setFont(new Font("Verdana", Font.PLAIN, 13));
					btnRegistrarDetalleVentas.setBounds(925, 99, 116, 25);
					panelVenta.add(btnRegistrarDetalleVentas);
				}
				{
					btnModificarDetalleVenta = new JButton("Modificar");
					btnModificarDetalleVenta.addActionListener(this);
					btnModificarDetalleVenta.setFont(new Font("Verdana", Font.PLAIN, 13));
					btnModificarDetalleVenta.setBounds(925, 134, 116, 25);
					panelVenta.add(btnModificarDetalleVenta);
				}
				{
					btnEliminarDetalleVenta = new JButton("Eliminar");
					btnEliminarDetalleVenta.setFont(new Font("Verdana", Font.PLAIN, 13));
					btnEliminarDetalleVenta.setBounds(925, 172, 116, 25);
					panelVenta.add(btnEliminarDetalleVenta);
				}
				{
					btnModificarVenta = new JButton("Modificar");
					btnModificarVenta.addActionListener(this);
					btnModificarVenta.setFont(new Font("Verdana", Font.PLAIN, 13));
					btnModificarVenta.setBounds(535, 167, 116, 25);
					panelVenta.add(btnModificarVenta);
				}
				{
					panel = new JPanel();
					panel.setBounds(10, 13, 217, 245);
					panelVenta.add(panel);
					panel.setLayout(null);
					{
						txtPrecioVenta = new JTextField();
						txtPrecioVenta.setBounds(66, 30, 96, 19);
						panel.add(txtPrecioVenta);
						txtPrecioVenta.setColumns(10);
					}
					{
						txtCantVenta = new JTextField();
						txtCantVenta.setColumns(10);
						txtCantVenta.setBounds(66, 59, 96, 19);
						panel.add(txtCantVenta);
					}
					{
						btnTotal = new JButton("Total");
						btnTotal.addActionListener(this);
						btnTotal.setBounds(20, 88, 85, 21);
						panel.add(btnTotal);
					}
					{
						lblPrecio = new JLabel("Precio:");
						lblPrecio.setBounds(10, 33, 45, 13);
						panel.add(lblPrecio);
					}
					{
						lblCantidadVenta = new JLabel("Cantidad:");
						lblCantidadVenta.setBounds(10, 62, 66, 13);
						panel.add(lblCantidadVenta);
					}
					{
						scrollPane_3 = new JScrollPane();
						scrollPane_3.setBounds(10, 131, 197, 104);
						panel.add(scrollPane_3);
						{
							txtS = new JTextArea();
							scrollPane_3.setViewportView(txtS);
						}
					}
					{
						btnSuma = new JButton("+");
						btnSuma.setBounds(164, 45, 43, 25);
						panel.add(btnSuma);
						btnSuma.setFont(new Font("Tahoma", Font.PLAIN, 10));
						{
							btnBorrar = new JButton("Borrar");
							btnBorrar.addActionListener(this);
							btnBorrar.setBounds(110, 88, 85, 21);
							panel.add(btnBorrar);
						}
						{
							btnRegistrarVenta = new JButton("Registrar");
							btnRegistrarVenta.addActionListener(this);
							btnRegistrarVenta.setFont(new Font("Verdana", Font.PLAIN, 13));
							btnRegistrarVenta.setBounds(535, 132, 116, 25);
							panelVenta.add(btnRegistrarVenta);
						}
						{
							btnEliminarVenta = new JButton("Eliminar");
							btnEliminarVenta.setFont(new Font("Verdana", Font.PLAIN, 13));
							btnEliminarVenta.setBounds(535, 203, 116, 25);
							panelVenta.add(btnEliminarVenta);
						}
						{
							lblCodNoEditable = new JLabel("Cód:");
							lblCodNoEditable.setFont(new Font("Verdana", Font.PLAIN, 15));
							lblCodNoEditable.setBounds(265, 64, 44, 25);
							panelVenta.add(lblCodNoEditable);
						}
						{
							txtCodNoEditable = new JTextField();
							txtCodNoEditable.setEnabled(false);
							txtCodNoEditable.setColumns(10);
							txtCodNoEditable.setBounds(348, 64, 96, 25);
							panelVenta.add(txtCodNoEditable);
						}
						{
							lblIdDetalle = new JLabel("ID Detalle:");
							lblIdDetalle.setFont(new Font("Verdana", Font.PLAIN, 15));
							lblIdDetalle.setBounds(697, 67, 90, 25);
							panelVenta.add(lblIdDetalle);
						}
						{
							txtIdDetalle = new JTextField();
							txtIdDetalle.setEnabled(false);
							txtIdDetalle.setColumns(10);
							txtIdDetalle.setBounds(806, 67, 96, 25);
							panelVenta.add(txtIdDetalle);
						}
						{
							btnBorrarVenta = new JButton("Borrar");
							btnBorrarVenta.addActionListener(this);
							btnBorrarVenta.setFont(new Font("Verdana", Font.PLAIN, 13));
							btnBorrarVenta.setBounds(1205, 320, 116, 25);
							panelVenta.add(btnBorrarVenta);
						}
						btnSuma.addActionListener(this);
					}
				}
			}
			{
				panelProducto = new JPanel();
				panelProducto.setBackground(UIManager.getColor("Button.light"));
				tabbedPane.addTab("Producto", null, panelProducto, null);
				panelProducto.setLayout(null);
				{
					txtIdBuscarProducto = new JTextField();
					txtIdBuscarProducto.addKeyListener(this);
					txtIdBuscarProducto.setColumns(10);
					txtIdBuscarProducto.setBounds(247, 66, 406, 25);
					panelProducto.add(txtIdBuscarProducto);
				}
				{
					lblIdProducto = new JLabel("Buscar:");
					lblIdProducto.setFont(new Font("Verdana", Font.PLAIN, 15));
					lblIdProducto.setBounds(172, 64, 81, 25);
					panelProducto.add(lblIdProducto);
				}
				{
					scrollPane_1 = new JScrollPane();
					scrollPane_1.setBounds(10, 150, 1311, 525);
					panelProducto.add(scrollPane_1);
					{
						tablaProducto = new JTable();
						tablaProducto.setFillsViewportHeight(true);
						scrollPane_1.setViewportView(tablaProducto);
					}
				}
			}
			{
				panelCliente = new JPanel();
				panelCliente.setBackground(UIManager.getColor("Button.light"));
				tabbedPane.addTab("Cliente", null, panelCliente, null);
				panelCliente.setLayout(null);
				{
					lblDniCliente = new JLabel("DNI:");
					lblDniCliente.setFont(new Font("Tahoma", Font.PLAIN, 15));
					lblDniCliente.setBounds(64, 86, 99, 25);
					panelCliente.add(lblDniCliente);
				}
				{
					lblIdNombreCliente = new JLabel("Nombre:");
					lblIdNombreCliente.setFont(new Font("Tahoma", Font.PLAIN, 15));
					lblIdNombreCliente.setBounds(64, 133, 99, 25);
					panelCliente.add(lblIdNombreCliente);
				}
				{
					lblTeleCliente = new JLabel("Teléfono:");
					lblTeleCliente.setFont(new Font("Tahoma", Font.PLAIN, 15));
					lblTeleCliente.setBounds(64, 179, 99, 25);
					panelCliente.add(lblTeleCliente);
				}
				{
					txtDniCliente = new JTextField();
					txtDniCliente.addKeyListener(this);
					txtDniCliente.setColumns(10);
					txtDniCliente.setBounds(137, 86, 117, 25);
					panelCliente.add(txtDniCliente);
				}
				{
					txtNombreCliente = new JTextField();
					txtNombreCliente.addKeyListener(this);
					txtNombreCliente.setColumns(10);
					txtNombreCliente.setBounds(137, 133, 370, 25);
					panelCliente.add(txtNombreCliente);
				}
				{
					txtTelefonoCliente = new JTextField();
					txtTelefonoCliente.addKeyListener(this);
					txtTelefonoCliente.setColumns(10);
					txtTelefonoCliente.setBounds(137, 179, 117, 25);
					panelCliente.add(txtTelefonoCliente);
				}
				{
					scrollPane_2 = new JScrollPane();
					scrollPane_2.setBounds(10, 227, 1311, 448);
					panelCliente.add(scrollPane_2);
					{
						tablaCliente = new JTable();
						tablaCliente.addMouseListener(this);
						tablaCliente.setFillsViewportHeight(true);
						scrollPane_2.setViewportView(tablaCliente);
					}
				}
				{
					btnRegistrarCliente = new JButton("Registrar");
					btnRegistrarCliente.addActionListener(this);
					btnRegistrarCliente.setFont(new Font("Verdana", Font.PLAIN, 13));
					btnRegistrarCliente.setBounds(613, 105, 116, 25);
					panelCliente.add(btnRegistrarCliente);
				}
				{
					btnModificarCliente = new JButton("Modificar");
					btnModificarCliente.addActionListener(this);
					btnModificarCliente.setFont(new Font("Verdana", Font.PLAIN, 13));
					btnModificarCliente.setBounds(613, 155, 116, 25);
					panelCliente.add(btnModificarCliente);
				}
				{
					txtBuscarCliente = new JTextField();
					txtBuscarCliente.addKeyListener(this);
					txtBuscarCliente.setColumns(10);
					txtBuscarCliente.setBounds(236, 23, 406, 25);
					panelCliente.add(txtBuscarCliente);
				}
				{
					lblIdProducto_1 = new JLabel("Buscar:");
					lblIdProducto_1.setFont(new Font("Verdana", Font.PLAIN, 15));
					lblIdProducto_1.setBounds(158, 23, 81, 25);
					panelCliente.add(lblIdProducto_1);
				}
				{
					btnBorrarCliente = new JButton("Borrar");
					btnBorrarCliente.addActionListener(this);
					btnBorrarCliente.setFont(new Font("Verdana", Font.PLAIN, 13));
					btnBorrarCliente.setBounds(1205, 192, 116, 25);
					panelCliente.add(btnBorrarCliente);
				}
				{
					btnMostrarCliente = new JButton("Mostrar");
					btnMostrarCliente.addActionListener(this);
					btnMostrarCliente.setFont(new Font("Verdana", Font.PLAIN, 13));
					btnMostrarCliente.setBounds(1079, 192, 116, 25);
					panelCliente.add(btnMostrarCliente);
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
		 ListarProducto("");
		 ListarCliente("");
		 ListarVentasDelDia();
		 LlenarCombo();
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnBorrarCliente) {
			do_btnBorrarCliente_actionPerformed(e);
		}
		if (e.getSource() == btnMostrarCliente) {
			do_btnMostrarCliente_actionPerformed(e);
		}
		if (e.getSource() == btnBorrarVenta) {
			do_btnBorrarVenta_actionPerformed(e);
		}
		if (e.getSource() == btnModificarDetalleVenta) {
			do_btnModificarDetalleVenta_actionPerformed(e);
		}
		if (e.getSource() == btnRegistrarDetalleVentas) {
			do_btnRegistrarDetalleVentas_actionPerformed(e);
		}
		if (e.getSource() == btnRegistrarVenta) {
			do_btnRegistrarVenta_actionPerformed(e);
		}
		if (e.getSource() == btnModificarVenta) {
			do_btnModificarVenta_actionPerformed(e);
		}
		if (e.getSource() == btnBorrar) {
			do_btnBorrar_actionPerformed(e);
		}
		if (e.getSource() == btnSuma) {
			do_btnSuma_actionPerformed(e);
		}
		if (e.getSource() == btnModificarCliente) {
			do_btnModificarCliente_actionPerformed(e);
		}
		if (e.getSource() == btnRegistrarCliente) {
			do_btnRegistrarCliente_actionPerformed(e);
		}
		if (e.getSource() == jlabelmodo) {
			do_btnNewButton_actionPerformed(e);
		}
	}
	private JLabel lblVendedor;
	
	private JLabel lblRegistroDeVentas;
	private JButton jlabelmodo;
	private JScrollPane scrollPane;
	private JLabel lblNewLabel_1;
	private JLabel lblclock;
	private JTabbedPane tabbedPane;
	private JPanel panelVenta;
	private JPanel panelProducto;
	private JTextField txtIdBuscarProducto;
	private JLabel lblIdProducto;
	private JScrollPane scrollPane_1;
	private JPanel panelCliente;
	private JLabel lblDniCliente;
	private JLabel lblIdNombreCliente;
	private JLabel lblTeleCliente;
	private JTextField txtDniCliente;
	private JTextField txtNombreCliente;
	private JTextField txtTelefonoCliente;
	private JScrollPane scrollPane_2;
	private JTable tablaCliente;
	private JButton btnRegistrarCliente;
	private JButton btnModificarCliente;
	private JTable tablaProducto;
	private JTextField txtBuscarCliente;
	private JLabel lblIdProducto_1;
	private JLabel lblCod;
	private JTextField txtCodEditable;
	private JLabel lblIdVendedor;
	private JComboBox cboIdVendedor;
	private JTextField txtNombreVendedor;
	private JTable tablaVenta;
	private JTextField txtDniClienteVenta;
	private JTextField txtIdProductoVenta;
	private JButton btnRegistrarDetalleVentas;
	private JButton btnModificarDetalleVenta;
	private JButton btnEliminarDetalleVenta;
	private JButton btnModificarVenta;
	private JPanel panel;
	private JTextField txtPrecioVenta;
	private JTextField txtCantVenta;
	private JButton btnTotal;
	private JLabel lblPrecio;
	private JLabel lblCantidadVenta;
	private JButton btnSuma;
	public void ListarProducto(String filtro) {
		DefaultTableModel modelo = new DefaultTableModel();
		MantProducto mp = new MantProducto();
		ArrayList<Producto> lista = new ArrayList<Producto>();
		if(filtro.length() == 0) lista = mp.MostrarProducto();
		else lista = mp.ConsultarProducto(filtro);
		
		modelo.setRowCount(lista.size());
		Iterator<Producto> it = lista.iterator();
		modelo.addColumn("ID");
		modelo.addColumn("Categoría");
		modelo.addColumn("Nombre");
		modelo.addColumn("Garantía");
		modelo.addColumn("Precio");
		modelo.addColumn("Stock");
		int i = 0;
		
		while (it.hasNext()) {
			Object obj = it.next();
			Producto p = (Producto)obj;
			modelo.setValueAt(p.getIdProducto(), i, 0);
			modelo.setValueAt(p.getCategoriaProducto(), i, 1);
			modelo.setValueAt(p.getNombreProducto(), i, 2);
			modelo.setValueAt(p.getGarantiaProducto(), i, 3);
			modelo.setValueAt(p.getPrecioProducto(), i, 4);
			modelo.setValueAt(p.getStockProducto(), i, 5);
			i++;
		}
		tablaProducto.setModel(modelo);
	}
	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
		if (e.getSource() == txtBuscarCliente) {
			do_txtBuscarCliente_keyReleased(e);
		}
		if (e.getSource() == txtIdBuscarProducto) {
			do_txtIdProductoBuscar_keyReleased(e);
		}
	}
	public void keyTyped(KeyEvent e) {
		if (e.getSource() == txtCantidadVenta) {
			do_txtCantidadVenta_keyTyped(e);
		}
		if (e.getSource() == txtIdProductoVenta) {
			do_txtIdProductoVenta_keyTyped(e);
		}
		if (e.getSource() == txtCodEditable) {
			do_txtCodEditable_keyTyped(e);
		}
		if (e.getSource() == txtDniClienteVenta) {
			do_txtDniClienteVenta_keyTyped(e);
		}
		if (e.getSource() == txtTelefonoCliente) {
			do_txtTelefonoCliente_keyTyped(e);
		}
		if (e.getSource() == txtNombreCliente) {
			do_txtNombreCliente_keyTyped(e);
		}
		if (e.getSource() == txtDniCliente) {
			do_txtDniCliente_keyTyped(e);
		}
	}
	protected void do_txtIdProductoBuscar_keyReleased(KeyEvent e) {
		String filtro = txtIdBuscarProducto.getText();
		ListarProducto(filtro);
	}
	protected void do_txtDniCliente_keyTyped(KeyEvent e) {
		char validarNumeros = e.getKeyChar();
		if(Character.isLetter(validarNumeros)) {
			e.consume();
			JOptionPane.showMessageDialog(this, "No permite letras");
		}
	}
	protected void do_txtNombreCliente_keyTyped(KeyEvent e) {
		char validarLetras = e.getKeyChar();
		if(Character.isDigit(validarLetras)) {
			e.consume();
			JOptionPane.showMessageDialog(this, "No permite números");
		}
	}
	protected void do_txtTelefonoCliente_keyTyped(KeyEvent e) {
		char validarNumeros = e.getKeyChar();
		if(Character.isLetter(validarNumeros)) {
			e.consume();
			JOptionPane.showMessageDialog(this, "No permite letras");
		}
	}
	public void ListarCliente(String filtro) {
		DefaultTableModel modelo = new DefaultTableModel();
		MantCliente mc = new MantCliente();
		ArrayList<Cliente> lista = new ArrayList<Cliente>();
		if(filtro.length() == 0) lista = mc.MostrarCliente();
		else lista = mc.ConsultarCliente(filtro);
		
		modelo.setRowCount(lista.size());
		Iterator<Cliente> it = lista.iterator();
	    modelo.addColumn("DNI");
	    modelo.addColumn("Nombre");
	    modelo.addColumn("Teléfono");
		int i = 0;
		
		while (it.hasNext()) {
			Object obj = it.next();
			Cliente c = (Cliente)obj;
	        modelo.setValueAt(c.getDniCliente(), i, 0);
	        modelo.setValueAt(c.getNombreCliente(), i, 1);
	        modelo.setValueAt(c.getTelefonoCliente(), i, 2);
	        i++;
		}
		tablaCliente.setModel(modelo);
	}
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == tablaVenta) {
			do_tablaVenta_mouseClicked(e);
		}
		if (e.getSource() == tablaCliente) {
			do_tablaCliente_mouseClicked(e);
		}
	}
	public void mouseEntered(MouseEvent e) {
	}
	public void mouseExited(MouseEvent e) {
	}
	public void mousePressed(MouseEvent e) {
	}
	public void mouseReleased(MouseEvent e) {
	}
	protected void do_tablaCliente_mouseClicked(MouseEvent e) {
		int fila = tablaCliente.getSelectedRow();
		txtDniCliente.setText(String.valueOf(tablaCliente.getValueAt(fila, 0)));
		txtNombreCliente.setText(String.valueOf(tablaCliente.getValueAt(fila, 1)));
		txtTelefonoCliente.setText(String.valueOf(tablaCliente.getValueAt(fila, 2)));
	}
	protected void do_btnRegistrarCliente_actionPerformed(ActionEvent e) {
		try {
			Cliente c = new Cliente(txtDniCliente.getText(), txtNombreCliente.getText(), txtTelefonoCliente.getText());
			MantCliente mc = new MantCliente();
			mc.AgregarCliente(c);
			ListarCliente("");
			LimpiarCliente();
							
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(this, "Verifique los datos ingresados. Intente de nuevo.");
		}
	}
	protected void do_btnModificarCliente_actionPerformed(ActionEvent e) {
		try {
			Cliente c = new Cliente(txtDniCliente.getText(), txtNombreCliente.getText(), txtTelefonoCliente.getText());
			
			MantCliente mc = new MantCliente();
			mc.ModificarCliente(c);
			ListarCliente(txtDniCliente.getText()); // Solo ese cliente
			tablaCliente.setRowSelectionInterval(0, 0);
			LimpiarCliente();
			
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(this, "Verifique los datos ingresados. Intente de nuevo.");
		}
	}
	void LimpiarCliente() {
		txtDniCliente.setText("");
		txtNombreCliente.setText("");
		txtTelefonoCliente.setText("");
	}
	protected void do_txtBuscarCliente_keyReleased(KeyEvent e) {
		String filtro = txtBuscarCliente.getText();
		ListarCliente(filtro);
	}
	protected void do_btnMostrarCliente_actionPerformed(ActionEvent e) {
		ListarCliente("");
	}
	protected void do_btnBorrarCliente_actionPerformed(ActionEvent e) {
		LimpiarCliente();
	}
	//KeyTyped DNICLiente
	protected void do_txtDniClienteVenta_keyTyped(KeyEvent e) {
		char validarNumeros = e.getKeyChar();
		if(!(Character.isDigit(validarNumeros) || validarNumeros =='\b')) {
			e.consume();
			if(Character.isLetter(validarNumeros)) {
				e.consume();
				JOptionPane.showMessageDialog(this, "No se permite letras.");
			}
			else if(Character.isEmoji(validarNumeros)) {
				e.consume();
				JOptionPane.showMessageDialog(this, "No se permiten símbolos extraños.");
			}
			else if(Character.isWhitespace(validarNumeros)) {
				e.consume();
				JOptionPane.showMessageDialog(this, "No se admiten espacios en blanco.");
			}
			else {
				e.consume();
				JOptionPane.showMessageDialog(this, "Solo se admiten números.");
			}
		}
	}
	protected void do_txtCodEditable_keyTyped(KeyEvent e) {
		char validarNumeros = e.getKeyChar();
		if(!(Character.isDigit(validarNumeros) || validarNumeros =='\b')) {
			e.consume();
			if(Character.isLetter(validarNumeros)) {
				e.consume();
				JOptionPane.showMessageDialog(this, "No se permite letras.");
			}
			else if(Character.isEmoji(validarNumeros)) {
				e.consume();
				JOptionPane.showMessageDialog(this, "No se permiten símbolos extraños.");
			}
			else if(Character.isWhitespace(validarNumeros)) {
				e.consume();
				JOptionPane.showMessageDialog(this, "No se admiten espacios en blanco.");
			}
			else {
				e.consume();
				JOptionPane.showMessageDialog(this, "Solo se admiten números.");
			}
		}
	}
	protected void do_txtIdProductoVenta_keyTyped(KeyEvent e) {
		char validarNumeros = e.getKeyChar();
		if(!(Character.isDigit(validarNumeros) || validarNumeros =='\b')) {
			e.consume();
			if(Character.isLetter(validarNumeros)) {
				e.consume();
				JOptionPane.showMessageDialog(this, "No se permite letras.");
			}
			else if(Character.isEmoji(validarNumeros)) {
				e.consume();
				JOptionPane.showMessageDialog(this, "No se permiten símbolos extraños.");
			}
			else if(Character.isWhitespace(validarNumeros)) {
				e.consume();
				JOptionPane.showMessageDialog(this, "No se admiten espacios en blanco.");
			}
			else {
				e.consume();
				JOptionPane.showMessageDialog(this, "Solo se admiten números.");
			}
		}
	}
	protected void do_txtCantidadVenta_keyTyped(KeyEvent e) {
		char validarNumeros = e.getKeyChar();
		if(!(Character.isDigit(validarNumeros) || validarNumeros =='\b')) {
			e.consume();
			if(Character.isLetter(validarNumeros)) {
				e.consume();
				JOptionPane.showMessageDialog(this, "No se permite letras.");
			}
			else if(Character.isEmoji(validarNumeros)) {
				e.consume();
				JOptionPane.showMessageDialog(this, "No se permiten símbolos extraños.");
			}
			else if(Character.isWhitespace(validarNumeros)) {
				e.consume();
				JOptionPane.showMessageDialog(this, "No se admiten espacios en blanco.");
			}
			else {
				e.consume();
				JOptionPane.showMessageDialog(this, "Solo se admiten números.");
			}
		}
	}
	
	//AGREGAR ESTILOS DE VISUALIZACION
	

	protected void do_btnNewButton_actionPerformed(ActionEvent e) {
		String actual = jlabelmodo.getText();
		if(actual == "Modo Normal") {        
		    contentPane.setBackground(UIManager.getColor("Button.light"));
		    panelCliente.setBackground(UIManager.getColor("Button.light"));
		    panelProducto.setBackground(UIManager.getColor("Button.light"));
		    panelVenta.setBackground(UIManager.getColor("Button.light"));
		    tablaVenta.setBackground(UIManager.getColor("Button.light"));
		    tablaCliente.setBackground(UIManager.getColor("Button.light"));
		    tablaProducto.setBackground(UIManager.getColor("Button.light"));
		    tablaVenta.setForeground(Color.BLACK);
		    tablaCliente.setForeground(Color.BLACK);
		    tablaProducto.setForeground(Color.BLACK);
		    lblIdVendedor.setForeground(Color.BLACK);
		    lblCod.setForeground(Color.BLACK);
		    lblIdProducto.setForeground(Color.BLACK);
		    lblIdProducto_1.setForeground(Color.BLACK);
		    lblDniCliente.setForeground(Color.BLACK);
		    lblTeleCliente.setForeground(Color.BLACK);
		    lblIdNombreCliente.setForeground(Color.BLACK);
		    lblRegistroDeVentas.setForeground(Color.BLACK);
		    lblDni.setForeground(Color.BLACK);
		    lblclock.setForeground(Color.BLACK);
		    lblId.setForeground(Color.BLACK);
		    lblCantidad.setForeground(Color.BLACK);
		    lblNewLabel.setForeground(Color.BLACK);
		    lblComprobante.setForeground(Color.BLACK);
		    lblVendedor.setForeground(Color.BLACK);
		    txtDniClienteVenta.setBackground(Color.WHITE);
		    txtNombreVendedor.setBackground(Color.WHITE);
		    txtCodEditable.setBackground(Color.WHITE);
		    txtIdProductoVenta.setBackground(Color.WHITE);
		    txtCantidadVenta.setBackground(Color.WHITE);
		    txtIdBuscarProducto.setBackground(Color.WHITE);
		    txtBuscarCliente.setBackground(Color.WHITE);
		    txtDniCliente.setBackground(Color.WHITE);
		    txtNombreCliente.setBackground(Color.WHITE);
		    txtTelefonoCliente.setBackground(Color.WHITE);
		    txtDniClienteVenta.setForeground(Color.WHITE);
		    txtNombreVendedor.setForeground(Color.WHITE);
		    txtCodEditable.setForeground(Color.WHITE);
		    txtIdProductoVenta.setForeground(Color.WHITE);
		    txtIdBuscarProducto.setForeground(Color.WHITE);
		    txtBuscarCliente.setForeground(Color.WHITE);
		    txtDniCliente.setForeground(Color.WHITE);
		    txtNombreCliente.setForeground(Color.WHITE);
		    txtTelefonoCliente.setForeground(Color.WHITE);
		    cboComprobante.setBackground(Color.WHITE);
		    cboComprobante.setForeground(Color.BLACK);
		    cboIdVendedor.setBackground(Color.WHITE);
		    cboIdVendedor.setForeground(Color.BLACK);
		    
		    
		      
		    cboTipoPago.setBackground(Color.WHITE);
		    cboComprobante.setBackground(Color.WHITE);
		    txtCantidadVenta.setBackground(Color.WHITE); 
		    txtCantidadVenta.setForeground(Color.BLACK);
		    cboTipoPago.setForeground(Color.BLACK);
		    jlabelmodo.setText("Modo Oscuro");
		}
		else if(actual == "Modo Oscuro"){
		    contentPane.setBackground(Color.BLACK);
		    panelCliente.setBackground(Color.BLACK);
		    panelProducto.setBackground(Color.BLACK);
		    panelVenta.setBackground(Color.BLACK);
		    tablaVenta.setBackground(Color.BLACK);
		    tablaCliente.setBackground(Color.BLACK);
		    tablaProducto.setBackground(Color.BLACK);
		    tablaVenta.setForeground(Color.LIGHT_GRAY);    
		    tablaCliente.setForeground(Color.LIGHT_GRAY);  
		    tablaProducto.setForeground(Color.LIGHT_GRAY); 
		    lblIdVendedor.setForeground(Color.LIGHT_GRAY);
		    lblCod.setForeground(Color.LIGHT_GRAY);
		    lblIdProducto.setForeground(Color.LIGHT_GRAY);
		    lblIdProducto_1.setForeground(Color.LIGHT_GRAY);
		    lblDniCliente.setForeground(Color.LIGHT_GRAY);
		    lblTeleCliente.setForeground(Color.LIGHT_GRAY);
		    lblIdNombreCliente.setForeground(Color.LIGHT_GRAY);
		    lblRegistroDeVentas.setForeground(Color.LIGHT_GRAY);
		    lblDni.setForeground(Color.LIGHT_GRAY);
		    lblId.setForeground(Color.LIGHT_GRAY);
		    lblCantidad.setForeground(Color.LIGHT_GRAY);
		    lblclock.setForeground(Color.LIGHT_GRAY);
		    lblNewLabel.setForeground(Color.LIGHT_GRAY);
		    lblComprobante.setForeground(Color.LIGHT_GRAY);
		    lblVendedor.setForeground(Color.LIGHT_GRAY);
		    txtDniClienteVenta.setBackground(Color.DARK_GRAY);
		    txtNombreVendedor.setBackground(Color.DARK_GRAY);
		    txtCodEditable.setBackground(Color.DARK_GRAY);
		    txtIdProductoVenta.setBackground(Color.DARK_GRAY);
		    txtCantidadVenta.setBackground(Color.DARK_GRAY);
		    txtIdBuscarProducto.setBackground(Color.DARK_GRAY);
		    txtBuscarCliente.setBackground(Color.DARK_GRAY);
		    txtDniCliente.setBackground(Color.DARK_GRAY);
		    txtNombreCliente.setBackground(Color.DARK_GRAY);
		    txtTelefonoCliente.setBackground(Color.DARK_GRAY);
		    txtDniClienteVenta.setForeground(Color.WHITE);
		    txtNombreVendedor.setForeground(Color.WHITE);
		    txtCodEditable.setForeground(Color.WHITE);
		    txtIdProductoVenta.setForeground(Color.WHITE);
		    txtIdBuscarProducto.setForeground(Color.WHITE);
		    txtBuscarCliente.setForeground(Color.WHITE);
		    txtDniCliente.setForeground(Color.WHITE);
		    txtNombreCliente.setForeground(Color.WHITE);
		    txtTelefonoCliente.setForeground(Color.WHITE);
		    cboComprobante.setForeground(Color.WHITE);
		    cboComprobante.setBackground(Color.DARK_GRAY);
		    cboIdVendedor.setForeground(Color.WHITE);
		    cboIdVendedor.setBackground(Color.DARK_GRAY);
		    cboTipoPago.setBackground(Color.DARK_GRAY);
		    txtCantidadVenta.setBackground(Color.DARK_GRAY);		    
		    txtCantidadVenta.setForeground(Color.WHITE);
		    cboTipoPago.setForeground(Color.WHITE);
		    jlabelmodo.setText("Modo Frío");
		}   
		else if(actual == "Modo Frío") {
		    contentPane.setBackground(new Color(10, 25, 45));
		    panelCliente.setBackground(new Color(10, 25, 45));
		    panelProducto.setBackground(new Color(10, 25, 45));
		    panelVenta.setBackground(new Color(10, 25, 45));
		    tablaVenta.setBackground(new Color(10, 25, 45));
		    tablaCliente.setBackground(new Color(10, 25, 45));
		    tablaProducto.setBackground(new Color(10, 25, 45));
		    tablaVenta.setForeground(new Color(150, 220, 255));
		    tablaCliente.setForeground(new Color(150, 220, 255));
		    tablaProducto.setForeground(new Color(150, 220, 255));
		    lblIdVendedor.setForeground(new Color(150, 220, 255));
		    lblCod.setForeground(new Color(150, 220, 255));
		    lblIdProducto.setForeground(new Color(150, 220, 255));
		    lblIdProducto_1.setForeground(new Color(150, 220, 255));
		    lblDniCliente.setForeground(new Color(150, 220, 255));
		    lblTeleCliente.setForeground(new Color(150, 220, 255));
		    lblIdNombreCliente.setForeground(new Color(150, 220, 255)); 
		    lblRegistroDeVentas.setForeground(new Color(150, 220, 255));
		    lblDni.setForeground(new Color(150, 220, 255));
		    lblId.setForeground(new Color(150, 220, 255));
		    lblCantidad.setForeground(new Color(150, 220, 255));
		    lblclock.setForeground(new Color(150, 220, 255));
		    lblNewLabel.setForeground(new Color(150, 220, 255));
		    lblComprobante.setForeground(new Color(150, 220, 255));
		    lblVendedor.setForeground(new Color(150, 220, 255));
		    txtDniClienteVenta.setBackground(new Color(30, 80, 120));
		    txtNombreVendedor.setBackground(new Color(30, 80, 120));
		    txtCodEditable.setBackground(new Color(30, 80, 120));
		    txtIdProductoVenta.setBackground(new Color(30, 80, 120));
		    txtCantidadVenta.setBackground(new Color(30, 80, 120));
		    txtIdBuscarProducto.setBackground(new Color(30, 80, 120));
		    txtBuscarCliente.setBackground(new Color(30, 80, 120));
		    txtDniCliente.setBackground(new Color(30, 80, 120));
		    txtNombreCliente.setBackground(new Color(30, 80, 120));
		    txtTelefonoCliente.setBackground(new Color(30, 80, 120));
		    txtDniClienteVenta.setForeground(Color.WHITE);
		    txtNombreVendedor.setForeground(Color.WHITE);
		    txtCodEditable.setForeground(Color.WHITE);
		    txtIdProductoVenta.setForeground(Color.WHITE);
		    txtIdBuscarProducto.setForeground(Color.WHITE);
		    txtBuscarCliente.setForeground(Color.WHITE);
		    txtDniCliente.setForeground(Color.WHITE);
		    txtNombreCliente.setForeground(Color.WHITE);
		    txtTelefonoCliente.setForeground(Color.WHITE);
		    cboComprobante.setBackground(new Color(30, 80, 120)); 
		    cboComprobante.setForeground(Color.WHITE);            
		    cboIdVendedor.setBackground(new Color(30, 80, 120));  
		    cboIdVendedor.setForeground(Color.WHITE);    
		    
		    
		    
		    cboTipoPago.setBackground(new Color(30, 80, 120));
		    txtCantidadVenta.setBackground(new Color(30, 80, 120));    
		    txtCantidadVenta.setForeground(Color.WHITE);
		    cboTipoPago.setForeground(Color.WHITE);
		    jlabelmodo.setText("Modo Normal");
		}
	}
	
	private ArrayList<Double> listaSubtotales = new ArrayList<>();
	private JScrollPane scrollPane_3;
	private JTextArea txtS;
	private JButton btnBorrar;
	private JButton btnRegistrarVenta;
	private JButton btnEliminarVenta;
	private JLabel lblCodNoEditable;
	private JTextField txtCodNoEditable;
	private JLabel lblIdDetalle;
	private JTextField txtIdDetalle;
	private JButton btnBorrarVenta;
	private JButton btnBorrarCliente;
	private JButton btnMostrarCliente;
	
	protected void do_btnSuma_actionPerformed(ActionEvent e) {
		try {
			double precio = Double.parseDouble(txtPrecioVenta.getText());
	        int cantidad = Integer.parseInt(txtCantVenta.getText());
	        
	        double subtotal = precio * cantidad;
	        listaSubtotales.add(subtotal);
	        
	        txtS.append("Subtotal: S/. " + subtotal + "\n");
	        
	        txtPrecioVenta.setText("");
	        txtCantVenta.setText("");
	      
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(this, "Ingrese un precio y cantidad válidos.");
		}	
	}
	protected void do_btnBorrar_actionPerformed(ActionEvent e) {
		txtS.setText("");
	}
	public void ListarVentasDelDia() {
	    DefaultTableModel modelo = new DefaultTableModel();
	    MantHistorialVentas mhv = new MantHistorialVentas();
	    ArrayList<HistorialVentas> lista = mhv.MostrarVentasDelDia();

	    modelo.addColumn("Código Venta");
	    modelo.addColumn("Detalle");
	    modelo.addColumn("DNI Cliente");
	    modelo.addColumn("Nombre Cliente");
	    modelo.addColumn("Teléfono Cliente");
	    modelo.addColumn("Fecha");
	    modelo.addColumn("Hora");
	    modelo.addColumn("ID Producto");
	    modelo.addColumn("Categoría Producto");
	    modelo.addColumn("Nombre Producto");
	    modelo.addColumn("Garantía");
	    modelo.addColumn("Precio");
	    modelo.addColumn("Cantidad");
	    modelo.addColumn("Tipo Pago");
	    modelo.addColumn("Comprobante");
	    modelo.addColumn("ID Vendedor");
	    modelo.addColumn("Vendedor");
	    modelo.addColumn("Subtotal");
	    modelo.addColumn("Total");

	    modelo.setRowCount(lista.size());
	    int i = 0;

	    for (HistorialVentas hv : lista) {
	        modelo.setValueAt(hv.getVenta().getCodigoVenta(), i, 0);
	        modelo.setValueAt(hv.getDetalleVenta().getIdDetalleVenta(), i, 1);
	        modelo.setValueAt(hv.getVenta().getCliente().getDniCliente(), i, 2);
	        modelo.setValueAt(hv.getVenta().getCliente().getNombreCliente(), i, 3);
	        modelo.setValueAt(hv.getVenta().getCliente().getTelefonoCliente(), i, 4);
	        modelo.setValueAt(hv.getVenta().getFechaVenta(), i, 5);
	        modelo.setValueAt(hv.getVenta().getHoraVenta(), i, 6);
	        modelo.setValueAt(hv.getDetalleVenta().getProducto().getIdProducto(), i, 7);
	        modelo.setValueAt(hv.getDetalleVenta().getProducto().getCategoriaProducto(), i, 8);
	        modelo.setValueAt(hv.getDetalleVenta().getProducto().getNombreProducto(), i, 9);
	        modelo.setValueAt(hv.getDetalleVenta().getProducto().getGarantiaProducto(), i, 10);
	        modelo.setValueAt(hv.getDetalleVenta().getProducto().getPrecioProducto(), i, 11);
	        modelo.setValueAt(hv.getDetalleVenta().getCantidadDetalleVenta(), i, 12);
	        modelo.setValueAt(hv.getVenta().getTipopagoVenta(), i, 13);
	        modelo.setValueAt(hv.getVenta().getComprobanteVenta(), i, 14);
	        modelo.setValueAt(hv.getVenta().getEmpleado().getIdEmpleado(), i, 15);
	        modelo.setValueAt(hv.getVenta().getEmpleado().getNombreEmpleado(), i, 16);
	        modelo.setValueAt(hv.getDetalleVenta().getSubtotalDetalleVenta(), i, 17);
	        modelo.setValueAt(hv.getVenta().getTotalVenta(), i, 18);
	        i++;
	    }

	    tablaVenta.setModel(modelo);
	}
	protected void do_tablaVenta_mouseClicked(MouseEvent e) {
		int fila = tablaVenta.getSelectedRow();
		txtCodNoEditable.setText(String.valueOf(tablaVenta.getValueAt(fila, 0)));
		txtDniClienteVenta.setText(String.valueOf(tablaVenta.getValueAt(fila, 2)));
		cboTipoPago.setSelectedItem(String.valueOf(tablaVenta.getValueAt(fila, 13)));
		cboComprobante.setSelectedItem(String.valueOf(tablaVenta.getValueAt(fila, 14)));
		int idEmpleado = Integer.parseInt(tablaVenta.getValueAt(fila, 15).toString());
		cboIdVendedor.setSelectedItem(idEmpleado);
		txtNombreVendedor.setText(String.valueOf(tablaVenta.getValueAt(fila, 16)));
		txtIdDetalle.setText(String.valueOf(tablaVenta.getValueAt(fila, 1)));
		txtCodEditable.setText(String.valueOf(tablaVenta.getValueAt(fila, 0)));
		txtIdProductoVenta.setText(String.valueOf(tablaVenta.getValueAt(fila, 7)));
		txtCantidadVenta.setText(String.valueOf(tablaVenta.getValueAt(fila, 12)));
	}
	public void itemStateChanged(ItemEvent e) {
		if (e.getSource() == cboIdVendedor) {
			do_cboIdVendedor_itemStateChanged(e);
		}
	}
	protected void do_cboIdVendedor_itemStateChanged(ItemEvent e) {
		String id = cboIdVendedor.getSelectedItem().toString();
		LlenarTexto(id); //para que se llenen los cuadros de texto del interfaz
	}
	public void LlenarTexto(String id) {
		ArrayList<Empleado>lista = new ArrayList<Empleado>();
		MantEmpleado me = new MantEmpleado();
		lista = me.ConsultarEmpleado(id);
		Iterator it = lista.iterator();
		int i = 0;
		while (it.hasNext()) {
			Object obj = it.next();
			Empleado e = (Empleado) obj;
			txtNombreVendedor.setText(e.getNombreEmpleado());
			i++;
		}
	}
	public void LlenarCombo() {
		ArrayList<Empleado>lista = new ArrayList<Empleado>();
		MantEmpleado me = new MantEmpleado();
		lista = me.MostrarEmpleado();
		Iterator<Empleado>it = lista.iterator();
		int i = 0;
		while (it.hasNext()) {
			Object obj = it.next();
			Empleado e = (Empleado) obj;
			cboIdVendedor.addItem(e.getIdEmpleado());
		}
	}

	protected void do_btnRegistrarVenta_actionPerformed(ActionEvent e) {
		try {
			Cliente c = new Cliente(txtDniClienteVenta.getText());
			Empleado emple = new Empleado(Integer.parseInt(cboIdVendedor.getSelectedItem().toString()));
			
			Venta v = new Venta(c, cboTipoPago.getSelectedItem().toString(), 
					cboComprobante.getSelectedItem().toString(), emple);
			
			MantVenta mv = new MantVenta();
			mv.AgregarVenta(v);
			JOptionPane.showMessageDialog(this, "Venta registrada correctamente");
							
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(this, "Verifique los datos ingresados. Intente de nuevo.");
		}
	}
	protected void do_btnRegistrarDetalleVentas_actionPerformed(ActionEvent e) {
		Venta v = new Venta(Integer.parseInt(txtCodEditable.getText()));
		Producto p = new Producto(Integer.parseInt(txtIdProductoVenta.getText()));
		if(p.getStockProducto() < Integer.parseInt(txtCantidadVenta.getText())) {
			JOptionPane.showMessageDialog(this, "Stock Insuficiente");
			return;
		}
		
		DetalleVenta dv = new DetalleVenta(v, p, Integer.parseInt(txtCantidadVenta.getText()));
		
		MantDetalleVenta mdv = new MantDetalleVenta();
		mdv.AgregarDetalleVenta(dv);
		
		MantVenta mv = new MantVenta();
		mv.CalcularTotalVenta(v.getCodigoVenta());
		ListarProducto("");
		JOptionPane.showMessageDialog(this, "Detalle de Venta registrada correctamente");
		ListarVentasDelDia();
		LimpiarVentaCompleta();
		
		
	}
	protected void do_btnModificarVenta_actionPerformed(ActionEvent e) {
		try {
			Cliente c = new Cliente(txtDniClienteVenta.getText());
			Empleado emple = new Empleado(Integer.parseInt(cboIdVendedor.getSelectedItem().toString()));
			
			Venta v = new Venta(Integer.parseInt(txtCodNoEditable.getText()), c, 
					cboTipoPago.getSelectedItem().toString(), 
					cboComprobante.getSelectedItem().toString(), emple);
			
			MantVenta mv = new MantVenta();
	        mv.ModificarVenta(v);
	        ListarVentasDelDia();
	        LimpiarVentaCompleta();
	        
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(this, "Verifique los datos ingresados. Intente de nuevo.");
		}
	}
	protected void do_btnModificarDetalleVenta_actionPerformed(ActionEvent e) {
		try {
			Venta v = new Venta(Integer.parseInt(txtCodEditable.getText()));
			Producto p = new Producto(Integer.parseInt(txtIdProductoVenta.getText()));
			
			DetalleVenta dv = new DetalleVenta(Integer.parseInt(txtIdDetalle.getText()), v, p, 
					Integer.parseInt(txtCantidadVenta.getText()));
			
			MantDetalleVenta mdv = new MantDetalleVenta();
			mdv.ModificarDetalleVenta(dv);
			
			MantVenta mv = new MantVenta();
			mv.CalcularTotalVenta(v.getCodigoVenta());
			ListarProducto("");
			ListarVentasDelDia();
			LimpiarVentaCompleta();
			
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(this, "Verifique los datos del detalle de venta. Intente nuevamente.");
		}
	}
	void LimpiarVentaCompleta() {
		txtCodNoEditable.setText("");
		txtDniClienteVenta.setText("");
		txtIdDetalle.setText("");
		txtCodEditable.setText("");
		txtIdProductoVenta.setText("");
		txtCantidadVenta.setText("");
	}
	protected void do_btnBorrarVenta_actionPerformed(ActionEvent e) {
		LimpiarVentaCompleta();
	}
}

