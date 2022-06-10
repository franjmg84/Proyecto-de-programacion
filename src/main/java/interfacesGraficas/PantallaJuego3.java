package interfacesGraficas;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

import componentesvisuales.BotonAzul;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.SwingConstants;


public class PantallaJuego3 extends JPanel {
	private Ventana ventana;
	private Clip musica;
	/**
	 * Create the panel.
	 * @param clip 
	 * @param ventana 
	 */
	public PantallaJuego3(Ventana v, Clip clip) {
		this.ventana=v;
		try {
			AudioInputStream archivo = AudioSystem.getAudioInputStream(new File("./musica/dance/Mambo Zenaida.wav"));
			this.musica = AudioSystem.getClip();
			musica.open(archivo);
			
		} catch (LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedAudioFileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		setLayout(null);
		
		BotonAzul BotonConSonido = new BotonAzul("Atras");
		BotonConSonido.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		BotonConSonido.setText("Play");
		BotonConSonido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//try {
					musica.start();
					/*Thread.sleep(15000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}*/
				//musica.stop();
			}
		});
		
		JButton botonRespuesta3 = new BotonAzul("Respuesta 3");
		botonRespuesta3.setFont(new Font("Tahoma", Font.PLAIN, 23));
		botonRespuesta3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				ventana.irAPantalla("juego4");
				
			}
		});
		
		JButton botonSalir = new BotonAzul("Salir");
		botonSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		botonSalir.setFont(new Font("Tahoma", Font.PLAIN, 23));
		botonSalir.setBounds(387, 517, 125, 48);
		add(botonSalir);
		
		JButton botonRespuesta4 = new BotonAzul("Respuesta 4");
		botonRespuesta4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				ventana.irAPantalla("juego4");
			}
		});
		botonRespuesta4.setFont(new Font("Tahoma", Font.PLAIN, 23));
		botonRespuesta4.setBounds(467, 383, 216, 48);
		add(botonRespuesta4);
		botonRespuesta3.setBounds(207, 383, 216, 48);
		add(botonRespuesta3);
		
		JButton botonRespuesta2 = new BotonAzul("Respuesta 2");
		botonRespuesta2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ventana.irAPantalla("juego4");
				
			}
		});
		botonRespuesta2.setFont(new Font("Tahoma", Font.PLAIN, 24));
		botonRespuesta2.setBounds(467, 285, 216, 48);
		add(botonRespuesta2);
		
		JButton botonRespuesta1 = new BotonAzul("Respuesta 1");
		botonRespuesta1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				ventana.irAPantalla("juego4");
			}
		});
		botonRespuesta1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		botonRespuesta1.setBounds(207, 285, 216, 48);
		add(botonRespuesta1);
		
		BotonAzul botonStop = new BotonAzul("Atras");
		botonStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				musica.stop();
			}
		});
		botonStop.setText("Stop");
		botonStop.setFont(new Font("Dubai Medium", Font.ITALIC, 20));
		botonStop.setBounds(501, 184, 132, 48);
		add(botonStop);
		BotonConSonido.setFont(new Font("Dubai Medium", Font.ITALIC, 20));
		BotonConSonido.setBounds(257, 184, 132, 48);
		add(BotonConSonido);
		
		JLabel fondoJuego = new JLabel("");
		fondoJuego.setIcon(new ImageIcon(PantallaJuego3.class.getResource("/imagenes/fondo con logo.png")));
		fondoJuego.setBounds(0, 0, 900, 700);
		add(fondoJuego);
		
	
	}
}
