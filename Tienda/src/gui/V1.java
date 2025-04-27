package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
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
	private JTextField txtCliente;
	private JScrollPane scrollPane;
	private JTextArea textArea;
	private JButton btnBuscar;
	private JButton btnBorrar;
	private JLabel lblNewLabel_2;
	private JButton btnBuscar_2;
	private JButton btnEmpleados_1;
	private JButton btnProductos_1;

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
			lblNewLabel.setBounds(160, 10, 423, 27);
			contentPane.add(lblNewLabel);
		}
		{
			txtCliente = new JTextField();
			txtCliente.setBounds(219, 72, 333, 19);
			contentPane.add(txtCliente);
			txtCliente.setColumns(10);
		}
		{
			scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 225, 660, 231);
			contentPane.add(scrollPane);
			{
				textArea = new JTextArea();
				scrollPane.setViewportView(textArea);
			}
		}
		{
			btnBuscar = new JButton("Clientes");
			btnBuscar.addActionListener(this);
			btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 14));
			btnBuscar.setBounds(10, 99, 100, 27);
			contentPane.add(btnBuscar);
		}
		{
			btnBorrar = new JButton("Borrar");
			btnBorrar.addActionListener(this);
			btnBorrar.setFont(new Font("Tahoma", Font.PLAIN, 14));
			btnBorrar.setBounds(585, 188, 85, 27);
			contentPane.add(btnBorrar);
		}
		
		JButton btnBuscar_1 = new JButton("Buscar");
		btnBuscar_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBuscar_1.setBounds(585, 66, 85, 27);
		contentPane.add(btnBuscar_1);
		
		JButton btnEmpleados = new JButton("Empleados");
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
			btnBuscar_2 = new JButton("Cliente");
			btnBuscar_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
			btnBuscar_2.setBounds(178, 143, 100, 27);
			contentPane.add(btnBuscar_2);
		}
		{
			btnEmpleados_1 = new JButton("Empleado");
			btnEmpleados_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
			btnEmpleados_1.setBounds(315, 143, 100, 27);
			contentPane.add(btnEmpleados_1);
		}
		{
			btnProductos_1 = new JButton("Producto");
			btnProductos_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
			btnProductos_1.setBounds(452, 143, 100, 27);
			contentPane.add(btnProductos_1);
		}

	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnBorrar) {
			do_btnBorrar_actionPerformed(e);
		}
		if (e.getSource() == btnBuscar) {
			do_btnBuscar_actionPerformed(e);
		}
	}
	protected void do_btnBuscar_actionPerformed(ActionEvent e) {
	}
	protected void do_btnBorrar_actionPerformed(ActionEvent e) {
	}
}
