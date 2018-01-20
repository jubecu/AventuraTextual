package ejecucion;

import actions.Interaction;
import java.util.Scanner;
import model.*;

public class Cliente {

	private static Scanner sc;

	public static void main(String[] args) {

		sc = new Scanner(System.in);
		Player jugador = new Player();
		// Escena habitaci�n 1 con su descripcion y sus elementos
		Scene escena1 = new Scene("Habitaci�n 1");
		escena1.setDescription("Te encuentras en una habitaci�n con dos puertas (una al norte y una al este).");
		// Elemento puerta norte con sus descripciones y acciones
		Elemento elemento1 = new Elemento("Puerta norte");
		elemento1.setDescription1("La puerta norte est� abierta");
		elemento1.setDescription2("La puerta norte est� cerrada");
		elemento1.setValor();
		SwitchSceneAction accion1 = new SwitchSceneAction("Habitaci�n 2");
		elemento1.addAvailableActions(accion1);
		escena1.addProp(elemento1);
		// Elemento puerta este con sus descripciones y acciones
		Elemento elemento2 = new Elemento("Puerta este");
		elemento2.setDescription1("La puerta este est� abierta");
		elemento2.setDescription2("La puerta este est� cerrada");
		SwitchSceneAction accion2 = new SwitchSceneAction("Habitaci�n 3");
		// elemento2.addAvailableActions(accion2);
		escena1.addProp(elemento2);

		escena1.addAvailableActions(accion1);
		escena1.addAvailableActions(accion2);
		World.getInstance().addEntity(jugador);
		World.getInstance().addEntity(elemento1);
		World.getInstance().addEntity(elemento2);
		World.getInstance().addEntity(escena1);
		World.getInstance().addScene(escena1);

		// Escena habitaci�n 2 con su descripcion y sus elementos
		Scene escena2 = new Scene("Habitaci�n 2");
		escena2.setDescription("Esta habitaci�n s�lo tiene una salida al sur. "
				+ "En el centro de la habitaci�n hay una mesa con una caja.");
		Elemento elemento3 = new Elemento("Caja");
		elemento3.setDescription1("Dentro de la caja se encuentra una llave");
		elemento3.setDescription2("La caja est� vac�a");
		elemento3.setValor();
		escena2.addProp(elemento3);
		Elemento elemento4 = new Elemento("Puerta sur");
		elemento4.setDescription1("La puerta sur est� abierta");
		elemento4.setDescription2("La puerta sur est� cerrada");
		elemento4.setValor();
		SwitchSceneAction accion3 = new SwitchSceneAction("Habitaci�n 1");
		elemento4.addAvailableActions(accion3);
		escena2.addProp(elemento4);
		ExaminarCaja accion4 = new ExaminarCaja();
		escena2.addAvailableActions(accion3);
		escena2.addAvailableActions(accion4);

		World.getInstance().addEntity(elemento3);
		World.getInstance().addEntity(elemento4);
		World.getInstance().addEntity(escena2);
		World.getInstance().addScene(escena2);

		Scene escena3 = new Scene("Habitaci�n 3");
		World.getInstance().addEntity(escena3);
		World.getInstance().addScene(escena3);

		// Comienzo del juego
		jugador.setCurrentScene(escena1);
		while (jugador.getCurrentScene() != escena3) {
			System.out.println(jugador.getCurrentScene().getDescription());
			System.out.println();
			System.out.println("0. Describir la escena");
			Interaction[] acciones = jugador.getCurrentScene().getAvailableActions();
			for (int i = 0; i < acciones.length; i++) {
				if (acciones[i] != null) {
					int n = i + 1;
					System.out.println(n + ". " + acciones[i].getDescription());
				}
			}
			System.out.println();
			System.out.print(">");
			String opcion = sc.nextLine();
			switch (opcion) {
			case "0":
				System.out.println(jugador.getCurrentScene().getDescription());
				break;
			case "1":
				acciones[0].doAction();
				break;
			case "2":
				acciones[1].doAction();
				break;
			}
		}
		System.out.println("Has llegado a tu destino.");
	}

}
