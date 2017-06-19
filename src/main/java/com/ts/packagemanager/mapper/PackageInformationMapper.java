package com.ts.packagemanager.mapper;

import java.io.StringReader;
import java.text.ParseException;
import java.time.format.DateTimeParseException;
import java.util.Date;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;

import com.ts.packagemanager.common.logging.Level;
import com.ts.packagemanager.common.logging.Logger;
import com.ts.packagemanager.exception.ApplicationException;
import com.ts.packagemanager.model.PackageInformation;
import com.ts.packagemanager.util.Infrastructure;
import com.ts.packagemanager.util.JsonUtil;
import com.ts.packagemanager.util.Util;

/**
 * This mapper handles mapping from json to PackageInformationMapper object and voice versa
 * 
 * @author Jahanzaib Ali
 * @since June 19, 2017
 *
 */
public class PackageInformationMapper {

	private static Logger logger = null;

	static {
		try {
			logger = Infrastructure.getLogger(PackageInformationMapper.class.getName());
		} catch (Exception e) {
			throw new ApplicationException(e, logger);
		}
	}

	private PackageInformationMapper() {
	}

	/**
	 * @param json
	 * @param packageInformation1 TODO
	 * @return PackageInformation
	 */
	public static PackageInformation fromJson(String json, PackageInformation packageInformation) {

		logger.log(Level.INFO, "PackageInformation.fromJson() starts! - input json: " + json);
		
		if (Util.isNotNullAndEmpty(json)) {
			JsonObject jsonObject = Json.createReader(new StringReader(json)).readObject();
			
			String name = JsonUtil.getFieldValue(jsonObject, "name");
			packageInformation.setName(name);

			Integer price = JsonUtil.getIntegerFieldValue(jsonObject, "price");
			packageInformation.setPrice(price);

			Boolean isActive = JsonUtil.getBooleanFieldValue(jsonObject, "active");
			packageInformation.setActive(isActive);

			String description = JsonUtil.getFieldValue(jsonObject, "description");
			packageInformation.setDescription(description);

			Integer duration = JsonUtil.getIntegerFieldValue(jsonObject, "duration");
			packageInformation.setDuration(duration);

			Date createDateTime = JsonUtil.getDateFieldValue(jsonObject, "createDateTime");
			if (Util.isNull(createDateTime)) {
				createDateTime = new Date();
			}
			
			try{
				createDateTime = Util.parseDateMySql(Util.formatDateStoredInDB(createDateTime));
			} catch (DateTimeParseException | ParseException e) {
				logger.log(e);
			}
			
			packageInformation.setCreateDateTime(createDateTime);
			packageInformation.setModifiedDateTime(new Date());
		}
		logger.log(Level.INFO, "PackageInformation.fromJson() ends!");

		return packageInformation;
	}

	/**
	 * @param signupas
	 *            TODO
	 * @param PackageInformation
	 *            type object
	 * @return json string
	 */
	public static JsonObjectBuilder toJson(PackageInformation packageInformation) {

		logger.log(Level.INFO, "PackageInformation.toJson() starts!");

		JsonObjectBuilder accountJsonBuilder = Json.createObjectBuilder();

		if (Util.isNotNull(packageInformation.getId())) {
			accountJsonBuilder.add("id", packageInformation.getId());
		}

		if (Util.isNotNullAndEmpty(packageInformation.getName())) {
			accountJsonBuilder.add("name", packageInformation.getName());
		}

		if (Util.isNotNull(packageInformation.getPrice())) {
			accountJsonBuilder.add("price", packageInformation.getPrice());
		}

		if (Util.isNotNull(packageInformation.getActive())) {
			accountJsonBuilder.add("active", packageInformation.getActive());
		}

		if (Util.isNotNullAndEmpty(packageInformation.getDescription())) {
			accountJsonBuilder.add("description", packageInformation.getDescription());
		}

		if (Util.isNotNull(packageInformation.getDuration())) {
			accountJsonBuilder.add("duration", packageInformation.getDuration());
		}

		if (packageInformation.getCreateDateTime() != null) {
			Date createDateTime = packageInformation.getCreateDateTime();
			accountJsonBuilder.add("createDateTime", Util.formatDateStoredInDB(createDateTime));
		}

		if (packageInformation.getCreateDateTime() != null) {
			Date modifiedDateTime = packageInformation.getModifiedDateTime();
			accountJsonBuilder.add("modifiedDateTime", Util.formatDateStoredInDB(modifiedDateTime));
		}

		logger.log(Level.INFO, "PackageInformation.toJson() ends!");

		return accountJsonBuilder;
	}
}