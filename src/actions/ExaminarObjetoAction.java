package actions;

import java.util.ArrayList;
import java.util.Iterator;

import model.Scene;
import model.World;

/**
 * Clase que representa la acci�n de examinar un objeto o elemento de una escena.
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
	 * Descripci�n de la acci�n.
	 */
	private String description;
	/**
	 * Texto que muestra en pantalla la acci�n despu�s de examinar el objeto
	 */
	private String despuesExaminar;
	/**
	 * Lista de elementos u objetos que afecta el hecho de realizar esta acci�n
	 */
	private ArrayList<String> elementosAfecta;
	
	/**
	 * Constructor que inicializa la acci�n a no realizada, y el ArrayList de
	 * los elementos a los que afecta.
	 */
	public ExaminarObjetoAction() {
		vista = false;
		elementosAfecta = new ArrayList<String>();
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
	 * Establece el texto de despu�s de examinar el objeto.
	 * 
	 * @param cadena
	 * 			Texto que muestra despu�s de examinar el objeto.
	 */
	public void setDespuesExaminar(String cadena) {
		despuesExaminar = cadena;
	}

	/**
	 * A�ade a la lista un elemento al cual le afecta la realizaci�n de la acci�n.
	 * 
	 * @param id
	 * 			Id del elemento
	 */
	public void addElementoAfecta(String id) {
		elementosAfecta.add(id);
	}

	/**
	 * Lleva a cabo la acci�n.
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
