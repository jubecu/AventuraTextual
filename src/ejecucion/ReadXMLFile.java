package ejecucion;

import java.io.IOException;
import java.util.Scanner;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import actions.Interaction;
import model.Player;
import model.Scene;
import model.World;

public class ReadXMLFile {

	private static Scene escena;
	private static Elemento elemento;
	private static SwitchSceneAction cambiarEscena;
	private static ExaminarObjetoAction examinarObjeto;
	private static String escenaInicial;
	private static String escenaFinal;
	private static boolean primeraEscena = true;
	private static Scanner sc;

	public static void main(String[] args) {
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser saxParser = null;
		try {
			saxParser = factory.newSAXParser();
		} catch (ParserConfigurationException e1) {
			e1.printStackTrace();
		} catch (SAXException e1) {
			e1.printStackTrace();
		}

		DefaultHandler handler = new DefaultHandler() {
			boolean bEscena = false;
			boolean contEsc = false;
			boolean bidEscena = false;
			boolean bidElemento = false;
			boolean bdescription = false;
			boolean bdescription1 = false;
			boolean bdescription2 = false;
			boolean belemento = false;
			boolean contElem = false;
			boolean baccion = false;
			boolean bidAccion = false;
			boolean contAcc = false;
			boolean btipo = false;
			boolean bvalor = false;
			boolean bdescriptionAccion = false;
			String tipo = null;
			boolean belementosAfecta = false;
			boolean bdespuesExaminar = false;

			public void startElement(String uri, String localName, String qName, Attributes attributes)
					throws SAXException {
				if (qName.equalsIgnoreCase("Escena"))
					bEscena = true;
				if (qName.equalsIgnoreCase("id") && !belemento && !baccion) {
					bidEscena = true;
				}
				if (qName.equalsIgnoreCase("id") && belemento && !baccion)
					bidElemento = true;
				if (qName.equalsIgnoreCase("id") && belemento && baccion)
					bidAccion = true;
				if (qName.equalsIgnoreCase("description") && !baccion) {
					bdescription = true;
				}
				if (qName.equalsIgnoreCase("description") && baccion) {
					bdescriptionAccion = true;
				}
				if (qName.equalsIgnoreCase("description1")) {
					bdescription1 = true;
				}
				if (qName.equalsIgnoreCase("description2")) {
					bdescription2 = true;
				}
				if (qName.equalsIgnoreCase("elemento"))
					belemento = true;
				if (qName.equalsIgnoreCase("tipo"))
					btipo = true;
				if (qName.equalsIgnoreCase("accion"))
					baccion = true;
				if (qName.equalsIgnoreCase("valor"))
					bvalor = true;
				if (qName.equalsIgnoreCase("elementosAfecta"))
					belementosAfecta = true;
				if (qName.equalsIgnoreCase("despuesExaminar"))
					bdespuesExaminar = true;
			}

			public void endElement(String uri, String localName, String qName) throws SAXException {
				if (qName.equalsIgnoreCase("Escena")) {
					bEscena = false;
					contEsc = false;
				}
				if (qName.equalsIgnoreCase("elemento")) {
					belemento = false;
					contElem = false;
				}
				if (qName.equalsIgnoreCase("accion")) {
					baccion = false;
					contAcc = false;
				}
			}

			public void characters(char ch[], int start, int lenght) throws SAXException {
				if (bEscena) {
					if (!contEsc) {
						System.out.println("Escena");
						contEsc = true;
					}
					if (bidEscena) {
						if (primeraEscena) {
							escenaInicial = new String(ch, start, lenght);
							primeraEscena = false;
						}
						escena = new Scene(new String(ch, start, lenght));
						World.getInstance().addScene(escena);
						World.getInstance().addEntity(escena);
						System.out.println("ID: " + new String(ch, start, lenght));
						escenaFinal = new String(ch, start, lenght);
						bidEscena = false;
					}
					if (bdescription) {
						escena.setDescription(new String(ch, start, lenght));
						System.out.println("Descripción: " + new String(ch, start, lenght));
						bdescription = false;
					}
					if (belemento) {
						if (!contElem) {
							System.out.println("Elemento");
							contElem = true;
						}
						if (bidElemento) {
							elemento = new Elemento(new String(ch, start, lenght));
							escena.addProp(elemento);
							World.getInstance().addEntity(elemento);
							System.out.println("id: " + new String(ch, start, lenght));
							bidElemento = false;
						}
						if (bdescription1) {
							elemento.setDescription1(new String(ch, start, lenght));
							System.out.println("Descripción 1: " + new String(ch, start, lenght));
							bdescription1 = false;
						}
						if (bdescription2) {
							elemento.setDescription2(new String(ch, start, lenght));
							System.out.println("Descripción 2: " + new String(ch, start, lenght));
							bdescription2 = false;
						}
						if (bvalor) {
							String valor = new String(ch, start, lenght);
							if (valor.compareTo("true") == 0)
								elemento.setValor();
							System.out.println("Valor: " + new String(ch, start, lenght));
							bvalor = false;
						}
						if (baccion) {
							if (!contAcc) {
								System.out.println("Acción");
								contAcc = true;
							}
							if (btipo) {
								tipo = new String(ch, start, lenght);
								System.out.println("Tipo: " + new String(ch, start, lenght));
								btipo = false;
							}
							if (bidAccion) {
								if (tipo.compareTo("Cambiar escena") == 0) {
									cambiarEscena = new SwitchSceneAction(new String(ch, start, lenght));
									elemento.addAvailableActions(cambiarEscena);
									escena.addAvailableActions(cambiarEscena);
								} else if (tipo.compareTo("Examinar objeto") == 0) {
									examinarObjeto = new ExaminarObjetoAction();
									elemento.addAvailableActions(examinarObjeto);
									escena.addAvailableActions(examinarObjeto);
								}
								System.out.println("id: " + new String(ch, start, lenght));
								bidAccion = false;
							}
							if (bdescriptionAccion) {
								if (tipo.compareTo("Cambiar escena") == 0)
									cambiarEscena.setDescription(new String(ch, start, lenght));
								else if (tipo.compareTo("Examinar objeto") == 0)
									examinarObjeto.setDescription(new String(ch, start, lenght));
								System.out.println("Descripción de la acción: " + new String(ch, start, lenght));
								bdescriptionAccion = false;
							}
							if (bdespuesExaminar) {
								examinarObjeto.setDespuesExaminar(new String(ch, start, lenght));
								System.out.println("Después de examinar: " + new String(ch, start, lenght));
								bdespuesExaminar = false;
							}
							if (belementosAfecta) {
								examinarObjeto.addElementoAfecta(new String(ch, start, lenght));
								System.out.println("Afecta al elemento: " + new String(ch, start, lenght));
								belementosAfecta = false;
							}
						}
					}
				}
			}
		};

		try {
			saxParser.parse("Ejemplo.xml", handler);
			sc = new Scanner(System.in);
			Player jugador = new Player();
			World.getInstance().addEntity(jugador);
			jugador.setCurrentScene(World.getInstance().getScene(escenaInicial));
			while (jugador.getCurrentScene().getId().compareTo(escenaFinal) != 0) {
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
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
