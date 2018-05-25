package module6;

import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SAXParserDemo {

	public static void main(String[] args) throws Exception {

		if (args.length != 2) {
			System.out.println("Usage: XML SAXParser Demo xmlFileName breakfastName");
			System.exit(-1);
		}
		SAXParserFactory saxparser = SAXParserFactory.newInstance();
		SAXParser parser = saxparser.newSAXParser();

		BreakfastMenuXMLHandler handler = new BreakfastMenuXMLHandler();
		parser.parse(args[0], handler);
		//
		for (BKMenuItem item : handler.menuItems) {
			if (item.name.equals(args[1]))
				System.out.println(item);
		}
	}
}

class BreakfastMenuXMLHandler extends DefaultHandler {

	protected List<BKMenuItem> menuItems = new ArrayList<>();
	protected BKMenuItem item = null;
	protected String content = null;

	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

		switch (qName) {
		case "food":
			item = new BKMenuItem();
			break;
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {

		switch (qName) {

		case "food":
			menuItems.add(item);
			break;

		case "name":
			item.name = content;
			break;

		case "price":
			item.price = content;
			break;

		case "description":
			item.description = content;
			break;

		case "calories":
			item.calories = content;
			break;
		}
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		content = String.copyValueOf(ch, start, length).trim();
	}

}
