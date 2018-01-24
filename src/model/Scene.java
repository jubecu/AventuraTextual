package model;

import java.util.ArrayList;
import java.util.Iterator;

import actions.Interaction;
import actions.InteractiveEntityMessage;
import actions.SceneMessage;

/**
 * Clase que representa una escena del mundo.
 * 
 * @author Juan Francisco Benito Cuesta
 *
 */
public class Scene extends InteractiveEntity {

	/**
	 * Descripci�n de la escena
	 */
	private String description;
	/**
	 * Lista de objetos o elementos interactivos que tiene la escena
	 */
	private ArrayList<Prop> props;
	/**
	 * Lista de acciones que se pueden realizar en la escena
	 */
	private Interaction[] acciones;

	/**
	 * Constructor que asigna un id a la escena e inicializa las dos listas.
	 * 
	 * @param id
	 * 			Id de la escena
	 */
	public Scene(String id) {
		super(id);
		acciones = new Interaction[10];
		props = new ArrayList<Prop>();
	}

	/**
	 * Devuelve la descripci�n de la escena.
	 * 
	 * @return Descripci�n de la escena
	 */
	@Override
	public String getDescription() {
		return description;
	}

	/**
	 * Establece la descripci�n de la escena.
	 * 
	 * @param description
	 * 			Descripci�n de la escena
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * A�ade una acci�n a la lista de acciones de la escena.
	 * 
	 * @param accion
	 * 			Acci�n a a�adir
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
	 * Devuelve la lista de acciones que se pueden realizar en la escena.
	 * 
	 * @return Lista de acciones que se pueden realizar en la escena
	 */
	@Override
	public Interaction[] getAvailableActions() {
		return acciones;
	}

	/**
	 * A�ade un objeto o elemento interactivo a la escena.
	 * 
	 * @param prop
	 * 			Objeto o elemento interactivo a a�adir
	 */
	public void addProp(Prop prop) {
		props.add(prop);
	}

	/**
	 * Elimina un objeto o elemento interactivo de la escena.
	 * 
	 * @param prop
	 * 			Objeto o elemento interactivo a eliminar
	 */
	public void removeProp(String propId) {
		Prop elementoBorrar = null;
		Iterator<Prop> iterador = props.iterator();
		while (iterador.hasNext()) {
			Prop elemento = iterador.next();
			if (elemento.getId().compareTo(propId) == 0) {
				elementoBorrar = elemento;
				break;
			}
		}
		props.remove(elementoBorrar);
	}

	/**
	 * Devuelve un objeto o elemento interactivo de la escena.
	 * 
	 * @param propId
	 * 			Id del objeto o elemento interactivo a devolver
	 * @return Un objeto o elemento interactivo de la escena
	 */
	public Prop getProp(String propId) {
		Prop elementoDevuelto = null;
		Iterator<Prop> iterador = props.iterator();
		while (iterador.hasNext()) {
			Prop elemento = iterador.next();
			if (elemento.getId().compareTo(propId) == 0) {
				elementoDevuelto = elemento;
				break;
			}
		}
		return props.get(props.indexOf(elementoDevuelto));
	}

	/**
	 * Maneja los mensajes que le llegan como entidad.
	 */
	@Override
	public void handleEntityMessage(InteractiveEntityMessage message) {

	}

	/**
	 * Maneja los mensajes que le llegan como escena.
	 * 
	 * @param message
	 * 			Mensaje
	 */
	public void handleSceneMessage(SceneMessage message) {

	}

}
