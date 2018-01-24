package actions;

/**
 * Clase abstracta con los m�todos principales de una acci�n.
 * 
 * @author Juan Francisco Benito Cuesta
 *
 */
public abstract class Interaction {

	/**
	 * Devuelve la descripci�n de la acci�n.
	 * 
	 * @return Descripci�n de la acci�n
	 */
	public abstract String getDescription();

	/**
	 * Lleva a cabo la acci�n.
	 */
	public abstract void doAction();

}
