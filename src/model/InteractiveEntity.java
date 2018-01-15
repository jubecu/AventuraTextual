package model;

import actions.Interaction;
import actions.InteractiveEntityMessage;

public abstract class InteractiveEntity {

	protected String id;

	public InteractiveEntity(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public abstract String getDescription();

	public abstract Interaction[] getAvailableActions();

	public void handleEntityMessage(InteractiveEntityMessage message) {

	}

}
