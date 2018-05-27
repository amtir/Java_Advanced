package module10.junit.test;

import static org.junit.Assert.*;
import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({TestStackAppExceptionA.class , TestStackAppExceptionB.class})
public class TestSuiteExceptions {

	private static final Logger log4j = Logger.getLogger(TestSuiteExceptions.class.getName());

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		log4j.debug("Inside the static void setUpBeforeClass() method.");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		log4j.debug("Inside the static void tearDownAfterClass() method.");
	}
}
