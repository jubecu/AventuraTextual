package ejecucion;

//import java.io.*;
import model.*;

public class Cliente {

	public static void main(String[] args) {

		Player jugador = new Player();
		// Escena habitación 1 con su descripcion y sus elementos
		Scene escena1 = new Scene("Habitación 1");
		escena1.setDescription("Te encuentras en una habitación con dos puertas (una al norte y una al este).");
		// Elemento puerta norte con sus descripciones y acciones
		Elemento elemento1 = new Elemento("Puerta norte");
		elemento1.setDescription1("La puerta norte está abierta");
		elemento1.setDescription2("La puerta norte está cerrada");
		elemento1.setValor();
		SwitchSceneAction accion1 = new SwitchSceneAction("Habitación 2");
		elemento1.addAvailableActions(accion1);
		escena1.addProp(elemento1);
		// Elemento puerta este con sus descripciones y acciones
		Elemento elemento2 = new Elemento("Puerta este");
		elemento2.setDescription1("La puerta este está abierta");
		elemento2.setDescription2("La puerta este está cerrada");
		SwitchSceneAction accion2 = new SwitchSceneAction("Habitación 3");
		elemento2.addAvailableActions(accion2);
		escena1.addProp(elemento2);

		escena1.addAvailableActions(accion1);
		escena1.addAvailableActions(accion2);
		World.getInstance().addEntity(jugador);
		World.getInstance().addEntity(elemento1);
		World.getInstance().addEntity(elemento2);
		World.getInstance().addEntity(escena1);
		World.getInstance().addScene(escena1);

		// Escena habitación 2 con su descripcion y sus elementos
		Scene escena2 = new Scene("Habitación 2");
		escena2.setDescription("Esta habitación sólo tiene una salida al sur. "
				+ "En el centro de la habitación hay una mesa con una caja.");
		Elemento elemento3 = new Elemento("Caja");
		elemento3.setDescription1("Dentro de la caja se encuentra una llave");
		elemento3.setDescription2("La caja está vacía");
		elemento3.setValor();
	}

}
