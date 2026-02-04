package com.orangehrm.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class LoadConfigProperties {

	private static Properties properties = new Properties();

	public static synchronized void loadProperties(String fileName) {
	        try (InputStream input =
	                LoadConfigProperties.class
	                    .getClassLoader()
	                    .getResourceAsStream(fileName + ".properties")) {

	            if (input == null) {
	                throw new RuntimeException("⚙️ Config file not found: " + fileName);
	            }
	            properties.load(input);

	        } catch (IOException e) {
	            throw new RuntimeException(e);
	        }
		}

	public static synchronized String getProperty(String key) {
		return properties == null ? null : properties.getProperty(key);
	}

	public static synchronized void unloadProperties() {
		if (properties != null) {
			properties.clear();
			properties = null;
		}
	}

}