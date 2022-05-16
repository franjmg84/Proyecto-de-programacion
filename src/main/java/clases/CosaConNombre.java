package clases;

public class CosaConNombre {
	
	private String nombre;

	/**
	 * @param nombre
	 */
	public CosaConNombre(String nombre) {
		super();
		this.nombre = nombre;
	}

	/**
	 *Metodo get para la variable nombre
	 * @return devuelve el valor de nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 *Metodo set pata la variable nombre
	 * @param nombre el nuevo valor de  nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "CosaConNombre [nombre=" + nombre + "]";
	}
	
	
}
