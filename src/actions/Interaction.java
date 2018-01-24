package actions;

/**
 * Clase abstracta con los métodos principales de una acción.
 * 
 * @author Juan Francisco Benito Cuesta
 *
 */
public abstract class Interaction {

	/**
	 * Devuelve la descripción de la acción.
	 * 
	 * @return Descripción de la acción
	 */
	public abstract String getDescription();

	/**
	 * Lleva a cabo la acción.
	 */
	public abstract void doAction();

}
