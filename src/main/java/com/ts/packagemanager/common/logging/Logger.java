package com.ts.packagemanager.common.logging;

/**
 * The Logger interface provides the logger services.
 * 
 * @author Jahanzaib Ali
 * @since June 16, 2017
 */
public interface Logger {

	/**
	 * The log() method logs the given message.
	 * 
	 * @param message
	 *            The message to be logged.
	 */
	public void log(String message);

	/**
	 * The log() method logs the given message with given level.
	 * 
	 * @param level
	 *            The level of the log.
	 * @param message
	 *            The message to be logged.
	 */
	public void log(Level level, String message);

	/**
	 * The log() method logs the given message and exception with given level.
	 * 
	 * @param level
	 *            The level of the log.
	 * @param message
	 *            The message to be logged.
	 * @param exception
	 *            The exception to be logged.
	 */
	public void log(Level level, String message, Exception exception);

	/**
	 * The log() method logs the given exception..
	 * 
	 * @param exception
	 *            The exception to be logged.
	 */
	public void log(Exception exception);

	/**
	 * The log() method logs the given exception at specified severity level.
	 * 
	 * @param level
	 *            Specifies the logger level.
	 * @param exception
	 *            Specifies the exception that needs to logged.
	 */
	public void log(Level level, Exception exception);

	/**
	 * The log() method logs the log record object.
	 * 
	 * @param logRecord
	 *            Specifies the log record object.
	 */
	public void log(LogRecord logRecord);
}
