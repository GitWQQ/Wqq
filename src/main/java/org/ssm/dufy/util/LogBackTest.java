package org.ssm.dufy.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogBackTest {
	private final static Logger logger=LoggerFactory.getLogger(LogBackTest.class);
	
	public static void main(String[] args) {
		logger.info("logback成功了");
		logger.error("logback成功了");
		logger.debug("logback成功");
		logger.info(logger.ROOT_LOGGER_NAME);
	}
}
