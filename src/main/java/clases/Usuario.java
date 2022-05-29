package clases;

import java.sql.SQLException;

import enumeration.Genero;
import enumeration.Idioma;
import enumeration.Pais;

public class Usuario extends Persona{
	
	private String password;

	/**
	 * @param nombre
	 * @param genero
	 * @param pais
	 * @param idioma
	 * @param password
	 * @throws SQLException
	 */
	public Usuario(String nombre, Genero genero, Pais pais, Idioma idioma, String password) throws SQLException {
		super(nombre, genero, pais, idioma);
		
		this.password = password;
	}

	/**
	 *Metodo get para la variable password
	 * @return devuelve el valor de password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 *Metodo set pata la variable password
	 * @param password el nuevo valor de  password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Usuario [password=" + password + "]";
	}

	
	
	
}
