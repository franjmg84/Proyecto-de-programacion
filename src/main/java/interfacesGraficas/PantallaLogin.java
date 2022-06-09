package interfacesGraficas;

import javax.swing.JPanel;


import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

import com.mysql.cj.xdevapi.Statement;


import clases.Usuario;
import componentesvisuales.BotonAzul;
import excepciones.UsuarioNoExisteException;
import hilos.MusicaFondo;
import utils.ConexionBD;

import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;

public class PantallaLogin extends JPanel {

	private Ventana ventana;
	private JTextField campoEmail;
	private JPasswordField campoContraseña;


	public PantallaLogin(Ventana v,Clip a) {
		this.ventana = v;
		setLayout(null);

		JButton botonLogin = new BotonAzul("Login");
		botonLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String email = campoEmail.getText();
				String contraseña = new String(campoContraseña.getPassword());
				System.out.println(email+contraseña);
				  java.sql.Statement smt = ConexionBD.conectar();
			        
			       

			        try { 
			        	System.out.println("Dentro del try");
			        	ResultSet consulta = smt.executeQuery("select * from usuario where email='"+email+"'");
						if(consulta.next()){
						  System.out.println("primer if");
						  System.out.println(consulta.getString("pass"));
						  System.out.println(contraseña);
						    if(contraseña.equals(consulta.getString("pass")) ){
						    	System.out.println("Segundo if");
						    	 ConexionBD.desconectar();
						    	ventana.irAPantalla("estilo");
						    }
						   
						   
						}else {System.out.println("Soy el else");
						    ConexionBD.desconectar();
						    //throw new UsuarioNoExisteException("No existe el mail en la BD");
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
						
				ventana.irAPantalla("estilo");
			
			}
		});
		
		JButton btnMusicOn = new JButton("Play");
		btnMusicOn.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnMusicOn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ventana.clip.start();
			}
		});
		btnMusicOn.setBounds(59, 42, 85, 27);
		add(btnMusicOn);
		
		JButton btnNewButton = new JButton("Stop");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				ventana.clip.stop();
;			}
		});
		btnNewButton.setBounds(775, 42, 85, 27);
		add(btnNewButton);
		botonLogin.setBackground(Color.LIGHT_GRAY);
		botonLogin.setFont(new Font("Dubai Medium", Font.BOLD | Font.ITALIC, 20));
		//botonLogin.addMouseListener(new MouseAdapter() {
		
		//});
	
		
		botonLogin.setToolTipText("Pincha aqui para iniciar sesion");
		botonLogin.setBounds(369, 455, 169, 53);
		this.add(botonLogin);

		JButton botonRegistro = new BotonAzul("Registrarse");
		botonRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		botonRegistro.setBackground(Color.LIGHT_GRAY);
		botonRegistro.setFont(new Font("Dubai Medium", Font.BOLD | Font.ITALIC, 20));

		botonRegistro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.irAPantalla("registro");

			}
		});
		botonRegistro.setToolTipText("Pincha aqui para registrarte");
		botonRegistro.setBounds(40, 590, 169, 53);
		this.add(botonRegistro);

		JLabel lblNewLabel = new JLabel("Iniciar Sesion");
		lblNewLabel.setForeground(Color.LIGHT_GRAY);
		lblNewLabel.setFont(new Font("Dubai Medium", Font.BOLD | Font.ITALIC, 40));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 129, 900, 53);
		add(lblNewLabel);

		campoEmail = new JTextField();
		campoEmail.setFont(new Font("Tahoma", Font.PLAIN, 20));
		campoEmail.setBounds(257, 253, 383, 27);
		add(campoEmail);
		campoEmail.setColumns(10);

		JLabel email = new JLabel("Email");
		email.setForeground(Color.LIGHT_GRAY);
		email.setFont(new Font("Dubai Medium", Font.PLAIN, 20));
		email.setHorizontalAlignment(SwingConstants.CENTER);
		email.setBounds(0, 206, 900, 43);
		add(email);

		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_1.setFont(new Font("Dubai Medium", Font.PLAIN, 20));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(0, 305, 900, 32);
		this.add(lblNewLabel_1);

		JButton botonCerrar = new BotonAzul("Cerrar");
		botonCerrar.setBackground(Color.LIGHT_GRAY);
		botonCerrar.setFont(new Font("Dubai Medium", Font.BOLD | Font.ITALIC, 20));
		botonCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		botonCerrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		botonCerrar.setToolTipText("Pincha aqui para cerrar");
		botonCerrar.setBounds(689, 590, 169, 53);
		this.add(botonCerrar);
		
		
		
		
		
		campoContraseña = new JPasswordField();
		campoContraseña.setFont(new Font("Tahoma", Font.PLAIN, 20));
		campoContraseña.setBounds(257, 347, 383, 27);
		add(campoContraseña);

		JLabel fondoLogin = new JLabel("");
		fondoLogin.setIcon(new ImageIcon(PantallaLogin.class.getResource("/imagenes/fondo con logo.png")));
		fondoLogin.setBounds(0, 0, 900, 701);
		add(fondoLogin);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(PantallaLogin.class.getResource("/imagenes/fondo login.png")));
		lblNewLabel_2.setBounds(0, 0, 900, 701);
		add(lblNewLabel_2);

	}
}
