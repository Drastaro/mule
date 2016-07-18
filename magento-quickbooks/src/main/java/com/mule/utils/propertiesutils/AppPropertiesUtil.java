package com.mule.utils.propertiesutils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

public class AppPropertiesUtil {

	public static final Logger LOG = Logger.getLogger(AppPropertiesUtil.class);

	public static Properties propConfig = null;
	public static String PROP_FILE = "xero-app.properties";

	public static String DB_URL;
	public static String DB_USERNAME;
	public static String DB_PASS;

	public static String JDBC_DRIVER_NAME;

	static {
		try {

			Properties propConfig = new Properties();
			InputStream input = null;

			input = Thread.currentThread().getContextClassLoader()
					.getResourceAsStream(PROP_FILE);

			// load properties file
			propConfig.load(input);

			DB_URL = propConfig.getProperty("db_url");
			DB_USERNAME = propConfig.getProperty("db_username");
			DB_PASS = propConfig.getProperty("db_pass");
			JDBC_DRIVER_NAME = propConfig.getProperty("jdbc_driver_name");

		} catch (IOException e) {
			e.printStackTrace();
			LOG.error("DATABASE Properties File can not be loaded!!! "
					+ e.getLocalizedMessage());
		}

	}

}
