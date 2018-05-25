package mod7.itc;

import org.apache.log4j.Logger;

public class CounterDemo {

	private static final Logger log4j = Logger.getLogger(CounterDemo.class.getName());
	
	private static int LOOP_ITERATION = 10;

	public static void main(String[] args) throws InterruptedException {
		
		if (args.length != 1) {
			System.out.println("Usage: java CounterDemo 10");
			System.exit(-1);
		}
		LOOP_ITERATION = Integer.parseInt(args[0]);

		log4j.info("Entering programme ...");
		System.out.println("Ensuring t1 -> t2 : Thread t1 incrementation should happen before t2 decrementation ...");

		IncrementorDecrementor c = new IncrementorDecrementor(LOOP_ITERATION);

		Thread t1 = new Thread(new Task1(c));
		t1.start();

		synchronized (t1) {
			try {
				System.out.println("Waiting for Thread t1 incrementor to complete...");
				t1.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Thred t1 increment is completed.");

		Thread t2 = new Thread(new Task2(c));
		System.out.println("Thread t2 decrementorabout to start...");
		t2.start();

		t1.join();
		t2.join();
		log4j.info("Exiting programme ...");

	}

	private static class Task1 implements Runnable {
		private IncrementorDecrementor rnp = null;

		public Task1(IncrementorDecrementor rnp) {
			this.rnp = rnp;
		}

		public void run() {

			synchronized (this) {

				log4j.debug(this.getClass().getName() + " running...");
				rnp.increment();
				log4j.debug(this.getClass().getName() + " exited...");
				notify();

			}
		}
	}

	private static class Task2 implements Runnable {
		private IncrementorDecrementor rnp = null;

		public Task2(IncrementorDecrementor rnp) {
			this.rnp = rnp;
		}

		public void run() {
			log4j.debug(this.getClass().getName() + " running...");
			rnp.decrement();
			log4j.debug(this.getClass().getName() + " running...");
		}
	}

}
