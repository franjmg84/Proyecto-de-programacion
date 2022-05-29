package interfacesGraficas;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JLabel;

public class PantallaLogin extends JPanel {
	
	private Ventana ventana;
	private JTextField textField;
	private JTextField textField_1;
	
	public PantallaLogin(Ventana v) {
		this.ventana=v;
		
		setLayout(null);
		
		JButton botonLogin = new JButton("Login");
		botonLogin.setToolTipText("Pincha aqui para iniciar sesion");
		botonLogin.setFont(new Font("Dubai Medium", Font.BOLD | Font.ITALIC, 18));
		botonLogin.setBounds(106, 440, 263, 53);
		this.add(botonLogin);
		
		JButton btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.setToolTipText("Pincha aqui para registrarte");
		btnRegistrarse.setFont(new Font("Dubai Medium", Font.BOLD | Font.ITALIC, 18));
		btnRegistrarse.setBounds(513, 440, 273, 53);
		this.add(btnRegistrarse);
		
		JLabel lblNewLabel = new JLabel("Iniciar Sesion");
		lblNewLabel.setFont(new Font("Dubai Medium", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 52, 880, 43);
		add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(309, 195, 344, 43);
		add(textField);
		textField.setColumns(10);
		
		JLabel email = new JLabel("Email");
		email.setFont(new Font("Dubai Medium", Font.PLAIN, 18));
		email.setHorizontalAlignment(SwingConstants.CENTER);
		email.setBounds(213, 194, 86, 43);
		add(email);
		
		textField_1 = new JTextField();
		textField_1.setBounds(309, 287, 344, 43);
		add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setFont(new Font("Dubai Medium", Font.PLAIN, 18));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(186, 291, 122, 32);
		add(lblNewLabel_1);
		
		JButton botonCerrar = new JButton("Cerrar");
		botonCerrar.setFont(new Font("Dubai Medium", Font.BOLD | Font.ITALIC, 18));
		botonCerrar.setBounds(341, 558, 204, 53);
		add(botonCerrar);
		
		
	}
}
