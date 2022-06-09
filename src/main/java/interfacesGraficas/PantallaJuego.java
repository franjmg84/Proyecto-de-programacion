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


public class PantallaJuego extends JPanel {
	private Ventana ventana;
	private Clip musica;
	/**
	 * Create the panel.
	 * @param clip 
	 * @param ventana 
	 */
	public PantallaJuego(Ventana v, Clip clip) {
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
				musica.start();
				try {
					Thread.sleep(15000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				musica.stop();
			}
		});
		
		JButton btnNewButton_2 = new JButton("Respuesta 3");
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 23));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JButton botonSalir = new JButton("Salir");
		botonSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		botonSalir.setFont(new Font("Tahoma", Font.PLAIN, 23));
		botonSalir.setBounds(724, 597, 125, 48);
		add(botonSalir);
		
		JButton btnNewButton_3 = new JButton("Respuesta 4");
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 23));
		btnNewButton_3.setBounds(488, 484, 361, 48);
		add(btnNewButton_3);
		btnNewButton_2.setBounds(50, 484, 361, 48);
		add(btnNewButton_2);
		
		JButton btnNewButton_1 = new JButton("Respuesta 2");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnNewButton_1.setBounds(488, 378, 361, 48);
		add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("Respuesta 1");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnNewButton.setBounds(50, 378, 361, 48);
		add(btnNewButton);
		
		BotonAzul botonStop = new BotonAzul("Atras");
		botonStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				musica.close();
			}
		});
		botonStop.setText("Stop");
		botonStop.setFont(new Font("Dubai Medium", Font.ITALIC, 20));
		botonStop.setBounds(527, 170, 231, 83);
		add(botonStop);
		BotonConSonido.setFont(new Font("Dubai Medium", Font.ITALIC, 20));
		BotonConSonido.setBounds(140, 170, 205, 83);
		add(BotonConSonido);
		
		JLabel fondoJuego = new JLabel("");
		fondoJuego.setIcon(new ImageIcon(PantallaJuego.class.getResource("/imagenes/fondo juego rockola.png")));
		fondoJuego.setBounds(0, 0, 900, 700);
		add(fondoJuego);
		
	
	}
}
