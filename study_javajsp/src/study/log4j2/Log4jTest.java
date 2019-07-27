package study.log4j2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4jTest {
	private static final Logger logger = LogManager.getLogger(Log4jTest.class);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		logger.debug("logger message");
	}

}
