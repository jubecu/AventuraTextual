package model;

import actions.Interaction;
import actions.InteractiveEntityMessage;

public class Elemento extends Prop {

	private String description;
	private String description1;
	private String description2;
	private boolean valor;
	private Interaction[] acciones;

	public Elemento(String id) {
		super(id);
		valor = false;
		acciones = new Interaction[10];
	}

	@Override
	public String getDescription() {
		return description;
	}

	public void setDescription1(String description) {
		description1 = description;
	}

	public void setDescription2(String description) {
		description2 = description;
		if (this.description == null)
			this.description = description2;
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

	@Override
	public boolean getValor() {
		return valor;
	}

	public void setValor() {
		if (valor) {
			valor = false;
			description = description2;
		} else {
			valor = true;
			description = description1;
		}
	}

	@Override
	public void handleEntityMessage(InteractiveEntityMessage message) {
		setValor();
	}

}
