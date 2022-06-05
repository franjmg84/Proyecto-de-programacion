package interfacesGraficas;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import clases.Usuario;
import componentesvisuales.BotonAzul;
import enumeraciones.Pais;
import enumeraciones.Idioma;

public class PantallaRegistro extends JPanel {
	private JTextField campoUsuario;
	private Ventana ventana;
	private JPasswordField passwordField;
	private JTextField textField;
	/**
	 * Create the panel.
	 */
	public PantallaRegistro( Ventana v) {
		this.ventana = v;
		setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(Idioma.values()));
		comboBox.setBounds(499, 461, 119, 27);
		add(comboBox);
		
		
		
		JLabel labelIdioma = new JLabel("Idioma");
		labelIdioma.setHorizontalAlignment(SwingConstants.CENTER);
		labelIdioma.setForeground(Color.LIGHT_GRAY);
		labelIdioma.setFont(new Font("Dubai Medium", Font.ITALIC, 20));
		labelIdioma.setBounds(489, 423, 119, 28);
		add(labelIdioma);
		
		textField = new JTextField();
		textField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		textField.setBounds(254, 284, 382, 28);
		add(textField);
		textField.setColumns(10);
		
		final JLabel campoEmail = new JLabel("Email");
		campoEmail.setHorizontalAlignment(SwingConstants.CENTER);
		campoEmail.setFont(new Font("Dubai Medium", Font.PLAIN, 20));
		campoEmail.setForeground(Color.LIGHT_GRAY);
		campoEmail.setBounds(399, 239, 88, 48);
		add(campoEmail);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(254, 368, 382, 28);
		add(passwordField);
		
		JLabel labelPais = new JLabel("Pais");
		labelPais.setForeground(Color.LIGHT_GRAY);
		labelPais.setHorizontalAlignment(SwingConstants.CENTER);
		labelPais.setFont(new Font("Dubai Medium", Font.ITALIC, 20));
		labelPais.setBounds(277, 423, 119, 28);
		add(labelPais);
		
		JLabel tituloRegistro = new JLabel("Registro");
		tituloRegistro.setForeground(Color.LIGHT_GRAY);
		tituloRegistro.setBounds(310, 75, 268, 102);
		tituloRegistro.setFont(new Font("Dubai Medium", Font.ITALIC, 40));
		tituloRegistro.setHorizontalAlignment(SwingConstants.CENTER);
		add(tituloRegistro);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(444, 153, 45, 13);
		add(lblNewLabel);
		
		JLabel labelUsuario = new JLabel("Usuario");
		labelUsuario.setForeground(Color.LIGHT_GRAY);
		labelUsuario.setBounds(399, 163, 90, 35);
		labelUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		labelUsuario.setFont(new Font("Dubai Medium", Font.ITALIC, 20));
		add(labelUsuario);
		
		campoUsuario = new JTextField();
		campoUsuario.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		campoUsuario.setBounds(254, 201, 382, 28);
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
		labelContraseña.setBounds(387, 323, 119, 35);
		labelContraseña.setHorizontalAlignment(SwingConstants.CENTER);
		labelContraseña.setFont(new Font("Dubai Medium", Font.ITALIC, 20));
		add(labelContraseña);
		
		JButton botonRegistrarse = new BotonAzul("Registrarse");
		botonRegistrarse.setBounds(362, 518, 169, 48);
		
		botonRegistrarse.setFont(new Font("Dubai Medium", Font.ITALIC, 20));
		botonRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		final JComboBox seleccionPais = new JComboBox();
		seleccionPais.setModel(new DefaultComboBoxModel(Pais.values()));
		seleccionPais.setBounds(277, 461, 119, 27);
		add(seleccionPais);
		add(botonRegistrarse);
		add(botonAtras);
		
		JLabel fondoLogo = new JLabel("");
		fondoLogo.setIcon(new ImageIcon(PantallaRegistro.class.getResource("/imagenes/fondo con logo.png")));
		fondoLogo.setBounds(0, 0, 900, 701);
		add(fondoLogo);
		
		botonRegistrarse.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String nombreUsuario=campoUsuario.getText();
				String contraseña=new String(passwordField.getPassword());
				String email=campoEmail.getText();
				Pais pais= (Pais)seleccionPais.getSelectedItem();
				try {
					new Usuario(nombreUsuario,email,pais, null, contraseña);
					JOptionPane.showMessageDialog(ventana,"Registrado con éxito",
							"Registro Completado",JOptionPane.PLAIN_MESSAGE);
					ventana.irAPantalla("login");
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(ventana, e1.getMessage(), "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}
}
