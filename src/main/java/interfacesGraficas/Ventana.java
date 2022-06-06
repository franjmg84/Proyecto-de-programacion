package interfacesGraficas;

import javax.swing.JPanel;


import clases.Usuario;

import java.awt.Cursor;
import java.awt.FlowLayout;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Ventana extends JFrame {
	
	
	protected Usuario usuarioLogeado;
	private JPanel pantallaActual;
	protected ArrayList<File> cancionesPorJugar;
	protected ArrayList<File> cancionesJugadas;
	/**
	 * Create the panel.
	 */
	public Ventana() {
		this.cancionesPorJugar= new ArrayList<File>();
		this.cancionesJugadas=new ArrayList<File>();
		

		this.setSize(900,700);
		this.setLocationRelativeTo(null);
		//this.setExtendedState(JFrame.HAND_CURSOR);
		this.setTitle("Rockola");
		this.setIconImage(new ImageIcon("./logoo.png").getImage());
		this.setCursor(new Cursor(Cursor.HAND_CURSOR));
		this.setResizable(false);
		this.pantallaActual=new PantallaLogin(this);
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
			this.pantallaActual=new PantallaLogin(this);
			break;
		case "registro":
			this.pantallaActual=new PantallaRegistro(this);
			break;
		case "estilo":
			this.pantallaActual=new PantallaEleccionEstilo(this);
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
