package actions;

import model.InteractiveEntity;

/**
 * Interfaz que se ocupa de los mensajes de las entidades interactivas.
 * 
 * @author Juan Francisco Benito Cuesta
 *
 */
public interface InteractiveEntityMessage {
	
	/**
	 * Maneja los mensajes de las entidades interactivas.
	 * 
	 * @param entity
	 * 			Entidad interactiva
	 */
	void handleEntityMessage(InteractiveEntity entity);

}
