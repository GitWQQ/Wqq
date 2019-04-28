package org.ssm.dufy.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PropertiesUtils {
	
	//»’÷æ
	private static  Logger LOGGER=LoggerFactory.getLogger(PropertiesUtils.class);

	static final Properties getProperties(String path){
			Properties properties=new Properties();
			InputStream is=PropertiesUtils.class.getResourceAsStream(path);
			try {
				properties.load(is);
			} catch (IOException e) {
				LOGGER.info("Properties File load Fail");
				e.printStackTrace();
			}
			return properties;
	}
}
