package interfacesGraficas;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import componentesvisuales.BotonAzul;
import enumeraciones.Idioma;
import enumeraciones.Pais;
import utils.ConexionBD;


import javax.swing.SwingConstants;

import clases.Artista;
import clases.CancionConOpcion;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

public class PantallaJuego1 extends JPanel implements ActionListener {
	private JPanel panel;
	private JTextField textField;
	private JRadioButton rdbtnNewRadioButton;
	
	private JRadioButton rdbtnNewRadioButtonSeleccionado;
	
	
	private ArrayList<CancionConOpcion> canciones = new ArrayList<>();
	private JPanel panel_1;
	private JLabel lblAciertos;
	private JLabel labelFallos;
	private JLabel preguntasTotales;
	private JLabel label_4;
	private JLabel labelAciertos;
	private JButton buttonSiguiente, buttonPlay, buttonStop;
	private JPanel panelJuego;
	
	private JRadioButton radio1,radio2,radio3,radio4;
	private ButtonGroup grupoDeRadios;
	
	
	int preguntaActual = 0;
	int preguntasTotal = 0;
	int aciertos = 1;
	int fallos = 0;
	private CancionConOpcion cancionActual;
	private JButton buttonSiguiente2;
	
	public PantallaJuego1(Ventana v) {
		cargarCanciones();

		
		setLayout(null);
		
		buttonStop = new JButton("Stop");
		buttonStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancionActual.getClipCancion().stop();
			}
		});
		
		BotonAzul btnzlSalir = new BotonAzul("SIGUIENTE");
		btnzlSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnzlSalir.setFont(new Font("Dubai Medium", Font.BOLD | Font.ITALIC, 25));
		btnzlSalir.setText("Salir");
		btnzlSalir.setBounds(748, 595, 88, 45);
		add(btnzlSalir);
		buttonStop.setFont(new Font("Dubai Medium", Font.ITALIC, 50));
		buttonStop.setBounds(499, 236, 168, 61);
		add(buttonStop);
		
	    buttonPlay = new JButton("Play");
		buttonPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancionActual.getClipCancion().start();
			}
		});
		buttonPlay.setFont(new Font("Dubai Medium", Font.ITALIC, 50));
		buttonPlay.setBounds(218, 236, 168, 61);
		add(buttonPlay);
		
		lblAciertos = new JLabel("Aciertos");
		lblAciertos.setForeground(Color.WHITE);
		lblAciertos.setFont(new Font("Dubai Medium", Font.ITALIC, 40));
		lblAciertos.setBounds(616, 37, 155, 45);
		add(lblAciertos);
		
		labelAciertos = new JLabel("ACIERTOS");
		labelAciertos.setForeground(Color.WHITE);
		labelAciertos.setFont(new Font("Dubai Medium", Font.ITALIC, 40));
		labelAciertos.setBounds(795, 37, 67, 45);
		add(labelAciertos);
		
		preguntasTotales = new JLabel("1/0");
		preguntasTotales.setHorizontalAlignment(SwingConstants.CENTER);
		preguntasTotales.setForeground(Color.WHITE);
		preguntasTotales.setFont(new Font("Dubai Medium", Font.ITALIC, 40));
		preguntasTotales.setBounds(382, 89, 106, 45);
		add(preguntasTotales);
		preguntasTotal = canciones.size();
		preguntaActual++;
		preguntasTotales.setText(""+preguntaActual+"/"+preguntasTotal);
		
		labelFallos = new JLabel("0");
		labelFallos.setForeground(Color.WHITE);
		labelFallos.setFont(new Font("Dubai Medium", Font.ITALIC, 40));
		labelFallos.setBounds(191, 29, 67, 61);
		add(labelFallos);
		
		JLabel label_1 = new JLabel("Fallos");
		label_1.setFont(new Font("Dubai Medium", Font.ITALIC, 40));
		label_1.setForeground(Color.WHITE);
		label_1.setBounds(63, 29, 129, 61);
		add(label_1);
		
		BotonAzul buttonSiguiente = new BotonAzul("SIGUIENTE");
		buttonSiguiente.setFont(new Font("Dubai Medium", Font.BOLD | Font.ITALIC, 25));
		buttonSiguiente.setBounds(358, 595, 174, 45);
		add(buttonSiguiente);
		
		panelJuego = new JPanel();
		panelJuego.setBackground(Color.DARK_GRAY);
		panelJuego.setBounds(0, 424, 900, 156);
		panelJuego.setOpaque(false);
		add(panelJuego);
		panelJuego.setLayout(new GridLayout(0, 3, 0, 0));
	
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(PantallaJuego1.class.getResource("/imagenes/fondo con logo.png")));
		lblNewLabel.setBounds(0, 0, 900, 700);
		add(lblNewLabel);
		
		
		//AQUI LIMPIAMOS EL JPANEL DE LA JUGADA
		panelJuego.removeAll();
		panelJuego.repaint();
		
		//AQUI PONEMOS EL TEXTO DE LOS CIERTOS Y FALLOS
		labelAciertos.setText(""+aciertos);
		labelFallos.setText(""+fallos);
		System.out.println("PREGUNTA ACTUAL "+preguntaActual);
		
		//AQUI CARGAMOS EL PANEL
		cargarPnael(preguntaActual-1);
		if(preguntaActual>=preguntasTotal  ) {
			System.out.println();
			buttonSiguiente.setEnabled(false);
			buttonSiguiente.setVisible(false);
			System.out.println("if "+preguntaActual);
			preguntasTotales.setText(""+preguntaActual+"/"+preguntasTotal);
			System.out.println("RESPUESTA COREECTA "+canciones.get(preguntaActual-1).getRespuestaCorrecta()+"RESPUTA USUARIO "+rdbtnNewRadioButtonSeleccionado.getText()+"pREGUNTAS TOTAL "+preguntasTotal+" pregunta actual "+preguntaActual);
			if(esCorrecta(rdbtnNewRadioButtonSeleccionado.getText(), canciones.get(preguntaActual-1).getRespuestaCorrecta())) {
				aciertos++;
				labelAciertos.setText(""+aciertos);
			}else {
				fallos++;
				labelFallos.setText(""+fallos);
			}
		}else {
			buttonSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancionActual.getClipCancion().stop();
				if(aciertos>=canciones.size()) {
					JOptionPane.showMessageDialog(null, "GANASTE", "WIN", JOptionPane.INFORMATION_MESSAGE);
					Statement smt = ConexionBD.conectar();
					LocalDateTime ld = LocalDateTime.now();
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
					String formattedDateTime = ld.format(formatter);
					String s = "INSERT INTO `partida` (`nombre_usuario`, `cancion_jugada`, `cacion`, `fecha_hora`, `acierto`) VALUES ('"+PantallaLogin.emailJugador+"', NULL, NULL, '"+formattedDateTime+"', '"+aciertos+"');";
					System.out.println("SQL INSERT -> "+s);
					try {
						if (smt.executeUpdate(s) > 0) {
							ConexionBD.desconectar();
							System.exit(0);

						} else {
							ConexionBD.desconectar();
							throw new SQLException("No se ha podido insertar");
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}else if(preguntaActual>=canciones.size() && aciertos<preguntasTotal) {
					JOptionPane.showMessageDialog(null, "PERDISTE", "LOSE", JOptionPane.ERROR_MESSAGE);
					Statement smt = ConexionBD.conectar();
					LocalDateTime ld = LocalDateTime.now();
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
					String formattedDateTime = ld.format(formatter);
					String s = "INSERT INTO `partida` (`nombre_usuario`, `cancion_jugada`, `cacion`, `fecha_hora`, `acierto`) VALUES ('"+PantallaLogin.emailJugador+"', NULL, NULL, '"+formattedDateTime+"', '"+aciertos+"');";
					System.out.println("SQL INSERT -> "+s);
					try {
						if (smt.executeUpdate(s) > 0) {
							ConexionBD.desconectar();
							System.exit(0);

						} else {
							ConexionBD.desconectar();
							throw new SQLException("No se ha podido insertar");
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				if(preguntaActual<preguntasTotal) {
					if(esCorrecta(rdbtnNewRadioButtonSeleccionado.getText(), cancionActual.getRespuestaCorrecta())) {
						aciertos++;
						labelAciertos.setText(""+aciertos);
					}else {
						fallos++;
						labelFallos.setText(""+fallos);
					}
					preguntaActual++;
					//preguntasTotales.setText(""+(preguntaActual+=1)+"/"+preguntasTotal);
					preguntasTotales.setText(""+preguntaActual+"/"+preguntasTotal);
					cargarPnael(preguntaActual-1);
					System.out.println("PREGUNTACA CTUAL "+preguntaActual);	
				}
			}
		});	
		}
		
	}
	
	
	private boolean esCorrecta(String opcionElegida, String opcionCorrecta) {
		boolean correcto = false;
		//cpmparamos la opcion elegida la pasamos ambas opciones minuscula y comparamos
		if(opcionElegida.toLowerCase().equals(opcionCorrecta.toLowerCase())) {
			correcto = true;
		}
		
		return correcto;
	}
	
	
	private void cargarPnael(int posicion) {
		//QUITAMOS EL CONTENIDO DEL PANEL
		panelJuego.removeAll();
		panelJuego.repaint();
		
		//ESTA VARIABLE INDICA EL RADIOBUTTON QUE HEMOS SELECCIONADO
		rdbtnNewRadioButtonSeleccionado = null;
		
		//DEL ARRAYLIST DE CANCIONES CON COPCIONES SACAMOS LA CACNICON DE LA POSICION QUE VA INDICANDO
		CancionConOpcion cancion = canciones.get(posicion);
		//GUARDMOS LA CANCION EN UNA VARIABLE A NIEL DE CLASE
		cancionActual = cancion;
		System.out.println("CANCION ACTUAL..."+cancionActual.getRespuestaCorrecta());
		//SACAMOS EL CLIP DE LA CANCION
		Clip clip = cancion.getClipCancion();
		
		///SACAMOS LAS RESPUESTAS CORRECTAS
		ArrayList<String> respuestasCorrectas = cancion.getRespuestasPosibles();
		
		//SACAMOS LA RESPUESTA CORRECTA
		String respuestaCorrecta = cancion.getRespuestaCorrecta();
		
		
		//CREAMOS LOS RADIO BUTTON
		grupoDeRadios=new ButtonGroup();
		
		
		radio1 = new JRadioButton();
		radio1.setText(respuestasCorrectas.get(0));
		radio1.setHorizontalAlignment(SwingConstants.LEFT);
		radio1.setForeground(Color.WHITE);
		radio1.setFont(new Font("Dubai Medium", Font.ITALIC, 25));
		radio1.setBackground(Color.DARK_GRAY);
		//radio1.setOpaque(false);
		
		radio2 = new JRadioButton();
		radio2.setText(respuestasCorrectas.get(2));
		radio2.setForeground(Color.WHITE);
		radio2.setFont(new Font("Dubai Medium", Font.ITALIC, 25));
		radio2.setBackground(Color.DARK_GRAY);
		//radio2.setOpaque(false);
		
		radio3 = new JRadioButton();
		radio3.setText(respuestasCorrectas.get(1));
		radio3.setForeground(Color.WHITE);
		radio3.setFont(new Font("Dubai Medium", Font.ITALIC, 25));
		radio3.setBackground(Color.DARK_GRAY);
		//radio4.setOpaque(false);
		
		  
		  
		  grupoDeRadios.add(radio1);
		  grupoDeRadios.add(radio2);
		  grupoDeRadios.add(radio3);
		  
		  panelJuego.add(radio1);
		  panelJuego.add(radio2);
		  panelJuego.add(radio3);
		  
		  JLabel lblNewLabel_1 = new JLabel("");
		  lblNewLabel_1.setBackground(Color.DARK_GRAY);
		  panelJuego.add(lblNewLabel_1);
		  //radio3.setOpaque(false);
		  
		  radio4 = new JRadioButton();
		  radio4.setText(respuestasCorrectas.get(3));
		  radio4.setForeground(Color.WHITE);
		  radio4.setFont(new Font("Dubai Medium", Font.ITALIC, 25));
		  radio4.setBackground(Color.DARK_GRAY);
		  grupoDeRadios.add(radio4);
		  panelJuego.add(radio4);
		  radio4.addActionListener(this);
		  
		  
		  //CREAMOS EL LISTENER DE LOS RADIOBUTTONS
		  radio1.addActionListener(this);
		  radio2.addActionListener(this);
		  radio3.addActionListener(this);
		  
	}
	
	
	//METODO QUE CARGA LAS CANCIONES
	private void cargarCanciones() {
		
		//VARIABLE QUE INDICA LA RUTA DE LA CANCION
		String ruta = "D:/CENEC/PROGRAMACION/3ER TRIMESTRE/Proyecto de programacion CC/Proyecto-de-programacion/musica/";
		//VARIABLE QUE INDICA EL FORMATO DE LA CANCION
		String formato = ".wav";
		//SE GUARDAN LAS CANCIONES
		String cancion1 = ruta+"ACDC"+formato;
		String cancion2 = ruta+"BonJovi"+formato;
		String cancion3 = ruta+"los_simpson"+formato;
		String cancion4 = ruta+"Lil_Nas_X_THATS_WHAT_I_WANT"+formato;
		String cancion5 = ruta+"Queen_We_Are_The_Champions"+formato;
		String cancion6 = ruta+"Queen_We_Will_Rock_You"+formato;
		String cancion7 = ruta+"Smash-Mouth-I-m-A-Believer"+formato;
		String cancion8 = ruta+"The_Black_Eyed Peas_Pump_It"+formato;
		String cancion9 = ruta+"Zzoilo_&_Aitana_Mon_Amour"+formato;
		String cancion10 = ruta+"Nirvana_Smells_Like_Teen_Spirit"+formato;
		
		//AÑADIMOS LAS CANCIONES AL ARRAYLIST
		canciones.add(cargarCancion1(cancion1));
		canciones.add(cargarCancion2(cancion2));
		canciones.add(cargarCancion3(cancion3));
		canciones.add(cargarCancion4(cancion4));
		canciones.add(cargarCancion5(cancion5));
		
		canciones.add(cargarCancion6(cancion6));
		canciones.add(cargarCancion7(cancion7));
		canciones.add(cargarCancion8(cancion8));
		canciones.add(cargarCancion9(cancion9));
		canciones.add(cargarCancion10(cancion10));
	}
	
	
	private CancionConOpcion cargarCancion1(String cancion) {
		//PONEMOS EL NOMBRE DE LA CANCION
		String nombre = "ACDC";
		//CREAMOS UNA VARIABLE CLIP
		Clip clip = null; 
		//CREAMOS UN FILE A PARTIR DE LA RUTA PASADA
		File musica = new File(cancion);
		//AGREGAMOS LA RESPUESTA CORRECTA TAL CUAL LA VAYAMNOS A PONER EN EL ARRAYLIST DE RESPUESTAS POSIBLES
		String respuestaCorrecta = "ACDC";
		ArrayList<String> respuestasPosibles = new ArrayList<>();
		
		//AGREAMOS LAS POSIBLES RESPUESTAS INCLUYENDO LA QUE DEBERIA SER LA BUENA
		respuestasPosibles.add("Respuesta 1 R.E.M.");
		respuestasPosibles.add("Respuesta 2 The Police");
		respuestasPosibles.add("Respuesta 3 U2");
		respuestasPosibles.add("ACDC");
		
		Collections.shuffle(respuestasPosibles);
		
		Artista artista = new Artista();
		
		//COMPROBAMOS SI EL CLIP DE MUSICA EXISTE
		if(musica.exists()){
			System.out.println("Existe---"+musica.exists());
			AudioInputStream archivo;
			try {
				archivo = AudioSystem.getAudioInputStream(musica);
				clip = AudioSystem.getClip();
				clip.open(archivo);		
				artista = new Artista("ACDC", Pais.ESPAÑA, Idioma.ESPAÑOL);
			} catch (UnsupportedAudioFileException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (LineUnavailableException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else {
			System.out.println("NO EXISTE WEI");
		}
		
		//CREAMOS UNA CACNCION CON OPCION
		CancionConOpcion c = new CancionConOpcion(nombre, artista, clip.getMicrosecondLength(), clip, respuestaCorrecta, respuestasPosibles);
		
		//retorno cancion con respuestas
		return c;
	}
	
	private CancionConOpcion cargarCancion2(String cancion) {
		String nombre = "BonJovi";
		
		Clip clip = null; 
		File musica = new File(cancion);
		String respuestaCorrecta = "BonJovi";
		ArrayList<String> respuestasPosibles = new ArrayList<>();
		
		respuestasPosibles.add("Respuesta 1 Metallica");
		respuestasPosibles.add("Respuesta 2 Pearl Jam");
		respuestasPosibles.add("Respuesta 3 The Band");
		respuestasPosibles.add("BonJovi");
		
		Collections.shuffle(respuestasPosibles);
		
		Artista artista = new Artista();
		if(musica.exists()){
			System.out.println("Existe---"+musica.exists());
			AudioInputStream archivo;
			try {
				archivo = AudioSystem.getAudioInputStream(musica);
				clip = AudioSystem.getClip();
				clip.open(archivo);		
				artista = new Artista("BonJovi", Pais.ESPAÑA, Idioma.ESPAÑOL);
			} catch (UnsupportedAudioFileException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (LineUnavailableException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		CancionConOpcion c = new CancionConOpcion(nombre, artista, clip.getMicrosecondLength(), clip, respuestaCorrecta, respuestasPosibles);
		
		return c;
	}
	
	private CancionConOpcion cargarCancion3(String cancion) {
		String nombre = "los_simpson";
		
		Clip clip = null; 
		File musica = new File(cancion);
		String respuestaCorrecta = "los_simpson";
		ArrayList<String> respuestasPosibles = new ArrayList<>();
		
		respuestasPosibles.add("Respuesta 1 Futurama");
		respuestasPosibles.add("Respuesta 2 South Park");
		respuestasPosibles.add("Respuesta 3 Big Mouth");
		respuestasPosibles.add("los_simpson");
		
		Collections.shuffle(respuestasPosibles);

		
		Artista artista = new Artista();
		if(musica.exists()){
			System.out.println("Existe---"+musica.exists());
			AudioInputStream archivo;
			try {
				archivo = AudioSystem.getAudioInputStream(musica);
				clip = AudioSystem.getClip();
				clip.open(archivo);		
				artista = new Artista("los_simpson", Pais.ESPAÑA, Idioma.ESPAÑOL);
			} catch (UnsupportedAudioFileException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (LineUnavailableException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		CancionConOpcion c = new CancionConOpcion(nombre, artista, clip.getMicrosecondLength(), clip, respuestaCorrecta, respuestasPosibles);
		
		return c;
	}
	
	private CancionConOpcion cargarCancion4(String cancion) {
		String nombre = "Lil_Nas_X_THATS_WHAT_I_WANT";
		
		Clip clip = null; 
		File musica = new File(cancion);
		String respuestaCorrecta = "Lil_Nas";
		ArrayList<String> respuestasPosibles = new ArrayList<>();
		
		respuestasPosibles.add("Respuesta 1 Arcade Fire");
		respuestasPosibles.add("Respuesta 2 CSN&Y");
		respuestasPosibles.add("Respuesta 3 The Cure");
		respuestasPosibles.add("Lil_Nas_X_THATS_WHAT_I_WANT");
		
		Collections.shuffle(respuestasPosibles);

		
		Artista artista = new Artista();
		if(musica.exists()){
			System.out.println("Existe---"+musica.exists());
			AudioInputStream archivo;
			try {
				archivo = AudioSystem.getAudioInputStream(musica);
				clip = AudioSystem.getClip();
				clip.open(archivo);		
				artista = new Artista("Lil_Nas_X_THATS_WHAT_I_WANT", Pais.ESPAÑA, Idioma.ESPAÑOL);
			} catch (UnsupportedAudioFileException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (LineUnavailableException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		CancionConOpcion c = new CancionConOpcion(nombre, artista, clip.getMicrosecondLength(), clip, respuestaCorrecta, respuestasPosibles);
		
		return c;
	}
	
	private CancionConOpcion cargarCancion5(String cancion) {
		String nombre = "Queen_We_Are_The_Champions";
		
		Clip clip = null; 
		File musica = new File(cancion);
		String respuestaCorrecta = "Queen";
		ArrayList<String> respuestasPosibles = new ArrayList<>();
		
		respuestasPosibles.add("Respuesta 1 Dire Straits");
		respuestasPosibles.add("Respuesta 2 Sonic Youth");
		respuestasPosibles.add("Respuesta 3 Public Enemy");
		respuestasPosibles.add("Queen_We_Are_The_Champions");
		
		Collections.shuffle(respuestasPosibles);
		
		Artista artista = new Artista();
		if(musica.exists()){
			System.out.println("Existe---"+musica.exists());
			AudioInputStream archivo;
			try {
				archivo = AudioSystem.getAudioInputStream(musica);
				clip = AudioSystem.getClip();
				clip.open(archivo);		
				artista = new Artista("Queen_We_Are_The_Champions", Pais.ESPAÑA, Idioma.ESPAÑOL);
			} catch (UnsupportedAudioFileException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (LineUnavailableException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		CancionConOpcion c = new CancionConOpcion(nombre, artista, clip.getMicrosecondLength(), clip, respuestaCorrecta, respuestasPosibles);
		
		return c;
	}
	
	private CancionConOpcion cargarCancion6(String cancion) {
		String nombre = "Queen_We_Will_Rock_You";
		
		Clip clip = null; 
		File musica = new File(cancion);
		String respuestaCorrecta = "Queen";
		ArrayList<String> respuestasPosibles = new ArrayList<>();
		
		respuestasPosibles.add("Respuesta 1 Genesis");
		respuestasPosibles.add("Respuesta 2 Depeche Mode");
		respuestasPosibles.add("Respuesta 3 Red Hot Chili Peppers");
		respuestasPosibles.add("Queen_We_Will_Rock_You");
		
		Collections.shuffle(respuestasPosibles);
		
		Artista artista = new Artista();
		if(musica.exists()){
			System.out.println("Existe---"+musica.exists());
			AudioInputStream archivo;
			try {
				archivo = AudioSystem.getAudioInputStream(musica);
				clip = AudioSystem.getClip();
				clip.open(archivo);		
				artista = new Artista("Queen_We_Will_Rock_You", Pais.ESPAÑA, Idioma.ESPAÑOL);
			} catch (UnsupportedAudioFileException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (LineUnavailableException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		CancionConOpcion c = new CancionConOpcion(nombre, artista, clip.getMicrosecondLength(), clip, respuestaCorrecta, respuestasPosibles);
		
		return c;
	}
	
	private CancionConOpcion cargarCancion7(String cancion) {
		String nombre = "Smash-Mouth-I-m-A-Believer";
		
		Clip clip = null; 
		File musica = new File(cancion);
		String respuestaCorrecta = "Smash-Mouth";
		ArrayList<String> respuestasPosibles = new ArrayList<>();
		
		respuestasPosibles.add("Respuesta 1 Smash-Mouth-I-m-A-Believer");
		respuestasPosibles.add("Respuesta 2 Smash-Mouth-I-m-A-Believer");
		respuestasPosibles.add("Respuesta 3 Smash-Mouth-I-m-A-Believer");
		respuestasPosibles.add("Smash-Mouth-I-m-A-Believer");
		
		Collections.shuffle(respuestasPosibles);
		
		Artista artista = new Artista();
		if(musica.exists()){
			System.out.println("Existe---"+musica.exists());
			AudioInputStream archivo;
			try {
				archivo = AudioSystem.getAudioInputStream(musica);
				clip = AudioSystem.getClip();
				clip.open(archivo);		
				artista = new Artista("Smash-Mouth-I-m-A-Believer", Pais.ESPAÑA, Idioma.ESPAÑOL);
			} catch (UnsupportedAudioFileException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (LineUnavailableException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		CancionConOpcion c = new CancionConOpcion(nombre, artista, clip.getMicrosecondLength(), clip, respuestaCorrecta, respuestasPosibles);
		
		return c;
	}
	
	private CancionConOpcion cargarCancion8(String cancion) {
		String nombre = "The_Black_Eyed Peas_Pump_It";
		
		Clip clip = null; 
		File musica = new File(cancion);
		String respuestaCorrecta = "The_Black_Eyed Peas_Pump_It";
		ArrayList<String> respuestasPosibles = new ArrayList<>();
		
		respuestasPosibles.add("Respuesta 1 Radiohead");
		respuestasPosibles.add("Respuesta 2 The Smiths");
		respuestasPosibles.add("Respuesta 3 The Kinkst");
		respuestasPosibles.add("The_Black_Eyed Peas_Pump_It");
		
		Collections.shuffle(respuestasPosibles);

		
		Artista artista = new Artista();
		if(musica.exists()){
			System.out.println("Existe---"+musica.exists());
			AudioInputStream archivo;
			try {
				archivo = AudioSystem.getAudioInputStream(musica);
				clip = AudioSystem.getClip();
				clip.open(archivo);		
				artista = new Artista("The_Black_Eyed Peas_Pump_It", Pais.ESPAÑA, Idioma.ESPAÑOL);
			} catch (UnsupportedAudioFileException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (LineUnavailableException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		CancionConOpcion c = new CancionConOpcion(nombre, artista, clip.getMicrosecondLength(), clip, respuestaCorrecta, respuestasPosibles);
		
		return c;
	}
	
	private CancionConOpcion cargarCancion9(String cancion) {
		String nombre = "los_simpson";
		
		Clip clip = null; 
		File musica = new File(cancion);
		String respuestaCorrecta = "Zzoilo_&_Aitana";
		ArrayList<String> respuestasPosibles = new ArrayList<>();
		
		respuestasPosibles.add("Respuesta 1 Karol G");
		respuestasPosibles.add("Respuesta 2 Natti Natasha");
		respuestasPosibles.add("Respuesta 3 Mara Prada");
		respuestasPosibles.add("Zzoilo_&_Aitana_Mon_Amour");
		
		Collections.shuffle(respuestasPosibles);
		
		Artista artista = new Artista();
		if(musica.exists()){
			System.out.println("Existe---"+musica.exists());
			AudioInputStream archivo;
			try {
				archivo = AudioSystem.getAudioInputStream(musica);
				clip = AudioSystem.getClip();
				clip.open(archivo);		
				artista = new Artista("Zzoilo_&_Aitana_Mon_Amour", Pais.ESPAÑA, Idioma.ESPAÑOL);
			} catch (UnsupportedAudioFileException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (LineUnavailableException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		CancionConOpcion c = new CancionConOpcion(nombre, artista, clip.getMicrosecondLength(), clip, respuestaCorrecta, respuestasPosibles);
		
		return c;
	}
	
	
	private CancionConOpcion cargarCancion10(String cancion) {
		String nombre = "Nirvana_Smells_Like_Teen_Spirit";
		
		Clip clip = null; 
		File musica = new File(cancion);
		String respuestaCorrecta = "Nirvana_Smells_Like_Teen_Spirit";
		ArrayList<String> respuestasPosibles = new ArrayList<>();
		
		respuestasPosibles.add("Respuesta 1 Nirvana_Smells_Like_Teen_Spirit");
		respuestasPosibles.add("Respuesta 2 Nirvana_Smells_Like_Teen_Spirit");
		respuestasPosibles.add("Respuesta 3 Nirvana_Smells_Like_Teen_Spirit");
		respuestasPosibles.add("Nirvana_Smells_Like_Teen_Spirit");
		
		Collections.shuffle(respuestasPosibles);
		
		Artista artista = new Artista();
		if(musica.exists()){
			System.out.println("Existe---"+musica.exists());
			AudioInputStream archivo;
			try {
				archivo = AudioSystem.getAudioInputStream(musica);
				clip = AudioSystem.getClip();
				clip.open(archivo);		
				artista = new Artista("Nirvana_Smells_Like_Teen_Spirit", Pais.ESPAÑA, Idioma.ESPAÑOL);
			} catch (UnsupportedAudioFileException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (LineUnavailableException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		CancionConOpcion c = new CancionConOpcion(nombre, artista, clip.getMicrosecondLength(), clip, respuestaCorrecta, respuestasPosibles);
		
		return c;
	}

	
	//listener de los JRADIOBUTTON
	public void actionPerformed(ActionEvent e) {
		//comprobamos si el radiobutton seleccionado es el radiobutton1
		if (e.getSource() == radio1) {
			//si es igual igualamos la variable creada a la del radio1
			rdbtnNewRadioButtonSeleccionado = radio1;
		}
		//comprobamos si el radiobutton seleccionado es el radiobutton2
		if (e.getSource() == radio2) {
			//si es igual igualamos la variable creada a la del radio2
			rdbtnNewRadioButtonSeleccionado = radio2;
		}
		//comprobamos si el radiobutton seleccionado es el radiobutton3
		if (e.getSource() == radio3) {
			//si es igual igualamos la variable creada a la del radio3
			rdbtnNewRadioButtonSeleccionado = radio3;
		}
		//comprobamos si el radiobutton seleccionado es el radiobutton4
		if (e.getSource() == radio4) {
			//si es igual igualamos la variable creada a la del radio4
			rdbtnNewRadioButtonSeleccionado = radio4;
		}
	}
}
