package interfacesGraficas;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class PantallaLogin extends JPanel {
	
	private Ventana ventana;
	
	public PantallaLogin(Ventana v) {
		this.ventana=v;
		
		setLayout(null);
		
		JButton botonLogin = new JButton("Login");
		botonLogin.setToolTipText("Pincha aqui para iniciar sesion");
		botonLogin.setFont(new Font("Dubai Medium", Font.BOLD | Font.ITALIC, 18));
		botonLogin.setBounds(38, 196, 157, 31);
		this.add(botonLogin);
		
		JButton btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.setToolTipText("Pincha aqui para registrarte");
		btnRegistrarse.setFont(new Font("Dubai Medium", Font.BOLD | Font.ITALIC, 18));
		btnRegistrarse.setBounds(306, 196, 157, 31);
		this.add(btnRegistrarse);
		
		
	}
}
