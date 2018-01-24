package actions;

import model.Scene;

/**
 * Interfaz que se ocupa de los mensajes de las escenas.
 * 
 * @author Juan Francisco Benito Cuesta
 *
 */
public interface SceneMessage {

	/**
	 * Maneja los mensajes de las ecenas.
	 * 
	 * @param scene
	 * 			Una escena del mundo
	 */
	void handleSceneMessage(Scene scene);
}
