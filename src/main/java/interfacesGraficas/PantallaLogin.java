package interfacesGraficas;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

import clases.Sonido;
import clases.Usuario;
import componentesvisuales.BotonAzul;
import hilos.MusicaFondo;

import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;

public class PantallaLogin extends JPanel {

	private Ventana ventana;
	private JTextField campoEmail;
	private JPasswordField campoContraseña;
	private Sonido sonido;

	public PantallaLogin(Ventana v) {
		this.ventana = v;
		setLayout(null);

		JButton botonLogin = new BotonAzul("Login");
		botonLogin.setBackground(Color.LIGHT_GRAY);
		botonLogin.setFont(new Font("Dubai Medium", Font.BOLD | Font.ITALIC, 20));
		botonLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String nombre = campoEmail.getText();
				String contraseña = new String(campoContraseña.getPassword());
				ventana.irAPantalla("estilo");
			}
		});
		botonLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
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
		
		
		MusicaFondo musica= new MusicaFondo(new File("./Bon Jovi.wav"));
		musica.start();
		
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
