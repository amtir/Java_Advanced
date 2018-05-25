package module4;

import org.apache.log4j.Logger;

// Demonstrating the Log4j framework
public final class Log4jDemo {
	// Loading the Log4j framework and initializing the framework 
	// with the values from log4j.properties files.
	private static final Logger log4j = 
			Logger.getLogger(Log4jDemo.class.getName());
	
	private static int sum(int intArr[]) {
		log4j.trace("Entering sum(...)");
		int val=0;
		for (int i=0;i<intArr.length; i++) {
			val += intArr[i];
			log4j.debug("val= " + val);
		}
		log4j.trace("Returning from sum(...)");
		return val;
	}
	
	public static void main(String[] args) {
		log4j.info("Entering main(...)");
		int intArr[] = {1,2,3,4,5,6,7,8,9,10};
		int sum = Log4jDemo.sum(intArr);
		log4j.debug("Final sum = " + sum);
		log4j.info("Exiting main(...)");
	}
}