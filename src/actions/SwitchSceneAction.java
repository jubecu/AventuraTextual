package actions;

import model.*;

public class SwitchSceneAction extends Interaction implements SceneMessage {

	private String targetSceneId;
	private String description;

	public SwitchSceneAction(String sceneId) {
		targetSceneId = sceneId;
	}

	@Override
	public void handleSceneMessage(Scene scene) {

	}

	@Override
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

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
