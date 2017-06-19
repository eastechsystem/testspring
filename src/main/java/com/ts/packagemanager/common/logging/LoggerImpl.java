package com.ts.packagemanager.common.logging;

import java.util.Arrays;

/**
 * The LoggerImpl class provides the logger services.
 * 
 * @author Jahanzaib Ali
 * @since May 16, 2016
 */
public class LoggerImpl implements Logger {

	private java.util.logging.Logger logger = null;
	private static boolean configured = false;
	private static String appName = "";

	{
		appName = "packagemanager";
		configure();
	}

	/**
	 * This method configures logger.
	 */
	private static void configure() {
		if (!configured) {
			try {
				configured = LoggingUtil.configure();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * This constructor creates a logger with the given name.
	 * 
	 * @param name
	 *            Specifies logger name.
	 */
	private LoggerImpl(String name) {
		configure();
		logger = java.util.logging.Logger.getLogger(name);
	}

	/**
	 * The getLogger() method returns a logger for the given name.
	 * 
	 * @param name
	 *            specifies the logger name.
	 * @return a logger object.
	 */
	public static Logger getLogger(String name) {
		return new LoggerImpl(name);
	}

	private LogRecord getLogRecord(String message) {
		return this.getLogRecord(Level.INFO, message);
	}

	private LogRecord getLogRecord(Level level, String message) {
		LogRecord logRecord = new LogRecord(level, message);
		logRecord.setLoggerName(logger.getName());
		logRecord.setSourceClassName(logger.getName());
		return logRecord;
	}

	/**
	 * The getName() method returns the name of the logger.
	 * 
	 * @return the name of the logger.
	 */
	public String getName() {
		return this.logger.getName();
	}

	@Override
	public void log(String message) {
		this.log(getLogRecord(message));
	}

	@Override
	public void log(LogRecord logRecord) {
		if (logRecord != null) {
			logRecord.setLoggerName(logRecord.getLoggerName());
			if (appName != null && !appName.isEmpty()) {
				logRecord.setMessage("[" + appName + "] " + logRecord.getMessage());
			}
			this.logger.log(logRecord);
		}
	}

	@Override
	public void log(Exception exception) {
		if (exception != null) {
			String message = exception.getMessage();
			if (message == null) {
				message = "";
			}
			if (exception.getStackTrace() == null) {
				this.log(Level.SEVERE, message);
			} else {
				this.log(Level.SEVERE, message + "\n" + Arrays.toString(exception.getStackTrace()));
			}

		}
	}

	@Override
	public void log(Level level, Exception exception) {
		if (exception != null) {
			if (exception.getStackTrace() == null) {
				this.log(Level.SEVERE, exception.getMessage());
			} else {
				this.log(Level.SEVERE, Arrays.toString(exception.getStackTrace()));
			}
		}
	}

	@Override
	public void log(Level level, String message) {
		this.log(getLogRecord(level, message));
	}

	@Override
	public void log(Level level, String message, Exception exception) {
		if (exception != null) {
			if (message == null) {
				message = "";
			}

			if (exception.getStackTrace() == null) {
				message += "\n\r Exception: " + exception.getMessage();
			} else {
				message += "\n\r Exception: " + Arrays.toString(exception.getStackTrace());
			}

		}
		this.log(level, message);
	}

	public static void main(String[] args) {
		testLog();
	}

	private static void testLog() {
		Logger logger = LoggerImpl.getLogger(LoggerImpl.class.getName());
		for (int i = 1; i <= 3; i++) {
			logger.log(Level.INFO, "This is test for logger " + i);
		}
	}
}
