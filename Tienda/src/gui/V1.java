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
	private JLabel lblNewLabel_1;
	private JTextField txtCliente;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JScrollPane scrollPane;
	private JTextArea textArea;
	private JTextField txtEmpleado;
	private JTextField txtIDproducto;
	private JButton btnBuscar;
	private JButton btnBorrar;
	private JButton btnRegistrar1;

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
		setBounds(100, 100, 644, 455);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			lblNewLabel = new JLabel("TIENDA TECNOLÓGICA \"TECNOBOX\"");
			lblNewLabel.setFont(new Font("Sitka Text", Font.PLAIN, 22));
			lblNewLabel.setBounds(128, 20, 377, 27);
			contentPane.add(lblNewLabel);
		}
		{
			lblNewLabel_1 = new JLabel("CLIENTE:");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblNewLabel_1.setBounds(24, 71, 69, 13);
			contentPane.add(lblNewLabel_1);
		}
		{
			txtCliente = new JTextField();
			txtCliente.setBounds(140, 70, 326, 19);
			contentPane.add(txtCliente);
			txtCliente.setColumns(10);
		}
		{
			lblNewLabel_2 = new JLabel("EMPLEADO:");
			lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblNewLabel_2.setBounds(24, 106, 93, 13);
			contentPane.add(lblNewLabel_2);
		}
		{
			lblNewLabel_3 = new JLabel("ID PRODUCTO:");
			lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblNewLabel_3.setBounds(24, 140, 106, 13);
			contentPane.add(lblNewLabel_3);
		}
		{
			scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 177, 515, 231);
			contentPane.add(scrollPane);
			{
				textArea = new JTextArea();
				scrollPane.setViewportView(textArea);
			}
		}
		{
			txtEmpleado = new JTextField();
			txtEmpleado.setColumns(10);
			txtEmpleado.setBounds(140, 99, 326, 19);
			contentPane.add(txtEmpleado);
		}
		{
			txtIDproducto = new JTextField();
			txtIDproducto.setColumns(10);
			txtIDproducto.setBounds(140, 138, 326, 19);
			contentPane.add(txtIDproducto);
		}
		{
			btnBuscar = new JButton("Buscar");
			btnBuscar.addActionListener(this);
			btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 14));
			btnBuscar.setBounds(535, 83, 85, 27);
			contentPane.add(btnBuscar);
		}
		{
			btnBorrar = new JButton("Borrar");
			btnBorrar.addActionListener(this);
			btnBorrar.setFont(new Font("Tahoma", Font.PLAIN, 14));
			btnBorrar.setBounds(535, 282, 85, 27);
			contentPane.add(btnBorrar);
		}

		{
			btnRegistrar1 = new JButton("Registrar");
			btnRegistrar1.addActionListener(this);
			btnRegistrar1.setFont(new Font("Tahoma", Font.PLAIN, 14));
			btnRegistrar1.setBounds(527, 121, 93, 27);
			contentPane.add(btnRegistrar1);
		}

	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnRegistrar1) {
			do_btnRegistrar1_actionPerformed(e);
		}
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
	protected void do_btnRegistrar1_actionPerformed(ActionEvent e) {
	}
}
