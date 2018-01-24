package actions;

import model.*;

/**
 * Clase que representa la acción de cambiar de escena.
 * 
 * @author Juan Francisco Benito Cuesta
 *
 */
public class SwitchSceneAction extends Interaction implements SceneMessage {

	/**
	 * Id de la escena a la que queremos cambiar
	 */
	private String targetSceneId;
	/**
	 * Descripción de la acción
	 */
	private String description;

	/**
	 * Constructor que se le pasa como parámetro el Id de la escena a la que
	 * queremos cambiar.
	 * 
	 * @param sceneId
	 * 			Id de la escena a la que queremos cambiar
	 */
	public SwitchSceneAction(String sceneId) {
		targetSceneId = sceneId;
	}

	/**
	 * Maneja los mensajes que llegan a la acción.
	 */
	@Override
	public void handleSceneMessage(Scene scene) {

	}

	/**
	 * Devuelve la descripción de la acción.
	 * 
	 * @return Descripción de la acción
	 */
	@Override
	public String getDescription() {
		return description;
	}

	/**
	 * Establece la descripción de la acción.
	 * 
	 * @param description
	 * 			Descripción de la acción
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Lleva a cabo la acción.
	 */
	@Override
	public void doAction() {
		if (targetSceneId.compareTo("Habitación 3") == 0) {
			if (World.getInstance().getScene("Habitación 1").getProp("Puerta este").getValor())
				World.getInstance().getPlayer().setCurrentScene(World.getInstance().getScene(targetSceneId));
			else
				System.out.println(World.getInstance().getEntity("Puerta este").getDescription());
		} else
			World.getInstance().getPlayer().setCurrentScene(World.getInstance().getScene(targetSceneId));
	}

}
