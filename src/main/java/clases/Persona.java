package clases;

import enumeration.Genero;
import enumeration.Idioma;
import enumeration.Pais;

public class Persona extends CosaConNombre {
	
	private Genero genero;
	private Pais pais;
	private Idioma idioma;
	/**
	 * @param nombre
	 * @param genero
	 * @param pais
	 * @param idioma
	 */
	public Persona(String nombre, Genero genero, Pais pais, Idioma idioma) {
		super(nombre);
		this.genero = genero;
		this.pais = pais;
		this.idioma = idioma;
	}
	/**
	 *Metodo get para la variable genero
	 * @return devuelve el valor de genero
	 */
	public Genero getGenero() {
		return genero;
	}
	/**
	 *Metodo set pata la variable genero
	 * @param genero el nuevo valor de  genero
	 */
	public void setGenero(Genero genero) {
		this.genero = genero;
	}
	/**
	 *Metodo get para la variable pais
	 * @return devuelve el valor de pais
	 */
	public Pais getPais() {
		return pais;
	}
	/**
	 *Metodo set pata la variable pais
	 * @param pais el nuevo valor de  pais
	 */
	public void setPais(Pais pais) {
		this.pais = pais;
	}
	/**
	 *Metodo get para la variable idioma
	 * @return devuelve el valor de idioma
	 */
	public Idioma getIdioma() {
		return idioma;
	}
	/**
	 *Metodo set pata la variable idioma
	 * @param idioma el nuevo valor de  idioma
	 */
	public void setIdioma(Idioma idioma) {
		this.idioma = idioma;
	}
	@Override
	public String toString() {
		return "Persona [genero=" + genero + ", pais=" + pais + ", idioma=" + idioma + "]";
	}
	
	
}