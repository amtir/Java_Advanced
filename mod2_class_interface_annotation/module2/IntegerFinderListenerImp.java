package module2;

public class IntegerFinderListenerImp implements IntegerFinderListener {

	@Override
	public void found(String mesg, int number, int index) {
		System.out.println(mesg+ number + "," + index);
	}
}
