package clases;

import java.sql.SQLException;
import java.sql.Statement;

import enumeraciones.Genero;
import enumeraciones.Idioma;
import enumeraciones.Pais;
import excepciones.PassInvalidException;
import excepciones.ContrasegnaInvalidaException;
import excepciones.NombreInvalidoException;
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
		
		Statement smt = ConexionBD.conectar();
		
		if (
				smt.executeUpdate("INSERT INTO usuario (nombre, genero, idioma, pass) "
						+ "VALUES (" + nombre + ", '" + genero + "', '" + pais + "', '" + idioma + "', '"+ pass +"');")
				> 0
		) 
		{
			
			this.pass = pass;
		;
		} else {
			ConexionBD.desconectar();
			throw new SQLException("Error al insertar datos.");
		}
	}
		

	/**
	 *Metodo get para la variable pass
	 * @return devuelve el valor de pass
	 */
	public String getPass() {
		return pass;
	}
	public static boolean isPassValid(String pass) {
		try {
			if (pass.length() < 3) {
				return false;
			} else {
				return true;
			}
		} catch (NullPointerException e) {
			return false;
		}

	}
	/**
	 *Metodo set pata la variable pass
	 * @param pass el nuevo valor de  pass
	 */
	public void setPass(String pass) {
		// Proteger los setters
				if (!isPassValid(pass)) {
					throw new PassInvalidException("La contraseña debe tener al menos 3 caracteres.");
				}

				Statement smt = ConexionBD.conectar();
				if (smt.executeUpdate("update usuarios set pass='" + pass + "' where nombre='" + this.nombre + "'") > 0) {
					this.pass = pass;
				} else {
					ConexionBD.desconectar();
					throw new SQLException("No se ha podido cambiar el password");
				}
				ConexionBD.desconectar();
			}
	}

	@Override
	public String toString() {
		return "Usuario [pass=" + pass + "]";
	}
	
	

	
	
	
}
