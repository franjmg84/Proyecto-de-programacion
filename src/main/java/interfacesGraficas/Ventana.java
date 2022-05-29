package interfacesGraficas;

import javax.swing.JPanel;

import clases.Usuario;

import java.awt.Cursor;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Ventana extends JFrame {
	
	/**
	 * Create the panel.
	 */
	public Ventana() {
		this.setSize(500,300);
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

}
