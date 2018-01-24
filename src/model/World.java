package model;

import java.util.ArrayList;
import java.util.Iterator;

import actions.InteractiveEntityMessage;
import actions.SceneMessage;

/**
 * Clase que representa al mundo de la historia o partida.
 * 
 * @author Juan Francisco Benito Cuesta
 *
 */
public class World {

	/**
	 * Jugador de la partida
	 */
	Player player;
	/**
	 * Lista de escenas del mundo
	 */
	private ArrayList<Scene> scenes=new ArrayList<Scene>();
	/**
	 * Lista de entidades interactivas del mundo
	 */
	private ArrayList<InteractiveEntity> interactiveEntities=new ArrayList<InteractiveEntity>();
	/**
	 * Instancia de la clase World
	 */
	private static World instance = null;

	/**
	 * Crea una instancia de World si esta vacía y la devuelve.
	 * 
	 * @return Instancia de World
	 */
	public static World getInstance() {
		if (instance == null)
			instance = new World();
		return instance;
	}

	/**
	 * Devuelve al jugador de la partida.
	 * 
	 * @return Jugador de la partida
	 */
	public Player getPlayer() {
		return player;
	}

	/**
	 * Añade una escena al mundo.
	 * 
	 * @param scene
	 * 			Escena a añadir
	 */
	public void addScene(Scene scene) {
		scenes.add(scene);
	}

	/**
	 * Elimina una escena del mundo.
	 * 
	 * @param id
	 * 			Id de la escena a eliminar
	 */
	public void removeScene(String id) {
		Scene escenaBorrar = null;
		Iterator<Scene> iterador = scenes.iterator();
		while (iterador.hasNext()) {
			Scene escena = iterador.next();
			if (escena.getId().compareTo(id) == 0) {
				escenaBorrar = escena;
				break;
			}
		}
		scenes.remove(escenaBorrar);
	}

	/**
	 * Devuelve una escena del mundo.
	 * 
	 * @param id
	 * 			Id de la escena a devolver
	 * @return Una escena del mundo
	 */
	public Scene getScene(String id) {
		Scene escenaDevolver = null;
		Iterator<Scene> iterador = scenes.iterator();
		while (iterador.hasNext()) {
			Scene escena = iterador.next();
			if (escena.getId().compareTo(id) == 0) {
				escenaDevolver = escena;
				break;
			}
		}
		return escenaDevolver;
	}

	/**
	 * Envía un mensaje o manda hacer una acción a una escena.
	 * 
	 * @param id
	 * 			Id de la escena
	 * @param message
	 * 			Mensaje a enviar
	 */
	public void sendMessageToScene(String id, SceneMessage message) {
		getScene(id).handleSceneMessage(message);
	}

	/**
	 * Añade una entidad interactiva al mundo.
	 *
	 * @param entity
	 * 			Entidad interactiva a añadir
	 */
	public void addEntity(InteractiveEntity entity) {
		interactiveEntities.add(entity);
		if(entity.getId().compareTo("Player")==0)
			player=(Player) entity;
	}

	/**
	 * Elimina una entidad interactiva del mundo.
	 * 
	 * @param id
	 * 			Id de la entidad interactiva a eliminar
	 */
	public void removeEntity(String id) {
		InteractiveEntity entidadBorrar = null;
		Iterator<InteractiveEntity> iterador = interactiveEntities.iterator();
		while (iterador.hasNext()) {
			InteractiveEntity entidad = iterador.next();
			if (entidad.getId().compareTo(id) == 0) {
				entidadBorrar = entidad;
				break;
			}
		}
		scenes.remove(entidadBorrar);
	}
	
	/**
	 * Devuelve una entidad interactiva del mundo.
	 * 
	 * @param id
	 * 			Id de la entidad interactiva a devolver
	 * @return Una entidad interactiva del mundo
	 */
	public InteractiveEntity getEntity(String id){
		InteractiveEntity entidadDevolver = null;
		Iterator<InteractiveEntity> iterador = interactiveEntities.iterator();
		while (iterador.hasNext()) {
			InteractiveEntity entidad = iterador.next();
			if (entidad.getId().compareTo(id) == 0) {
				entidadDevolver = entidad;
				break;
			}
		}
		return entidadDevolver;
	}

	/**
	 * Envía un mensaje o manda hacer una acción a una entidad interactiva.
	 * 
	 * @param id
	 * 			Id de la entidad interactiva
	 * @param message
	 * 			Mensaje a enviar
	 */
	public void sendMessageToEntity(String id, InteractiveEntityMessage message) {
		InteractiveEntity entidadConcreta = null;
		Iterator<InteractiveEntity> iterador = interactiveEntities.iterator();
		while (iterador.hasNext()) {
			InteractiveEntity entidad = iterador.next();
			if (entidad.getId().compareTo(id) == 0) {
				entidadConcreta = entidad;
				break;
			}
		}
		entidadConcreta.handleEntityMessage(message);
	}

}
