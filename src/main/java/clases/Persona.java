package clases;

import java.sql.SQLException;
import java.sql.Statement;

import enumeraciones.Genero;
import enumeraciones.Idioma;
import enumeraciones.Pais;
import excepciones.NombreInvalidoException;
import excepciones.PassInvalidException;
import utils.ConexionBD;

public class Persona extends CosaConNombre {
	
	protected Genero genero;
	protected Pais pais;
	protected Idioma idioma;
	/**
	 * @param nombre
	 * @param genero
	 * @param pais
	 * @param idioma
	 */

	public Persona(String nombre, Genero genero, Pais pais, Idioma idioma) throws SQLException{
		super(nombre);
		
		if (!isnombreValid(nombre)) {
			throw new NombreInvalidoException("debe escribir un nombre");
		}
		
		Statement smt=ConexionBD.conectar();
		
		if(smt.executeUpdate("insert into usuario values('"+nombre+"',	"
				+ "'"+nombre+"','"+genero+"',"+pais+",'"+idioma+"')")>0) {
			// Solo si todo ha ido bien insertando, se modifican las variables internas
			this.genero = genero;
			
		}else {
			//Si no se ha podido insertar, lanzo un error: Algo ha ido mal.
			throw new SQLException("No se ha podido insertar");
		}
		
		
		ConexionBD.desconectar();
	}
	
		
	//}
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
