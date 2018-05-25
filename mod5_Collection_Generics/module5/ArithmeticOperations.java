package module5;

import java.util.Arrays;
import java.util.List;

public class ArithmeticOperations {
	
	public static <T extends Number> Number add(T t1, T t2) {
		return (t1.doubleValue() + t2.doubleValue() );
	}
	
	public static <T extends Number> Number subtract(T t1, T t2) {
		return (t1.doubleValue() - t2.doubleValue() );
	}
	
	public static <T extends Number> Number divide(T t1, T t2) {
		return (t1.doubleValue() / t2.doubleValue() );
	}
	
	public static <T extends Number> Number add( List<? extends Number>	list) {
		double d =0;
		for(int i=0; i<list.size();i++) {
			d += list.get(i).doubleValue();
		}
		return new Double(d);
	}
	
	public static <T> T[] swap(T[] list, int firstPost, int secondPos)  {
		// Check the length of the array
		if(firstPost >= list.length && firstPost >= list.length ) {
			throw new IndexOutOfBoundsException("Please check firstPost and secondPos. Indexe is out of bounds!");
		}
		T temp = list[firstPost];
		list[firstPost] = list[secondPos];
		list[secondPos] = temp;
		return list;
	}
	
	public static void dumpList(List<?> list) {
		System.out.println("List dump with unbounded wildcard: ");
		for(int i =0; i<list.size(); i++)
			System.out.println(list.get(i));
	}
	
	public static <T>  void dumpList(T[] arr) {
		System.out.println("List dump with unbounded wildcard: ");
		for(int i =0; i<arr.length; i++)
			System.out.println(arr[i]);
	}
	
	public static void main(String[] args) {
		Integer i1 = new Integer(34); 
		Integer i2 = new Integer(43);
		System.out.println("Add with generic methood: " + ArithmeticOperations.add(i1,i2));
		Float f1 = new Float(12.56), f2 = new Float(3.6778);
		System.out.println("Float Numbers: " + f1 + ", " + f2 );
		System.out.println("Add with generic methood: " + ArithmeticOperations.add(f1,f2));
		System.out.println("Subtract with generic methood: " + ArithmeticOperations.subtract(f1,f2));
		System.out.println("Divide with generic methood: " + ArithmeticOperations.divide(f1,f2));
	
		Integer intArr[] = { new Integer(1), new Integer(2), new Integer(3), new Integer(4), new Integer(5)};
		///dumpList(intArr);
		System.out.println("Before Swaping " + Arrays.toString(intArr));
		intArr = swap(intArr, 0, 4);
		//dumpList(intArr);
		System.out.println("After Swaping " + Arrays.toString(intArr));
		
	}

}
