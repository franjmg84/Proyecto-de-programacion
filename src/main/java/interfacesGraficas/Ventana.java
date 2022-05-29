package interfacesGraficas;

import javax.swing.JPanel;

import clases.Usuario;

import java.awt.Cursor;
import java.awt.FlowLayout;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Ventana extends JFrame {
	
	private HashMap<String,JPanel> pantallas;
	/**
	 * Create the panel.
	 */
	public Ventana() {
		/**
		 * 
		 */
		this.pantallas=new HashMap<String,JPanel>();
		
		this.pantallas.put("login",new PantallaLogin(this));
		this.pantallas.put("registro",new PantallaRegistro(this));
		
		
		this.setSize(900,700);
		this.setLocationRelativeTo(null);
		this.setExtendedState(JFrame.HAND_CURSOR);
		this.setTitle("Proyecto");
		//this.setIconImage/new ImageIcon().getImage());
		this.setCursor(new Cursor(Cursor.HAND_CURSOR));
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setContentPane(new PantallaLogin(this));
		this.setVisible(true);
	}
	public void irAPantalla(String nombrePantalla) {
		Iterator it=this.pantallas.values().iterator();
		while(it.hasNext()) {
			JPanel actual=(JPanel)it.next();
			actual.setVisible(false);
		}
		this.pantallas.get(nombrePantalla).setVisible(true);
	}
}
