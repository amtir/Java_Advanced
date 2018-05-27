package module10.patterns.adapter;

import org.apache.log4j.Logger;

public class Client {

	private static final Logger log4j = Logger.getLogger(Client.class.getName());
	
	public static void main(String[] args) {
		
		int [] list = new int [] {7,9,4,0,1,6};
		log4j.debug("Array created...");
		
		log4j.debug("Adapter created...");
		Adapter adapter = new Adapter();
		log4j.debug("Sorting the Array via the Adapter...");
		adapter.sort(list);
		log4j.debug("Sorted Array.");
		for(int i : list) {
			log4j.debug(i);
		}
	}

}
