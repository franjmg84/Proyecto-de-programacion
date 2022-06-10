package interfacesGraficas;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.SwingConstants;

import componentesvisuales.BotonAzul;
import componentesvisuales.BotonRosa;
import hilos.MusicaFondo;

import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PantallaEleccionEstilo extends JPanel {
	
		private Ventana ventana;
		private Clip musica;
		
		public PantallaEleccionEstilo(Ventana v, Clip clip) {
			
			this.ventana = v;
			
			/*try {
				AudioInputStream archivo = AudioSystem.getAudioInputStream(new File("./popRock/Bon Jovi.wav"));
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
			}*/
			
		setLayout(null);
		
		JButton botonAtras = new BotonRosa("Atras");
		botonAtras.addMouseListener(new MouseAdapter() {
			
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
		
	
	;
	
		;
		
		
		JButton botonEntrar = new BotonAzul("Entrar");
		botonEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				/*
				if(botonTv.isSelected()==true) {
					ventana.irAPantalla("juego");
					MusicaFondo musica= new MusicaFondo(new File("./musica/musicaSeries/los simpson - esta yegua.wav"));
					musica.start();
				}
				if(botonRockPop.isSelected()==true) {
					ventana.irAPantalla("juego");
					MusicaFondo musica= new MusicaFondo(new File("./musica/musicaRock"));
					musica.start();
				}
				if(botonDance.isSelected()==true) {
					ventana.irAPantalla("juego");
					MusicaFondo musica= new MusicaFondo(new File("./musica/dance"));
					musica.start();
				}*/
				
				ventana.irAPantalla("juego");
				
			}
		});
		botonEntrar.setFont(new Font("Dubai Medium", Font.ITALIC, 20));
		botonEntrar.setBounds(351, 491, 180, 56);
		add(botonEntrar);
		
		
		// Hago para que solo se pueda seleccionar uno
		ButtonGroup grupoEstilos = new ButtonGroup();
		
		// Titulo de ventana
		JLabel labelTitulo = new JLabel("");
		labelTitulo.setFont(new Font("Dubai Medium", Font.PLAIN, 40));
		labelTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		labelTitulo.setForeground(Color.WHITE);
		labelTitulo.setBounds(278, 151, 342, 79);
		add(labelTitulo);
		
		// Aqui le pongo de fondo una imagen a la ventana
		JLabel labelFondo = new JLabel("");
		labelFondo.setIcon(new ImageIcon(PantallaEleccionEstilo.class.getResource("/imagenes/fondo con logo21.png")));
		labelFondo.setBounds(0, 0, 885, 700);
		add(labelFondo);
	}


		
}
