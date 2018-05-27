package module10;

import org.apache.log4j.Logger;

public class MyStackApp {

	private static final Logger log4j = Logger.getLogger(MyStackApp.class.getName());

	public static void main(String[] args) throws MyStackException, InterruptedException {
		final int volume = 20000;
		MyStack<Integer> stack = new MyStack<Integer>(volume);

		log4j.debug("Pusching " + volume + "elements in a stack");
		for (int i = 0; i < volume; i++) {
			stack.push(new Integer(i));
		}

		log4j.debug("Poping " + volume + "elements from a stack");
		for (int i = 0; i < volume; i++) {
			stack.pop();
		}
		log4j.debug("Waiting for 5 minutes to exit... ");
		Thread.sleep(5 * 60 * 1000);

	}

}
