package model;

import actions.Interaction;

public abstract class Prop extends InteractiveEntity {

	public Prop(String id) {
		super(id);
	}

	public boolean getValor() {
		return true;
	}

	@Override
	public String getDescription() {
		return null;
	}

	@Override
	public Interaction[] getAvailableActions() {
		return null;
	}

}
