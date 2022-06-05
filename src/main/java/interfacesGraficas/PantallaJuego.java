package interfacesGraficas;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import componentesvisuales.BotonAzul;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class PantallaJuego extends JPanel {
	private Ventana ventana;
	/**
	 * Create the panel.
	 * @param ventana 
	 */
	public PantallaJuego(Ventana v) {
		setLayout(null);
		
		BotonAzul botonPlay = new BotonAzul("Atras");
		botonPlay.setText("Play");
		botonPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		BotonAzul botonStop = new BotonAzul("Atras");
		botonStop.setText("Stop");
		botonStop.setFont(new Font("Dubai Medium", Font.ITALIC, 20));
		botonStop.setBounds(565, 223, 169, 48);
		add(botonStop);
		botonPlay.setFont(new Font("Dubai Medium", Font.ITALIC, 20));
		botonPlay.setBounds(176, 223, 169, 48);
		add(botonPlay);
		
		JLabel fondoJuego = new JLabel("");
		fondoJuego.setIcon(new ImageIcon(PantallaJuego.class.getResource("/imagenes/fondo juego rockola.png")));
		fondoJuego.setBounds(0, 0, 900, 700);
		add(fondoJuego);
		
	
	}
}
