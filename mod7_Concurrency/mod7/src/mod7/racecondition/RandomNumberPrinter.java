package mod7.racecondition;

import org.apache.log4j.Logger;

public class RandomNumberPrinter {
	
	private static final Logger log4j = Logger.getLogger(RandomNumberPrinter.class.getName());

	public synchronized void printRandomNumbers(int n) {
		log4j.debug(this.getClass().getName() + " entered...");
	      Thread t = Thread.currentThread();
	      String name = t.getName();
		
		for (int i =0; i<n ;i++) {
			System.out.println( name + " " + (int)(Math.random()*1000));
		}
		log4j.debug(this.getClass().getName() + " exited...");
	}
}
