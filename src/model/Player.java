package model;

import actions.Interaction;

public class Player extends InteractiveEntity {

	public static String PLAYER_ID = "  Player";
	private Scene currentScene;

	public Player() {
		super(PLAYER_ID);
	}

	@Override
	public String getDescription() {
		return "El jugador está en la escena tal y lleva los objetos tal";
	}

	@Override
	public Interaction[] getAvailableActions() {
		return null;
	}

	public void setCurrentScene(Scene scene) {
		this.currentScene = scene;
	}

	public Scene getCurrentScene() {
		return currentScene;
	}
}
