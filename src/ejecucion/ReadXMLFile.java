package ejecucion;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class ReadXMLFile {

	public static void main(String[] args) {
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser saxParser = null;
		try {
			saxParser = factory.newSAXParser();
		} catch (ParserConfigurationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SAXException e1) {
			// TODO Auto-generated catch block
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
				if (qName.equalsIgnoreCase("description")) {
					bdescription = true;
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
						System.out.println("ID: " + new String(ch, start, lenght));
						bidEscena = false;
					}
					if (bdescription) {
						System.out.println("Descripción: " + new String(ch, start, lenght));
						bdescription = false;
					}
					if (belemento) {
						if (!contElem) {
							System.out.println("Elemento");
							contElem = true;
						}
						if (bidElemento) {
							System.out.println("id: " + new String(ch, start, lenght));
							bidElemento = false;
						}
						if (bdescription1) {
							System.out.println("Descripción 1: " + new String(ch, start, lenght));
							bdescription1 = false;
						}
						if (bdescription2) {
							System.out.println("Descripción 2: " + new String(ch, start, lenght));
							bdescription2 = false;
						}
						if (baccion) {
							if (!contAcc) {
								System.out.println("Acción");
								contAcc = true;
							}
							if (btipo) {
								System.out.println("Tipo: " + new String(ch, start, lenght));
								btipo = false;
							}
							if (bidAccion) {
								System.out.println("id: " + new String(ch, start, lenght));
								bidAccion = false;
							}
						}
					}
				}
			}
		};

		try {
			saxParser.parse("Ejemplo.xml", handler);
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
