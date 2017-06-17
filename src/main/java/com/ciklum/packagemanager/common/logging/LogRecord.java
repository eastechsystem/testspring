package com.ciklum.packagemanager.common.logging;

import java.util.ArrayList;
import java.util.List;

/**
 * The LogRecord class is used to hold log information.
 * 
 * @author Jahanzaib Ali
 * @since June 16, 2017
 */
public class LogRecord extends java.util.logging.LogRecord {

	private static final long serialVersionUID = 1L;
	private List<LogRecordProperty> logRecordProperties = null;

	/**
	 * @param level
	 *            an instance of type com.sanmar.infrastructure.logging.Level.
	 * @param message
	 *            the message to be logged.
	 */
	public LogRecord(Level level, String message) {
		super(level, message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * The getLogRecordProperties() method returns a list of log properties.
	 * 
	 * @return a list of log properties.
	 */
	public List<LogRecordProperty> getLogRecordProperties() {
		return logRecordProperties;
	}

	/**
	 * The setLogRecordProperties() method sets a list of log properties.
	 * 
	 * @param logRecordProperties
	 *            a list of type LogRecordProperty.
	 */
	public void setLogRecordProperties(List<LogRecordProperty> logRecordProperties) {
		this.logRecordProperties = logRecordProperties;
	}

	/**
	 * The addLogProperty() method adds a log property to the log record.
	 * 
	 * @param logRecordProperty
	 *            an instance of type LogRecordProperty.
	 */
	public void addLogProperty(LogRecordProperty logRecordProperty) {
		if (this.logRecordProperties == null) {
			this.logRecordProperties = new ArrayList<LogRecordProperty>();
		}
		this.logRecordProperties.add(logRecordProperty);
	}

	/**
	 * The addLogProperty() method adds a log property for the given name and
	 * value.
	 * 
	 * @param propertyName
	 *            specifies the name of the log property.
	 * @param propertyValue
	 *            specifies the value for the log property.
	 */
	public void addLogProperty(String propertyName, String propertyValue) {
		LogRecordProperty logRecordProperty = new LogRecordProperty(propertyName, propertyValue, this);
		this.addLogProperty(logRecordProperty);
	}
}
