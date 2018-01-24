package actions;

import java.util.ArrayList;
import java.util.Iterator;

import model.Scene;
import model.World;

public class ExaminarObjetoAction extends Interaction implements SceneMessage {
	private boolean vista;
	private String description;
	private String despuesExaminar;
	private ArrayList<String> elementosAfecta;

	public ExaminarObjetoAction() {
		vista = false;
		elementosAfecta = new ArrayList<String>();
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

	public void setDespuesExaminar(String cadena) {
		despuesExaminar = cadena;
	}

	public void addElementoAfecta(String id) {
		elementosAfecta.add(id);
	}

	@Override
	public void doAction() {
		if (!vista) {
			InteractiveEntityMessage message = null;
			Iterator<String> iterador = elementosAfecta.iterator();
			while (iterador.hasNext()) {
				String elemento = iterador.next();
				World.getInstance().sendMessageToEntity(elemento, message);
			}
			System.out.println(despuesExaminar);
			vista = true;
		} else
			System.out.println(World.getInstance().getEntity(elementosAfecta.get(0)).getDescription());
	}
}
