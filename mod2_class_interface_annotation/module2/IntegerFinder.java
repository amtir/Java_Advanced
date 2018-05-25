package module2;

public class IntegerFinder {
	static final int INT_VAL = 6;
	static final String STR_MESSG = "Found [Number,Index] = ";

	public static void main(String[] args) {
		int intArr[] = {6,1,2,3,4,5,6,7,2,9,10,6};
		IntegerFinder t = new IntegerFinder();
		IntegerFinderListenerImp listener = new IntegerFinderListenerImp();
		t.searchFind(INT_VAL, intArr, listener );
	}
	
	public boolean searchFind(int x, int intArr[], IntegerFinderListenerImp listener ) {
		
		for(int i = 0; i<intArr.length; i++) {
			if(x == intArr[i])
				listener.found(STR_MESSG, intArr[i], i);
		}
		return false;
	}
}
