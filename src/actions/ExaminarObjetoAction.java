package actions;

import java.util.ArrayList;
import java.util.Iterator;

import model.Scene;
import model.World;

/**
 * Clase que representa la acción de examinar un objeto o elemento de una escena.
 * 
 * @author Juan Francisco Benito Cuesta
 *
 */
public class ExaminarObjetoAction extends Interaction implements SceneMessage {
	/**
	 * Si el objeto ha sido examinado (true) o no (false)
	 */
	private boolean vista;
	/**
	 * Descripción de la acción.
	 */
	private String description;
	/**
	 * Texto que muestra en pantalla la acción después de examinar el objeto
	 */
	private String despuesExaminar;
	/**
	 * Lista de elementos u objetos que afecta el hecho de realizar esta acción
	 */
	private ArrayList<String> elementosAfecta;
	
	/**
	 * Constructor que inicializa la acción a no realizada, y el ArrayList de
	 * los elementos a los que afecta.
	 */
	public ExaminarObjetoAction() {
		vista = false;
		elementosAfecta = new ArrayList<String>();
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
	 * Establece el texto de después de examinar el objeto.
	 * 
	 * @param cadena
	 * 			Texto que muestra después de examinar el objeto.
	 */
	public void setDespuesExaminar(String cadena) {
		despuesExaminar = cadena;
	}

	/**
	 * Añade a la lista un elemento al cual le afecta la realización de la acción.
	 * 
	 * @param id
	 * 			Id del elemento
	 */
	public void addElementoAfecta(String id) {
		elementosAfecta.add(id);
	}

	/**
	 * Lleva a cabo la acción.
	 */
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
