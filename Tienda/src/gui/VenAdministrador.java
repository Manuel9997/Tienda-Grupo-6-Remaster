package gui;

import java.awt.Color;
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
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.JTabbedPane;

public class VenAdministrador extends JFrame implements ActionListener {

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
	private JLabel lblIdBuscarE;
	private JTextField txtIdEmpleBuscar;
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
		setBounds(100, 100, 859, 770);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		

		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			
			JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
			tabbedPane.setBounds(10, 11, 826, 712);
			contentPane.add(tabbedPane);
			
			JPanel panelEmpleado = new JPanel();
			tabbedPane.addTab("Empleado", null, panelEmpleado, null);
			panelEmpleado.setLayout(null);
			{
				lblIdBuscarE = new JLabel("ID:");
				lblIdBuscarE.setBounds(96, 11, 45, 19);
				panelEmpleado.add(lblIdBuscarE);
				lblIdBuscarE.setFont(new Font("Verdana", Font.PLAIN, 15));
			}
			{
				txtIdEmpleBuscar = new JTextField();
				txtIdEmpleBuscar.setBounds(128, 10, 447, 25);
				panelEmpleado.add(txtIdEmpleBuscar);
				txtIdEmpleBuscar.setBackground(Color.WHITE);
				txtIdEmpleBuscar.setColumns(10);
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
				lblHorario.setBounds(427, 218, 69, 19);
				panelEmpleado.add(lblHorario);
				lblHorario.setFont(new Font("Tahoma", Font.PLAIN, 15));
			}
			{
				cboHorario = new JComboBox();
				cboHorario.setBounds(490, 215, 173, 25);
				panelEmpleado.add(cboHorario);
				cboHorario.setModel(new DefaultComboBoxModel(new String[] {"8:00 a.m. - 5:00 p.m.", "8:00 a.m. - 12:00 a.m.", "12:00 a.m. - 4:00 p.m."}));
				cboHorario.setFont(new Font("Tahoma", Font.PLAIN, 15));
			}
			{
				lblPagoPorHora = new JLabel("Pago/hora:");
				lblPagoPorHora.setBounds(183, 256, 87, 19);
				panelEmpleado.add(lblPagoPorHora);
				lblPagoPorHora.setFont(new Font("Verdana", Font.PLAIN, 15));
			}
			{
				txtPago = new JTextField();
				txtPago.setBounds(281, 255, 117, 25);
				panelEmpleado.add(txtPago);
				txtPago.setColumns(10);
			}
			{
				lblHorasTrabajadas = new JLabel("Horas trabajadas:");
				lblHorasTrabajadas.setBounds(429, 256, 144, 19);
				panelEmpleado.add(lblHorasTrabajadas);
				lblHorasTrabajadas.setFont(new Font("Verdana", Font.PLAIN, 15));
			}
			{
				txtHoras = new JTextField();
				txtHoras.setBounds(577, 255, 117, 25);
				panelEmpleado.add(txtHoras);
				txtHoras.setColumns(10);
			}
			{
				lblDescuento = new JLabel("Descuento:");
				lblDescuento.setBounds(183, 297, 87, 19);
				panelEmpleado.add(lblDescuento);
				lblDescuento.setFont(new Font("Verdana", Font.PLAIN, 15));
			}
			{
				txtDescuento = new JTextField();
				txtDescuento.setBounds(281, 296, 117, 25);
				panelEmpleado.add(txtDescuento);
				txtDescuento.setColumns(10);
			}
			{
				btnMostrarEmpleado = new JButton("Mostrar");
				btnMostrarEmpleado.setBounds(147, 353, 116, 25);
				panelEmpleado.add(btnMostrarEmpleado);
				btnMostrarEmpleado.addActionListener(this);
				btnMostrarEmpleado.setFont(new Font("Verdana", Font.PLAIN, 13));
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
					scrollPane.setBounds(10, 400, 801, 275);
					panelEmpleado.add(scrollPane);
					{
						txtS = new JTextArea();
						txtS.setBackground(Color.WHITE);
						scrollPane.setViewportView(txtS);
					}
				}
				{
					btnEliminarEmpleado = new JButton("Eliminar");
					btnEliminarEmpleado.setFont(new Font("Verdana", Font.PLAIN, 13));
					btnEliminarEmpleado.setBounds(547, 353, 116, 25);
					panelEmpleado.add(btnEliminarEmpleado);
				}
				{
					btnBuscarEmpleado = new JButton("Buscar");
					btnBuscarEmpleado.addActionListener(this);
					btnBuscarEmpleado.setFont(new Font("Verdana", Font.PLAIN, 13));
					btnBuscarEmpleado.setBounds(585, 11, 116, 25);
					panelEmpleado.add(btnBuscarEmpleado);
				}
				jlabelmodo.addActionListener(this);
			}
			
			JPanel panelProducto = new JPanel();
			tabbedPane.addTab("Producto", null, panelProducto, null);
			panelProducto.setLayout(null);
			{
				lblIdBuscarP = new JLabel("ID:");
				lblIdBuscarP.setFont(new Font("Verdana", Font.PLAIN, 15));
				lblIdBuscarP.setBounds(94, 11, 45, 19);
				panelProducto.add(lblIdBuscarP);
			}
			{
				txtIdProdBuscar = new JTextField();
				txtIdProdBuscar.setColumns(10);
				txtIdProdBuscar.setBackground(Color.WHITE);
				txtIdProdBuscar.setBounds(126, 10, 447, 25);
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
				lblPrecio.setBounds(430, 177, 69, 19);
				panelProducto.add(lblPrecio);
			}
			{
				lblCantProducto = new JLabel("Cantidad:");
				lblCantProducto.setFont(new Font("Verdana", Font.PLAIN, 15));
				lblCantProducto.setBounds(217, 216, 87, 19);
				panelProducto.add(lblCantProducto);
			}
			{
				txtCantProducto = new JTextField();
				txtCantProducto.setColumns(10);
				txtCantProducto.setBounds(296, 215, 117, 25);
				panelProducto.add(txtCantProducto);
			}
			{
				txtPrecio = new JTextField();
				txtPrecio.setColumns(10);
				txtPrecio.setBounds(490, 174, 117, 25);
				panelProducto.add(txtPrecio);
			}
			{
				btnMostrarProducto = new JButton("Mostrar");
				btnMostrarProducto.addActionListener(this);
				btnMostrarProducto.setFont(new Font("Verdana", Font.PLAIN, 13));
				btnMostrarProducto.setBounds(10, 422, 116, 25);
				panelProducto.add(btnMostrarProducto);
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
				scrollPane_2.setBounds(10, 457, 801, 218);
				panelProducto.add(scrollPane_2);
				{
					txtS2 = new JTextArea();
					scrollPane_2.setViewportView(txtS2);
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
				cboGarantia = new JComboBox();
				cboGarantia.setFont(new Font("Verdana", Font.PLAIN, 15));
				cboGarantia.setModel(new DefaultComboBoxModel(new String[] {"1 semana", "3 meses", "6 meses", "1 año"}));
				cboGarantia.setBounds(296, 176, 117, 21);
				panelProducto.add(cboGarantia);
			}
			{
				btnBuscarProducto = new JButton("Buscar");
				btnBuscarProducto.addActionListener(this);
				btnBuscarProducto.setFont(new Font("Verdana", Font.PLAIN, 13));
				btnBuscarProducto.setBounds(583, 11, 116, 25);
				panelProducto.add(btnBuscarProducto);
			}
			{
				btnEliminarProducto = new JButton("Eliminar");
				btnEliminarProducto.setFont(new Font("Verdana", Font.PLAIN, 13));
				btnEliminarProducto.setBounds(522, 257, 116, 25);
				panelProducto.add(btnEliminarProducto);
			}
			{
				panelVenta = new JPanel();
				tabbedPane.addTab("Venta", null, panelVenta, null);
				panelVenta.setLayout(null);
				{
					scrollPane_1 = new JScrollPane();
					scrollPane_1.setBounds(10, 226, 801, 449);
					panelVenta.add(scrollPane_1);
					{
						txtS3 = new JTextArea();
						scrollPane_1.setViewportView(txtS3);
					}
				}
				
				btnHistorialVentas = new JButton("Historial de ventas");
				btnHistorialVentas.addActionListener(this);
				btnHistorialVentas.setFont(new Font("Verdana", Font.PLAIN, 13));
				btnHistorialVentas.setBounds(10, 191, 173, 25);
				panelVenta.add(btnHistorialVentas);
				{
					lblCodDni = new JLabel("Cód./DNI:");
					lblCodDni.setFont(new Font("Verdana", Font.PLAIN, 15));
					lblCodDni.setBounds(73, 48, 106, 19);
					panelVenta.add(lblCodDni);
				}
				{
					txtCodDni = new JTextField();
					txtCodDni.setColumns(10);
					txtCodDni.setBackground(Color.WHITE);
					txtCodDni.setBounds(166, 47, 447, 25);
					panelVenta.add(txtCodDni);
				}
				{
					btnBuscarHistorialVenta = new JButton("Buscar");
					btnBuscarHistorialVenta.addActionListener(this);
					btnBuscarHistorialVenta.setFont(new Font("Verdana", Font.PLAIN, 13));
					btnBuscarHistorialVenta.setBounds(623, 47, 116, 25);
					panelVenta.add(btnBuscarHistorialVenta);
				}
			}
			lblclock = new JLabel("");
			lblclock.setBounds(579, 10, 256, 19);
			contentPane.add(lblclock);
			lblclock.setFont(new Font("Tahoma", Font.PLAIN, 15));
			
		    clock();
		}
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnBuscarHistorialVenta) {
			do_btnBuscarHistorialVenta_actionPerformed(e);
		}
		if (e.getSource() == btnBuscarProducto) {
			do_btnBuscarProducto_actionPerformed(e);
		}
		if (e.getSource() == btnBuscarEmpleado) {
			do_btnBuscarEmpleado_actionPerformed(e);
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
		if (e.getSource() == btnMostrarProducto) {
			do_btnMostrarProducto_actionPerformed(e);
		}
		if (e.getSource() == btnHistorialVentas) {
			do_btnHistorialVentas_actionPerformed(e);
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
		if (e.getSource() == btnMostrarEmpleado) {
			do_btnMostrarEmpleado_actionPerformed(e);
		}
	}
	

	private JLabel lblclock;
	private JScrollPane scrollPane;
	private JTextArea txtS;
	private JButton jlabelmodo;
	private JPanel panelVenta;
	private JScrollPane scrollPane_1;
	private JTextArea txtS3;
	private JButton btnHistorialVentas;
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
	private JButton btnMostrarProducto;
	private JButton btnModificarProducto;
	private JLabel lblRegistrarStock;
	private JLabel lblIdStock;
	private JTextField txtIdProdStock;
	private JLabel lblCantStock;
	private JTextField txtCantStock;
	private JButton btnRegistrarStock;
	private JScrollPane scrollPane_2;
	private JTextArea txtS2;
	private JLabel lblCodDni;
	private JTextField txtCodDni;
	
	private JButton btnRegistrarProducto;
	private JComboBox cboGarantia;
	private JButton btnEliminarEmpleado;
	private JButton btnBuscarEmpleado;
	private JButton btnBuscarProducto;
	private JButton btnBuscarHistorialVenta;
	private JButton btnEliminarProducto;
	
	ArregloHistorialVentas ahv = new ArregloHistorialVentas();
	ArregloEmpleado ae = new ArregloEmpleado();
	ArregloProducto ap = new ArregloProducto();

	protected void do_btnMostrarEmpleado_actionPerformed(ActionEvent e) {
		ListadoEmpleados();
	}
	
	void ImprimirEmple(String s) {
		txtS.append(s+"\n");
	}
	
	void ListadoEmpleados() {
		txtS.setText("");
		ImprimirEmple("ID\tDNI\tNombre completo\tTeléfono\tFecha de ingreso\tCargo\tJornada laboral\t\tHorario laboral\t\tPago por hora\tHoras trab.\tDescuento\tSueldo");
		for(int i = 0; i < ae.Tamaño(); i++) {
			Empleado e = ae.Obtener(i);
			double descuento = e.getDescuento();
			ImprimirEmple("" + e.getId_empleado() + "\t" +
			"" + e.getDni() + "\t" + "" +
			"" + e.getNombre_apellido() + "\t" +
			"" + e.getTelefono() + "\t" +
			"" + e.getFecha() + "\t\t" +
			"" + e.getCargo() + "\t" +
			"" + e.getJornada() + "\t" +  
			"" + e.getHorario() + "\t" + 
			"" + e.getPago_hora() + "\t" + 
			"" + e.getHoras_trabajadas() + "\t" + 
			"" + e.getDescuento() + "\t" +
			"" + e.Sueldo(descuento));
	}
}
	protected void do_btnBuscarEmpleado_actionPerformed(ActionEvent e) {
		try {
			int codigo = Integer.parseInt(txtIdEmpleBuscar.getText());
			Empleado empleadoEncontrado = ae.Buscar(codigo);
			double descuento = empleadoEncontrado.getDescuento(); 
			if(empleadoEncontrado == null) {
				txtS.setText("");
				JOptionPane.showMessageDialog(this, "EL código no se encuentra en el sistema");		
			}
			else{
				 txtS.setText(""); 
				 ImprimirEmple("ID\tDNI\tNombre completo\tTeléfono\tFecha de ingreso\tCargo\tJornada laboral\t\tHorario laboral\t\tPago por hora\tHoras trab.\tDescuento\tSueldo");
				    ImprimirEmple("" + empleadoEncontrado.getId_empleado() + "\t" +
							"" + empleadoEncontrado.getDni() + "\t" + "" +
							"" + empleadoEncontrado.getNombre_apellido() + "\t" +
							"" + empleadoEncontrado.getTelefono() + "\t" +
							"" + empleadoEncontrado.getFecha() + "\t\t" + 
							"" + empleadoEncontrado.getCargo() + "\t" +
							"" + empleadoEncontrado.getJornada() + "\t" + 
							"" + empleadoEncontrado.getHorario() + "\t" + 
							"" + empleadoEncontrado.getPago_hora() + "\t" + 
							"" + empleadoEncontrado.getHoras_trabajadas() + "\t" + 
							"" + empleadoEncontrado.getDescuento() + "\t" +
							"" + empleadoEncontrado.Sueldo(descuento));
			}
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
							
			Empleado nuevoempleado= new Empleado(idempleado, dniempleado, nomempleado, teleempleado, LocalDate.now(), carempleado, jorempleado,horaempleado, pxhempleado, htempleado, descuento);
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
				empleadoEncontrado.setJornada(cboJornada.getSelectedItem().toString() );
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
	protected void do_btnMostrarProducto_actionPerformed(ActionEvent e) {
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
	}
	protected void do_btnBuscarProducto_actionPerformed(ActionEvent e) {
		try {
			int id = Integer.parseInt(txtIdProdBuscar.getText());
			Producto p = ap.Buscar(id);
			if(p == null) {
				txtS2.setText("");
				JOptionPane.showMessageDialog(this, "EL ID no se encuentra en el sistema");
				
			}
			else{
				 txtS2.setText(""); 
				 ImprimirProducto("ID\tProducto\tNombre del modelo\tGarantía\tPrecio\tStock");
				    ImprimirProducto(p.getId_producto()+ "\t"
				            + "" + p.getCat_producto()+ "\t"
				        	+ "" + p.getNombre()+ "\t" 
				        	+ "" + p.getGarantia() + "\t" 
				        	+ "" + p.getPrecio()+ "\t" 
				            + "" + p.getStock());
			}
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(this, "El valor ingresado no es válido. Intente de nuevo.");	
		}	
	}
	protected void do_btnRegistrarProducto_actionPerformed(ActionEvent e) {
		try {		
			int id = Integer.parseInt(txtIdProducto.getText());
			String categoria = txtCategoria.getText();
			String nombre = txtNombreProducto.getText();
			String garantia = cboGarantia.getSelectedItem().toString();
			double precio = Double.parseDouble(txtPrecio.getText());
			int cantidad = Integer.parseInt(txtCantProducto.getText());
							
			Producto nuevoproducto= new Producto(id, categoria, nombre, garantia, precio);
			if( ap.Buscar(id) == null) {
				ap.Adicionar(nuevoproducto);	
				JOptionPane.showMessageDialog(this, "Nuevo producto registrado éxitosamente");
			}
			else {
				JOptionPane.showMessageDialog(this, "Producto ya registrado en el sistema");
				return;		
			}

		} catch (Exception e2) {
			JOptionPane.showMessageDialog(this, "Verifique los datos ingresados. Intente de nuevo.");
		}
	} 
	 protected void do_btnModificarProducto_actionPerformed(ActionEvent e) {
			try {
				txtS2.setText("");
				int id = Integer.parseInt(txtIdProducto.getText());
				Producto productoEncontrado = ap.Buscar(id);
				if(productoEncontrado == null) {
					txtS2.setText("");
					JOptionPane.showMessageDialog(this, "EL ID no se encuentra en el sistema");
					return;
				}
				else {
					txtS.setText("");
					productoEncontrado.setId_producto(Integer.parseInt(txtIdProducto.getText()));
					productoEncontrado.setCat_producto(txtCategoria.getText());
					productoEncontrado.setNombre(txtNombreProducto.getText());
					productoEncontrado.setGarantia(cboGarantia.getSelectedItem().toString());
					productoEncontrado.setPrecio(Double.parseDouble(txtPrecio.getText()));
					productoEncontrado.setStock(Integer.parseInt(txtCantProducto.getText()));		
				}		
			}
			catch(Exception e2){
				JOptionPane.showMessageDialog(this, "Verifique el ID ingresado. Intente de nuevo.");
			}
	}
	protected void do_btnRegistrarStock_actionPerformed(ActionEvent e) {	
		try {
			int id = Integer.parseInt(txtIdProdStock.getText());
			int cantidad = Integer.parseInt(txtCantStock.getText());
			
			Producto productoEncontrado = ap.Buscar(id);
			if(productoEncontrado == null) {
				JOptionPane.showMessageDialog(this, "EL ID no se encuentra en el sistema");
				return;
			}
			else {
				productoEncontrado.aumentarStock(cantidad);
			}
		}
		catch (Exception e2) {
			JOptionPane.showMessageDialog(this, "Verifique los datos ingresados. Intente de nuevo.");
		}
		ListadoProductos();
	}
	
	protected void do_btnHistorialVentas_actionPerformed(ActionEvent e) {
		ListadoHistorialVentas();
	}
	
	void ImprimirVenta(String s) {
		txtS3.append(s+"\n");
	}
	
	void ListadoHistorialVentas() {
		txtS3.setText("");
		ImprimirVenta("Código\tDNI\tNombres y apellidos\tTeléfono\tFecha\tHora\tID Producto\tProducto\tNombre del modelo\tGarantia\tPrecio unitario\tCantidad\tTipo de pago\tVendedor\t\tTotal");
		for(int i = 0; i < ahv.Tamaño(); i++) {
			Venta v = ahv.Obtener(i);
			ImprimirVenta("" + v.getCodigo_venta() + "\t" +
			"" + v.getCliente().getDni() + "\t" + 
			"" + v.getCliente().getNombre_apellido() + "\t" +
			"" + v.getCliente().getTelefono() + "\t" +
			"" + v.getFecha() + "\t" +
			"" + v.getHora() + "\t" +
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
	protected void do_btnBuscarHistorialVenta_actionPerformed(ActionEvent e) {
		try {
			int codigo = Integer.parseInt(txtCodDni.getText());
			String dni = txtCodDni.getText();
			
			Venta ventaencontrada = ahv.Buscar(codigo, dni);
			
			if(ventaencontrada == null) {
				txtS3.setText("");
				JOptionPane.showMessageDialog(this, "EL código no se encuentra en el sistema");
				
			}
			else{
				 txtS3.setText(""); 
				 ImprimirVenta("Código\tDNI\tNombres y apellidos\tTeléfono\tFecha\tHora\tID Producto\tProducto\tNombre del modelo\tGarantia\tPrecio unitario\tCantidad\tTipo de pago\tVendedor\t\tTotal");
				    ImprimirVenta("" + ventaencontrada.getCodigo_venta() + "\t" +
							"" + ventaencontrada.getCliente().getDni() + "\t" + "" +
							"" + ventaencontrada.getCliente().getNombre_apellido() + "\t" +
							"" + ventaencontrada.getCliente().getTelefono() + "\t" +
							"" + ventaencontrada.getFecha() + "\t" + 
							"" + ventaencontrada.getHora() + "\t" +
							"" + ventaencontrada.getProducto().getId_producto() + "\t" + 
							"" + ventaencontrada.getProducto().getCat_producto() + "\t" + 
							"" + ventaencontrada.getProducto().getNombre() + "\t" + 
							"" + ventaencontrada.getProducto().getGarantia() + "\t" + 
							"" + ventaencontrada.getProducto().getPrecio() + "\t" +
							"" + ventaencontrada.getCantidad() + "\t" +
					        "" + ventaencontrada.getTipo_pago() + "\t" +
							"" + ventaencontrada.getVendedor().getNombre_apellido() + "\t" +
					        "" + ventaencontrada.SubTotal());    
			}
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(this, "El valor ingresado no es válido. Intente de nuevo.");	
		}
	}
	protected void do_btnNewButton_actionPerformed(ActionEvent e) {
		String actual = jlabelmodo.getText();
		if(actual == "Modo Normal") {		
			contentPane.setBackground(UIManager.getColor("Button.light"));
			lblIdBuscarE.setForeground(Color.BLACK);
			txtIdEmpleBuscar.setBackground(Color.WHITE);
			txtS.setBackground(Color.WHITE);
			lblIdE.setForeground(Color.BLACK);
			lblDniE.setForeground(Color.BLACK);
			lblNombreCompletoE.setForeground(Color.BLACK);
			lblTelefono.setForeground(Color.BLACK);
			lblCargo.setForeground(Color.BLACK);
			lblJornada.setForeground(Color.BLACK);
			lblHorario.setForeground(Color.BLACK);
			lblPagoPorHora.setForeground(Color.BLACK);
			lblHorasTrabajadas.setForeground(Color.BLACK);
			lblDescuento.setForeground(Color.BLACK);
			lblRegistrarEmpleado.setForeground(Color.BLACK);
			lblclock.setForeground(Color.BLACK);
			txtIdEmpleado.setBackground(Color.WHITE);
			txtDniEmpleado.setBackground(Color.WHITE);
			txtNombreEmpleado.setBackground(Color.WHITE);
			txtTelefono.setBackground(Color.WHITE);
			cboCargo.setBackground(Color.WHITE);
			cboJornada.setBackground(Color.WHITE);
			cboHorario.setBackground(Color.WHITE);
			txtPago.setBackground(Color.WHITE);
			txtHoras.setBackground(Color.WHITE);
			txtDescuento.setBackground(Color.WHITE);		
			
			
			txtIdEmpleBuscar.setForeground(Color.BLACK);
			txtS.setForeground(Color.BLACK);
			txtIdEmpleado.setForeground(Color.BLACK);
			txtDniEmpleado.setForeground(Color.BLACK);
			txtNombreEmpleado.setForeground(Color.BLACK);
			txtTelefono.setForeground(Color.BLACK);
			txtPago.setForeground(Color.BLACK);
			txtHoras.setForeground(Color.BLACK);
			txtDescuento.setForeground(Color.BLACK);
			cboCargo.setForeground(Color.BLACK);
			cboJornada.setForeground(Color.BLACK);
			cboHorario.setForeground(Color.BLACK);
			jlabelmodo.setText("Modo Oscuro");
		}
		else if(actual == "Modo Oscuro"){
			contentPane.setBackground(Color.BLACK);
			
			lblIdBuscarE.setForeground(Color.LIGHT_GRAY);
			txtIdEmpleBuscar.setBackground(Color.LIGHT_GRAY);
			txtS.setBackground(Color.LIGHT_GRAY);
			lblIdE.setForeground(Color.LIGHT_GRAY);
			lblDniE.setForeground(Color.LIGHT_GRAY);
			lblNombreCompletoE.setForeground(Color.LIGHT_GRAY);
			lblTelefono.setForeground(Color.LIGHT_GRAY);
			lblCargo.setForeground(Color.LIGHT_GRAY);
			lblJornada.setForeground(Color.LIGHT_GRAY);
			lblHorario.setForeground(Color.LIGHT_GRAY);
			lblPagoPorHora.setForeground(Color.LIGHT_GRAY);
			lblHorasTrabajadas.setForeground(Color.LIGHT_GRAY);
			lblDescuento.setForeground(Color.LIGHT_GRAY);
			lblRegistrarEmpleado.setForeground(Color.LIGHT_GRAY);
			lblclock.setForeground(Color.LIGHT_GRAY);
			txtIdEmpleado.setBackground(Color.LIGHT_GRAY);
			txtDniEmpleado.setBackground(Color.LIGHT_GRAY);
			txtNombreEmpleado.setBackground(Color.LIGHT_GRAY);
			txtTelefono.setBackground(Color.LIGHT_GRAY);
			cboCargo.setBackground(Color.LIGHT_GRAY);
			cboJornada.setBackground(Color.LIGHT_GRAY);
			cboHorario.setBackground(Color.LIGHT_GRAY);
			txtPago.setBackground(Color.LIGHT_GRAY);
			txtHoras.setBackground(Color.LIGHT_GRAY);
			txtDescuento.setBackground(Color.LIGHT_GRAY);
			jlabelmodo.setText("Modo Frío");
		}	
		
		else if(actual == "Modo Frío") {
			contentPane.setBackground(new Color(10, 25, 45));
			lblIdBuscarE.setForeground(new Color(150, 220, 255));
			txtIdEmpleBuscar.setBackground(new Color(30, 80, 120));
			txtS.setBackground(new Color(30, 80, 120));
			lblIdE.setForeground(new Color(150, 220, 255));
			lblDniE.setForeground(new Color(150, 220, 255));
			lblNombreCompletoE.setForeground(new Color(150, 220, 255));
			lblTelefono.setForeground(new Color(150, 220, 255));
			lblCargo.setForeground(new Color(150, 220, 255));
			lblJornada.setForeground(new Color(150, 220, 255));
			lblHorario.setForeground(new Color(150, 220, 255));
			lblPagoPorHora.setForeground(new Color(150, 220, 255));
			lblHorasTrabajadas.setForeground(new Color(150, 220, 255));
			lblDescuento.setForeground(new Color(150, 220, 255));
			lblRegistrarEmpleado.setForeground(new Color(150, 220, 255));
			lblclock.setForeground(new Color(150, 220, 255));
			txtIdEmpleado.setBackground(new Color(30, 80, 120));
			txtDniEmpleado.setBackground(new Color(30, 80, 120));
			txtNombreEmpleado.setBackground(new Color(30, 80, 120));
			txtTelefono.setBackground(new Color(30, 80, 120));
			cboCargo.setBackground(new Color(30, 80, 120));
			cboJornada.setBackground(new Color(30, 80, 120));
			cboHorario.setBackground(new Color(30, 80, 120));
			txtPago.setBackground(new Color(30, 80, 120));
			txtHoras.setBackground(new Color(30, 80, 120));
			txtDescuento.setBackground(new Color(30, 80, 120));

			txtIdEmpleBuscar.setForeground(Color.WHITE);
			txtS.setForeground(Color.WHITE);
			txtIdEmpleado.setForeground(Color.WHITE);
			txtDniEmpleado.setForeground(Color.WHITE);
			txtNombreEmpleado.setForeground(Color.WHITE);
			txtTelefono.setForeground(Color.WHITE);
			txtPago.setForeground(Color.WHITE);
			txtHoras.setForeground(Color.WHITE);
			txtDescuento.setForeground(Color.WHITE);
			cboCargo.setForeground(Color.WHITE);
			cboJornada.setForeground(Color.WHITE);
			cboHorario.setForeground(Color.WHITE);		
			jlabelmodo.setText("Modo Normal");
		}	
	}	
}
