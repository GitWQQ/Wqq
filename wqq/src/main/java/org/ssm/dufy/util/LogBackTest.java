package org.ssm.dufy.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogBackTest {
	private final static Logger logger=LoggerFactory.getLogger(LogBackTest.class);
	
	public static void main(String[] args) {
		logger.info("logback�ɹ���");
		logger.error("logback�ɹ���");
		logger.debug("logback�ɹ�");
		logger.info(logger.ROOT_LOGGER_NAME);
	}
}
