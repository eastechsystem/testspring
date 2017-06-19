package com.ts.packagemanager.util;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map.Entry;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonValue;
import javax.json.JsonValue.ValueType;
import javax.json.stream.JsonParsingException;

import com.ts.packagemanager.common.logging.Level;
import com.ts.packagemanager.common.logging.Logger;

/**
 * The JsonUtil class provides JSON utility operations.
 * 
 * @author Jahanzaib Ali
 * @since June 19, 2017
 */
public class JsonUtil {

	private static final String STATUS_CODE_SUCCESS = "100";
	public static final String STATUS_CODE_FAILURE = "200";
	public static final String STATUS_CODE_BUSINESS_VALIDATION_ERROR = "201";
	public static final String STATUS_CODE_EXCEPTION = "202";
	public static final String STATUS_CODE_REQUEST_VALIDATION_ERROR = "203";

	private static Logger logger;

	static {
		logger = Infrastructure.getLogger(JsonUtil.class.getName().toString());
	}

	/**
	 * Default private constructor.
	 */
	private JsonUtil() {

	}

	/**
	 * The getFieldValue() method is used to get string value from json object
	 * 
	 * @param json
	 *            Specifies the JsonObject instance
	 * @param fieldName
	 *            Specifies the field name
	 * @return Return field value of given field name
	 */
	public static String getFieldValue(JsonObject json, String fieldName) {

		String result = null;

		try {
			result = json.getString(fieldName);

			if (Util.isNotNullAndEmpty(result)) {
				result = result.trim();
			}

		} catch (Exception e) {
			logger.log("Invalid Field Value for " + fieldName);
		}

		return result;
	}

	/**
	 * The getFieldValue() method is used to get integer value from json object
	 * 
	 * @param json
	 *            Specifies the JsonObject instance
	 * @param fieldName
	 *            Specifies the field name
	 * @return Return field value of given field name
	 */
	public static Integer getIntegerFieldValue(JsonObject json, String fieldName) {

		Integer result = null;

		try {
			result = json.getInt(fieldName);

		} catch (Exception e) {
			logger.log("Invalid Field Value for " + fieldName);
		}

		return result;
	}

	/**
	 * The getFieldValue() method is used to get double value from json object
	 * 
	 * @param json
	 *            Specifies the JsonObject instance
	 * @param fieldName
	 *            Specifies the field name
	 * @return Return field value of given field name
	 */
	public static Double getDoubleFieldValue(JsonObject json, String fieldName) {

		Double result = null;

		try {
			result = json.getJsonNumber(fieldName).doubleValue();

		} catch (Exception e) {
			logger.log("Invalid Field Value for " + fieldName);
		}

		return result;
	}

	public static Long getLongFieldValue(JsonObject json, String fieldName) {

		Long result = null;

		try {
			result = json.getJsonNumber(fieldName).longValue();

		} catch (Exception e) {
			logger.log("Invalid Field Value for " + fieldName);
		}

		return result;
	}

	/**
	 * The getBooleanFieldValue() method is used to get boolean value from json
	 * object
	 * 
	 * @param json
	 *            Specifies the JsonObject instance
	 * @param fieldName
	 *            Specifies the field name
	 * @return Return field value of given field name
	 */
	public static Boolean getBooleanFieldValue(JsonObject json, String fieldName) {

		Boolean result = null;

		try {
			result = json.getBoolean(fieldName);

		} catch (Exception e) {
			logger.log("Invalid Field Value for " + fieldName);

		}
		return result;
	}

	/**
	 * The getFieldValue() method is used to get date value from json object
	 * 
	 * @param json
	 *            Specifies the JsonObject instance
	 * @param fieldName
	 *            Specifies the field name
	 * @return Return field value of given field name
	 */
	public static Date getDateFieldValue(JsonObject json, String fieldName) {

		String dateStr = getFieldValue(json, fieldName);
		Date date = null;

		try {
			date = Util.getParsedDate(dateStr);
		} catch (Exception ex) {
			logger.log("Warning: Invalid Date passed to getDateFieldValue function, returning default date...");
		}

		return date;
	}

	public static Date getDateFieldValueFromLong(JsonObject json, String fieldName) {

		Long millis = getLongFieldValue(json, fieldName);
		Date date = null;

		try {
			date = new Date(millis);
		} catch (Exception ex) {
			logger.log("Warning: Invalid Date passed to getDateFieldValue function, returning default date...");
		}

		return date;
	}

	/**
	 * The getCalendarDateFieldValue() method is used to get calendar date value
	 * from json object
	 * 
	 * @param json
	 *            Specifies the JsonObject instance
	 * @param fieldName
	 *            Specifies the field name
	 * @return Return field value of given field name
	 */
	public static Calendar getCalendarDateFieldValue(JsonObject json, String fieldName) {

		Calendar calendar = null;

		try {
			Date date = getDateFieldValue(json, fieldName);

			if (date != null) {
				calendar = Calendar.getInstance();
				calendar.setTime(date);
			}

		} catch (Exception ex) {
			logger.log("Warning: Invalid Date passed to getCalendarDateFieldValue function, returning default date...");
		}

		return calendar;
	}

