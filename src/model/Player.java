package model;

import actions.Interaction;

public class Player extends InteractiveEntity {

	public static String PLAYER_ID = "Player";
	private Scene currentScene;
	private Interaction[] acciones;

	public Player() {
		super(PLAYER_ID);
		acciones = new Interaction[10];
	}

	@Override
	public String getDescription() {
		return "El jugador está en la escena tal y lleva los objetos tal";
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

	public void setCurrentScene(Scene scene) {
		this.currentScene = scene;
	}

	public Scene getCurrentScene() {
		return currentScene;
	}
}
