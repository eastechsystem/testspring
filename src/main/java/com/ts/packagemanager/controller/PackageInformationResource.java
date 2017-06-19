package com.ts.packagemanager.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.ts.packagemanager.common.logging.Logger;
import com.ts.packagemanager.exception.ApplicationException;
import com.ts.packagemanager.mapper.PackageInformationMapper;
import com.ts.packagemanager.model.PackageInformation;
import com.ts.packagemanager.service.PackageInformationService;
import com.ts.packagemanager.util.Infrastructure;
import com.ts.packagemanager.util.Util;

/**
 * This class(/api/v1.0) provides the rest web services for PackageInformation
 * CRUD operations.
 * 
 * @author Jahanzaib Ali
 * @since June 19, 2017
 */

@RestController
@RequestMapping(value = "/api/v1.0")
public class PackageInformationResource {

	@Autowired
	private PackageInformationService packageInformationService;

	private static Logger logger = null;

	static {
		try {
			logger = Infrastructure.getLogger(PackageInformationResource.class.getName());
		} catch (Exception e) {
			throw new ApplicationException(e, logger);
		}
	}

	/**
	 * sayHello() is a test method to test whether Web service is accessible or
	 * not
	 * 
	 * @return response string
	 */
	@RequestMapping("/hello")
	public String sayHello() {
		logger.log("sayHello() Webservice starts!");

		String result = "Hello World! This is PackageManager RestWeb Service v1.0 (" + (new Date()).toString() + ").";

		logger.log("sayHello() Webservice ends!");
		return result;
	}

	/**
	 * getPackageInformationByIdentifier() This resource retrieve single
	 * packageInfo by identifier
	 * 
	 * @param identifier
	 * @return ResponseEntity
	 */
	@RequestMapping(value = "/packageinformations/{identifier}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PackageInformation> getPackageInformationByIdentifier(@PathVariable("identifier") Integer identifier) {
		logger.log("getPackageInformationByIdentifier() Webservice starts!");

		PackageInformation packageInformation = null;
		try {
			packageInformation = packageInformationService.getPackageInformationById(identifier);
			if (packageInformation == null) {
				logger.log("User with id " + identifier + " not found");
				return new ResponseEntity<PackageInformation>(HttpStatus.NOT_FOUND);
			}

		} catch (Exception e) {
			logger.log(e);
		}

		logger.log("getPackageInformationByIdentifier() Webservice ends!");

		return new ResponseEntity<PackageInformation>(packageInformation, HttpStatus.OK);
	}

	/**
	 * getAllPackageInformation() This resource retrieve all packageInfo by
	 * identifier
	 * 
	 * @return
	 */
	@RequestMapping(value = "/packageinformations", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<PackageInformation>> getAllPackageInformation() {
		logger.log("getAllPackageInformation() Webservice starts!");
		List<PackageInformation> packageInformations = null;

		try {
			packageInformations = packageInformationService.getAllPackageInformation();
			if (Util.isNullOrEmpty(packageInformations)) {
				return new ResponseEntity<List<PackageInformation>>(HttpStatus.NOT_FOUND);
			}

			logger.log("Total PackageInfo records found from top 25 =========> " + packageInformations.size());
		} catch (Exception e) {
			logger.log(e);
		}
		logger.log("getAllPackageInformation() Webservice ends!");

		return new ResponseEntity<List<PackageInformation>>(packageInformations, HttpStatus.OK);
	}

	/**
	 * savePackageInformation() This resource is use to save packageInfo
	 * 
	 * @param identifier
	 * @return
	 */
	@RequestMapping(value = "/packageinformations", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> savePackageInformation(@RequestBody String json, UriComponentsBuilder builder) {
		logger.log("savePackageInformation() Webservice starts!");
		HttpHeaders headers = new HttpHeaders();

		try {
			PackageInformation packageInformation = new PackageInformation();
			PackageInformationMapper.fromJson(json, packageInformation);

			String statusMessage = packageInformationService.saveOrUpdate(packageInformation);
			if (!PackageInformation.SUCCESS.equalsIgnoreCase(statusMessage)) {
				return new ResponseEntity<Void>(HttpStatus.CONFLICT);
			}

			headers = new HttpHeaders();
			headers.setLocation(builder.path("/packageinformations/{id}").buildAndExpand(packageInformation.getId()).toUri());
		} catch (Exception e) {
			logger.log(e);
		}

		logger.log("savePackageInformation() Webservice ends!");

		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	/**
	 * updatePackageInformation() This resource is use to update the existing
	 * packageInfo
	 * 
	 * @param packageInformation
	 * @return
	 */
	@RequestMapping(value = "/packageinformations/{identifier}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PackageInformation> updatePackageInformation(@RequestBody String json, @PathVariable("identifier") Integer identifier) {
		logger.log("updatePackageInformation() Webservice starts!");

		PackageInformation packageInformation = null;
		try {
			packageInformation = packageInformationService.getPackageInformationById(identifier);
			if (Util.isNull(packageInformation)) {
				return new ResponseEntity<PackageInformation>(HttpStatus.NOT_FOUND);
			}

			PackageInformationMapper.fromJson(json, packageInformation);
			String statusMessage = packageInformationService.saveOrUpdate(packageInformation);
			if (!PackageInformation.SUCCESS.equalsIgnoreCase(statusMessage)) {
				return new ResponseEntity<PackageInformation>(HttpStatus.CONFLICT);
			}
		} catch (Exception e) {
			logger.log(e);
		}

		logger.log("updatePackageInformation() Webservice ends!");

		return new ResponseEntity<PackageInformation>(packageInformation, HttpStatus.OK);
	}

	/**
	 * deletePackageInformation() This resource is use to hard delete the
	 * existing packageInfo by providing packageInfo identifier
	 * 
	 * @param identifier
	 * @return
	 */
	@RequestMapping(value = "/packageinformations/{identifier}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deletePackageInformation(@PathVariable("identifier") Integer identifier) {
		logger.log("deletePackageInformation() Webservice starts!");

		try {
			String statusMessage = packageInformationService.deletePackageInformationById(identifier);
			if (!PackageInformation.SUCCESS.equalsIgnoreCase(statusMessage)) {
				return new ResponseEntity<Void>(HttpStatus.CONFLICT);
			}
		} catch (Exception e) {
			logger.log(e);
		}

		logger.log("deletePackageInformation() Webservice ends!");

		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}
