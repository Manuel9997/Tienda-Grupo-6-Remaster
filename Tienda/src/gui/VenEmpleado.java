package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

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
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.awt.event.ActionEvent;

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
	private JScrollPane scrollPane;
	private JTextArea txtS;

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

	/**
	 * Create the frame.
	 */
	public VenEmpleado() {
		setAlwaysOnTop(true);
		setTitle("Empleado");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 930, 730);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			cboTipoPago = new JComboBox();
			cboTipoPago.setFont(new Font("Tahoma", Font.PLAIN, 15));
			cboTipoPago.setModel(new DefaultComboBoxModel(new String[] {"Efectivo", "Débito", "Crédito", "Yape/Plin"}));
			cboTipoPago.setBounds(370, 239, 116, 25);
			contentPane.add(cboTipoPago);
		}
		{
			cboComprobante = new JComboBox();
			cboComprobante.setFont(new Font("Tahoma", Font.PLAIN, 15));
			cboComprobante.setModel(new DefaultComboBoxModel(new String[] {"Boleta", "Factura"}));
			cboComprobante.setBounds(614, 239, 116, 25);
			contentPane.add(cboComprobante);
		}
		{
			lblNewLabel = new JLabel("Tipo de pago:");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblNewLabel.setBounds(261, 239, 99, 25);
			contentPane.add(lblNewLabel);
		}
		{
			lblComprobante = new JLabel("Comprobante:");
			lblComprobante.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblComprobante.setBounds(505, 239, 99, 25);
			contentPane.add(lblComprobante);
		}
		{
			lblId = new JLabel("ID Producto:");
			lblId.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblId.setBounds(261, 156, 99, 25);
			contentPane.add(lblId);
		}
		{
			txtIdProducto = new JTextField();
			txtIdProducto.setBounds(370, 158, 96, 25);
			contentPane.add(txtIdProducto);
			txtIdProducto.setColumns(10);
		}
		{
			lblDni = new JLabel("DNI:");
			lblDni.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblDni.setBounds(35, 151, 44, 25);
			contentPane.add(lblDni);
		}
		{
			lblNombresYApellidos = new JLabel("Nombre completo:");
			lblNombresYApellidos.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblNombresYApellidos.setBounds(261, 90, 147, 25);
			contentPane.add(lblNombresYApellidos);
		}
		{
			txtDNI = new JTextField();
			txtDNI.setBounds(106, 153, 117, 25);
			contentPane.add(txtDNI);
			txtDNI.setColumns(10);
		}
		{
			txtNombre = new JTextField();
			txtNombre.setColumns(10);
			txtNombre.setBounds(407, 92, 416, 25);
			contentPane.add(txtNombre);
		}
		{
			txtCod = new JTextField();
			txtCod.setColumns(10);
			txtCod.setBounds(127, 100, 96, 25);
			contentPane.add(txtCod);
		}
		{
			lblCdcompra = new JLabel("Cód.Venta:");
			lblCdcompra.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblCdcompra.setBounds(35, 98, 96, 25);
			contentPane.add(lblCdcompra);
		}
		{
			lblTelfono = new JLabel("Teléfono:");
			lblTelfono.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblTelfono.setBounds(35, 201, 73, 25);
			contentPane.add(lblTelfono);
		}
		{
			txtTelefono = new JTextField();
			txtTelefono.setColumns(10);
			txtTelefono.setBounds(106, 203, 117, 25);
			contentPane.add(txtTelefono);
		}
		{
			lblCantidad = new JLabel("Cantidad:");
			lblCantidad.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblCantidad.setBounds(505, 156, 99, 25);
			contentPane.add(lblCantidad);
		}
		{
			txtCantidad = new JTextField();
			txtCantidad.setColumns(10);
			txtCantidad.setBounds(583, 156, 96, 25);
			contentPane.add(txtCantidad);
		}
		{
			btnRegistrar = new JButton("Registrar");
			btnRegistrar.addActionListener(this);
			btnRegistrar.setFont(new Font("Tahoma", Font.PLAIN, 13));
			btnRegistrar.setBounds(330, 390, 116, 25);
			contentPane.add(btnRegistrar);
		}
		{
			scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 437, 896, 246);
			contentPane.add(scrollPane);
			{
				txtS = new JTextArea();
				scrollPane.setViewportView(txtS);
			}
		}
		{
			btnTotal = new JButton("Total");
			btnTotal.addActionListener(this);
			btnTotal.setFont(new Font("Tahoma", Font.PLAIN, 13));
			btnTotal.setBounds(481, 390, 116, 25);
			contentPane.add(btnTotal);
		}
		{
			lblVendedor = new JLabel("Vendedor:");
			lblVendedor.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblVendedor.setBounds(261, 314, 84, 25);
			contentPane.add(lblVendedor);
		}
		{
			cboVendedor = new JComboBox();
			cboVendedor.setModel(new DefaultComboBoxModel(new String[] {"Ana Torres", "Sara Palacios", "Rogelio Vargas", "Fabricio Peña", "José Meza"}));
			cboVendedor.setFont(new Font("Tahoma", Font.PLAIN, 15));
			cboVendedor.setBounds(370, 314, 116, 25);
			contentPane.add(cboVendedor);
		}
		{
			btnMostrarProductos = new JButton("Mostrar productos");
			btnMostrarProductos.addActionListener(this);
			btnMostrarProductos.setFont(new Font("Tahoma", Font.PLAIN, 13));
			btnMostrarProductos.setBounds(10, 402, 147, 25);
			contentPane.add(btnMostrarProductos);
		}
		{
			btnBuscar = new JButton("Buscar");
			btnBuscar.addActionListener(this);
			btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 13));
			btnBuscar.setBounds(683, 11, 116, 25);
			contentPane.add(btnBuscar);
		}
		{
			txtID = new JTextField();
			txtID.setColumns(10);
			txtID.setBounds(267, 12, 406, 25);
			contentPane.add(txtID);
		}
		{
			lblId_1 = new JLabel("ID Producto:");
			lblId_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblId_1.setBounds(172, 10, 99, 25);
			contentPane.add(lblId_1);
		}
		{
			lblRegistroDeVentas = new JLabel("REGISTRO DE VENTAS");
			lblRegistroDeVentas.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblRegistroDeVentas.setBounds(35, 49, 210, 25);
			contentPane.add(lblRegistroDeVentas);
		}
	}
	public void actionPerformed(ActionEvent e) {
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
		Venta v = new Venta(LeerCodigo(), c, LocalDate.now(), p, LeerCantidad(), LeerTipoPago(), LeerComprobante(), vendedor);
		
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
		Imprimir("Código\tDNI\tNombres y apellidos\tTeléfono\tFecha\tID Producto\tProducto\tNombre del modelo\tGarantia\tPrecio unitario\tCantidad\tTipo de pago\tVendedor\tSub Total");

		for (int i = 0; i < av.Tamaño(); i++) {
			Venta v = av.Obtener(i);
			Producto prod = ap.Buscar(v.getProducto().getId_producto());
			
			Imprimir("" + v.getCodigo_venta() + "\t" +
			v.getCliente().getDni() + "\t" + 
			v.getCliente().getNombre_apellido() + "\t" +
			v.getCliente().getTelefono() + "\t" +
			v.getFecha() + "\t" +
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
		int cod = Integer.parseInt(txtCod.getText());
	    double total = 0;

	    for (int i = 0; i < av.Tamaño(); i++) {
	        Venta v = av.Obtener(i);
	        if (v.getCodigo_venta() == cod) {
	            total += v.SubTotal();
	        }
	    }
	    txtS.append("Total: " + total);
	}
	protected void do_btnMostrarProductos_actionPerformed(ActionEvent e) {
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
}

