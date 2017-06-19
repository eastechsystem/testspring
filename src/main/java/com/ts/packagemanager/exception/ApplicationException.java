package com.ts.packagemanager.exception;

import java.io.Serializable;

import com.ts.packagemanager.common.logging.Logger;
import com.ts.packagemanager.util.Util;

/**
 * 
 * ApplicationException class holds information about error occurred at any
 * layer in the application. This class should be extended by exception classes
 * specific to each layer.
 * 
 * @author Jahanzaib Ali
 * @since June 19, 2017
 * 
 */
public class ApplicationException extends RuntimeException implements Serializable {

	private static final long serialVersionUID = 1L;

	public static final String ERROR_TYPE_ALL = "All";
	public static final String ERROR_TYPE_TECHNICAL = "Technical";
	public static final String ERROR_TYPE_BUSINESS = "Business";

	private String errorType = ERROR_TYPE_TECHNICAL;
	private String errorNumber;

	/**
	 * Default constructor.
	 */
	public ApplicationException() {
		super();
	}

	/**
	 * This constructor creates an exception object with the given message.
	 * 
	 * @param message
	 *            Specifies exception message object.
	 */
	public ApplicationException(String message) {
		super(message);
	}

	/**
	 * This constructor creates an exception object with the given cause.
	 * 
	 * @param cause
	 *            Specifies cause of exception.
	 */
	public ApplicationException(Throwable cause) {
		super(cause);

	}

	/**
	 * This constructor creates an exception object with the given message and
	 * cause.
	 * 
	 * @param message
	 *            Specifies exception message object.
	 * @param cause
	 *            Specifies cause of exception.
	 */
	public ApplicationException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * This constructor creates an exception object with the given cause and
	 * logger.
	 * 
	 * @param cause
	 *            Specifies cause of exception.
	 * @param logger
	 *            Specifies logger object.
	 */
	public ApplicationException(Exception cause, Logger logger) {
		this(null, cause, logger);
	}

	/**
	 * This constructor creates an exception object with the given message,
	 * cause and logger.
	 * 
	 * @param message
	 *            Specifies exception message object.
	 * @param cause
	 *            Specifies cause of exception.
	 * @param logger
	 *            Specifies logger object.
	 */
	public ApplicationException(String message, Exception cause, Logger logger) {
		super(cause);
		if (logger != null) {
			if (Util.isNotNullAndEmpty(message)) {
				logger.log(message);
			}
			logger.log(cause);
		}
	}

	/**
	 * This method returns type of error which specifies nature of exception
	 * which specifies whether it business related exception or some technical
	 * exception.
	 * 
	 * @return Type of error.
	 */
	public String getErrorType() {
		return errorType;
	}

	/**
	 * This method sets type of error.
	 * 
	 * @param errorType
	 *            Specifies type of error.
	 */
	public void setErrorType(String errorType) {
		this.errorType = errorType;
	}
	
	/**
	 * This method returns error number
	 * 
	 * @return error number
	 */
	public String getErrorNumber() {
		return errorNumber;
	}

	/**
	 * This method sets error error.
	 * 
	 * @param errorNumber
	 *            Specifies error number.
	 */
	public void setErrorNumber(String errorNumber) {
		this.errorNumber = errorNumber;
	}
}
