package interfacesGraficas;

import javax.swing.JPanel;

import clases.Cancion;
import clases.CancionJugada;
import clases.Usuario;
import hilos.MusicaFondo;

import java.awt.Cursor;
import java.awt.FlowLayout;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Ventana extends JFrame {
	
	
	protected Usuario usuarioLogeado;
	private JPanel pantallaActual;
	protected ArrayList<Cancion> cancionesPorJugar;
	protected ArrayList<CancionJugada> cancionesJugadas;
	protected Clip clip;
	/**
	 * Create the panel.
	 */
	public Ventana() {
		this.cancionesPorJugar= new ArrayList<Cancion>();
		this.cancionesJugadas=new ArrayList<CancionJugada>();
		
		try {
			AudioInputStream archivo = AudioSystem.getAudioInputStream(new File("./popRock/Bon Jovi.wav"));
			this.clip = AudioSystem.getClip();
			clip.open(archivo);
			
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
		
		
		this.setSize(900,700);
		this.setLocationRelativeTo(null);
		//this.setExtendedState(JFrame.HAND_CURSOR);
		this.setTitle("Rockola");
		this.setIconImage(new ImageIcon("./logoo.png").getImage());
		this.setCursor(new Cursor(Cursor.HAND_CURSOR));
		this.setResizable(false);
		this.pantallaActual=new PantallaLogin(this,clip);
		this.setContentPane(this.pantallaActual);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	
		
	}
	public void irAPantalla(String nombrePantalla) {
		/*Iterator it=this.pantallas.values().iterator();
		while(it.hasNext()) {
			JPanel actual=(JPanel)it.next();
			actual.setVisible(false);*/
		//}
		this.pantallaActual.setVisible(false);
		this.pantallaActual=null;
		switch (nombrePantalla) {
		case "login":
			this.pantallaActual=new PantallaLogin(this,clip);
			break;
		case "registro":
			this.pantallaActual=new PantallaRegistro(this.clip);
			break;
		case "estilo":
			this.pantallaActual=new PantallaEleccionEstilo(this,clip);
			break;
		case "juego":
			this.pantallaActual=new PantallaJuego(this);
			break;
		default:
			break;
	}
		
	this.pantallaActual.setVisible(true);
	this.setContentPane(pantallaActual);
		//this.pantallas.get(nombrePantalla).setVisible(true);
		//this.setContentPane(this.pantallas.get(nombrePantalla));
	
	}
	
}
