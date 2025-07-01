package gui;
import java.awt.BorderLayout;
import java.awt.Component;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import clase.LoginAdmi;
import mantenimiento.MantLoginAdmi;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.SystemColor;

public class VenLoginAdmi extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JTextField txtUsuario;
	private JButton btnIngresar;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JPasswordField pswContraseña;

	public static void main(String[] args) {
		try {
			VenLoginAdmi dialog = new VenLoginAdmi();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public VenLoginAdmi() {
		setAlwaysOnTop(true);
		setModal(true);
		setBounds(100, 100, 450, 399);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.BLACK);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			lblNewLabel_3 = new JLabel("LOGIN");
			lblNewLabel_3.setBackground(Color.LIGHT_GRAY);
			lblNewLabel_3.setForeground(Color.LIGHT_GRAY);
			lblNewLabel_3.setFont(new Font("Verdana", Font.PLAIN, 26));
			lblNewLabel_3.setBounds(164, 46, 96, 55);
			contentPanel.add(lblNewLabel_3);
		}
		{
			lblNewLabel = new JLabel("USUARIO:");
			lblNewLabel.setForeground(SystemColor.controlShadow);
			lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 15));
			lblNewLabel.setBounds(55, 140, 115, 13);
			contentPanel.add(lblNewLabel);
		}
		{
			lblNewLabel_1 = new JLabel("CONTRASEÑA:");
			lblNewLabel_1.setForeground(SystemColor.controlShadow);
			lblNewLabel_1.setFont(new Font("Verdana", Font.PLAIN, 15));
			lblNewLabel_1.setBounds(55, 186, 126, 19);
			contentPanel.add(lblNewLabel_1);
		}
		{
			txtUsuario = new JTextField();
			txtUsuario.setBounds(210, 134, 121, 29);
			contentPanel.add(txtUsuario);
			txtUsuario.setColumns(10);
		}
		{
			btnIngresar = new JButton("INGRESAR");
			btnIngresar.addActionListener(this);
			{


			}
			btnIngresar.setFont(new Font("Verdana", Font.PLAIN, 13));
			btnIngresar.setBounds(145, 234, 115, 35);
			contentPanel.add(btnIngresar);
		}
		{
			lblNewLabel_2 = new JLabel("");
			ImageIcon icon= new ImageIcon(VenLoginAdmi.class.getResource("/recursos/logingft.gif"));
			ImageIcon gifEscalado = new ImageIcon(icon.getImage()) {
		
			    public synchronized void paintIcon(Component c, Graphics g, int x, int y) {
			 
			        g.drawImage(
			            getImage(), 
			            x, y, 
			            lblNewLabel_2.getWidth(), lblNewLabel_2.getHeight(),
			            c
			        );
			    }
			    
		
			    public int getIconWidth() {
			        return lblNewLabel_2.getWidth(); 
			    }
			    
		
			    public int getIconHeight() {
			        return lblNewLabel_2.getHeight(); 
			    }
			};
		
			lblNewLabel_2.setIcon(gifEscalado);
			lblNewLabel_2.setBounds(0, 0, 434, 360);
			contentPanel.add(lblNewLabel_2);
		} 
		{
			pswContraseña = new JPasswordField();
			pswContraseña.setBounds(210, 183, 121, 29);
			contentPanel.add(pswContraseña);
		}
	}

	public void actionPerformed(ActionEvent e) {
		Ingresar();
	}

	private void Ingresar() {
		String usuario = txtUsuario.getText();
		String contraseña = String.valueOf(pswContraseña.getPassword());
		
		if (usuario.isEmpty() || contraseña.isEmpty()) {
	        JOptionPane.showMessageDialog(this, "Debe ingresar usuario y contraseña");
	        return;
	    } 
		
		MantLoginAdmi mla = new MantLoginAdmi();
		
		LoginAdmi logadmi = new LoginAdmi();
		logadmi.setUsuario(usuario);
		logadmi.setContraseña(contraseña);
		
		
		LoginAdmi usu = mla.ObtenerUsuario(logadmi);
		
		if(usu != null) {
			VenAdministrador vAdmi = new VenAdministrador();
			vAdmi.setVisible(true);
			dispose();
		}
		else {
			JOptionPane.showMessageDialog(this, "El usuario o contraseña es incorrecto");
		}
	}
}
