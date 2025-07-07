package gui;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import clase.Cliente;
import clase.Empleado;
import clase.HistorialVentas;
import clase.Producto;
import clase.Proveedor;
import clase.Venta;
import mantenimiento.MantCliente;
import mantenimiento.MantEmpleado;
import mantenimiento.MantHistorialVentas;
import mantenimiento.MantProducto;
import mantenimiento.MantProveedor;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.JTabbedPane;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.awt.event.MouseEvent;
import javax.swing.JSeparator;
import javax.swing.JSlider;

public class VenAdministrador extends JFrame implements ActionListener, KeyListener, MouseListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblDniE;
	private JLabel lblNombreCompletoE;
	private JLabel lblTelefono;
	private JLabel lblCargo;
	private JLabel lblIdE;
	private JTextField txtIdEmpleado;
	private JTextField txtNombreEmpleado;
	private JTextField txtDniEmpleado;
	private JTextField txtTelefono;
	private JComboBox cboCargo;
	private JLabel lblJornada;
	private JComboBox cboJornada;
	private JLabel lblHorario;
	private JComboBox cboHorario;
	private JButton btnRegistrarEmpleado;
	private JButton btnModificarEmpleado;
	private JLabel lblRegistrarEmpleado;
	private JLabel lblIdBuscarE;
	private JTextField txtBuscarEmple;
	private JLabel lblclock;
	private JScrollPane scrollPane;
	private JButton jlabelmodo;
	private JPanel panelVenta;
	private JScrollPane scrollPane_1;
	private JLabel lblIdBuscarP;
	private JTextField txtIdProdBuscar;
	private JLabel lblRegistrarProducto;
	private JLabel lblIdP;
	private JTextField txtIdProducto;
	private JLabel lblCategoria;
	private JTextField txtCategoria;
	private JLabel lblNombreP;
	private JTextField txtNombreProducto;
	private JLabel lblGarantia;
	private JLabel lblPrecio;
	private JLabel lblCantProducto;
	private JTextField txtCantProducto;
	private JTextField txtPrecio;
	private JButton btnModificarProducto;
	private JLabel lblRegistrarStock;
	private JLabel lblIdStock;
	private JTextField txtIdProdStock;
	private JLabel lblCantStock;
	private JTextField txtCantStock;
	private JButton btnRegistrarStock;
	private JScrollPane scrollPane_2;
	private JLabel lblBuscarHistorial;
	private JTextField txtBuscarHistorialVentas;
	
	private JButton btnRegistrarProducto;
	private JTable tablaProducto;
	private JTextField txtGarantia;
	private JLabel lblSueldo;
	private JTextField txtSueldo;
	private JTable tablaEmpleado;
	private JTable tablaHistorialVentas;
	private JLabel lblHistorialVentas;
	private JLabel lblIdProveedor;
	private JTextField txtIdProveedor;
	private JPanel panelProveedor;
	private JScrollPane scrollPane_3;
	private JTable tablaProveedor;
	private JButton btnRegistrarProveedor;
	private JButton btnModificarProveedor;
	private JTextField txtBuscarProveedor;
	private JLabel lblId;
	private JTextField txtIDProveedor;
	private JLabel lblRuc;
	private JTextField txtRucProveedor;
	private JLabel lblNombre;
	private JTextField txtNombreProveedor;
	private JLabel lblTelfono;
	private JTextField txtTelefonoProveedor;
	private JLabel lblCorreo;
	private JTextField txtCorreoProveedor;
	private JLabel lblDireccin;
	private JTextField txtDireccionProveedor;
	private JLabel lblCorreo_2;
	private JTextField txtEstadoProveedor;
	private JLabel lblNewLabel;
	private JLabel lblEliminarVenta;
	private JLabel lblEliminar;
	private JTextField txtideliminarhistorial;
	private JButton btEliminar;
	private JTabbedPane tabbedPane;
	private JPanel panelEmpleado;
	private JPanel panelProducto;
	public int day;
	public int year;
	public int month;
	public int second;
	public int minute;
	public int hour;
	public String tmam;
	public String fecha;
	public String hora;
	private static Clip clipreproduciendo;
	private JSlider controlvol;
	
	private static FloatControl volumeControl;
	private JTextField txtEstadoEmpleado;
	private JLabel lblEstado;
	private JButton btnBorrarEmpleado;
	private JButton btnMostrarEmpleado;
	private JButton btnBorrarProducto;
	private JButton btnMostrarProducto;
	private JButton btnMostrarProveedor;
	private JButton btnBorrarProveedor;
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
						 month="0"+Integer.toString(mont+1);
					 }
					 else {
						 month=Integer.toString(mont+1);
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
		addMouseListener(this);
		setAlwaysOnTop(true);
		setTitle("Administrador");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1370, 770);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		

		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			
			tabbedPane = new JTabbedPane(JTabbedPane.TOP);
			tabbedPane.addMouseListener(this);
			tabbedPane.setBounds(10, 11, 1336, 712);
			contentPane.add(tabbedPane);
			
			panelEmpleado = new JPanel();
			panelEmpleado.addMouseListener(this);
			tabbedPane.addTab("Empleado", null, panelEmpleado, null);
			panelEmpleado.setLayout(null);
			{
				lblIdBuscarE = new JLabel("Buscar:");
				lblIdBuscarE.setBounds(141, 11, 67, 19);
				panelEmpleado.add(lblIdBuscarE);
				lblIdBuscarE.setFont(new Font("Verdana", Font.PLAIN, 15));
			}
			{
				txtBuscarEmple = new JTextField();
				txtBuscarEmple.addKeyListener(this);
				txtBuscarEmple.setBounds(216, 10, 447, 25);
				panelEmpleado.add(txtBuscarEmple);
				txtBuscarEmple.setBackground(Color.WHITE);
				txtBuscarEmple.setColumns(10);
			}
			{
				lblRegistrarEmpleado = new JLabel("REGISTRAR EMPLEADO");
				lblRegistrarEmpleado.setBounds(183, 60, 203, 19);
				panelEmpleado.add(lblRegistrarEmpleado);
				lblRegistrarEmpleado.setFont(new Font("Tahoma", Font.PLAIN, 19));
			}
			{
				lblIdE = new JLabel("ID:");
				lblIdE.setBounds(183, 100, 45, 19);
				panelEmpleado.add(lblIdE);
				lblIdE.setFont(new Font("Verdana", Font.PLAIN, 15));
			}
			{
				txtIdEmpleado = new JTextField();
				txtIdEmpleado.addKeyListener(this);
				txtIdEmpleado.setBounds(215, 99, 96, 25);
				panelEmpleado.add(txtIdEmpleado);
				txtIdEmpleado.setColumns(10);
			}
			{
				lblDniE = new JLabel("DNI:");
				lblDniE.setBounds(341, 100, 45, 19);
				panelEmpleado.add(lblDniE);
				lblDniE.setFont(new Font("Verdana", Font.PLAIN, 15));
			}
			{
				txtDniEmpleado = new JTextField();
				txtDniEmpleado.addKeyListener(this);
				txtDniEmpleado.setBounds(379, 99, 117, 25);
				panelEmpleado.add(txtDniEmpleado);
				txtDniEmpleado.setColumns(10);
			}
			{
				lblNombreCompletoE = new JLabel("Nombre completo:");
				lblNombreCompletoE.setBounds(183, 139, 158, 19);
				panelEmpleado.add(lblNombreCompletoE);
				lblNombreCompletoE.setFont(new Font("Verdana", Font.PLAIN, 15));
			}
			{
				txtNombreEmpleado = new JTextField();
				txtNombreEmpleado.addKeyListener(this);
				txtNombreEmpleado.setBounds(331, 138, 349, 25);
				panelEmpleado.add(txtNombreEmpleado);
				txtNombreEmpleado.setColumns(10);
			}
			{
				lblTelefono = new JLabel("Teléfono:");
				lblTelefono.setBounds(183, 177, 87, 19);
				panelEmpleado.add(lblTelefono);
				lblTelefono.setFont(new Font("Verdana", Font.PLAIN, 15));
			}
			{
				txtTelefono = new JTextField();
				txtTelefono.addKeyListener(this);
				txtTelefono.setBounds(269, 176, 117, 25);
				panelEmpleado.add(txtTelefono);
				txtTelefono.setColumns(10);
			}
			{
				lblCargo = new JLabel("Cargo:");
				lblCargo.setBounds(396, 179, 69, 19);
				panelEmpleado.add(lblCargo);
				lblCargo.setFont(new Font("Verdana", Font.PLAIN, 15));
			}
			{
				cboCargo = new JComboBox();
				cboCargo.setBounds(456, 177, 117, 25);
				panelEmpleado.add(cboCargo);
				cboCargo.setModel(new DefaultComboBoxModel(new String[] {"Cajero", "Vendedor"}));
				cboCargo.setFont(new Font("Verdana", Font.PLAIN, 15));
			}
			{
				lblJornada = new JLabel("Jornada:");
				lblJornada.setBounds(183, 218, 69, 19);
				panelEmpleado.add(lblJornada);
				lblJornada.setFont(new Font("Verdana", Font.PLAIN, 15));
			}
			{
				cboJornada = new JComboBox();
				cboJornada.setBounds(269, 215, 146, 25);
				panelEmpleado.add(cboJornada);
				cboJornada.setModel(new DefaultComboBoxModel(new String[] {"Tiempo completo", "Medio tiempo"}));
				cboJornada.setFont(new Font("Tahoma", Font.PLAIN, 15));
			}
			{
				lblHorario = new JLabel("Horario:");
				lblHorario.setBounds(425, 218, 69, 19);
				panelEmpleado.add(lblHorario);
				lblHorario.setFont(new Font("Verdana", Font.PLAIN, 15));
			}
			{
				cboHorario = new JComboBox();
				cboHorario.setBounds(490, 215, 173, 25);
				panelEmpleado.add(cboHorario);
				cboHorario.setModel(new DefaultComboBoxModel(new String[] {"7:00 a.m. - 4:00 p.m.", "8:00 a.m. - 5:00 p.m.", "8:00 a.m. - 12:00 a.m.", "9:00 a.m. - 6:00 p.m.", "10:00 a.m. - 7:00 p.m.", "12:00 a.m. - 4:00 p.m.", "1:00 p.m. - 5:00 p.m.", "2:00 p.m. - 6:00 p.m."}));
				cboHorario.setFont(new Font("Tahoma", Font.PLAIN, 15));
			}
			{
				btnRegistrarEmpleado = new JButton("Registrar");
				btnRegistrarEmpleado.setBounds(281, 353, 116, 25);
				panelEmpleado.add(btnRegistrarEmpleado);
				btnRegistrarEmpleado.addActionListener(this);
				btnRegistrarEmpleado.setFont(new Font("Verdana", Font.PLAIN, 13));
			}
			{
				btnModificarEmpleado = new JButton("Modificar");
				btnModificarEmpleado.setBounds(414, 353, 116, 25);
				panelEmpleado.add(btnModificarEmpleado);
				btnModificarEmpleado.addActionListener(this);
				btnModificarEmpleado.setFont(new Font("Verdana", Font.PLAIN, 13));
			}
			{
				jlabelmodo = new JButton("Modo Oscuro");
				jlabelmodo.setBounds(10, 231, 133, 33);
				panelEmpleado.add(jlabelmodo);
				jlabelmodo.setFont(new Font("Verdana", Font.PLAIN, 14));
				{
					scrollPane = new JScrollPane();
					scrollPane.setBounds(10, 400, 1311, 275);
					panelEmpleado.add(scrollPane);
					{
						tablaEmpleado = new JTable();
						tablaEmpleado.addMouseListener(this);
						tablaEmpleado.setFillsViewportHeight(true);
						scrollPane.setViewportView(tablaEmpleado);
					}
				}
				{
					lblSueldo = new JLabel("Sueldo:");
					lblSueldo.setFont(new Font("Verdana", Font.PLAIN, 15));
					lblSueldo.setBounds(183, 260, 69, 19);
					panelEmpleado.add(lblSueldo);
				}
				{
					txtSueldo = new JTextField();
					txtSueldo.addKeyListener(this);
					txtSueldo.setColumns(10);
					txtSueldo.setBounds(269, 259, 117, 25);
					panelEmpleado.add(txtSueldo);
				}
				{
					txtEstadoEmpleado = new JTextField();
					txtEstadoEmpleado.addKeyListener(this);
					txtEstadoEmpleado.setColumns(10);
					txtEstadoEmpleado.setBounds(490, 259, 117, 25);
					panelEmpleado.add(txtEstadoEmpleado);
				}
				{
					lblEstado = new JLabel("Estado:");
					lblEstado.setFont(new Font("Verdana", Font.PLAIN, 15));
					lblEstado.setBounds(427, 260, 69, 19);
					panelEmpleado.add(lblEstado);
				}
				{
					btnBorrarEmpleado = new JButton("Borrar");
					btnBorrarEmpleado.addActionListener(this);
					btnBorrarEmpleado.setFont(new Font("Verdana", Font.PLAIN, 13));
					btnBorrarEmpleado.setBounds(718, 174, 116, 25);
					panelEmpleado.add(btnBorrarEmpleado);
				}
				{
					btnMostrarEmpleado = new JButton("Mostrar");
					btnMostrarEmpleado.addActionListener(this);
					btnMostrarEmpleado.setFont(new Font("Verdana", Font.PLAIN, 13));
					btnMostrarEmpleado.setBounds(1205, 365, 116, 25);
					panelEmpleado.add(btnMostrarEmpleado);
				}
				jlabelmodo.addActionListener(this);
			}
			
			panelProducto = new JPanel();
			panelProducto.addMouseListener(this);
			tabbedPane.addTab("Producto", null, panelProducto, null);
			panelProducto.setLayout(null);
			{
				lblIdBuscarP = new JLabel("Buscar:");
				lblIdBuscarP.setFont(new Font("Verdana", Font.PLAIN, 15));
				lblIdBuscarP.setBounds(119, 11, 69, 19);
				panelProducto.add(lblIdBuscarP);
			}
			{
				txtIdProdBuscar = new JTextField();
				txtIdProdBuscar.addKeyListener(this);
				txtIdProdBuscar.setColumns(10);
				txtIdProdBuscar.setBackground(Color.WHITE);
				txtIdProdBuscar.setBounds(198, 10, 447, 25);
				panelProducto.add(txtIdProdBuscar);
			}
			{
				lblRegistrarProducto = new JLabel("REGISTRAR PRODUCTO");
				lblRegistrarProducto.setFont(new Font("Tahoma", Font.PLAIN, 19));
				lblRegistrarProducto.setBounds(217, 58, 203, 19);
				panelProducto.add(lblRegistrarProducto);
			}
			{
				lblIdP = new JLabel("ID:");
				lblIdP.setFont(new Font("Verdana", Font.PLAIN, 15));
				lblIdP.setBounds(217, 98, 45, 19);
				panelProducto.add(lblIdP);
			}
			{
				txtIdProducto = new JTextField();
				txtIdProducto.addKeyListener(this);
				txtIdProducto.setColumns(10);
				txtIdProducto.setBounds(249, 97, 96, 25);
				panelProducto.add(txtIdProducto);
			}
			{
				lblCategoria = new JLabel("Categoría:");
				lblCategoria.setFont(new Font("Verdana", Font.PLAIN, 15));
				lblCategoria.setBounds(375, 98, 87, 19);
				panelProducto.add(lblCategoria);
			}
			{
				txtCategoria = new JTextField();
				txtCategoria.addKeyListener(this);
				txtCategoria.setColumns(10);
				txtCategoria.setBounds(464, 97, 117, 25);
				panelProducto.add(txtCategoria);
			}
			{
				lblNombreP = new JLabel("Nombre:");
				lblNombreP.setFont(new Font("Verdana", Font.PLAIN, 15));
				lblNombreP.setBounds(217, 137, 87, 19);
				panelProducto.add(lblNombreP);
			}
			{
				txtNombreProducto = new JTextField();
				txtNombreProducto.setColumns(10);
				txtNombreProducto.setBounds(296, 136, 349, 25);
				panelProducto.add(txtNombreProducto);
			}
			{
				lblGarantia = new JLabel("Garantía:");
				lblGarantia.setFont(new Font("Verdana", Font.PLAIN, 15));
				lblGarantia.setBounds(217, 175, 87, 19);
				panelProducto.add(lblGarantia);
			}
			{
				lblPrecio = new JLabel("Precio:");
				lblPrecio.setFont(new Font("Verdana", Font.PLAIN, 15));
				lblPrecio.setBounds(217, 214, 69, 19);
				panelProducto.add(lblPrecio);
			}
			{
				lblCantProducto = new JLabel("Cantidad:");
				lblCantProducto.setFont(new Font("Verdana", Font.PLAIN, 15));
				lblCantProducto.setBounds(423, 215, 87, 19);
				panelProducto.add(lblCantProducto);
			}
			{
				txtCantProducto = new JTextField();
				txtCantProducto.addKeyListener(this);
				txtCantProducto.setColumns(10);
				txtCantProducto.setBounds(528, 213, 117, 25);
				panelProducto.add(txtCantProducto);
			}
			{
				txtPrecio = new JTextField();
				txtPrecio.addKeyListener(this);
				txtPrecio.setColumns(10);
				txtPrecio.setBounds(296, 213, 117, 25);
				panelProducto.add(txtPrecio);
			}
			{
				btnModificarProducto = new JButton("Modificar");
				btnModificarProducto.addActionListener(this);
				btnModificarProducto.setFont(new Font("Verdana", Font.PLAIN, 13));
				btnModificarProducto.setBounds(374, 257, 116, 25);
				panelProducto.add(btnModificarProducto);
			}
			{
				lblRegistrarStock = new JLabel("REGISTRAR STOCK");
				lblRegistrarStock.setFont(new Font("Tahoma", Font.PLAIN, 19));
				lblRegistrarStock.setBounds(217, 308, 203, 19);
				panelProducto.add(lblRegistrarStock);
			}
			{
				lblIdStock = new JLabel("ID:");
				lblIdStock.setFont(new Font("Verdana", Font.PLAIN, 15));
				lblIdStock.setBounds(217, 348, 45, 19);
				panelProducto.add(lblIdStock);
			}
			{
				txtIdProdStock = new JTextField();
				txtIdProdStock.addKeyListener(this);
				txtIdProdStock.setColumns(10);
				txtIdProdStock.setBounds(249, 347, 96, 25);
				panelProducto.add(txtIdProdStock);
			}
			{
				lblCantStock = new JLabel("Cantidad:");
				lblCantStock.setFont(new Font("Verdana", Font.PLAIN, 15));
				lblCantStock.setBounds(375, 348, 87, 19);
				panelProducto.add(lblCantStock);
			}
			{
				txtCantStock = new JTextField();
				txtCantStock.addKeyListener(this);
				txtCantStock.setColumns(10);
				txtCantStock.setBounds(464, 347, 117, 25);
				panelProducto.add(txtCantStock);
			}
			{
				btnRegistrarStock = new JButton("Registrar");
				btnRegistrarStock.addActionListener(this);
				btnRegistrarStock.setFont(new Font("Verdana", Font.PLAIN, 13));
				btnRegistrarStock.setBounds(356, 382, 116, 25);
				panelProducto.add(btnRegistrarStock);
			}
			{
				scrollPane_2 = new JScrollPane();
				scrollPane_2.setBounds(10, 427, 1311, 248);
				panelProducto.add(scrollPane_2);
				{
					tablaProducto = new JTable();
					tablaProducto.addMouseListener(this);
					tablaProducto.setFillsViewportHeight(true);
					scrollPane_2.setViewportView(tablaProducto);
				}
			}
			{
				btnRegistrarProducto = new JButton("Registrar");
				btnRegistrarProducto.addActionListener(this);
				btnRegistrarProducto.setFont(new Font("Verdana", Font.PLAIN, 13));
				btnRegistrarProducto.setBounds(227, 257, 116, 25);
				panelProducto.add(btnRegistrarProducto);
			}
			{
				txtGarantia = new JTextField();
				txtGarantia.setColumns(10);
				txtGarantia.setBounds(295, 174, 118, 25);
				panelProducto.add(txtGarantia);
			}
			{
				lblIdProveedor = new JLabel("ID Proveedor:");
				lblIdProveedor.setFont(new Font("Verdana", Font.PLAIN, 15));
				lblIdProveedor.setBounds(420, 175, 118, 19);
				panelProducto.add(lblIdProveedor);
			}
			{
				txtIdProveedor = new JTextField();
				txtIdProveedor.addKeyListener(this);
				txtIdProveedor.setColumns(10);
				txtIdProveedor.setBounds(528, 174, 117, 25);
				panelProducto.add(txtIdProveedor);
			}
			{
				btnBorrarProducto = new JButton("Borrar");
				btnBorrarProducto.addActionListener(this);
				btnBorrarProducto.setFont(new Font("Verdana", Font.PLAIN, 13));
				btnBorrarProducto.setBounds(689, 172, 116, 25);
				panelProducto.add(btnBorrarProducto);
			}
			{
				btnMostrarProducto = new JButton("Mostrar");
				btnMostrarProducto.addActionListener(this);
				btnMostrarProducto.setFont(new Font("Verdana", Font.PLAIN, 13));
				btnMostrarProducto.setBounds(1205, 392, 116, 25);
				panelProducto.add(btnMostrarProducto);
			}
			{
				panelVenta = new JPanel();
				panelVenta.addMouseListener(this);
				tabbedPane.addTab("Venta", null, panelVenta, null);
				panelVenta.setLayout(null);
				{
					scrollPane_1 = new JScrollPane();
					scrollPane_1.setBounds(10, 182, 1311, 493);
					panelVenta.add(scrollPane_1);
					{
						tablaHistorialVentas = new JTable();
						tablaHistorialVentas.addMouseListener(this);
						tablaHistorialVentas.setFillsViewportHeight(true);
						scrollPane_1.setViewportView(tablaHistorialVentas);
					}
				}
				{
					lblBuscarHistorial = new JLabel("Buscar:");
					lblBuscarHistorial.setFont(new Font("Verdana", Font.PLAIN, 15));
					lblBuscarHistorial.setBounds(121, 106, 82, 19);
					panelVenta.add(lblBuscarHistorial);
				}
				{
					txtBuscarHistorialVentas = new JTextField();
					txtBuscarHistorialVentas.addKeyListener(this);
					txtBuscarHistorialVentas.setColumns(10);
					txtBuscarHistorialVentas.setBackground(Color.WHITE);
					txtBuscarHistorialVentas.setBounds(202, 105, 447, 25);
					panelVenta.add(txtBuscarHistorialVentas);
				}
				{
					lblHistorialVentas = new JLabel("HISTORIAL DE VENTAS");
					lblHistorialVentas.setFont(new Font("Verdana", Font.PLAIN, 25));
					lblHistorialVentas.setBounds(121, 27, 297, 46);
					panelVenta.add(lblHistorialVentas);
				}
				{
					lblEliminarVenta = new JLabel("ELIMINAR  VENTA:");
					lblEliminarVenta.setFont(new Font("Verdana", Font.PLAIN, 25));
					lblEliminarVenta.setBounds(749, 27, 297, 46);
					panelVenta.add(lblEliminarVenta);
				}
				{
					lblEliminar = new JLabel("Cód:");
					lblEliminar.setFont(new Font("Verdana", Font.PLAIN, 15));
					lblEliminar.setBounds(749, 86, 37, 19);
					panelVenta.add(lblEliminar);
				}
				{
					txtideliminarhistorial = new JTextField();
					txtideliminarhistorial.setColumns(10);
					txtideliminarhistorial.setBackground(Color.WHITE);
					txtideliminarhistorial.setBounds(796, 85, 55, 25);
					panelVenta.add(txtideliminarhistorial);
				}
				{
					btEliminar = new JButton("Eliminar");
					btEliminar.setFont(new Font("Verdana", Font.PLAIN, 14));
					btEliminar.addActionListener(this);
					btEliminar.setBounds(861, 84, 109, 25);
					panelVenta.add(btEliminar);
				}
			}
			{
				panelProveedor = new JPanel();
				panelProveedor.addMouseListener(this);
				tabbedPane.addTab("Proveedor", null, panelProveedor, null);
				panelProveedor.setLayout(null);
				{
					scrollPane_3 = new JScrollPane();
					scrollPane_3.setBounds(10, 297, 1311, 378);
					panelProveedor.add(scrollPane_3);
					{
						tablaProveedor = new JTable();
						tablaProveedor.addMouseListener(this);
						tablaProveedor.setFillsViewportHeight(true);
						scrollPane_3.setViewportView(tablaProveedor);
					}
				}
				{
					btnRegistrarProveedor = new JButton("Registrar");
					btnRegistrarProveedor.addActionListener(this);
					btnRegistrarProveedor.setFont(new Font("Verdana", Font.PLAIN, 13));
					btnRegistrarProveedor.setBounds(294, 248, 116, 25);
					panelProveedor.add(btnRegistrarProveedor);
				}
				{
					btnModificarProveedor = new JButton("Modificar");
					btnModificarProveedor.addActionListener(this);
					btnModificarProveedor.setFont(new Font("Verdana", Font.PLAIN, 13));
					btnModificarProveedor.setBounds(441, 248, 116, 25);
					panelProveedor.add(btnModificarProveedor);
				}
				{
					txtBuscarProveedor = new JTextField();
					txtBuscarProveedor.setColumns(10);
					txtBuscarProveedor.setBackground(Color.WHITE);
					txtBuscarProveedor.setBounds(195, 36, 447, 25);
					panelProveedor.add(txtBuscarProveedor);
				}
				{
					lblId = new JLabel("ID:");
					lblId.setFont(new Font("Verdana", Font.PLAIN, 15));
					lblId.setBounds(77, 81, 31, 14);
					panelProveedor.add(lblId);
				}
				{
					txtIDProveedor = new JTextField();
					txtIDProveedor.addKeyListener(this);
					txtIDProveedor.setColumns(10);
					txtIDProveedor.setBackground(Color.WHITE);
					txtIDProveedor.setBounds(106, 78, 78, 25);
					panelProveedor.add(txtIDProveedor);
				}
				{
					lblRuc = new JLabel("RUC:");
					lblRuc.setFont(new Font("Verdana", Font.PLAIN, 15));
					lblRuc.setBounds(229, 81, 44, 14);
					panelProveedor.add(lblRuc);
				}
				{
					txtRucProveedor = new JTextField();
					txtRucProveedor.addKeyListener(this);
					txtRucProveedor.setColumns(10);
					txtRucProveedor.setBackground(Color.WHITE);
					txtRucProveedor.setBounds(283, 78, 164, 25);
					panelProveedor.add(txtRucProveedor);
				}
				{
					lblNombre = new JLabel("NOMBRE:");
					lblNombre.setFont(new Font("Verdana", Font.PLAIN, 15));
					lblNombre.setBounds(478, 81, 84, 14);
					panelProveedor.add(lblNombre);
				}
				{
					txtNombreProveedor = new JTextField();
					txtNombreProveedor.addKeyListener(this);
					txtNombreProveedor.setColumns(10);
					txtNombreProveedor.setBackground(Color.WHITE);
					txtNombreProveedor.setBounds(555, 78, 219, 25);
					panelProveedor.add(txtNombreProveedor);
				}
				{
					lblTelfono = new JLabel("TELÉFONO:");
					lblTelfono.setFont(new Font("Verdana", Font.PLAIN, 15));
					lblTelfono.setBounds(77, 122, 107, 14);
					panelProveedor.add(lblTelfono);
				}
				{
					txtTelefonoProveedor = new JTextField();
					txtTelefonoProveedor.addKeyListener(this);
					txtTelefonoProveedor.setColumns(10);
					txtTelefonoProveedor.setBackground(Color.WHITE);
					txtTelefonoProveedor.setBounds(171, 119, 134, 25);
					panelProveedor.add(txtTelefonoProveedor);
				}
				{
					lblCorreo = new JLabel("CORREO:");
					lblCorreo.setFont(new Font("Verdana", Font.PLAIN, 15));
					lblCorreo.setBounds(331, 122, 78, 14);
					panelProveedor.add(lblCorreo);
				}
				{
					txtCorreoProveedor = new JTextField();
					txtCorreoProveedor.addKeyListener(this);
					txtCorreoProveedor.setColumns(10);
					txtCorreoProveedor.setBackground(Color.WHITE);
					txtCorreoProveedor.setBounds(411, 119, 201, 25);
					panelProveedor.add(txtCorreoProveedor);
				}
				{
					lblDireccin = new JLabel("DIRECCIÓN:");
					lblDireccin.setFont(new Font("Verdana", Font.PLAIN, 15));
					lblDireccin.setBounds(77, 169, 107, 14);
					panelProveedor.add(lblDireccin);
				}
				{
					txtDireccionProveedor = new JTextField();
					txtDireccionProveedor.addKeyListener(this);
					txtDireccionProveedor.setColumns(10);
					txtDireccionProveedor.setBackground(Color.WHITE);
					txtDireccionProveedor.setBounds(185, 166, 178, 25);
					panelProveedor.add(txtDireccionProveedor);
				}
				{
					lblCorreo_2 = new JLabel("ESTADO:");
					lblCorreo_2.setFont(new Font("Verdana", Font.PLAIN, 15));
					lblCorreo_2.setBounds(373, 172, 78, 14);
					panelProveedor.add(lblCorreo_2);
				}
				{
					txtEstadoProveedor = new JTextField();
					txtEstadoProveedor.addKeyListener(this);
					txtEstadoProveedor.setColumns(10);
					txtEstadoProveedor.setBackground(Color.WHITE);
					txtEstadoProveedor.setBounds(465, 169, 134, 25);
					panelProveedor.add(txtEstadoProveedor);
				}
				{
					lblNewLabel = new JLabel("BUSCAR:");
					lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 15));
					lblNewLabel.setBounds(106, 42, 84, 14);
					panelProveedor.add(lblNewLabel);
				}
				{
					btnMostrarProveedor = new JButton("Mostrar");
					btnMostrarProveedor.addActionListener(this);
					btnMostrarProveedor.setFont(new Font("Verdana", Font.PLAIN, 13));
					btnMostrarProveedor.setBounds(1205, 267, 116, 25);
					panelProveedor.add(btnMostrarProveedor);
				}
				{
					btnBorrarProveedor = new JButton("Borrar");
					btnBorrarProveedor.addActionListener(this);
					btnBorrarProveedor.setFont(new Font("Verdana", Font.PLAIN, 13));
					btnBorrarProveedor.setBounds(675, 134, 116, 25);
					panelProveedor.add(btnBorrarProveedor);
				}
			}
			lblclock = new JLabel("");
			lblclock.setBounds(579, 10, 256, 19);
			contentPane.add(lblclock);
			lblclock.setFont(new Font("Tahoma", Font.PLAIN, 15));
			
		    clock();
		}
		ListarProducto("");
		ListarEmpleado("");
		ListarHistorialVentas("");
		ListarProveedor("");
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnModificarProveedor) {
			do_btnModificarProveedor_actionPerformed(e);
		}
		if (e.getSource() == btnBorrarProveedor) {
			do_btnBorrarProveedor_actionPerformed(e);
		}
		if (e.getSource() == btnMostrarProveedor) {
			do_btnMostrarProveedor_actionPerformed(e);
		}
		if (e.getSource() == btnBorrarProducto) {
			do_btnBorrarProducto_actionPerformed(e);
		}
		if (e.getSource() == btnMostrarProducto) {
			do_btnMostrarProducto_actionPerformed(e);
		}
		if (e.getSource() == btnBorrarEmpleado) {
			do_btnBorrarEmpleado_actionPerformed(e);
		}
		if (e.getSource() == btnMostrarEmpleado) {
			do_btnMostrarEmpleado_actionPerformed(e);
		}
		if (e.getSource() == btEliminar) {
			do_btEliminar_actionPerformed(e);
		}
		if (e.getSource() == btnRegistrarProveedor) {
			do_btnRegistrarProveedor_actionPerformed(e);
		}
		if (e.getSource() == btnRegistrarStock) {
			do_btnRegistrarStock_actionPerformed(e);
		}
		if (e.getSource() == btnModificarProducto) {
			do_btnModificarProducto_actionPerformed(e);
		}
		if (e.getSource() == btnRegistrarProducto) {
			do_btnRegistrarProducto_actionPerformed(e);
		}
		if (e.getSource() == jlabelmodo) {
			do_btnNewButton_actionPerformed(e);
		}
		if (e.getSource() == btnModificarEmpleado) {
			do_btnModificarEmpleado_actionPerformed(e);
		}
		if (e.getSource() == btnRegistrarEmpleado) {
			do_btnRegistrarEmpleado_actionPerformed(e);
		}
	}
	
	public void keyPressed(KeyEvent e) {
		if (e.getSource() == txtBuscarHistorialVentas) {
			do_txtBuscarHistorialVentas_keyPressed(e);
		}
	}
	public void keyReleased(KeyEvent e) {
		if (e.getSource() == txtBuscarEmple) {
			do_txtIdEmpleBuscar_keyReleased(e);
		}
		if (e.getSource() == txtIdProdBuscar) {
			do_txtIdProdBuscar_keyReleased(e);
		}
	}
	public void keyTyped(KeyEvent e) {
		if (e.getSource() == txtEstadoEmpleado) {
			do_txtEstadoEmpleado_keyTyped(e);
		}
		if (e.getSource() == txtNombreProveedor) {
			do_txtNombreProveedor_keyTyped(e);
		}
		if (e.getSource() == txtTelefonoProveedor) {
			do_txtTelefonoProveedor_keyTyped(e);
		}
		if (e.getSource() == txtRucProveedor) {
			do_txtRucProveedor_keyTyped(e);
		}
		if (e.getSource() == txtIDProveedor) {
			do_txtIDProveedor_keyTyped(e);
		}
		if (e.getSource() == txtIdProveedor) {
			do_txtIdProveedor_keyTyped(e);
		}
		if (e.getSource() == txtSueldo) {
			do_txtSueldo_keyTyped(e);
		}
		if (e.getSource() == txtTelefono) {
			do_txtTelefono_keyTyped(e);
		}
		if (e.getSource() == txtNombreEmpleado) {
			do_txtNombreEmpleado_keyTyped(e);
		}
		if (e.getSource() == txtDniEmpleado) {
			do_txtDniEmpleado_keyTyped(e);
		}
		if (e.getSource() == txtIdEmpleado) {
			do_txtIdEmpleado_keyTyped(e);
		}
		if (e.getSource() == txtCantStock) {
			do_txtCantStock_keyTyped(e);
		}
		if (e.getSource() == txtIdProdStock) {
			do_txtIdProdStock_keyTyped(e);
		}
		if (e.getSource() == txtCantProducto) {
			do_txtCantProducto_keyTyped(e);
		}
		if (e.getSource() == txtPrecio) {
			do_txtPrecio_keyTyped(e);
		}
		if (e.getSource() == txtCategoria) {
			do_txtCategoria_keyTyped(e);
		}
		if (e.getSource() == txtIdProducto) {
			do_txtIdProducto_keyTyped(e);
		}
	}
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == panelProveedor) {
			try {
				do_panelProveedor_mouseClicked(e);
			} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if (e.getSource() == panelVenta) {
			try {
				do_panelVenta_mouseClicked(e);
			} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if (e.getSource() == panelProducto) {
			try {
				do_panelProducto_mouseClicked(e);
			} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if (e.getSource() == panelEmpleado) {
			try {
				do_panelEmpleado_mouseClicked(e);
			} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if (e.getSource() == this) {
			do_this_mouseClicked(e);
		}
		if (e.getSource() == tabbedPane) {
			try {
				do_tabbedPane_mouseClicked(e);
			} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if (e.getSource() == tablaHistorialVentas) {
			do_tablaHistorialVentas_mouseClicked(e);
		}
		if (e.getSource() == tablaProveedor) {
			do_tablaProveedor_mouseClicked(e);
		}
		if (e.getSource() == tablaEmpleado) {
			do_tablaEmpleado_mouseClicked(e);
		}
		if (e.getSource() == tablaProducto) {
			do_tablaProducto_mouseClicked(e);
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
	//                                                                                             EMPLEADO
	protected void do_txtIdEmpleado_keyTyped(KeyEvent e) {
		//para que solamente acepte ingresar números
		char validarNumeros = e.getKeyChar();
		if(Character.isLetter(validarNumeros)) {
			e.consume();
			JOptionPane.showMessageDialog(this, "No permite letras");
		}
	}
	protected void do_txtDniEmpleado_keyTyped(KeyEvent e) {
		//para que solamente acepte ingresar números
		char validarNumeros = e.getKeyChar();
		if(Character.isLetter(validarNumeros)) {
			e.consume();
			JOptionPane.showMessageDialog(this, "No permite letras");
		}
	}
	protected void do_txtNombreEmpleado_keyTyped(KeyEvent e) {
		//para que solamente acepte ingresar letras
		char validarLetras = e.getKeyChar();
		if(Character.isDigit(validarLetras)) {
			e.consume();
			JOptionPane.showMessageDialog(this, "No permite números");
		}
	}
	protected void do_txtTelefono_keyTyped(KeyEvent e) {
		//para que solamente acepte ingresar números
		char validarNumeros = e.getKeyChar();
		if(Character.isLetter(validarNumeros)) {
			e.consume();
			JOptionPane.showMessageDialog(this, "No permite letras");
		}
	}
	protected void do_txtSueldo_keyTyped(KeyEvent e) {
		//para que solamente acepte ingresar números
		char validarNumeros = e.getKeyChar();
		if(Character.isLetter(validarNumeros)) {
			e.consume();
			JOptionPane.showMessageDialog(this, "No permite letras");
		}
	}
	protected void do_txtEstadoEmpleado_keyTyped(KeyEvent e) {
		//para que solamente acepte ingresar letras
		char validarLetras = e.getKeyChar();
		if(Character.isDigit(validarLetras)) {
			e.consume();
			JOptionPane.showMessageDialog(this, "No permite números");
		}
	}
	public void ListarEmpleado(String filtro) {
		DefaultTableModel modelo = new DefaultTableModel();
		MantEmpleado me = new MantEmpleado();
		ArrayList<Empleado> lista = new ArrayList<Empleado>();
		if(filtro.length() == 0) lista = me.MostrarEmpleado();
		else lista = me.ConsultarEmpleado(filtro);
		
		modelo.setRowCount(lista.size());
		Iterator<Empleado> it = lista.iterator();
	    modelo.addColumn("ID");
	    modelo.addColumn("DNI");
	    modelo.addColumn("Nombre");
	    modelo.addColumn("Teléfono");
	    modelo.addColumn("Fecha");
	    modelo.addColumn("Cargo");
	    modelo.addColumn("Jornada");
	    modelo.addColumn("Horario");
	    modelo.addColumn("Sueldo");
	    modelo.addColumn("Estado");
		int i = 0;
		
		while (it.hasNext()) {
			Object obj = it.next();
			Empleado e = (Empleado)obj;
	        modelo.setValueAt(e.getIdEmpleado(), i, 0);
	        modelo.setValueAt(e.getDniEmpleado(), i, 1);
	        modelo.setValueAt(e.getNombreEmpleado(), i, 2);
	        modelo.setValueAt(e.getTelefonoEmpleado(), i, 3);
	        modelo.setValueAt(e.getFechaEmpleado(), i, 4);
	        modelo.setValueAt(e.getCargoEmpleado(), i, 5);
	        modelo.setValueAt(e.getJornadaEmpleado(), i, 6);
	        modelo.setValueAt(e.getHorarioEmpleado(), i, 7);
	        modelo.setValueAt(e.getSueldoEmpleado(), i, 8);
	        modelo.setValueAt(e.getEstadoEmpleado(), i, 9);
	        i++;
		}
		tablaEmpleado.setModel(modelo);
	}
	protected void do_tablaEmpleado_mouseClicked(MouseEvent e) {
		int fila = tablaEmpleado.getSelectedRow();
		txtIdEmpleado.setText(String.valueOf(tablaEmpleado.getValueAt(fila, 0)));
		txtDniEmpleado.setText(String.valueOf(tablaEmpleado.getValueAt(fila, 1)));
		txtNombreEmpleado.setText(String.valueOf(tablaEmpleado.getValueAt(fila, 2)));
		txtTelefono.setText(String.valueOf(tablaEmpleado.getValueAt(fila, 3)));
		cboCargo.setSelectedItem(String.valueOf(tablaEmpleado.getValueAt(fila, 5)));
		cboJornada.setSelectedItem(String.valueOf(tablaEmpleado.getValueAt(fila, 6)));
		cboHorario.setSelectedItem(String.valueOf(tablaEmpleado.getValueAt(fila, 7)));
		txtSueldo.setText(String.valueOf(tablaEmpleado.getValueAt(fila, 8)));
		txtEstadoEmpleado.setText(String.valueOf(tablaEmpleado.getValueAt(fila, 9)));
	}
	protected void do_btnRegistrarEmpleado_actionPerformed(ActionEvent e) {
		try {
			Date fecha = java.sql.Date.valueOf(LocalDate.now());
			Empleado emple = new Empleado(Integer.parseInt(txtIdEmpleado.getText()), 
					txtDniEmpleado.getText(), txtNombreEmpleado.getText(), 
					txtTelefono.getText(), fecha, cboCargo.getSelectedItem().toString(), 
					cboJornada.getSelectedItem().toString(), cboHorario.getSelectedItem().toString(), 
					Double.parseDouble(txtSueldo.getText()), txtEstadoEmpleado.getText());
			
			MantEmpleado me = new MantEmpleado();
			me.AgregarEmpleado(emple);
			ListarEmpleado("");
			LimpiarEmpleado();

		} catch (Exception e2) {
			JOptionPane.showMessageDialog(this, "Verifique los datos ingresados. Intente de nuevo.");
		}	
	}
	protected void do_btnModificarEmpleado_actionPerformed(ActionEvent e) {
		try {
			Date fecha = java.sql.Date.valueOf(LocalDate.now());
			Empleado emple = new Empleado(Integer.parseInt(txtIdEmpleado.getText()), 
					txtDniEmpleado.getText(), txtNombreEmpleado.getText(), 
					txtTelefono.getText(), fecha, cboCargo.getSelectedItem().toString(), 
					cboJornada.getSelectedItem().toString(), cboHorario.getSelectedItem().toString(), 
					Double.parseDouble(txtSueldo.getText()), txtEstadoEmpleado.getText());
				
			 MantEmpleado me = new MantEmpleado();
			 me.ModificarEmpleado(emple);
			 ListarEmpleado(txtIdEmpleado.getText()); // Solo se mostrará ese empleado
			 tablaEmpleado.setRowSelectionInterval(0, 0);
			 LimpiarEmpleado();
		}
		catch(Exception e2){
			JOptionPane.showMessageDialog(this, "Verifique los datos ingresados. Intente de nuevo.");
		}
	}
	void LimpiarEmpleado() {
		txtIdEmpleado.setText("");
		txtDniEmpleado.setText("");
		txtNombreEmpleado.setText("");
		txtTelefono.setText("");
		txtSueldo.setText("");
		txtEstadoEmpleado.setText("");
	}
	protected void do_txtIdEmpleBuscar_keyReleased(KeyEvent e) {
		String filtro = txtBuscarEmple.getText();
		ListarEmpleado(filtro);
	}
	protected void do_btnMostrarEmpleado_actionPerformed(ActionEvent e) {
		ListarEmpleado("");
	}
	protected void do_btnBorrarEmpleado_actionPerformed(ActionEvent e) {
		LimpiarEmpleado();
	}
	//                                                                                             PRODUCTO
	protected void do_txtIdProducto_keyTyped(KeyEvent e) {
		//para que solamente acepte ingresar números
		char validarNumeros = e.getKeyChar();
		if(Character.isLetter(validarNumeros)) {
			e.consume();
			JOptionPane.showMessageDialog(this, "No permite letras");
		}	
	}
	protected void do_txtCategoria_keyTyped(KeyEvent e) {
		//para que solamente acepte ingresar letras
		char validarLetras = e.getKeyChar();
		if(Character.isDigit(validarLetras)) {
			e.consume();
			JOptionPane.showMessageDialog(this, "No permite números");
		}
	}
	protected void do_txtIdProveedor_keyTyped(KeyEvent e) {
		//para que solamente acepte ingresar números
		char validarNumeros = e.getKeyChar();
		if(Character.isLetter(validarNumeros)) {
			e.consume();
			JOptionPane.showMessageDialog(this, "No permite letras");
		}
	}
	protected void do_txtPrecio_keyTyped(KeyEvent e) {
		//para que solamente acepte ingresar números
		char validarNumeros = e.getKeyChar();
		if(Character.isLetter(validarNumeros)) {
			e.consume();
			JOptionPane.showMessageDialog(this, "No permite letras");
		}
	}
	protected void do_txtCantProducto_keyTyped(KeyEvent e) {
		//para que solamente acepte ingresar números
		char validarNumeros = e.getKeyChar();
		if(Character.isLetter(validarNumeros)) {
			e.consume();
			JOptionPane.showMessageDialog(this, "No permite letras");
		}
	}
	protected void do_txtIdProdStock_keyTyped(KeyEvent e) {
		//para que solamente acepte ingresar números
		char validarNumeros = e.getKeyChar();
		if(Character.isLetter(validarNumeros)) {
			e.consume();
			JOptionPane.showMessageDialog(this, "No permite letras");
		}
	}
	protected void do_txtCantStock_keyTyped(KeyEvent e) {
		//para que solamente acepte ingresar números
		char validarNumeros = e.getKeyChar();
		if(Character.isLetter(validarNumeros)) {
			e.consume();
			JOptionPane.showMessageDialog(this, "No permite letras");
		}
	}
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
		modelo.addColumn("ID Proveedor");
		modelo.addColumn("Nombre Proveedor");
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
			modelo.setValueAt(p.getProveedor().getIdProveedor(), i, 4);
			modelo.setValueAt(p.getProveedor().getNombreProveedor(), i, 5);
			modelo.setValueAt(p.getPrecioProducto(), i, 6);
			modelo.setValueAt(p.getStockProducto(), i, 7);
			i++;
		}
		tablaProducto.setModel(modelo);
	}
	protected void do_tablaProducto_mouseClicked(MouseEvent e) {
		int fila = tablaProducto.getSelectedRow();
		txtIdProducto.setText(String.valueOf(tablaProducto.getValueAt(fila, 0)));
		txtCategoria.setText(String.valueOf(tablaProducto.getValueAt(fila, 1)));
		txtNombreProducto.setText(String.valueOf(tablaProducto.getValueAt(fila, 2)));
		txtGarantia.setText(String.valueOf(tablaProducto.getValueAt(fila, 3)));
		txtIdProveedor.setText(String.valueOf(tablaProducto.getValueAt(fila, 4)));
		txtPrecio.setText(String.valueOf(tablaProducto.getValueAt(fila, 6)));
		txtCantProducto.setText(String.valueOf(tablaProducto.getValueAt(fila, 7)));
	}
	protected void do_btnRegistrarProducto_actionPerformed(ActionEvent e) {
		try {
			int idProveedor = Integer.parseInt(txtIdProveedor.getText());
			Proveedor proveedor = new Proveedor(idProveedor);
			Producto p = new Producto(Integer.parseInt(txtIdProducto.getText()), 
					txtCategoria.getText(), txtNombreProducto.getText(), 
					txtGarantia.getText(), proveedor , Double.parseDouble(txtPrecio.getText()), 
					Integer.parseInt(txtCantProducto.getText()));
			
			MantProducto mp = new MantProducto();
			mp.AgregarProducto(p);
			ListarProducto("");
			LimpiarProducto();
							
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(this, "Verifique los datos ingresados. Intente de nuevo.");
		}
	}
	protected void do_btnModificarProducto_actionPerformed(ActionEvent e) {
		try {
			int idProveedor = Integer.parseInt(txtIdProveedor.getText());
			Proveedor proveedor = new Proveedor(idProveedor);
			 Producto p = new Producto(Integer.parseInt(txtIdProducto.getText()), 
					 txtCategoria.getText(), txtNombreProducto.getText(), 
					 txtGarantia.getText(), proveedor, Double.parseDouble(txtPrecio.getText()), 
					 Integer.parseInt(txtCantProducto.getText()));
				
			 MantProducto mp = new MantProducto();
			 mp.ModificarProducto(p);
			 ListarProducto(txtIdProducto.getText()); // Solo se mostrará ese producto
			 tablaProducto.setRowSelectionInterval(0, 0);
			 LimpiarProducto();
			 
		 } catch(Exception e2){
			 JOptionPane.showMessageDialog(this, "Verifique el ID ingresado. Intente de nuevo.");	 
		 }	 
	}
	void LimpiarProducto() {
		txtIdProducto.setText("");
		txtCategoria.setText("");
		txtNombreProducto.setText("");
		txtGarantia.setText("");
		txtPrecio.setText("");
		txtIdProveedor.setText("");
		txtCantProducto.setText("");
	}
	protected void do_btnRegistrarStock_actionPerformed(ActionEvent e) {	
		try {
			Producto p = new Producto(Integer.parseInt(txtIdProdStock.getText()), Integer.parseInt(txtCantStock.getText()));
			MantProducto mp = new MantProducto();
			mp.AumentarStock(p);
			ListarProducto("");
			LimpiarProductoStock();
			
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(this, "Verifique los datos ingresados. Intente de nuevo.");
		}

	}
	void LimpiarProductoStock() {
		txtIdProdStock.setText("");
		txtCantStock.setText("");
	}
	protected void do_txtIdProdBuscar_keyReleased(KeyEvent e) {
		String filtro = txtIdProdBuscar.getText();
		ListarProducto(filtro);
	}
	protected void do_btnMostrarProducto_actionPerformed(ActionEvent e) {
		ListarProducto("");
	}
	protected void do_btnBorrarProducto_actionPerformed(ActionEvent e) {
		LimpiarProducto();
		LimpiarProductoStock();
	}
	//                                                                                             HISTORIAL VENTA
	public void ListarHistorialVentas(String filtro) {
	    DefaultTableModel modelo = new DefaultTableModel();
	    MantHistorialVentas mhv = new MantHistorialVentas();
	    ArrayList<HistorialVentas> lista = new ArrayList<HistorialVentas>();
		if(filtro.length() == 0) lista = mhv.ConsultarHistorialVentas(filtro);
		else lista = mhv.ConsultarHistorialVentas(filtro);

	    modelo.addColumn("ID Venta");
	    modelo.addColumn("ID Detalle");
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

	    tablaHistorialVentas.setModel(modelo);
	}
	protected void do_txtBuscarHistorialVentas_keyPressed(KeyEvent e) {
		String filtro = txtBuscarHistorialVentas.getText();
		ListarHistorialVentas(filtro);
	}
	protected void do_tablaHistorialVentas_mouseClicked(MouseEvent e) {
		int fila = tablaHistorialVentas.getSelectedRow();
		txtideliminarhistorial.setText(String.valueOf(tablaHistorialVentas.getValueAt(fila, 0)));

	}
	protected void do_btEliminar_actionPerformed(ActionEvent e) {
		
		try {
			MantHistorialVentas mv = new MantHistorialVentas();
			mv.EliminarHistorial(Integer.parseInt(txtideliminarhistorial.getText()));
		ListarHistorialVentas("");
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(this, "Verifique los datos ingresados. Intente de nuevo.");
		}
	}
	//                                                                                             PROVEEDOR
	protected void do_txtIDProveedor_keyTyped(KeyEvent e) {
		//para que solamente acepte ingresar números
		char validarNumeros = e.getKeyChar();
		if(Character.isLetter(validarNumeros)) {
			e.consume();
			JOptionPane.showMessageDialog(this, "No permite letras");
		}
	}
	protected void do_txtRucProveedor_keyTyped(KeyEvent e) {
		//para que solamente acepte ingresar números
		char validarNumeros = e.getKeyChar();
		if(Character.isLetter(validarNumeros)) {
			e.consume();
			JOptionPane.showMessageDialog(this, "No permite letras");
		}
	}
	protected void do_txtTelefonoProveedor_keyTyped(KeyEvent e) {
		//para que solamente acepte ingresar números
		char validarNumeros = e.getKeyChar();
		if(Character.isLetter(validarNumeros)) {
			e.consume();
			JOptionPane.showMessageDialog(this, "No permite letras");
		}
	}

	protected void do_txtNombreProveedor_keyTyped(KeyEvent e) {
		//para que solamente acepte ingresar letras
		char validarLetras = e.getKeyChar();
		if(Character.isDigit(validarLetras)) {
			e.consume();
			JOptionPane.showMessageDialog(this, "No permite números");
		}
	}

	protected void do_txtEstadoProveedor_keyTyped(KeyEvent e) {
		//para que solamente acepte ingresar letras
		char validarLetras = e.getKeyChar();
		if(Character.isDigit(validarLetras)) {
			e.consume();
			JOptionPane.showMessageDialog(this, "No permite números");
		}
	}
	public void ListarProveedor(String filtro) {
		DefaultTableModel modelo = new DefaultTableModel();
		MantProveedor mprov = new MantProveedor();
		ArrayList<Proveedor> lista = new ArrayList<Proveedor>();
		if(filtro.length() == 0) lista = mprov.MostrarProveedor();
		else lista = mprov.ConsultarProveedor(filtro);

		modelo.addColumn("ID");
		modelo.addColumn("RUC");
		modelo.addColumn("Nombre");
		modelo.addColumn("Teléfono");
		modelo.addColumn("Correo");
		modelo.addColumn("Dirección");
		modelo.addColumn("Estado");
		modelo.addColumn("Fecha");

		modelo.setRowCount(lista.size());
		int i = 0;

		for (Proveedor pro : lista) {
			modelo.setValueAt(pro.getIdProveedor(), i, 0);
			modelo.setValueAt(pro.getRucProveedor(), i, 1);
			modelo.setValueAt(pro.getNombreProveedor(), i, 2);
			modelo.setValueAt(pro.getTelefonoProveedor(), i, 3);
			modelo.setValueAt(pro.getCorreoProveedor(), i, 4);
			modelo.setValueAt(pro.getDireccionProveedor(), i, 5);
			modelo.setValueAt(pro.getEstadoProveedor(), i, 6);
			modelo.setValueAt(pro.getFechaProveedor(), i, 7);
			i++;	
		}

	  tablaProveedor.setModel(modelo);
	}
	protected void do_tablaProveedor_mouseClicked(MouseEvent e) {
		int fila = tablaProveedor.getSelectedRow();
		txtIDProveedor.setText(String.valueOf(tablaProveedor.getValueAt(fila, 0)));
		txtRucProveedor.setText(String.valueOf(tablaProveedor.getValueAt(fila, 1)));
		txtNombreProveedor.setText(String.valueOf(tablaProveedor.getValueAt(fila, 2)));
		txtTelefonoProveedor.setText(String.valueOf(tablaProveedor.getValueAt(fila, 3)));
		txtCorreoProveedor.setText(String.valueOf(tablaProveedor.getValueAt(fila, 4)));
		txtDireccionProveedor.setText(String.valueOf(tablaProveedor.getValueAt(fila, 5)));
		txtEstadoProveedor.setText(String.valueOf(tablaProveedor.getValueAt(fila, 6)));
	}
	protected void do_btnRegistrarProveedor_actionPerformed(ActionEvent e) {
		try {
			Date fecha = java.sql.Date.valueOf(LocalDate.now());
			Proveedor prov = new Proveedor(Integer.parseInt(txtIDProveedor.getText()), 
					txtRucProveedor.getText(), txtNombreProveedor.getText(), 
					txtTelefonoProveedor.getText(), txtCorreoProveedor.getText(), 
					txtDireccionProveedor.getText(), txtEstadoProveedor.getText(), fecha);
			
			MantProveedor mprov = new MantProveedor();
			mprov.AgregarProveedor(prov);
			ListarProveedor("");
			LimpiarProveedor();
							
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(this, "Verifique los datos ingresados. Intente de nuevo.");
		}
	}
	protected void do_btnModificarProveedor_actionPerformed(ActionEvent e) {
		try {
			Date fecha = java.sql.Date.valueOf(LocalDate.now());
			Proveedor prov = new Proveedor(Integer.parseInt(txtIDProveedor.getText()), 
					txtRucProveedor.getText(), txtNombreProveedor.getText(), 
					txtTelefonoProveedor.getText(), txtCorreoProveedor.getText(), 
					txtDireccionProveedor.getText(), txtEstadoProveedor.getText(), fecha);
			
			MantProveedor mprov = new MantProveedor();
			mprov.ModificarProveedor(prov);
			ListarProveedor(txtIDProveedor.getText()); // Solo se mostrará ese proveedor
			tablaProveedor.setRowSelectionInterval(0, 0);
			LimpiarProveedor();
			
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(this, "Verifique los datos ingresados. Intente de nuevo.");
		}
	}
	void LimpiarProveedor() {
		txtIDProveedor.setText("");
		txtRucProveedor.setText("");
		txtNombreProveedor.setText("");
		txtTelefonoProveedor.setText("");
		txtCorreoProveedor.setText("");
		txtDireccionProveedor.setText("");
		txtEstadoProveedor.setText("");
	}
	protected void do_btnMostrarProveedor_actionPerformed(ActionEvent e) {
		ListarProveedor("");
	}
	protected void do_btnBorrarProveedor_actionPerformed(ActionEvent e) {
		LimpiarProveedor();
	}
	//                                                                                             MÚSICA
	
	protected void do_tabbedPane_mouseClicked(MouseEvent e) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		URL url = Inicio.class.getResource("/recursos/ErrorW.wav");
		if(url == null) {
			JOptionPane.showMessageDialog(null,"No se encontró");
		}
		AudioInputStream audiostream= AudioSystem.getAudioInputStream(url);
		clipreproduciendo = AudioSystem.getClip();
		clipreproduciendo.open(audiostream);
		 volumeControl = (FloatControl) clipreproduciendo.getControl(FloatControl.Type.MASTER_GAIN);
		 setVolume(0);  
		 clipreproduciendo.start();
	}
	private static void setVolume(int volume) {
	    if (volumeControl != null) {
	        float min = volumeControl.getMinimum();
	        float max = volumeControl.getMaximum();
	        float dB = (float) (min + (max - min) * (volume / 100.0));
	        volumeControl.setValue(dB);
	    }
	}
	protected void do_this_mouseClicked(MouseEvent e) {
	}
	protected void do_panelEmpleado_mouseClicked(MouseEvent e) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		URL url = Inicio.class.getResource("/recursos/ErrorW.wav");
		if(url == null) {
			JOptionPane.showMessageDialog(null,"No se encontró");
		}
		AudioInputStream audiostream= AudioSystem.getAudioInputStream(url);
		clipreproduciendo = AudioSystem.getClip();
		clipreproduciendo.open(audiostream);
		 volumeControl = (FloatControl) clipreproduciendo.getControl(FloatControl.Type.MASTER_GAIN);
		 setVolume(50);  
		 clipreproduciendo.start();
	}
	protected void do_panelProducto_mouseClicked(MouseEvent e) throws UnsupportedAudioFileException, IOException, LineUnavailableException  {
		URL url = Inicio.class.getResource("/recursos/ErrorW.wav");
		if(url == null) {
			JOptionPane.showMessageDialog(null,"No se encontró");
		}
		AudioInputStream audiostream= AudioSystem.getAudioInputStream(url);
		clipreproduciendo = AudioSystem.getClip();
		clipreproduciendo.open(audiostream);
		 volumeControl = (FloatControl) clipreproduciendo.getControl(FloatControl.Type.MASTER_GAIN);
		 setVolume(50);  
		 clipreproduciendo.start();
	}
	protected void do_panelVenta_mouseClicked(MouseEvent e) throws UnsupportedAudioFileException, IOException, LineUnavailableException{
		URL url = Inicio.class.getResource("/recursos/ErrorW.wav");
		if(url == null) {
			JOptionPane.showMessageDialog(null,"No se encontró");
		}
		AudioInputStream audiostream= AudioSystem.getAudioInputStream(url);
		clipreproduciendo = AudioSystem.getClip();
		clipreproduciendo.open(audiostream);
		 volumeControl = (FloatControl) clipreproduciendo.getControl(FloatControl.Type.MASTER_GAIN);
		 setVolume(50);  
		 clipreproduciendo.start();
	}
	protected void do_panelProveedor_mouseClicked(MouseEvent e) throws UnsupportedAudioFileException, IOException, LineUnavailableException{
		URL url = Inicio.class.getResource("/recursos/ErrorW.wav");
		if(url == null) {
			JOptionPane.showMessageDialog(null,"No se encontró");
		}
		AudioInputStream audiostream= AudioSystem.getAudioInputStream(url);
		clipreproduciendo = AudioSystem.getClip();
		clipreproduciendo.open(audiostream);
		 volumeControl = (FloatControl) clipreproduciendo.getControl(FloatControl.Type.MASTER_GAIN);
		 setVolume(50);  
		 clipreproduciendo.start();
	} 
	//                                                                                          COLOR DEL INTERFAZ
	protected void do_btnNewButton_actionPerformed(ActionEvent e) {
		String actual = jlabelmodo.getText();
		if(actual == "Modo Normal") {		
			contentPane.setBackground(UIManager.getColor("Button.light"));
			lblIdBuscarE.setForeground(Color.BLACK);
			txtBuscarEmple.setBackground(Color.WHITE);
			lblIdE.setForeground(Color.BLACK);
			lblDniE.setForeground(Color.BLACK);
			lblNombreCompletoE.setForeground(Color.BLACK);
			lblTelefono.setForeground(Color.BLACK);
			lblCargo.setForeground(Color.BLACK);
			lblJornada.setForeground(Color.BLACK);
			lblHorario.setForeground(Color.BLACK);
			lblRegistrarEmpleado.setForeground(Color.BLACK);
			lblclock.setForeground(Color.BLACK);
			txtIdEmpleado.setBackground(Color.WHITE);
			txtDniEmpleado.setBackground(Color.WHITE);
			txtNombreEmpleado.setBackground(Color.WHITE);
			txtTelefono.setBackground(Color.WHITE);
			cboCargo.setBackground(Color.WHITE);
			cboJornada.setBackground(Color.WHITE);
			cboHorario.setBackground(Color.WHITE);
					
			txtBuscarEmple.setForeground(Color.BLACK);
			txtIdEmpleado.setForeground(Color.BLACK);
			txtDniEmpleado.setForeground(Color.BLACK);
			txtNombreEmpleado.setForeground(Color.BLACK);
			txtTelefono.setForeground(Color.BLACK);
			cboCargo.setForeground(Color.BLACK);
			cboJornada.setForeground(Color.BLACK);
			cboHorario.setForeground(Color.BLACK);
			jlabelmodo.setText("Modo Oscuro");
		}
		else if(actual == "Modo Oscuro"){
			contentPane.setBackground(Color.BLACK);
			lblIdBuscarE.setForeground(Color.LIGHT_GRAY);
			txtBuscarEmple.setBackground(Color.LIGHT_GRAY);
			lblIdE.setForeground(Color.LIGHT_GRAY);
			lblDniE.setForeground(Color.LIGHT_GRAY);
			lblNombreCompletoE.setForeground(Color.LIGHT_GRAY);
			lblTelefono.setForeground(Color.LIGHT_GRAY);
			lblCargo.setForeground(Color.LIGHT_GRAY);
			lblJornada.setForeground(Color.LIGHT_GRAY);
			lblHorario.setForeground(Color.LIGHT_GRAY);
			lblRegistrarEmpleado.setForeground(Color.LIGHT_GRAY);
			lblclock.setForeground(Color.LIGHT_GRAY);
			txtIdEmpleado.setBackground(Color.LIGHT_GRAY);
			txtDniEmpleado.setBackground(Color.LIGHT_GRAY);
			txtNombreEmpleado.setBackground(Color.LIGHT_GRAY);
			txtTelefono.setBackground(Color.LIGHT_GRAY);
			cboCargo.setBackground(Color.LIGHT_GRAY);
			cboJornada.setBackground(Color.LIGHT_GRAY);
			cboHorario.setBackground(Color.LIGHT_GRAY);
			jlabelmodo.setText("Modo Frío");
		}	
		
		else if(actual == "Modo Frío") {
			contentPane.setBackground(new Color(10, 25, 45));
			lblIdBuscarE.setForeground(new Color(150, 220, 255));
			txtBuscarEmple.setBackground(new Color(30, 80, 120));
			lblIdE.setForeground(new Color(150, 220, 255));
			lblDniE.setForeground(new Color(150, 220, 255));
			lblNombreCompletoE.setForeground(new Color(150, 220, 255));
			lblTelefono.setForeground(new Color(150, 220, 255));
			lblCargo.setForeground(new Color(150, 220, 255));
			lblJornada.setForeground(new Color(150, 220, 255));
			lblHorario.setForeground(new Color(150, 220, 255));
			lblRegistrarEmpleado.setForeground(new Color(150, 220, 255));
			lblclock.setForeground(new Color(150, 220, 255));
			txtIdEmpleado.setBackground(new Color(30, 80, 120));
			txtDniEmpleado.setBackground(new Color(30, 80, 120));
			txtNombreEmpleado.setBackground(new Color(30, 80, 120));
			txtTelefono.setBackground(new Color(30, 80, 120));
			cboCargo.setBackground(new Color(30, 80, 120));
			cboJornada.setBackground(new Color(30, 80, 120));
			cboHorario.setBackground(new Color(30, 80, 120));

			txtBuscarEmple.setForeground(Color.WHITE);
			txtIdEmpleado.setForeground(Color.WHITE);
			txtDniEmpleado.setForeground(Color.WHITE);
			txtNombreEmpleado.setForeground(Color.WHITE);
			txtTelefono.setForeground(Color.WHITE);
			cboCargo.setForeground(Color.WHITE);
			cboJornada.setForeground(Color.WHITE);
			cboHorario.setForeground(Color.WHITE);		
			jlabelmodo.setText("Modo Normal");
		}	
	}	
}