	/**
	 * The getJsonValueFromJsonString() method is used to get json value of
	 * given key from given json detail string
	 * 
	 * @param json
	 *            Specifies the json detail string
	 * @param key
	 *            Specifies the key name of json
	 * @return Return value of given json key
	 */
	public static String getJsonValueFromJsonString(String json, String key) {

		logger.log(Level.INFO, "getJsonValueFromJsonString() method starts");
		logger.log(Level.INFO, "key: " + key);

		JsonObject jsonObject = Json.createReader(new StringReader(json)).readObject();
		String detailString = null;

		if (jsonObject.containsKey(key) && !jsonObject.isNull(key)) {

			JsonObject detail = jsonObject.getJsonObject(key);

			if (detail != null) {
				detailString = detail.toString();
			}
		}

		logger.log(Level.INFO, "getJsonValueFromJsonString() method ends");

		return detailString;
	}

	/**
	 * The getJsonArrayFromJsonString() method is used to get json array from
	 * given json detail string
	 * 
	 * @param json
	 *            Specifies the json detail string
	 * @param key
	 *            Specifies the key name of json
	 * @return Return array of given json key
	 */
	public static String[] getJsonArrayFromJsonString(String json, String key) {

		logger.log(Level.INFO, "getJsonArrayFromJsonString() method starts");
		logger.log(Level.INFO, "key: " + key);

		JsonObject jsonObject = Json.createReader(new StringReader(json)).readObject();

		String[] jsonStringArray = null;

		if (jsonObject.containsKey(key) && !jsonObject.isNull(key)) {

			JsonArray jsonArray = jsonObject.getJsonArray(key);

			if (jsonArray != null) {
				jsonStringArray = new String[jsonArray.size()];

				for (int i = 0; i < jsonArray.size(); i++) {

					jsonStringArray[i] = jsonArray.getJsonObject(i).toString();
					// logger.log(Level.INFO, "Json for " + key + " [" + i +
					// "]: " + jsonStringArray[i]);
				}
			}
		}

		logger.log(Level.INFO, "getJsonArrayFromJsonString() method ends");

		return jsonStringArray;
	}

	/**
	 * The getStringFieldValueFromJson() method is used to get string value from
	 * json string
	 * 
	 * @param json
	 *            Specifies the json string
	 * @param fieldName
	 *            Specifies the field name
	 * @return Return field value of given field name
	 */
	public static String getStringFieldValueFromJson(String json, String fieldName) {

		JsonObject jsonObject = Json.createReader(new StringReader(json)).readObject();
		String result = getFieldValue(jsonObject, fieldName);

		return result;
	}

	/**
	 * The getBooleanFieldValueFromJson() method is used to get boolean value
	 * from json string
	 * 
	 * @param json
	 *            Specifies the json string
	 * @param fieldName
	 *            Specifies the field name
	 * @return Return boolean field value of given field name
	 */
	public static Boolean getBooleanFieldValueFromJson(String json, String fieldName) {

		JsonObject jsonObject = Json.createReader(new StringReader(json)).readObject();
		Boolean result = getBooleanFieldValue(jsonObject, fieldName);

		return result;
	}

	/**
	 * The getIntegerFieldValueFromString() method is used to get integer value
	 * from json object
	 * 
	 * @param json
	 *            Specifies the JsonObject instance
	 * @param fieldName
	 *            Specifies the field name
	 * @return Return field value of given field name
	 */
	// TODO: We need to merge getIntegerFieldValueFromString and
	// getIntegerFieldValue
	public static Integer getIntegerFieldValueFromString(JsonObject json, String fieldName) {

		Integer result = null;

		try {
			JsonValue jsonValue = json.get(fieldName);
			if (jsonValue != null) {

				ValueType valueType = jsonValue.getValueType();

				if (valueType == ValueType.STRING) {
					result = Integer.parseInt(json.getString(fieldName));
				} else if (valueType == ValueType.NUMBER) {
					result = json.getInt(fieldName);
				}
			}
		} catch (Exception e) {
			logger.log("Invalid Field Value for " + fieldName);
		}

		return result;
	}

	public static Double getDoubleFieldValueFromString(JsonObject json, String fieldName) {

		Double result = null;

		try {
			JsonValue jsonValue = json.get(fieldName);
			if (jsonValue != null) {

				ValueType valueType = jsonValue.getValueType();

				if (valueType == ValueType.STRING) {
					result = Double.parseDouble(json.getString(fieldName));
				} else if (valueType == ValueType.NUMBER) {
					result = json.getJsonNumber(fieldName).doubleValue();
				}
			}
		} catch (Exception e) {
			logger.log("Invalid Field Value for " + fieldName);
		}

		return result;
	}

	public static Boolean isJSONValid(String json) {
		try {
			Json.createReader(new StringReader(json)).readObject();
			return true;
		} catch (JsonParsingException e) {
			return false;
		}
	}

	public static JsonObjectBuilder getJsonObjectBuilderFromJsonObject(JsonObject jsonObject) {
		JsonObjectBuilder builder = Json.createObjectBuilder();

		for (Entry<String, JsonValue> entry : jsonObject.entrySet()) {
			builder.add(entry.getKey(), entry.getValue());
		}
		return builder;
	}

	public static List<String> fromStringArray(String json) {

		JsonArray inputArray = Json.createReader(new StringReader(json)).readArray();
		List<String> result = new ArrayList<String>();

		for (int i = 0; i < inputArray.size(); i++) {
			result.add(inputArray.getString(i));
		}
		return result;
	}
}
