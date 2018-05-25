package module6;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class CatalogueUtils {

	private static boolean updatePrice(String xmlFilename, String newXMLFileName, String bookID, String newPrice)
			throws ParserConfigurationException, SAXException, IOException, TransformerException {

		boolean retVal = false;
		DocumentBuilderFactory parserFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = parserFactory.newDocumentBuilder();
		Document model = builder.parse(xmlFilename);

		if (modifyPrice(model, bookID, newPrice)) {
			generateNewXML(model, newXMLFileName);
			retVal = true;
		}

		return retVal;
	}

	private static boolean modifyPrice(Document model, String bookID, String newPrice) {

		boolean retVal = false;
		NodeList nodes = model.getElementsByTagName("book");
		for (int i = 0; i < nodes.getLength(); i++) {
			Node node = nodes.item(i);

			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) node;

				if (bookID.compareTo(eElement.getAttribute("id")) == 0) {
					eElement.getElementsByTagName("price").item(0).setTextContent(newPrice);
					retVal = true;
				}
			}
		}
		return retVal;
	}

	private static void generateNewXML(Document model, String newXMLFilename) throws TransformerException {
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(model);
		StreamResult result = new StreamResult(new File(newXMLFilename));
		transformer.transform(source, result);

	}

	public static void main(String[] args)
			throws ParserConfigurationException, SAXException, IOException, TransformerException {

		if (args.length != 4) {
			System.out.println("Usage: Java XML DOMParserAlterPriceDemo xml_File_Name book_id new_price");
			System.exit(-1);
		}

		boolean retVal = CatalogueUtils.updatePrice(args[0], args[1], args[2], args[3]);

		if (retVal)
			System.out.println("[Success] Book ID: " + args[2] + " New Price: " + args[3]);
		else
			System.out.println("[Failure] Book ID: " + args[2] + " does not exist.");

	}

}
