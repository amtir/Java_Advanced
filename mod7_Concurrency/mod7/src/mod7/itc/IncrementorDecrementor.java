package mod7.itc;

import org.apache.log4j.Logger;

public class IncrementorDecrementor {
	

	private static final Logger log4j = Logger.getLogger(IncrementorDecrementor.class.getName());
	private int count = 0;
	
	
	public IncrementorDecrementor(int counter) {
		this.count = counter;
	}
	public synchronized void increment() {
		log4j.debug(this.getClass().getName() + " entered...");
		Thread t = Thread.currentThread();
		String name = t.getName();

		for (int i = 0; i <= count; i++) {
			System.out.println(name + " " + i);
		}
		log4j.debug(this.getClass().getName() + " exited...");
	}

	public synchronized void decrement() {
		log4j.debug(this.getClass().getName() + " entered...");
		Thread t = Thread.currentThread();
		String name = t.getName();

		for (int i = count; i>0; i--) {
			System.out.println(name + " " + i);
		}
		log4j.debug(this.getClass().getName() + " exited...");
	}

}
