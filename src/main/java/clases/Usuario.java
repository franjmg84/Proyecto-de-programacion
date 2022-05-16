package clases;

import enumProyecto.Genero;
import enumProyecto.Idioma;
import enumProyecto.Pais;

public class Usuario extends Persona{
	
	private String contrase�a;

	/**
	 * @param nombre
	 * @param genero
	 * @param pais
	 * @param idioma
	 * @param contrase�a
	 */
	public Usuario(String nombre, Genero genero, Pais pais, Idioma idioma, String contrase�a) {
		super(nombre, genero, pais, idioma);
		this.contrase�a = contrase�a;
	}

	/**
	 *Metodo get para la variable contrase�a
	 * @return devuelve el valor de contrase�a
	 */
	public String getContrase�a() {
		return contrase�a;
	}

	/**
	 *Metodo set pata la variable contrase�a
	 * @param contrase�a el nuevo valor de  contrase�a
	 */
	public void setContrase�a(String contrase�a) {
		this.contrase�a = contrase�a;
	}

	@Override
	public String toString() {
		return "Usuario [contrase�a=" + contrase�a + "]";
	}
	
	
}
