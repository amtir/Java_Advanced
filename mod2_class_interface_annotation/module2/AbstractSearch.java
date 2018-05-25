package module2;

import java.util.Arrays;

public abstract class AbstractSearch {	
	static final Integer IntVal1 = 5; 
	static final Integer IntVal2 = 10; 
	static final String strVal1 = "Bob";
	static final String strVal2 = "Cat";
	
	public abstract boolean search(Object obj_list[], Object obj);
	
	public static void main(String[] args) {
		Integer arrInteger[] = { new Integer(1), new Integer(2), 
				new Integer(3), new Integer(4), new Integer(5) };
		AbstractSearch objSearchInt = new IntegerSearch();
		System.out.printf( "Is %d in %s ? : %s %n", IntVal1,
				Arrays.toString(arrInteger),  objSearchInt.search( arrInteger, IntVal1));
		System.out.printf( "Is %d in %s ? : %s %n", IntVal2, 
				Arrays.toString(arrInteger),  objSearchInt.search( arrInteger, IntVal2));	
		
		objSearchInt = new StringSearch();	
		String arrString[] = { new String("Alice"), new String("Bob"), 
				new String("Peter"), new String("Smith"), new String("Tom") };
		System.out.printf( "Is %s in %s ? : %s %n", strVal2, 
				Arrays.toString(arrString),  objSearchInt.search( arrString, strVal2));
		System.out.printf( "Is %s in %s ? : %s %n", strVal1, 
				Arrays.toString(arrString),  objSearchInt.search( arrString, strVal1));
	}
}

class StringSearch extends AbstractSearch {

	@Override
	public boolean search(Object[] obj_list, Object obj) {

		for (int i = 0; i< obj_list.length; i++ ) {			
			if(  ((String)obj_list[i]).equals(((String) obj) )) {
				return true;
			}
		}		
		return false;
	
	
	}
	
}



class IntegerSearch extends AbstractSearch {

	@Override
	public boolean search(Object obj_list[], Object obj) {
			
		for (int i = 0; i< obj_list.length; i++ ) {			
			if(  ((Integer)obj_list[i]).intValue() == ((Integer) obj).intValue() ) {
				return true;
			}
		}		
		return false;
	}	
}


