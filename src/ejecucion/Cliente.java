package ejecucion;

//import java.io.*;
import model.*;

public class Cliente {

	public static void main(String[] args) {

		Player jugador=new Player();
		//Escena habitaci�n 1 con su descripcion y sus elementos
		Scene escena1=new Scene("Habitaci�n 1");
		escena1.setDescription("Te encuentras en una habitaci�n con dos puertas (una al norte y una al este).");
		//Elemento puerta norte con sus descripciones y acciones
		Elemento elemento1=new Elemento("Puerta norte");
		elemento1.setDescription1("La puerta norte est� abierta");
		elemento1.setDescription2("La puerta norte est� cerrada");
		elemento1.setValor();
		SwitchSceneAction accion1=new SwitchSceneAction("Habitaci�n 2");
		elemento1.addAvailableActions(accion1);
		escena1.addProp(elemento1);
		//Elemento puerta este con sus descripciones y acciones
		Elemento elemento2=new Elemento("Puerta este");
		elemento2.setDescription1("La puerta este est� abierta");
		elemento2.setDescription2("La puerta este est� cerrada");
		SwitchSceneAction accion2=new SwitchSceneAction("Habitaci�n 3");
		elemento2.addAvailableActions(accion2);
		escena1.addProp(elemento2);
	}

}
