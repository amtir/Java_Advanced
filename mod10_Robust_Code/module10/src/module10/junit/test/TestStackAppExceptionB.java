package module10.junit.test;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import module10.MyStack;
import module10.MyStackException;

public class TestStackAppExceptionB {

	private static final Logger log4j = Logger.getLogger(TestStackAppExceptionB.class.getName());
	static private final int volume = 5;
	static private MyStack<Integer> stack = null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		log4j.debug("Inside the static void setUpBeforeClass() method.");
		stack = new MyStack<Integer>(volume);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		log4j.debug("Inside the static void tearDownAfterClass() method.");
		stack = null;
	}

	@Before
	public void setUp() throws Exception {
		log4j.debug("Inside the setUp() method.");
	}

	@After
	public void tearDown() throws Exception {
		log4j.debug("Inside the tearDown() method.");
	}

	@Test(expected = MyStackException.class)
	public void test1_underflow() throws MyStackException {
		int i = 0;
		log4j.debug("Inside the test1_underflow() method.");
		log4j.debug("Poping " + volume + " elements from a stack");
		for (i = 0; i < volume + 1; i++) {
			stack.pop();
		}
	}

	@Test
	public void test2_underflow() throws MyStackException {
		int i = 0;
		log4j.debug("Inside the test2_underflow() method.");
		log4j.debug("Poping " + volume + " elements from a stack");
		try {
			for (i = 0; i < volume + 1; i++) {
				stack.pop();
			}
		} catch (MyStackException e) {
			log4j.debug("Exception occured for i = " + i + " : ", e);
		}
	}

}
