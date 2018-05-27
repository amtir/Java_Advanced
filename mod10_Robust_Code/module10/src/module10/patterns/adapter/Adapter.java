package module10.patterns.adapter;

import java.util.ArrayList;
import org.apache.log4j.Logger;


public class Adapter implements Target {

	private static final Logger log4j = Logger.getLogger(Adapter.class.getName());
	
	@Override
	public void sort(int[] list) {
		int i;
		log4j.debug("Converting Array to ArrayList...");
		ArrayList<Integer> newList = new ArrayList<Integer>();
		for(i=0; i<list.length; i++)
			newList.add(new Integer(list[i]));
		log4j.debug("Sorting the ArrayList...");
		log4j.debug("Calling the Adaptee.sort...");
		Adaptee.sort(newList);
		
		log4j.debug("Converting ArrayList to Array...");
		for(i=0; i<newList.size(); i++)
			list[i] = newList.get(i).intValue();
	}
}
