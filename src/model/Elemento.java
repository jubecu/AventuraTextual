package model;

import actions.Interaction;
import actions.InteractiveEntityMessage;

/**
 * Clase concreta que representa un objeto o elemento interactivo.
 * 
 * @author Juan Francisco Benito Cuesta
 *
 */
public class Elemento extends Prop {

	/**
	 * Descripción del elemento
	 */
	private String description;
	/**
	 * Descripción del elemento en caso de que su estado sea true
	 */
	private String description1;
	/**
	 * Descripción del elemento en caso de que su estado sea false
	 */
	private String description2;
	/**
	 * Valor del estado del elemento
	 */
	private boolean valor;
	/**
	 * Lista de acciones que interactúan con el elemento
	 */
	private Interaction[] acciones;

	/**
	 * Constructor que asigna un id, su estado a false e inicializa
	 * la lista de acciones.
	 * @param id
	 * 			Id del elemento
	 */
	public Elemento(String id) {
		super(id);
		valor = false;
		acciones = new Interaction[10];
	}

	/**
	 * Devuelve la descripción del elemento.
	 * 
	 * @return Descripción del elemento
	 */
	@Override
	public String getDescription() {
		return description;
	}

	/**
	 * Establece la descripción del elemento cuando su estado es true.
	 * 
	 * @param description
	 * 			Descripción del elemento cuando su estado es true
	 */
	public void setDescription1(String description) {
		description1 = description;
	}

	/**
	 * Establece la descripción del elemento cuando su estado es false
	 * y la asigna como la descripción principal en caso de estar vacía.
	 * 
	 * @param description
	 * 			Descripción del elemento cuando su estado es false
	 */
	public void setDescription2(String description) {
		description2 = description;
		if (this.description == null)
			this.description = description2;
	}

	/**
	 * Añade una acción que interacciona con el elemento.
	 * 
	 * @param accion
	 * 			Acción que interacciona con el elemento
	 */
	public void addAvailableActions(Interaction accion) {
		for (int i = 0; i < acciones.length; i++) {
			if (acciones[i] == null) {
				acciones[i] = accion;
				break;
			}
		}
	}

	/**
	 * Devuelve la lista de acciones que interaccionan con el elemento.
	 * 
	 * @return Lista de acciones que interactúan con el elemento
	 */
	@Override
	public Interaction[] getAvailableActions() {
		return acciones;
	}

	/**
	 * Devuelve el valor del estado del elemento.
	 * 
	 * @return Valor del estado del elemento
	 */
	@Override
	public boolean getValor() {
		return valor;
	}

	/**
	 * Cambia el valor del estado del elemento y su descripción.
	 */
	public void setValor() {
		if (valor) {
			valor = false;
			description = description2;
		} else {
			valor = true;
			description = description1;
		}
	}

	/**
	 * Maneja los mensajes que llegan al elemento, en este caso cambia su
	 * estado de valor.
	 */
	@Override
	public void handleEntityMessage(InteractiveEntityMessage message) {
		setValor();
	}

}
