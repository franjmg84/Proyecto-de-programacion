package clases;

import enumProyecto.Genero;
import enumProyecto.Idioma;
import enumProyecto.Pais;

public class Usuario extends Persona{
	
	private String contraseña;

	/**
	 * @param nombre
	 * @param genero
	 * @param pais
	 * @param idioma
	 * @param contraseña
	 */
	public Usuario(String nombre, Genero genero, Pais pais, Idioma idioma, String contraseña) {
		super(nombre, genero, pais, idioma);
		this.contraseña = contraseña;
	}

	/**
	 *Metodo get para la variable contraseña
	 * @return devuelve el valor de contraseña
	 */
	public String getContraseña() {
		return contraseña;
	}

	/**
	 *Metodo set pata la variable contraseña
	 * @param contraseña el nuevo valor de  contraseña
	 */
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	@Override
	public String toString() {
		return "Usuario [contraseña=" + contraseña + "]";
	}
	
	
}
