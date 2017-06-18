package com.ciklum.packagemanager.ws;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ciklum.packagemanager.common.logging.Logger;
import com.ciklum.packagemanager.exception.ApplicationException;
import com.ciklum.packagemanager.model.PackageInformation;
import com.ciklum.packagemanager.service.PackageInformationService;
import com.ciklum.packagemanager.util.Infrastructure;

@RestController
public class PackageInformationResource {

	private static Logger logger = null;

	static {
		try {
			logger = Infrastructure.getLogger(PackageInformationResource.class.getName());
		} catch (Exception e) {
			throw new ApplicationException(e, logger);
		}
	}

	
	 @Autowired	 
	 @Qualifier("packageInformationService")
	 private PackageInformationService packageInformationService;
	 

	/**
	 * sayHello() is a test method to test whether Web service is accessible or
	 * not
	 * 
	 * @return response string
	 */
	@RequestMapping("/")
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
	@RequestMapping(value = "/packageinfo/{identifier}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PackageInformation> getPackageInformationByIdentifier(@PathVariable("identifier") Integer identifier) {
		logger.log("PackageInfo Id==>" + identifier);

		PackageInformation packageInformation = packageInformationService.getPackageInformationById(identifier);

		if (packageInformation == null) {
			logger.log("User with id " + identifier + " not found");
			return new ResponseEntity<PackageInformation>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<PackageInformation>(packageInformation, HttpStatus.OK);
	}

}
