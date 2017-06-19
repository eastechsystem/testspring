package com.ts.packagemanager.common.logging;

import java.io.InputStream;
import java.util.logging.LogManager;

import com.ts.packagemanager.exception.DaoException;


public class LoggingUtil {

	private static String fileName = "logging.properties";

	public static boolean configure() throws Exception {
		return configure(fileName);
	}

	public static boolean configure(String fileName) throws Exception {
		
		boolean configured = false;
		InputStream inputStream = null;
		
		try {
			inputStream = LoggingUtil.class.getClassLoader().getResourceAsStream(fileName);

			if (inputStream == null) {
				throw new DaoException("LoggingUtil: Unable to configure logger");
			}
			
			LogManager.getLogManager().readConfiguration(inputStream);
			configured = true;
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			
			if (inputStream != null) {
				inputStream.close();
			}
		}

		return configured;
	}
}
