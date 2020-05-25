package demo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4jDemo {

	private static Logger logger = LogManager.getLogger(Log4jDemo.class);
	
	public static void main(String[] args) {
		
		System.out.println("Hello World...! \n");
		
		logger.trace("this is traces message");
		logger.info("This is information Message");
		logger.error("This is an error menssage");
		logger.warn("this is a warn message");
		logger.fatal("this is a fatal message");
		
		System.out.println("\n completed");
	}
	
}
