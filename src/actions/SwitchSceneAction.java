package actions;

import model.*;

/**
 * Clase que representa la acci�n de cambiar de escena.
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
	 * Descripci�n de la acci�n
	 */
	private String description;

	/**
	 * Constructor que se le pasa como par�metro el Id de la escena a la que
	 * queremos cambiar.
	 * 
	 * @param sceneId
	 * 			Id de la escena a la que queremos cambiar
	 */
	public SwitchSceneAction(String sceneId) {
		targetSceneId = sceneId;
	}

	/**
	 * Maneja los mensajes que llegan a la acci�n.
	 */
	@Override
	public void handleSceneMessage(Scene scene) {

	}

	/**
	 * Devuelve la descripci�n de la acci�n.
	 * 
	 * @return Descripci�n de la acci�n
	 */
	@Override
	public String getDescription() {
		return description;
	}

	/**
	 * Establece la descripci�n de la acci�n.
	 * 
	 * @param description
	 * 			Descripci�n de la acci�n
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Lleva a cabo la acci�n.
	 */
	@Override
	public void doAction() {
		if (targetSceneId.compareTo("Habitaci�n 3") == 0) {
			if (World.getInstance().getScene("Habitaci�n 1").getProp("Puerta este").getValor())
				World.getInstance().getPlayer().setCurrentScene(World.getInstance().getScene(targetSceneId));
			else
				System.out.println(World.getInstance().getEntity("Puerta este").getDescription());
		} else
			World.getInstance().getPlayer().setCurrentScene(World.getInstance().getScene(targetSceneId));
	}

}
