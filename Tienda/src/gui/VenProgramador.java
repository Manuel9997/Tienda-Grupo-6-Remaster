package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;

public class VenProgramador extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNombre1;
	private JLabel lblNombre2;
	private JLabel lblNombre3;
	private JLabel lblNombre4;

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
			lblNombre1.setBounds(479, 238, 226, 19);
			contentPane.add(lblNombre1);
		}
		{
			lblNombre2 = new JLabel("Manuel Alejandro Ortiz Pereda");
			lblNombre2.setFont(new Font("Verdana", Font.PLAIN, 15));
			lblNombre2.setBounds(70, 238, 243, 19);
			contentPane.add(lblNombre2);
		}
		{
			lblNombre3 = new JLabel("Rodrigo Alexis Polack Noriega");
			lblNombre3.setFont(new Font("Verdana", Font.PLAIN, 15));
			lblNombre3.setBounds(476, 506, 243, 19);
			contentPane.add(lblNombre3);
		}
		{
			lblNombre4 = new JLabel("Gerardo Favián Palacios Bazán");
			lblNombre4.setFont(new Font("Verdana", Font.PLAIN, 15));
			lblNombre4.setBounds(70, 506, 243, 19);
			contentPane.add(lblNombre4);
		}
	}
}
