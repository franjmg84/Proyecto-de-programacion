package interfacesGraficas;

import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;

public class PantallaLogin extends JPanel {
	private JTextField txtLogin;

	/**
	 * Create the panel.
	 */
	public PantallaLogin() {
		
		txtLogin = new JTextField();
		txtLogin.setHorizontalAlignment(SwingConstants.CENTER);
		txtLogin.setFont(new Font("Tahoma", Font.PLAIN, 45));
		txtLogin.setText("Login");
		add(txtLogin);
		txtLogin.setColumns(10);

	}

}
