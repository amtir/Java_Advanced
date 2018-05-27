package module10.patterns.ObserverObservable;

import java.util.Observable;
import java.util.Random;
import org.apache.log4j.Logger;

public class RandObservable2 extends Observable {

	private Random rn = new Random();
	private static final Logger log4j = Logger.getLogger(RandObservable.class.getName());
	private static boolean flag = false;

	public synchronized void startObservable() {
		if (flag == false) {
			flag = true;
			log4j.debug("Generating Random Number in the RandObservable2.");
			int intRandom = rn.nextInt(20) + 1;
			for (int i = 0; i < 10; i++) {
				intRandom = rn.nextInt(100) + 1; // generate Random number
				// set change
				setChanged();
				// notify observers for change only if Odd Number
				if (intRandom % 2 == 1) { // Odd Number?
					notifyObservers(String.valueOf(intRandom));
				}
				try {
					Thread.sleep(300);
				} catch (InterruptedException e) {
					log4j.debug("Error Occurred.");
				}
			}
		}
	}
}