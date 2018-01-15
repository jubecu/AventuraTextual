package model;

import java.util.ArrayList;
import java.util.Iterator;

import actions.InteractiveEntityMessage;
import actions.SceneMessage;

public class World {

	Player player;
	private ArrayList<Scene> scenes;
	private ArrayList<InteractiveEntity> interactiveEntities;

	public Player getPlayer() {
		return player;
	}

	public void addScene(Scene scene) {
		scenes.add(scene);
	}

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

	public void sendMessageToScene(String id, SceneMessage message) {

	}

	public void addEntity(InteractiveEntity entity) {
		interactiveEntities.add(entity);
	}

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

	public void sendMessageToEntity(String id, InteractiveEntityMessage message) {

	}

}