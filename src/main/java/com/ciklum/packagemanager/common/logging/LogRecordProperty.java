package com.ciklum.packagemanager.common.logging;

/**
 * The LogRecordProperty class holds additional information for the log record.
 * 
 * @author Jahanzaib Ali
 * @since June 16, 2017
 */
public class LogRecordProperty {

	private Long id = null;
	private String name = null;
	private String value = null;
	private LogRecord logRecord = null;

	/**
	 * This constructor creates log record property object with given name, value and log record.
	 * @param name Specifies the property name.
	 * @param value Specifies the property value.
	 * @param logRecord Specifies the property log record object.
	 */
	public LogRecordProperty(String name, String value, LogRecord logRecord) {
		super();
		this.name = name;
		this.value = value;
		this.logRecord=logRecord ;
	}

	/**
	 * This method returns log record with which this property is associated.
	 * @return Log record with which this property is associated.
	 */
	public LogRecord getLogRecord() {
		return logRecord;
	}

	/**
	 * This method sets log record for this property.
	 * @param logRecord Specifies the logger object.
	 */
	public void setLogRecord(LogRecord logRecord) {
		this.logRecord = logRecord;
	}

	/**
	 * This method returns identifier of the object.
	 * @return Identifier of the object.
	 */
	public Long getId() {
		return id;
	}

	/**
	 * This method sets identifier of the object. 
	 * @param id
	 *            Specifies identifier of the object.
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * This method returns name of the log record property.
	 * @return Name of the log record property.
	 */
	public String getName() {
		return name;
	}

	/**
	 * This method sets name of the log record property.
	 * @param name Specifies name of the log record property.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * This method returns value of the log record property.
	 * @return Value of the log record property.
	 */
	public String getValue() {
		return value;
	}

	/**
	 * This method sets value of the log record property.
	 * @param value Specifies value of the log record property.
	 */
	public void setValue(String value) {
		this.value = value;
	}
}
