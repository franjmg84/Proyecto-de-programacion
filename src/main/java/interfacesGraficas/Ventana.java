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
			this.pantallaActual=new PantallaRegistro(this);
			break;
		case "estilo":
			this.pantallaActual=new PantallaEleccionEstilo(this,clip);
			break;
		case "juego1":
			this.pantallaActual=new PantallaJuego1(this, clip);
			break;
		case "juego2":
			this.pantallaActual=new PantallaJuego2(this, clip);
			break;
		case "juego3":
			this.pantallaActual=new PantallaJuego3(this, clip);
			break;
		case "juego4":
			this.pantallaActual=new PantallaJuego4(this, clip);
			break;
		case "juego5":
			this.pantallaActual=new PantallaJuego5(this, clip);
			break;
		case "juego6":
			this.pantallaActual=new PantallaJuego6(this);
			break;
		case "juego7":
			this.pantallaActual=new PantallaJuego7(this);
			break;
		case "juego8":
			this.pantallaActual=new PantallaJuego8(this);
			break;
		case "juego9":
			this.pantallaActual=new PantallaJuego9(this);
			break;
		case "juego10":
			this.pantallaActual=new PantallaJuego10(this);
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
