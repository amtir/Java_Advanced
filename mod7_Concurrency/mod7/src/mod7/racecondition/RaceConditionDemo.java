package mod7.racecondition;

import org.apache.log4j.Logger;

public class RaceConditionDemo {

	private static final Logger log4j = Logger.getLogger(RaceConditionDemo.class.getName());

	public static void main(String[] args) throws InterruptedException {
		log4j.info("Entering programme ...");

		RandomNumberPrinter rnp = new RandomNumberPrinter();

		Thread t1 = new Thread(new Task1(rnp));
		t1.start();

		Thread t2 = new Thread(new Task2(rnp));
		t2.start();

		t1.join();
		t2.join();
		log4j.info("Exiting programme ...");
	}

	private static class Task1 implements Runnable {
		private RandomNumberPrinter rnp = null;

		public Task1(RandomNumberPrinter rnp) {
			this.rnp = rnp;
		}

		public void run() {
			synchronized (rnp) {
				log4j.debug(this.getClass().getName() + " running...");
				rnp.printRandomNumbers(5);
				log4j.debug(this.getClass().getName() + " exited...");
			}
		}
	}

	private static class Task2 implements Runnable {
		private RandomNumberPrinter rnp = null;

		public Task2(RandomNumberPrinter rnp) {
			this.rnp = rnp;
		}

		public void run() {
			synchronized (rnp) {
				log4j.debug(this.getClass().getName() + " running...");
				rnp.printRandomNumbers(5);
				log4j.debug(this.getClass().getName() + " running...");
			}
		}
	}

}
