package module3;

import java.util.ArrayList;
import java.util.List;

public class MySearchHelper extends SearchHelper {
	
	public Integer[] search( Double list[], Double number) {
		
		List<Integer> indexes = new ArrayList<Integer>();
		
		
		for (int i = 0; i<list.length; i++) {
			
			if(list[i].doubleValue()== number.doubleValue()) {
				indexes.add(i);
			}
		}	
		
        Integer[] arr = new Integer[indexes.size()];
        arr = indexes.toArray(arr);
	
		return arr;
	}
}
