package model;

import actions.Interaction;

/**
 * Clase abstracta que representa un objeto o elemento interactivo con sus
 * métodos prinicpales.
 * 
 * @author Juan Francisco Benito Cuesta
 *
 */
public abstract class Prop extends InteractiveEntity {

	/**
	 * Constructor que asigna un id.
	 * 
	 * @param id
	 * 			Id del elemento
	 */
	public Prop(String id) {
		super(id);
	}

	/**
	 * Devuelve el valor del estado del elemento.
	 */
	public boolean getValor() {
		return true;
	}

	/**
	 * Devuelve la descripción del elemento.
	 */
	@Override
	public String getDescription() {
		return null;
	}

	/**
	 * Devuelve la lista de acciones que interaccionan con el elemento.
	 */
	@Override
	public Interaction[] getAvailableActions() {
		return null;
	}

}
