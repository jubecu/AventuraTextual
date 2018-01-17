package ejecucion;

import actions.Interaction;
import actions.SceneMessage;
import model.*;

public class SwitchSceneAction extends Interaction implements SceneMessage{

	private String targetSceneId;
	
	public SwitchSceneAction(String sceneId){
		targetSceneId=sceneId;
	}
	
	@Override
	public void handleSceneMessage(Scene scene) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void doAction() {
		Scene escenaObjetivo;
		escenaObjetivo=World.getInstance().getScene(targetSceneId);
		World.getInstance().getPlayer().setCurrentScene(escenaObjetivo);
	}

}

