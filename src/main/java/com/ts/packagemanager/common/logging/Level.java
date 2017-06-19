package com.ts.packagemanager.common.logging;

/**
 * The Level interface provides log levels.
 * 
 * @author Jahanzaib Ali
 *  @since May 16, 2016
 */
public class Level extends java.util.logging.Level {

	private static final long serialVersionUID = 1L;

	public static final Level OFF = new Level("OFF", Integer.MAX_VALUE);
	public static final Level SEVERE = new Level("SEVERE", 1000);
	public static final Level WARNING = new Level("WARNING", 900);
	public static final Level INFO = new Level("INFO", 800);
	public static final Level CONFIG = new Level("CONFIG", 700);
	public static final Level FINE = new Level("FINE", 500);
	public static final Level FINER = new Level("FINER", 400);
	public static final Level FINEST = new Level("FINEST", 300);
	public static final Level ALL = new Level("ALL", Integer.MIN_VALUE);

	/**
	 * This constructor creates a log level object with given name and value.
	 * 
	 * @param name
	 *            Specifies log level name.
	 * @param value
	 *            Specifies log level value.
	 */
	protected Level(String name, int value) {
		super(name, value);
	}
}
