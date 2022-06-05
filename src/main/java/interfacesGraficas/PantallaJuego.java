package interfacesGraficas;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class PantallaJuego extends JPanel {
	private Ventana ventana;
	/**
	 * Create the panel.
	 * @param ventana 
	 */
	public PantallaJuego(Ventana v) {
		setLayout(null);
		
		JButton btnNewButton = new JButton("PLAY");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.irAPantalla("juego");
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 48));
		btnNewButton.setBounds(264, 343, 351, 90);
		add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(PantallaJuego.class.getResource("/imagenes/fondo con logo3.png")));
		lblNewLabel.setBounds(0, 0, 900, 700);
		add(lblNewLabel);
		
	
	}
}
