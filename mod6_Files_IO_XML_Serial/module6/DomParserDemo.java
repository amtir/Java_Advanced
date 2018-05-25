package module6;





import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DomParserDemo {

	public static void dumpXMLToConsole(Document model) {
		NodeList nodes = model.getElementsByTagName("book");
		
		for(int i = 0; i<nodes.getLength(); i++) {
			Node node = nodes.item(i);
			
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) node;
				System.out.print("[Book ID]: " + eElement.getAttribute("id"));
				System.out.print("[Title]: " + eElement.getElementsByTagName("title").item(0).getTextContent());
				System.out.print("[Price]: " + eElement.getElementsByTagName("price").item(0).getTextContent());
				System.out.print("[Genre]: " + eElement.getElementsByTagName("genre").item(0).getTextContent());
				System.out.print("[Publish Date]: " + eElement.getElementsByTagName("publish_date").item(0).getTextContent());
				System.out.print("[Description]: " + eElement.getElementsByTagName("description").item(0).getTextContent());
				System.out.println();
				
			}
		}
		
	}
	
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {

		if (args.length !=1) {
			System.out.println("Usage: Java XML DOMParser Demo xml_File_Name");
			System.exit(-1);
		}
		
		DocumentBuilderFactory parserFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = parserFactory.newDocumentBuilder();		
		Document model = builder.parse(args[0]);
		DomParserDemo.dumpXMLToConsole(model);
		
		
		
	}

}
