package clases;

import java.awt.image.BufferedImage;

import enumeration.Genero;
import enumeration.Idioma;
import enumeration.Pais;

public class Artista extends Persona {
	
	private BufferedImage foto;

	/**
	 * @param nombre
	 * @param genero
	 * @param pais
	 * @param idioma
	 * @param foto
	 */
	public Artista(String nombre, Genero genero, Pais pais, Idioma idioma, BufferedImage foto) {
		super(nombre, genero, pais, idioma);
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
	 *Metodo set pata la variable foto
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
