package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import arreglo.ArregloCliente;
import arreglo.ArregloEmpleado;
import arreglo.ArregloProducto;
import clase.Cliente;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class V1 extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JTextField txtID;
	private JScrollPane scrollPane;
	private JTextArea txtS;
	private JButton btnClientes;
	private JButton btnBorrar;
	private JLabel lblNewLabel_2;
	private JButton btnCliente;
	private JButton btnEmpleado;
	private JButton btnProducto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					V1 frame = new V1();
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
	public V1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 694, 503);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			lblNewLabel = new JLabel("TIENDA TECNOLÓGICA \"TECNOBOX\"");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
			lblNewLabel.setBounds(160, 20, 423, 27);
			contentPane.add(lblNewLabel);
		}
		{
			txtID = new JTextField();
			txtID.setBounds(219, 72, 333, 19);
			contentPane.add(txtID);
			txtID.setColumns(10);
		}
		{
			scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 225, 660, 231);
			contentPane.add(scrollPane);
			{
				txtS = new JTextArea();
				scrollPane.setViewportView(txtS);
			}
		}
		{
			btnClientes = new JButton("Clientes");
			btnClientes.addActionListener(this);
			btnClientes.setFont(new Font("Tahoma", Font.PLAIN, 14));
			btnClientes.setBounds(10, 99, 100, 27);
			contentPane.add(btnClientes);
		}
		{
			btnBorrar = new JButton("Borrar");
			btnBorrar.addActionListener(this);
			btnBorrar.setFont(new Font("Tahoma", Font.PLAIN, 14));
			btnBorrar.setBounds(585, 188, 85, 27);
			contentPane.add(btnBorrar);
		}
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(this);
		btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBuscar.setBounds(585, 66, 85, 27);
		contentPane.add(btnBuscar);
		
		btnEmpleados = new JButton("Empleados");
		btnEmpleados.addActionListener(this);
		btnEmpleados.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEmpleados.setBounds(10, 136, 100, 27);
		contentPane.add(btnEmpleados);
		
		JButton btnProductos = new JButton("Productos");
		btnProductos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnProductos.setBounds(10, 173, 100, 27);
		contentPane.add(btnProductos);
		
		JLabel lblNewLabel_1 = new JLabel("MOSTRAR");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(28, 70, 72, 19);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("ID/DNI:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(154, 70, 72, 19);
		contentPane.add(lblNewLabel_1_1);
		{
			lblNewLabel_2 = new JLabel("REGISTRAR");
			lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblNewLabel_2.setBounds(330, 115, 85, 19);
			contentPane.add(lblNewLabel_2);
		}
		{
			btnCliente = new JButton("Cliente");
			btnCliente.setFont(new Font("Tahoma", Font.PLAIN, 14));
			btnCliente.setBounds(178, 143, 100, 27);
			contentPane.add(btnCliente);
		}
		{
			btnEmpleado = new JButton("Empleado");
			btnEmpleado.setFont(new Font("Tahoma", Font.PLAIN, 14));
			btnEmpleado.setBounds(315, 143, 100, 27);
			contentPane.add(btnEmpleado);
		}
		{
			btnProducto = new JButton("Producto");
			btnProducto.setFont(new Font("Tahoma", Font.PLAIN, 14));
			btnProducto.setBounds(452, 143, 100, 27);
			contentPane.add(btnProducto);
		}

	}	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnBuscar) {
			do_btnBuscar_actionPerformed(e);
		}
		if (e.getSource() == btnClientes) {
			do_btnClientes_actionPerformed(e);
		}
	}
	
	ArregloCliente ac = new ArregloCliente();
	ArregloEmpleado ae = new ArregloEmpleado();
	ArregloProducto ap = new ArregloProducto();
	private JButton btnEmpleados;
	private JButton btnBuscar;
	
	protected void do_btnClientes_actionPerformed(ActionEvent e) {
		txtS.setText("");
		Listado_Cliente();
	}
	void Imprimir(String s) {
		txtS.append(s+"\n");
	}
	void Listado_Cliente() {
		Imprimir("Código\tDNI\tNombres y apellidos\tProducto\tTeléfono\tFecha\tTipo de pago\tCantidad");
		for(int i = 0; i <ac.Tamaño(); i++) {
			Imprimir("" + ac.Obtener(i).getCodigo_compra() + "\t" +
			"" + ac.Obtener(i).getDni() + "\t" +
			"" + ac.Obtener(i).getNombre_apellido() + "\t" +
			"" + ac.Obtener(i).getProducto() + "\t" +
			"" + ac.Obtener(i).getTelefono() + "\t" +
			"" + ac.Obtener(i).getFecha() + "\t" +
			"" + ac.Obtener(i).getTipo_pago() + "\t" +
			"" + ac.Obtener(i).getCantidad() + "\t");
		}
	}	
	int LeerCodigo() {
		return Integer.parseInt(txtID.getText());		
	}
	protected void do_btnBuscar_actionPerformed(ActionEvent e) {
		try {
			txtS.setText("");
			Cliente cli = ac.Buscar(LeerCodigo());
			if(cli != null) {
				Imprimir("Código\tDNI\tNombres y apellidos\tProducto\tTeléfono\tFecha\tTipo de pago\tCantidad");
				Imprimir(""+cli.getCodigo_compra() + "\t"+ cli.getNombre_apellido() + "\t" + cli.getProducto() + "\t" + cli.getTelefono() + "\t" + cli.getFecha() + "\t" + cli.getTipo_pago() + "\t" + cli.getCantidad());
			}
			else {
				JOptionPane.showMessageDialog(this, "El código NO existe");
			}
		} catch(Exception e2) {
			MostrarError();
		}		
	}
	private void MostrarError() {
		JOptionPane.showMessageDialog(this,  "Ingrese número(s) válido(s)");
	}
}
