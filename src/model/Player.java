package model;

import actions.Interaction;

/**
 * Clase que representa al jugador de la partida.
 * 
 * @author Juan Francisco Benito Cuesta
 *
 */
public class Player extends InteractiveEntity {

	/**
	 * Id �nico del jugador
	 */
	public static String PLAYER_ID = "Player";
	/**
	 * Escena donde se encuentra el jugador en un momento dado de la partida
	 */
	private Scene currentScene;
	/**
	 * Lista de acciones del jugador
	 */
	private Interaction[] acciones;

	/**
	 * Constructor que asigna el id al jugador e inicializa la lista de acciones.
	 */
	public Player() {
		super(PLAYER_ID);
		acciones = new Interaction[10];
	}

	/**
	 * Devuelve la descripci�n del jugador.
	 * 
	 * @return Descripci�n del jugador
	 */
	@Override
	public String getDescription() {
		return "El jugador est� en la escena " + currentScene.id;
	}

	/**
	 * A�ade una acci�n a la lista de acciones del jugador.
	 * 
	 * @param accion
	 * 			Acci�n a a�adir en la lista
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
	 * Devuelve la lista de acciones del jugador.
	 * 
	 * @return Lista de acciones del jugador
	 */
	@Override
	public Interaction[] getAvailableActions() {
		return acciones;
	}

	/**
	 * Establece la escena donde se encuentra el jugador.
	 * 
	 * @param scene
	 * 			Escena nueva donde se encuentra el jugador
	 */
	public void setCurrentScene(Scene scene) {
		this.currentScene = scene;
	}

	/**
	 * Devuelve la escena donde se encuentra el jugador.
	 * 
	 * @return Escena donde se encuentra el jugador
	 */
	public Scene getCurrentScene() {
		return currentScene;
	}
}
