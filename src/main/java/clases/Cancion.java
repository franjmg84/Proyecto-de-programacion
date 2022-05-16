package clases;

import javax.sound.sampled.Clip;

public class Cancion extends CosaConNombre{
	
	private Artista artista;
	private float duracion;
	private Clip audio;
	/**
	 * @param nombre
	 * @param artista
	 * @param duracion
	 * @param audio
	 */
	public Cancion(String nombre, Artista artista, float duracion, Clip audio) {
		super(nombre);
		this.artista = artista;
		this.duracion = duracion;
		this.audio = audio;
	}
	/**
	 *Metodo get para la variable artista
	 * @return devuelve el valor de artista
	 */
	public Artista getArtista() {
		return artista;
	}
	/**
	 *Metodo set pata la variable artista
	 * @param artista el nuevo valor de  artista
	 */
	public void setArtista(Artista artista) {
		this.artista = artista;
	}
	/**
	 *Metodo get para la variable duracion
	 * @return devuelve el valor de duracion
	 */
	public float getDuracion() {
		return duracion;
	}
	/**
	 *Metodo set pata la variable duracion
	 * @param duracion el nuevo valor de  duracion
	 */
	public void setDuracion(float duracion) {
		this.duracion = duracion;
	}
	/**
	 *Metodo get para la variable audio
	 * @return devuelve el valor de audio
	 */
	public Clip getAudio() {
		return audio;
	}
	/**
	 *Metodo set pata la variable audio
	 * @param audio el nuevo valor de  audio
	 */
	public void setAudio(Clip audio) {
		this.audio = audio;
	}
	@Override
	public String toString() {
		return "Cancion [artista=" + artista + ", duracion=" + duracion + ", audio=" + audio + "]";
	}
	
	

}
