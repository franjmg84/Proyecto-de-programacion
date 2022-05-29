package interfacesGraficas;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

import componentesvisuales.BotonAzul;

import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PantallaLogin extends JPanel {
	
	private Ventana ventana;
	private JTextField campoUsuario;
	private JPasswordField passwordField;
	
	public PantallaLogin(Ventana v) {
		this.ventana=v;
		
		setLayout(null);
		
		JButton botonLogin = new BotonAzul("Login");
		botonLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		botonLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		botonLogin.setToolTipText("Pincha aqui para iniciar sesion");
		botonLogin.setBounds(106, 440, 263, 53);
		this.add(botonLogin);
		
		JButton botonRegistro = new BotonAzul("Registrarse");
		botonRegistro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.irAPantalla("registro");
			}
		});
		botonRegistro.setBackground(new Color(0, 204, 255));
		botonRegistro.setToolTipText("Pincha aqui para registrarte");
		botonRegistro.setFont(new Font("Dubai Medium", Font.BOLD | Font.ITALIC, 18));
		botonRegistro.setBounds(513, 440, 273, 53);
		this.add(botonRegistro);
		
		JLabel lblNewLabel = new JLabel("Iniciar Sesion");
		lblNewLabel.setFont(new Font("Dubai Medium", Font.BOLD | Font.ITALIC, 40));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 52, 880, 43);
		add(lblNewLabel);
		
		campoUsuario = new JTextField();
		campoUsuario.setBounds(222, 206, 477, 27);
		add(campoUsuario);
		campoUsuario.setColumns(10);
		
		JLabel email = new JLabel("Email");
		email.setFont(new Font("Dubai Medium", Font.PLAIN, 18));
		email.setHorizontalAlignment(SwingConstants.CENTER);
		email.setBounds(106, 205, 86, 43);
		add(email);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setFont(new Font("Dubai Medium", Font.PLAIN, 18));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(105, 291, 122, 32);
		this.add(lblNewLabel_1);
		
		JButton botonCerrar = new BotonAzul("Cerrar");
		botonCerrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.irAPantalla("login");
			}
		});
		botonCerrar.setToolTipText("Pincha aqui para cerrar");
		botonCerrar.setForeground(new Color(0, 0, 0));
		botonCerrar.setBackground(new Color(0, 204, 255));
		botonCerrar.setFont(new Font("Dubai Medium", Font.BOLD | Font.ITALIC, 18));
		botonCerrar.setBounds(341, 558, 204, 53);
		this.add(botonCerrar);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(222, 291, 477, 27);
		add(passwordField);
		
		
	}
}
