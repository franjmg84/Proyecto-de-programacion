package clases;

import java.sql.SQLException;
import java.sql.Statement;

import enumeraciones.Genero;
import enumeraciones.Idioma;
import enumeraciones.Pais;

import utils.ConexionBD;

public class Usuario extends Persona{
	
	private String pass;

	/**
	 * @param nombre
	 * @param genero
	 * @param pais
	 * @param idioma
	 * @param pass
	 * @throws SQLException
	 */
	public Usuario(String nombre, Genero genero, Pais pais, Idioma idioma, String pass) throws SQLException {
		super(nombre, genero, pais, idioma);
		
		
		
			
		
		this.pass = pass;
	}

	/**
	 *Metodo get para la variable pass
	 * @return devuelve el valor de pass
	 */
	public String getPass() {
		return pass;
	}

	/**
	 *Metodo set pata la variable pass
	 * @param pass el nuevo valor de  pass
	 */
	public void setPass(String pass) {
		this.pass = pass;
	}

	@Override
	public String toString() {
		return "Usuario [pass=" + pass + "]";
	}
	
	

	
	
	
}
