package model;

import java.util.ArrayList;
import java.util.Iterator;

import actions.Interaction;
import actions.InteractiveEntityMessage;
import actions.SceneMessage;

public class Scene extends InteractiveEntity {

	private String description;
	private ArrayList<Prop> props;
	private Interaction[] acciones;

	public Scene(String id) {
		super(id);
		acciones = new Interaction[10];
		// acciones[0]=
	}

	@Override
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void addAvailableActions(Interaction accion) {
		for (int i = 0; i < acciones.length; i++) {
			if (acciones[i] == null) {
				acciones[i] = accion;
				break;
			}
		}
	}

	@Override
	public Interaction[] getAvailableActions() {
		return acciones;
	}

	public void addProp(Prop prop) {
		props.add(prop);
	}

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

	@Override
	public void handleEntityMessage(InteractiveEntityMessage message) {

	}

	public void handleSceneMessage(SceneMessage message) {

	}

}
