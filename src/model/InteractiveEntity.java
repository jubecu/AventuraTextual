package model;

import actions.Interaction;
import actions.InteractiveEntityMessage;

/**
 * Clase abstracta que representa una entidad interactiva del mundo con sus
 * métodos principales.
 * 
 * @author Juan Francisco Benito Cuesta
 *
 */
public abstract class InteractiveEntity {

	/**
	 * Id de la entidad interactiva
	 */
	protected String id;

	/**
	 * Constructor general que asigna un id a la entidad interactiva.
	 * 
	 * @param id
	 * 			Id de la entidad interactiva
	 */
	public InteractiveEntity(String id) {
		this.id = id;
	}

	/**
	 * Devuelve el id de la entidad interactiva.
	 * 
	 * @return Id de la entidad interactiva
	 */
	public String getId() {
		return id;
	}

	/**
	 * Devuelve la descripción de la entidad interactiva.
	 * 
	 * @return Descripción de la entidad interactiva
	 */
	public abstract String getDescription();

	/**
	 * Devuelve la lista de las acciones disponibles de la entidad interactiva.
	 * 
	 * @return Lista de las acciones disponibles de la entidad interactiva
	 */
	public abstract Interaction[] getAvailableActions();

	/**
	 * Maneja los mensajes que le llegan a la entidad interactiva.
	 * 
	 * @param message
	 * 			Mensaje que le llega a la entidad interactiva
	 */
	public void handleEntityMessage(InteractiveEntityMessage message) {

	}

}
