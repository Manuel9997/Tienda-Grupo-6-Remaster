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

public class V1 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JTextField txtCliente;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JScrollPane scrollPane;
	private JTextArea textArea;

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
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
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
	}
}
