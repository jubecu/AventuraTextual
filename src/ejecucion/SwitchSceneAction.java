package ejecucion;

import actions.Interaction;
import actions.SceneMessage;
import model.*;

public class SwitchSceneAction extends Interaction implements SceneMessage {

	private String targetSceneId;

	public SwitchSceneAction(String sceneId) {
		targetSceneId = sceneId;
	}

	@Override
	public void handleSceneMessage(Scene scene) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getDescription() {
		if (targetSceneId == "Habitación 1")
			return "Ir al sur";
		if (targetSceneId == "Habitación 2")
			return "Ir al norte";
		if (targetSceneId == "Habitación 3")
			return "Ir al este";
		return null;
	}

	@Override
	public void doAction() {
		Scene escenaObjetivo;
		escenaObjetivo = World.getInstance().getScene(targetSceneId);
		World.getInstance().getPlayer().setCurrentScene(escenaObjetivo);
	}

}
