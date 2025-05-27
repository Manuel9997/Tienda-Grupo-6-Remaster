package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ContraseñaAdmin extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JTextField txtID;
	private JTextField txtContraseña;
	private JButton btnIngresar;

	/**
	 * Launch the application.
	 */
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
		setBounds(100, 100, 387, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			lblNewLabel = new JLabel("ID");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblNewLabel.setBounds(139, 43, 45, 13);
			contentPanel.add(lblNewLabel);
		}
		{
			lblNewLabel_1 = new JLabel("Contraseña");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblNewLabel_1.setBounds(139, 113, 91, 19);
			contentPanel.add(lblNewLabel_1);
		}
		{
			txtID = new JTextField();
			txtID.setBounds(139, 64, 96, 19);
			contentPanel.add(txtID);
			txtID.setColumns(10);
		}
		{
			txtContraseña = new JTextField();
			txtContraseña.setBounds(139, 136, 96, 19);
			contentPanel.add(txtContraseña);
			txtContraseña.setColumns(10);
		}
		{
			btnIngresar = new JButton("Ingresar");
			btnIngresar.addActionListener(this);
			btnIngresar.setFont(new Font("Tahoma", Font.PLAIN, 13));
			btnIngresar.setBounds(139, 200, 96, 21);
			contentPanel.add(btnIngresar);
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
