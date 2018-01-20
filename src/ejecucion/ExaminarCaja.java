package ejecucion;

import actions.Interaction;
import actions.InteractiveEntityMessage;
import actions.SceneMessage;
import model.Scene;
import model.World;

public class ExaminarCaja extends Interaction implements SceneMessage{

	public ExaminarCaja(){
		
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
		/*Interaction[] acciones=World.getInstance().getScene("Habitación 1").getAvailableActions();
		Interaction accion = null;
		for(int i=0;i<acciones.length;i++){
			if (acciones[i].getDescription()=="Ir al este"){
				accion=acciones[i];
				break;
			}
		}
		World.getInstance().getPlayer().addAvailableActions(accion);*/
		InteractiveEntityMessage message = null;
		World.getInstance().sendMessageToEntity("Puerta este", message);
		System.out.println("Has cogido una llave que había dentro.");
	}

}
