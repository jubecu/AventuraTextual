package ejecucion;

import actions.Interaction;
import actions.InteractiveEntityMessage;
import actions.SceneMessage;
import model.Scene;
import model.World;

public class ExaminarCaja extends Interaction implements SceneMessage {

	private boolean vista;

	public ExaminarCaja() {
		vista = false;
	}

	@Override
	public void handleSceneMessage(Scene scene) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getDescription() {
		return "Examinar caja";
	}

	@Override
	public void doAction() {
		if (!vista) {
			InteractiveEntityMessage message = null;
			World.getInstance().sendMessageToEntity("Puerta este", message);
			World.getInstance().sendMessageToEntity("Caja", message);
			System.out.println("Has cogido una llave que había dentro.");
			vista = true;
		} else
			System.out.println(World.getInstance().getEntity("Caja").getDescription());
	}

}
