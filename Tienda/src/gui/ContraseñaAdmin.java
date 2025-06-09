package gui;


import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.*;
import java.awt.FlowLayout;

import javax.swing.border.EmptyBorder;

import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.SystemColor;

public class ContraseñaAdmin extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JTextField txtID;
	private JTextField txtContraseña;
	private JButton btnIngresar;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;

	
	

	
	
	public static void main(String[] args) {
		try {
			ContraseñaAdmin dialog = new ContraseñaAdmin();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ContraseñaAdmin() {
		setAlwaysOnTop(true);
		setModal(true);
		setBounds(100, 100, 450, 399);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			lblNewLabel_3 = new JLabel("LOGIN");
			lblNewLabel_3.setForeground(new Color(255, 255, 255));
			lblNewLabel_3.setFont(new Font("Verdana", Font.PLAIN, 26));
			lblNewLabel_3.setBounds(164, 46, 96, 55);
			contentPanel.add(lblNewLabel_3);
		}
		{
			lblNewLabel = new JLabel("ID ADMIN:");
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
			txtID = new JTextField();
			txtID.setBounds(210, 134, 121, 29);
			contentPanel.add(txtID);
			txtID.setColumns(10);
		}
		{
			txtContraseña = new JTextField();
			txtContraseña.setBounds(210, 183, 121, 29);
			contentPanel.add(txtContraseña);
			txtContraseña.setColumns(10);
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
			ImageIcon icon= new ImageIcon(ContraseñaAdmin.class.getResource("/recursos/rueda2.gif"));
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
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnIngresar) {
			do_btnIngresar_actionPerformed(e);
		}
	}
	protected void do_btnIngresar_actionPerformed(ActionEvent e) {
		int id = Integer.parseInt(txtID.getText());
		int contraseña = Integer.parseInt(txtContraseña.getText());
		
		if(id == 001 && contraseña == 12345) {
			VenAdministrador vAdmi = new VenAdministrador();
			vAdmi.setVisible(true);
			dispose();
		}
		else {
			JOptionPane.showMessageDialog(this, "Contraseña incorrecta");
		}	 
	}
}
