package clases;

import java.io.File;
import java.util.ArrayList;

import javax.sound.sampled.AudioSystem;
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
	public void cancion() {
		
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
		
		   try {
	            
	            // Se obtiene un Clip de sonido
	            Clip sonido = AudioSystem.getClip();
	            
	            // Se carga con un fichero wav
	            sonido.open(AudioSystem.getAudioInputStream(new File("Bon Jovi.wav")));
	            
	            // Comienza la reproducci�n
	            sonido.start();
	            
	            // Espera mientras se est� reproduciendo.
	            while (sonido.isRunning())
	                Thread.sleep(1000);
	            
	            // Se cierra el clip.
	            sonido.close();
	        } catch (Exception e) {
	            System.out.println("" + e);
	        }
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
