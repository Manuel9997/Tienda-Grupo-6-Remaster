package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;

public class VenProgramador extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNombre1;
	private JLabel lblNombre2;
	private JLabel lblNombre3;
	private JLabel lblNombre4;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VenProgramador frame = new VenProgramador();
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
	public VenProgramador() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 803, 683);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			lblNombre1 = new JLabel("Carmen Luisa Rivera Zárate");
			lblNombre1.setFont(new Font("Verdana", Font.PLAIN, 15));
			lblNombre1.setBounds(508, 287, 226, 19);
			contentPane.add(lblNombre1);
		}
		{
			lblNombre2 = new JLabel("Manuel Alejandro Ortiz Pereda");
			lblNombre2.setFont(new Font("Verdana", Font.PLAIN, 15));
			lblNombre2.setBounds(55, 287, 243, 19);
			contentPane.add(lblNombre2);
		}
		{
			lblNombre3 = new JLabel("Rodrigo Alexis Polack Noriega");
			lblNombre3.setFont(new Font("Verdana", Font.PLAIN, 15));
			lblNombre3.setBounds(497, 595, 243, 19);
			contentPane.add(lblNombre3);
		}
		{
			lblNombre4 = new JLabel("Gerardo Favián Palacios Bazán");
			lblNombre4.setFont(new Font("Verdana", Font.PLAIN, 15));
			lblNombre4.setBounds(55, 595, 243, 19);
			contentPane.add(lblNombre4);
		}
		{
			lblNewLabel_1 = new JLabel("");
			  try {
		           ImageIcon iconomenu = new ImageIcon(getClass().getResource("/recursos/manuel.jpg"));
		           int anchoDeseado = 188; 
		           int altoDeseado = 250;  
		           Image imagenOriginal = iconomenu.getImage();
		           Image imagenEscalada = imagenOriginal.getScaledInstance(anchoDeseado, altoDeseado, Image.SCALE_SMOOTH);
		           ImageIcon iconoRedimensionado = new ImageIcon(imagenEscalada);
		           lblNewLabel_1.setIcon(iconoRedimensionado);

		       } catch (Exception e) {
		           System.err.println("No se pudo cargar o escalar el icono del menú: " + e.getMessage());
		           e.printStackTrace();
		       }
			lblNewLabel_1.setBounds(73, 26, 188, 250);
			contentPane.add(lblNewLabel_1);
		}
		{
			lblNewLabel_2 = new JLabel("");
			lblNewLabel_2.setIcon(new ImageIcon(VenProgramador.class.getResource("/recursos/carmen.jpg")));
			lblNewLabel_2.setBounds(508, 26, 188, 250);
			contentPane.add(lblNewLabel_2);
		}
		{
			lblNewLabel = new JLabel("");
			try {
		           ImageIcon iconomenu = new ImageIcon(getClass().getResource("/recursos/gerardo.jpg"));
		           int anchoDeseado = 188; 
		           int altoDeseado = 250;  
		           Image imagenOriginal = iconomenu.getImage();
		           Image imagenEscalada = imagenOriginal.getScaledInstance(anchoDeseado, altoDeseado, Image.SCALE_SMOOTH);
		           ImageIcon iconoRedimensionado = new ImageIcon(imagenEscalada);
		           lblNewLabel.setIcon(iconoRedimensionado);

		       } catch (Exception e) {
		           System.err.println("No se pudo cargar o escalar el icono del menú: " + e.getMessage());
		           e.printStackTrace();
		       }
			lblNewLabel.setBounds(73, 334, 188, 250);
			contentPane.add(lblNewLabel);
		}
		{
			lblNewLabel_3 = new JLabel("");
			try {
		           ImageIcon iconomenu = new ImageIcon(getClass().getResource("/recursos/rodri.jpg"));
		           int anchoDeseado = 188; 
		           int altoDeseado = 250;  
		           Image imagenOriginal = iconomenu.getImage();
		           Image imagenEscalada = imagenOriginal.getScaledInstance(anchoDeseado, altoDeseado, Image.SCALE_SMOOTH);
		           ImageIcon iconoRedimensionado = new ImageIcon(imagenEscalada);
		           lblNewLabel_3.setIcon(iconoRedimensionado);

		       } catch (Exception e) {
		           System.err.println("No se pudo cargar o escalar el icono del menú: " + e.getMessage());
		           e.printStackTrace();
		       }
		
			lblNewLabel_3.setBounds(518, 334, 188, 250);
			contentPane.add(lblNewLabel_3);
		}
	}
	
	
}
