 package gui;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.Color;

import java.util.Calendar;
import java.util.GregorianCalendar;



public class Inicio extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnNewMenu;
	private JMenuItem mnAdministrador;
	private JMenuItem mnEmpleado;
	private JPanel panel;
	private JLabel lblclock;
	private JLabel logofondo;
	

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

	public void clock() {
		Thread clock =new Thread() {
			public void run() {
				try {
					for(;;) {
					Calendar cal= new GregorianCalendar();
					int day= cal.get(Calendar.DAY_OF_MONTH);
					int month= cal.get(Calendar.MONTH);
					int year= cal.get(Calendar.YEAR);
					
					int second= cal.get(Calendar.SECOND);
					int minute= cal.get(Calendar.MINUTE);
					int hour= cal.get(Calendar.HOUR);
					
					int ampm= cal.get(Calendar.AM_PM);
					String tmam="a";
				if(ampm == 0) {
					
					tmam= "am";
				}
				else {
					tmam= "pm";
				}
					
					
					lblclock.setText("Fecha: "+ day+"/"+month+"/"+year+" Hora: "+hour+":"+minute+":"+second+tmam);
					sleep(1000);
					}
				}
				catch(InterruptedException e) {
					e.printStackTrace();
				}
				
			}
		};

		clock.start();
	}
	
	
	
	/**
	 * Create the frame.
	 */
	public Inicio() {
	    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    setBounds(100, 100, 803, 683);
	    
	
	    

	    menuBar = new JMenuBar();
	    setJMenuBar(menuBar);
	    
	    
	    

	    mnNewMenu = new JMenu("Menú");
	    mnNewMenu.setFont(new Font("Verdana", Font.PLAIN, 20));
	    mnNewMenu.setBackground(new Color(0, 255, 255));
	    menuBar.add(mnNewMenu);

	    

	    try {
            ImageIcon iconomenu = new ImageIcon(getClass().getResource("/recursos/menuicon.png"));
            int anchoDeseado = 32; 
            int altoDeseado = 32;  
            Image imagenOriginal = iconomenu.getImage();
            Image imagenEscalada = imagenOriginal.getScaledInstance(anchoDeseado, altoDeseado, Image.SCALE_SMOOTH);
            ImageIcon iconoRedimensionado = new ImageIcon(imagenEscalada);
            mnNewMenu.setIcon(iconoRedimensionado);

        } catch (Exception e) {
            System.err.println("No se pudo cargar o escalar el icono del menú: " + e.getMessage());
            e.printStackTrace();
        }
	    
	    
	    
	    mnAdministrador = new JMenuItem("Administrador");
	    mnAdministrador.setFont(new Font("Verdana", Font.PLAIN, 17));
	    mnAdministrador.setBackground(new Color(192, 192, 192));
	    mnAdministrador.addActionListener(this);
	    mnNewMenu.add(mnAdministrador);
	    
	    
	    try {
            ImageIcon iconoadmin = new ImageIcon(getClass().getResource("/recursos/adminicon.png"));
            int anchoDeseado = 32; 
            int altoDeseado = 32;  
            Image imagenOriginal = iconoadmin.getImage();
            Image imagenEscalada = imagenOriginal.getScaledInstance(anchoDeseado, altoDeseado, Image.SCALE_SMOOTH);
            ImageIcon iconoRedimensionado = new ImageIcon(imagenEscalada);
            mnAdministrador.setIcon(iconoRedimensionado);

        } catch (Exception e) {
            System.err.println("No se pudo cargar o escalar el icono del menú: " + e.getMessage());
            e.printStackTrace();
        }
 
	    
	    mnEmpleado = new JMenuItem("Empleado");
	    mnEmpleado.setFont(new Font("Verdana", Font.PLAIN, 17));
	    mnEmpleado.addActionListener(this);
	    mnNewMenu.add(mnEmpleado);
	    
	    
	    try {
            ImageIcon iconoempleado = new ImageIcon(getClass().getResource("/recursos/empleadoicon.png"));
            int anchoDeseado = 32; 
            int altoDeseado = 32;  
            Image imagenOriginal = iconoempleado.getImage();
            Image imagenEscalada = imagenOriginal.getScaledInstance(anchoDeseado, altoDeseado, Image.SCALE_SMOOTH);
            ImageIcon iconoRedimensionado = new ImageIcon(imagenEscalada);
            mnEmpleado.setIcon(iconoRedimensionado);

        } catch (Exception e) {
            System.err.println("No se pudo cargar o escalar el icono del menú: " + e.getMessage());
            e.printStackTrace();
        }
	    


	    contentPane = new JPanel();
	    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	    contentPane.setBackground(new Color(240, 240, 245));
	    setContentPane(contentPane);
	    contentPane.setLayout(null);
	    
	    panel = new JPanel();
	    panel.setBounds(0, 0, 787, 606);
	    contentPane.add(panel);
	    panel.setLayout(null);
	    panel.setBackground(new Color(0x2f4f4f));
	    panel.setOpaque(true);

	    
	    lblclock = new JLabel("");
	    lblclock.setFont(new Font("Tahoma", Font.PLAIN, 15));
	    lblclock.setForeground(new Color(255, 255, 255));
	    lblclock.setBounds(512, 33, 249, 43);
	    panel.add(lblclock);
	    
	    clock();
        
        logofondo = new JLabel("New label");
        logofondo.setFont(new Font("Verdana", Font.PLAIN, 11));
        logofondo.setIcon(new ImageIcon(Inicio.class.getResource("/recursos/logo.png")));
        logofondo.setBounds(0, 0, 787, 606);
        panel.add(logofondo);
        
        logofondo.setHorizontalAlignment(SwingConstants.CENTER);
        logofondo.setVerticalAlignment(SwingConstants.CENTER);


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
