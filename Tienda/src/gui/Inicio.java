 package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;

public class Inicio extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnNewMenu;
	private JMenuItem mnAdministrador;
	private JMenuItem mnEmpleado;
	private JLabel lblNewLabel;
	private JLabel lblTecnobox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try { 
					Inicio frame = new Inicio();
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
	public Inicio() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 803, 683);
		{
			menuBar = new JMenuBar();
			setJMenuBar(menuBar);
			{
				mnNewMenu = new JMenu("Menú");
				menuBar.add(mnNewMenu);
				{
					mnAdministrador = new JMenuItem("Administrador");
					mnAdministrador.addActionListener(this);
					mnNewMenu.add(mnAdministrador);
				}
				{
					mnEmpleado = new JMenuItem("Empleado");
					mnEmpleado.addActionListener(this);
					mnNewMenu.add(mnEmpleado);
				}
			}
		}
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			lblNewLabel = new JLabel("TIENDA TECNOLÓGICA");
			lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 40));
			lblNewLabel.setBounds(172, 205, 474, 60);
			contentPane.add(lblNewLabel);
		}
		{
			lblTecnobox = new JLabel("TECNOBOX");
			lblTecnobox.setFont(new Font("Times New Roman", Font.PLAIN, 40));
			lblTecnobox.setBounds(277, 286, 247, 60);
			contentPane.add(lblTecnobox);
		}
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mnEmpleado) {
			do_mnEmpleado_actionPerformed(e);
		}
		if (e.getSource() == mnAdministrador) {
			do_mnAdministrador_actionPerformed(e);
		}
	}
	protected void do_mnAdministrador_actionPerformed(ActionEvent e) {
		ContraseñaAdmin contraseña = new ContraseñaAdmin();
		contraseña.setVisible(true);
	}
	
	protected void do_mnEmpleado_actionPerformed(ActionEvent e) {
		VenEmpleado vEmple = new VenEmpleado();
		vEmple.setVisible(true);
	}
}
