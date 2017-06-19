package com.ts.packagemanager.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The AbstractHibernateDao class handles core database operations.
 * 
 * @author Jahanzaib Ali
 * @since June 19, 2017
 */
public final class Util {

	public static String generalDatePatternStoredInDB = "yyyy-MM-dd HH:mm:ss";

	/**
	 * Default private constructor.
	 */
	private Util() {
	}

	/**
	 * This method returns true if the given string is either null or empty.
	 * Otherwise it returns false.
	 * 
	 * @param string
	 *            Specifies the element that is to be checked for null or empty
	 *            state
	 * @return Returns true if the given string is either null or empty.
	 *         Otherwise it returns false.
	 */
	public static boolean isNullOrEmpty(String string) {
		return (((string == null) || (string.trim().length() == 0)) ? true : false);
	}

	public static boolean isNull(Object object) {
		return object == null;
	}

	/**
	 * This method returns true if the given string array is not null and not
	 * empty. Otherwise it returns false.
	 * 
	 * @param str
	 *            Specifies the string array that is to be checked for null and
	 *            empty state
	 * @return Returns true if the given string array is not null and not empty.
	 *         Otherwise it returns false.
	 */
	public static boolean isNotNullAndEmpty(String[] str) {
		return (((str != null) && (str.length > 0)) ? true : false);
	}

	/**
	 * The isNotNullAndEmpty() method returns true if the given string is not
	 * null and not empty. Otherwise it returns false.
	 * 
	 * @param string
	 *            Specifies the element that is to be checked for null and empty
	 *            state
	 * @return Returns true if the given string is not null and not empty.
	 *         Otherwise it returns false.
	 */
	public static boolean isNotNullAndEmpty(String string) {
		return (((string != null) && (string.trim().length() > 0)) ? true : false);
	}

	/**
	 * The isNotNull() method returns true if the given object is not null.
	 * Otherwise it returns false.
	 * 
	 * @param object
	 *            Specifies the element that is to be checked for null and empty
	 *            state
	 * @return Returns true if the given string is not null and not empty.
	 *         Otherwise it returns false.
	 */
	public static boolean isNotNull(Object object) {
		return object != null;
	}

	/**
	 * The isNullOrEmpty() method returns true if the given collection is either
	 * null or empty. Otherwise it returns false.
	 * 
	 * @param list
	 *            Specifies the collection that is to be checked for null or
	 *            empty state
	 * @return Returns true if the given list is either null or empty. Otherwise
	 *         it returns false.
	 */
	public static boolean isNullOrEmpty(List<?> list) {
		return (((list == null) || (list.size() == 0)) ? true : false);
	}

	/**
	 * The isNullOrEmpty() method returns true if the given map is either null
	 * or empty. Otherwise it returns false.
	 * 
	 * @param map
	 *            Specifies the map that is to be checked for null or empty
	 *            state
	 * @return Returns true if the given map is either null or empty. Otherwise
	 *         it returns false.
	 */
	public static boolean isNullOrEmpty(Map<?, ?> map) {
		return (((map == null) || (map.size() == 0)) ? true : false);
	}

	/**
	 * The isNotNullAndEmpty() method returns true if the given collection is
	 * not null and not empty. Otherwise it returns false.
	 * 
	 * @param list
	 *            Specifies the collection that is to be checked for null and
	 *            empty state
	 * @return Returns true if the given collection is not null and not empty.
	 *         Otherwise it returns false.
	 */
	public static boolean isNotNullAndEmpty(List<?> list) {
		return (((list != null) && (list.size() > 0)) ? true : false);
	}

	/**
	 * The isNotNullAndEmpty() method returns true if the given set is not null
	 * and not empty. Otherwise it returns false.
	 * 
	 * @param set
	 *            Specifies the set that is to be checked for null and empty
	 *            state
	 * @return Returns true if the given set is not null and not empty.
	 *         Otherwise it returns false.
	 */
	public static boolean isNotNullAndEmpty(Set<?> set) {
		return (((set != null) && (set.size() > 0)) ? true : false);
	}

	/**
	 * The isNotNullAndEmpty() method returns true if the given map is not null
	 * and not empty. Otherwise it returns false.
	 * 
	 * @param map
	 *            Specifies the map that is to be checked for null and empty
	 *            state
	 * @return Returns true if the given map is not null and not empty.
	 *         Otherwise it returns false.
	 */
	public static boolean isNotNullAndEmpty(Map<?, ?> map) {
		return (((map != null) && (map.size() > 0)) ? true : false);
	}

	/**
	 * The isNumber() method returns true if the given string is a number.
	 * Otherwise it returns false.
	 * 
	 * @param string
	 *            Specifies the element that is to be checked for number type
	 * @return Returns true if the given string is a number. Otherwise it
	 *         returns false.
	 */
	public static boolean isNumber(String string) {
		boolean flag = false;
		if (isNotNullAndEmpty(string)) {
			try {
				Double.parseDouble(string);
				flag = true;
			} catch (NumberFormatException nfe) {
			}
		}
		return flag;
	}

	/**
	 * convertIntegerToStringList converts list of Integers to List of String
	 * 
	 * @param list
	 *            of integers
	 * @return list of strings
	 */
	public static List<String> convertIntegerToStringList(List<Integer> list) {
		List<String> strings = new ArrayList<String>();
		if (Util.isNotNullAndEmpty(list)) {
			for (Integer item : list) {
				strings.add(item.toString());
			}
		}
		return strings;
	}

	/**
	 * listToQuotedCommaSeparatedString
	 * 
	 * @param list
	 * @return
	 */
	public static String listToQuotedCommaSeparatedString(List<String> list) {
		StringBuffer result = new StringBuffer("");
		int count = 0;
		for (String type : list) {
			if (count > 0) {
				result.append(", ");
			}
			result.append("'" + type + "'");
			count++;
		}
		return result.toString();
	}

	/**
	 * This method returns true if the given number is either null or 0.
	 * Otherwise it returns false.
	 * 
	 * @param number
	 *            Specifies the element that is to be checked for null or 0
	 *            state
	 * @return Returns true if the given string is either null or 0. Otherwise
	 *         it returns false.
	 */
	public static boolean isNullOrZero(Integer number) {
		return (((number == null) || (number == 0)) ? true : false);
	}

	public static Date getParsedDate(String dateTimeString) throws ParseException {
		DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		sdf.setLenient(Boolean.FALSE);
		Date date = null;
		date = sdf.parse(dateTimeString);
		return date;
	}

	/**
	 * This method formats date with yyyy-MM-dd HH:mm:ss.
	 * 
	 * @param date
	 *            Specifies date to be formatted.
	 * @return Formatted date.
	 */
	public static String formatDateStoredInDB(Date date) {
		SimpleDateFormat customFormat = new SimpleDateFormat(generalDatePatternStoredInDB);
		customFormat.setLenient(false);
		return customFormat.format(date);
	}
	
	public static Date parseDateMySql(String dateString) throws ParseException {
		SimpleDateFormat mySqlDateTime = new SimpleDateFormat(generalDatePatternStoredInDB);
		return mySqlDateTime.parse(dateString);
	}
}
