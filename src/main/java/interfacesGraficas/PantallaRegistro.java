package interfacesGraficas;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class PantallaRegistro extends JPanel {
	private JTextField campoUsuario;
	private JTextField campoContrase�a;

	/**
	 * Create the panel.
	 */
	public PantallaRegistro(Ventana ventana) {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 32, 298, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel tituloRegistro = new JLabel("Registro");
		tituloRegistro.setFont(new Font("Dubai Medium", Font.ITALIC, 60));
		tituloRegistro.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_tituloRegistro = new GridBagConstraints();
		gbc_tituloRegistro.anchor = GridBagConstraints.WEST;
		gbc_tituloRegistro.insets = new Insets(0, 0, 5, 5);
		gbc_tituloRegistro.gridx = 3;
		gbc_tituloRegistro.gridy = 1;
		add(tituloRegistro, gbc_tituloRegistro);
		
		JLabel labelUsuario = new JLabel("Usuario");
		labelUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		labelUsuario.setFont(new Font("Dubai Medium", Font.ITALIC, 20));
		GridBagConstraints gbc_labelUsuario = new GridBagConstraints();
		gbc_labelUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_labelUsuario.anchor = GridBagConstraints.EAST;
		gbc_labelUsuario.gridx = 1;
		gbc_labelUsuario.gridy = 4;
		add(labelUsuario, gbc_labelUsuario);
		
		campoUsuario = new JTextField();
		campoUsuario.setFont(new Font("Dubai Medium", Font.ITALIC, 20));
		GridBagConstraints gbc_campoUsuario = new GridBagConstraints();
		gbc_campoUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_campoUsuario.fill = GridBagConstraints.HORIZONTAL;
		gbc_campoUsuario.gridx = 2;
		gbc_campoUsuario.gridy = 4;
		add(campoUsuario, gbc_campoUsuario);
		campoUsuario.setColumns(10);
		
		JButton botonAtras = new JButton("Atras");
		botonAtras.setFont(new Font("Dubai Medium", Font.ITALIC, 20));
		botonAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JLabel labelContrase�a = new JLabel("Contrase\u00F1a");
		labelContrase�a.setHorizontalAlignment(SwingConstants.CENTER);
		labelContrase�a.setFont(new Font("Dubai Medium", Font.ITALIC, 20));
		GridBagConstraints gbc_labelContrase�a = new GridBagConstraints();
		gbc_labelContrase�a.anchor = GridBagConstraints.EAST;
		gbc_labelContrase�a.insets = new Insets(0, 0, 5, 5);
		gbc_labelContrase�a.gridx = 1;
		gbc_labelContrase�a.gridy = 7;
		add(labelContrase�a, gbc_labelContrase�a);
		
		campoContrase�a = new JTextField();
		campoContrase�a.setFont(new Font("Dubai Medium", Font.ITALIC, 20));
		GridBagConstraints gbc_campoContrase�a = new GridBagConstraints();
		gbc_campoContrase�a.insets = new Insets(0, 0, 5, 5);
		gbc_campoContrase�a.fill = GridBagConstraints.HORIZONTAL;
		gbc_campoContrase�a.gridx = 2;
		gbc_campoContrase�a.gridy = 7;
		add(campoContrase�a, gbc_campoContrase�a);
		campoContrase�a.setColumns(10);
		
		JButton botonRegistrarse = new JButton("Registrarse");
		botonRegistrarse.setFont(new Font("Dubai Medium", Font.ITALIC, 20));
		botonRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JComboBox comboBox = new JComboBox();
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 2;
		gbc_comboBox.gridy = 10;
		add(comboBox, gbc_comboBox);
		GridBagConstraints gbc_botonRegistrarse = new GridBagConstraints();
		gbc_botonRegistrarse.insets = new Insets(0, 0, 5, 5);
		gbc_botonRegistrarse.gridx = 2;
		gbc_botonRegistrarse.gridy = 14;
		add(botonRegistrarse, gbc_botonRegistrarse);
		GridBagConstraints gbc_botonAtras = new GridBagConstraints();
		gbc_botonAtras.insets = new Insets(0, 0, 5, 5);
		gbc_botonAtras.gridx = 2;
		gbc_botonAtras.gridy = 17;
		add(botonAtras, gbc_botonAtras);
		
	}

}
