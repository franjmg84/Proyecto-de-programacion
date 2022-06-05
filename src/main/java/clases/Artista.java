package clases;

import java.awt.image.BufferedImage;

import java.sql.SQLException;

import enumeraciones.Idioma;
import enumeraciones.Pais;

public class Artista extends Persona {
	
	private BufferedImage foto;

	/**
	 * @param nombre
	 * @param genero
	 * @param pais
	 * @param idioma
	 * @param foto
	 * @throws SQLException 
	 */
	public Artista(String nombre, Pais pais, Idioma idioma, BufferedImage foto) throws SQLException {
		super(nombre, pais, idioma);
		this.foto = foto;
	}

	/**
	 *Metodo get para la variable foto
	 * @return devuelve el valor de foto
	 */
	public BufferedImage getFoto() {
		return foto;
	}

	/**
	 *Metodo set para la variable foto
	 * @param foto el nuevo valor de  foto
	 */
	public void setFoto(BufferedImage foto) {
		this.foto = foto;
	}

	@Override
	public String toString() {
		return "Artista [foto=" + foto + "]";
	}

	
	
	
	
}
