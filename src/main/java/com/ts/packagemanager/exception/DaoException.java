package com.ts.packagemanager.exception;

/**
 * The DaoException class represents error during database interaction.
 * 
 * @author Jahanzaib Ali
 * @since June 19, 2017
 */
public class DaoException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * This constructor create data access exception object with given message.
	 * 
	 * @param message
	 *            Specifies message about error.
	 */
	public DaoException(String message) {
		super(message);
	}

	/**
	 * This constructor create data access exception object with given cause.
	 * 
	 * @param cause
	 *            Specifies cause of exception.
	 */
	public DaoException(Throwable cause) {
		super(cause);
	}

	/**
	 * This constructor create data access exception object with given cause and
	 * message.
	 * 
	 * @param cause
	 *            Specifies cause of exception.
	 * @param message
	 *            Specifies message about error.
	 */
	public DaoException(String message, Throwable cause) {
		super(message, cause);
	}
}
