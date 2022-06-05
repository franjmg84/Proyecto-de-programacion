package interfacesGraficas;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.SwingConstants;

import componentesvisuales.BotonAzul;

import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PantallaEleccionEstilo extends JPanel {
	
		private Ventana ventana;
		
		public PantallaEleccionEstilo(Ventana v) {
			this.ventana = v;
		setLayout(null);
		
		JButton botonAtras = new JButton("Atras");
		botonAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.irAPantalla("login");
			}
		});
		botonAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		botonAtras.setFont(new Font("Dubai Medium", Font.ITALIC, 20));
		botonAtras.setBounds(681, 589, 169, 48);
		add(botonAtras);
		
		JButton botonEntrar = new BotonAzul("Entrar");
		botonEntrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.irAPantalla("juego");
			}
		});
		botonEntrar.setFont(new Font("Dubai Medium", Font.ITALIC, 20));
		botonEntrar.setBounds(351, 491, 180, 56);
		add(botonEntrar);
		
		JRadioButton botonDance = new JRadioButton("Dance");
		botonDance.setForeground(Color.BLACK);
		botonDance.setBackground(new Color(255, 20, 147));
		botonDance.setFont(new Font("Dubai Medium", Font.ITALIC, 20));
		botonDance.setBounds(375, 367, 137, 44);
		add(botonDance);
		
		JRadioButton BotonRockPop = new JRadioButton("  Rock - Pop");
		BotonRockPop.setBackground(new Color(255, 20, 147));
		BotonRockPop.setFont(new Font("Dubai Medium", Font.ITALIC, 20));
		BotonRockPop.setHorizontalAlignment(SwingConstants.LEFT);
		BotonRockPop.setBounds(499, 273, 137, 46);
		add(BotonRockPop);
		
		JRadioButton botonTv = new JRadioButton("Series de TV");
		botonTv.setBackground(new Color(255, 20, 147));
		botonTv.setFont(new Font("Dubai Medium", Font.ITALIC, 20));
		botonTv.setHorizontalAlignment(SwingConstants.LEFT);
		botonTv.setSelected(true);
		botonTv.setBounds(251, 274, 137, 44);
		add(botonTv);
		
		JLabel lblNewLabel = new JLabel("Selecciona el estilo");
		lblNewLabel.setFont(new Font("Dubai Medium", Font.PLAIN, 40));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(278, 151, 342, 79);
		add(lblNewLabel);
		
		JLabel labelFondo = new JLabel("");
		labelFondo.setIcon(new ImageIcon(PantallaEleccionEstilo.class.getResource("/imagenes/fondo con logo21.png")));
		labelFondo.setBounds(0, 0, 900, 700);
		add(labelFondo);
	}
}
