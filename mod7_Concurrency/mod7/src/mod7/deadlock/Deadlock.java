package mod7.deadlock;

import org.apache.log4j.Logger;

public class Deadlock {

	private static Object lock1 = new Object();
	private static Object lock2 = new Object();
	private static final Logger log4j = Logger.getLogger(Deadlock.class.getName());

	public static void main(String[] args) throws InterruptedException {
		log4j.info("Entering programme ...");

		Thread t1 = new Thread(new Task1());
		t1.start();

		Thread t2 = new Thread(new Task2());
		t2.start();

		t1.join();
		t2.join();
		log4j.info("Exiting programme ...");

	}

	// }

	private static class Task1 implements Runnable {
		public void run() {
			synchronized (lock1) {
				log4j.info("Task1 acquired lock1 ...");
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				log4j.info("Task1 trying to acquire lock2 ...");
				synchronized (lock2) {
					log4j.info("Task1 acquired lock2 ...");
				}

			}
		}
	}
  //--------------------------------------
	private static class Task2 implements Runnable {
		public void run() {
			synchronized (lock1) {
				log4j.info("Task2 acquired lock1 ...");
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				log4j.info("Task2 trying to acquire lock2 ...");
				synchronized (lock2) {
					log4j.info("Task2 acquired lock2 ...");
				}

			}
		}
	}

	// ------------------

}
