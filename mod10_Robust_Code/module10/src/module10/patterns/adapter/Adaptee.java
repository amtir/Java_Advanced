package module10.patterns.adapter;

import java.util.ArrayList;
import java.util.Collections;

public class Adaptee {

	public static void sort(ArrayList<Integer> newList) {
		
		Collections.sort(newList);
		
	}
}
