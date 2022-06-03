package interfacesGraficas;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.SwingConstants;

import componentesvisuales.BotonAzul;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.DefaultComboBoxModel;
import enumeraciones.Pais;

public class PantallaRegistro extends JPanel {
	private JTextField campoUsuario;
	private JTextField campoContraseña;
	private Ventana ventana;
	/**
	 * Create the panel.
	 */
	public PantallaRegistro( Ventana v) {
		this.ventana = v;
		setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Pais");
		lblNewLabel_2.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Dubai Medium", Font.ITALIC, 20));
		lblNewLabel_2.setBounds(387, 406, 119, 28);
		add(lblNewLabel_2);
		
		JLabel tituloRegistro = new JLabel("Registro");
		tituloRegistro.setForeground(Color.LIGHT_GRAY);
		tituloRegistro.setBounds(310, 100, 268, 102);
		tituloRegistro.setFont(new Font("Dubai Medium", Font.ITALIC, 40));
		tituloRegistro.setHorizontalAlignment(SwingConstants.CENTER);
		add(tituloRegistro);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(444, 153, 45, 13);
		add(lblNewLabel);
		
		JLabel labelUsuario = new JLabel("Usuario");
		labelUsuario.setForeground(Color.LIGHT_GRAY);
		labelUsuario.setBounds(399, 221, 90, 35);
		labelUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		labelUsuario.setFont(new Font("Dubai Medium", Font.ITALIC, 20));
		add(labelUsuario);
		
		campoUsuario = new JTextField();
		campoUsuario.setBounds(254, 266, 382, 27);
		campoUsuario.setFont(new Font("Dubai Medium", Font.ITALIC, 20));
		add(campoUsuario);
		campoUsuario.setColumns(10);
		
		JButton botonAtras = new BotonAzul("Atras");
		botonAtras.setBounds(681, 590, 169, 48);
		botonAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.irAPantalla("login");
			}
		});
		botonAtras.setFont(new Font("Dubai Medium", Font.ITALIC, 20));
		botonAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JLabel labelContraseña = new JLabel("Contrase\u00F1a");
		labelContraseña.setForeground(Color.LIGHT_GRAY);
		labelContraseña.setBounds(387, 303, 119, 35);
		labelContraseña.setHorizontalAlignment(SwingConstants.CENTER);
		labelContraseña.setFont(new Font("Dubai Medium", Font.ITALIC, 20));
		add(labelContraseña);
		
		campoContraseña = new JTextField();
		campoContraseña.setBounds(254, 348, 382, 27);
		campoContraseña.setFont(new Font("Dubai Medium", Font.ITALIC, 20));
		add(campoContraseña);
		campoContraseña.setColumns(10);
		
		JButton botonRegistrarse = new BotonAzul("Registrarse");
		botonRegistrarse.setBounds(362, 518, 169, 48);
		botonRegistrarse.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String nombreUsuario=campoUsuario.getText();
				//String contraseña=new String()
				//String email=campoEmail.
			}
		});
		botonRegistrarse.setFont(new Font("Dubai Medium", Font.ITALIC, 20));
		botonRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(Pais.values()));
		comboBox.setBounds(310, 444, 283, 27);
		add(comboBox);
		add(botonRegistrarse);
		add(botonAtras);
		
		JLabel fondoLogo = new JLabel("");
		fondoLogo.setIcon(new ImageIcon(PantallaRegistro.class.getResource("/imagenes/fondo con logo.png")));
		fondoLogo.setBounds(0, 0, 900, 701);
		add(fondoLogo);
		
	}
}
