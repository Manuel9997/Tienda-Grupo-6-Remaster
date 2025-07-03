 package gui;

import java.awt.EventQueue;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Image;
import java.awt.Color;

import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JSlider;
import javax.swing.UIManager;
import java.awt.SystemColor;

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
	public int day;
	public int year;
	public int month;
	public int second;
	public int minute;
	public int hour;
	public String tmam;
	private static Clip clipreproduciendo;
	private JSlider controlvol;
	private static FloatControl volumeControl;

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
					 int dai= cal.get(Calendar.DAY_OF_MONTH);
					 String day, month, second,minute,hour;
					 if(dai<10) {
						 day="0"+Integer.toString(dai);
					 }
					 else {
						 day=Integer.toString(dai);
					 }
					int mont= cal.get(Calendar.MONTH);
					 if(mont<10) {
						 month="0"+Integer.toString(mont);
					 }
					 else {
						 month=Integer.toString(mont);
					 }
					
					
					year= cal.get(Calendar.YEAR);
					
					 int secon= cal.get(Calendar.SECOND);
					 if(secon<10) {
						 second="0"+Integer.toString(secon);
					 }
					 else {
						 second=Integer.toString(secon);
					 }
					 
					 int minut= cal.get(Calendar.MINUTE);
					 
					 if(minut<10) {
						 minute="0"+Integer.toString(minut);
					 }
					 else {
						 minute=Integer.toString(minut);
					 }
					 
					 int hou= cal.get(Calendar.HOUR);
					 
					 
					 if(hou == 0) { 
						    hour = "12";
						}
					 else if(hou<10) {
						 hour="0"+Integer.toString(hou);
					 }
					 else {
						 hour=Integer.toString(hou);
					 }
					
					int ampm= cal.get(Calendar.AM_PM);

				if(ampm == 0) {
					
					tmam= "am";
				}
				else {
					tmam= "pm";
				}
					
					
					lblclock.setText("Fecha: "+ day+"/"+month+"/"+year+"  Hora: "+hour+":"+minute+":"+second+tmam);
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
	 * @throws LineUnavailableException 
	 * @throws IOException 
	 * @throws UnsupportedAudioFileException 
	 */
	public Inicio() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
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
	    {
	    	controlvol = new JSlider();
	    	controlvol.setValue(80);
	    	controlvol.setMajorTickSpacing(25);
	    	controlvol.setBackground(SystemColor.activeCaptionBorder);
	    	controlvol.setBounds(10, 11, 164, 16);
	    	panel.add(controlvol);
	    	 controlvol.addChangeListener(e -> {
	    	        if (!controlvol.getValueIsAdjusting()) {
	    	            setVolume(controlvol.getValue());
	    	        }
	    	    });
	    	 controlvol.addChangeListener(e -> setVolume(controlvol.getValue()));
	    	 
	    }
    
	    lblclock = new JLabel("");
	    lblclock.setFont(new Font("Verdana", Font.PLAIN, 13));
	    lblclock.setForeground(new Color(255, 255, 255));
	    lblclock.setBounds(488, 0, 289, 43);
	    panel.add(lblclock);
	    clock();
	    music();
	    
        
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
		VenLoginAdmi contraseña = new VenLoginAdmi();
		contraseña.setVisible(true);
	}
	
	protected void do_mnEmpleado_actionPerformed(ActionEvent e) {
		VenEmpleado vEmple = new VenEmpleado();
		vEmple.setVisible(true);
	}
	
	public static void music() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		URL url = Inicio.class.getResource("/recursos/portugal.wav");
		if(url == null) {
			JOptionPane.showMessageDialog(null,"No se encontró");
		}
		AudioInputStream audiostream= AudioSystem.getAudioInputStream(url);
		clipreproduciendo = AudioSystem.getClip();
		clipreproduciendo.open(audiostream);
		 volumeControl = (FloatControl) clipreproduciendo.getControl(FloatControl.Type.MASTER_GAIN);
		 setVolume(80);  
		 clipreproduciendo.start();
	}
	

	private static void setVolume(int volume) {
	    if (volumeControl != null) {
	        float min = volumeControl.getMinimum();
	        float max = volumeControl.getMaximum();
	        float dB = (float) (min + (max - min) * (volume / 100.0));
	        volumeControl.setValue(dB);
	    }
	}
	

}
