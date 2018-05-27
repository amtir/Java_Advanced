package module10.junit.test;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class LifeCycleTest {

	private static final Logger log4j = Logger.getLogger(LifeCycleTest.class.getName());

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		log4j.debug("Inside the static void setUpBeforeClass() method.");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		log4j.debug("Inside the static void tearDownAfterClass() method.");
	}

	@Before
	public void setUp() throws Exception {
		log4j.debug("Inside the setUp() method.");
	}

	@After
	public void tearDown() throws Exception {
		log4j.debug("Inside the tearDown() method.");
	}

	@Test
	public void test1() {
		// fail("Not yet implemented");
		log4j.debug("Inside the test1() method.");
	}

	@Test
	public void test2() {
		// fail("Not yet implemented");

		throw new NullPointerException();
		// log4j.debug("Inside the test2() method.");
	}

	@Test
	public void test3() {
		// fail("Not yet implemented");
		log4j.debug("Inside the test3() method.");
	}

}
