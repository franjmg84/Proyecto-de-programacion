package componentesvisuales;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.border.MatteBorder;

public class BotonAzul extends JButton {
	public BotonAzul(String s) {
		super(s);
		estilosPorDefecto();
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				setForeground(new Color(200, 150, 150));
				setBackground(new Color(50, 0, 0));
				setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				estilosPorDefecto();
			}
		});
	}
	private void estilosPorDefecto() {
		this.setBackground(new Color(0, 204, 255));
		this.setForeground(new Color(0, 0, 0));
		this.setBorder(
				new MatteBorder(3,3,3,3,new Color(200,0,0)));
		this.setFont(new Font("Dubai Medium", Font.BOLD | Font.ITALIC, 18));
	}
}
