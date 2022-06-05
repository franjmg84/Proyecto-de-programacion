package clases;

import java.sql.SQLException;
import java.sql.Statement;

import enumeraciones.Idioma;
import enumeraciones.Pais;
import excepciones.PassInvalidException;
import excepciones.UsuarioNoExisteException;

import excepciones.NombreInvalidoException;
import utils.ConexionBD;

public class Usuario extends Persona {

	private String pass;
	private String email;
	/**
	 * @param nombre
	 * @param genero
	 * @param pais
	 * @param idioma
	 * @param email
	 * @param pass
	 * @throws SQLException 
	 */
	public Usuario(String email, String nombre, Pais pais, Idioma idioma, String pass) throws SQLException {
		super(nombre, pais, idioma);
		
		Statement smt= ConexionBD.conectar();
		if(smt.executeUpdate("insert into usuario values('"+email+"','"+nombre+"','"+pais+"','"+idioma+"','"+pass+"')")>0) {
			this.email=email;
			this.nombre=nombre;
			this.pais=pais;
			this.idioma=idioma;
			this.pass=pass;
			
		}else {
			throw new SQLException("No se ha podido insertar");
		}
		
		ConexionBD.desconectar();
		
	
		
	}
	

	/**
	 * Metodo get para la variable pass
	 * 
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
	 * Metodo set pata la variable pass
	 * 
	 * @param pass el nuevo valor de pass
	 * @throws PassInvalidException
	 */
	public void setPass(String pass) throws PassInvalidException {
		// Proteger los setters
		if (!isPassValid(pass)) {
			throw new PassInvalidException("La contraseña debe tener al menos 3 caracteres.");
		}

		Statement smt = ConexionBD.conectar();
		try {
			if (smt.executeUpdate("update usuarios set pass='" + pass + "' where nombre='" + this.nombre + "'") > 0) {
				this.pass = pass;
			} else {
				ConexionBD.desconectar();
				throw new SQLException("No se ha podido cambiar el password");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ConexionBD.desconectar();
	}

	@Override
	public String toString() {
		return "Usuario [pass=" + pass + "]";
	}

}
