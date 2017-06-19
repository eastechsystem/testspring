package com.ts.packagemanager.ws;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ts.packagemanager.exception.ApplicationException;
import com.ts.packagemanager.model.Country;

@RestController
public class CountryController {
	
	/**
	 * sayHello() is a test method to test whether Web service is accessible or
	 * not
	 * 
	 * @return response string
	 */
	@RequestMapping("/hello")
	public String sayHello() {
		String result = "Hello World! This is PackageManager RestWeb Service v1.0 (" + (new Date()).toString() + ").";
		return result;
	}
	
	/**
	 * @return
	 */
	@RequestMapping(value = "/countries", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Country> getCountries() {
		List<Country> listOfCountries = getCountryList();
		return listOfCountries;
	}

	/**
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/country/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public Country getCountryById(@PathVariable int id) {
		List<Country> listOfCountries = getCountryList();

		for (Country country : listOfCountries) {
			if (country.getId() == id)
				return country;
		}

		return null;
	}
	
	private  List<Country> getCreatedCountryList() {
		Country indiaCountry = new Country(1, "India");
		Country chinaCountry = new Country(4, "China");
		Country nepalCountry = new Country(3, "Nepal");
		Country bhutanCountry = new Country(2, "Bhutan");

		List<Country> listOfCountries = new ArrayList<Country>(0);
		listOfCountries.add(indiaCountry);
		listOfCountries.add(chinaCountry);
		listOfCountries.add(nepalCountry);
		listOfCountries.add(bhutanCountry);

		return listOfCountries;
	}
	
	public List<Country> getCountryList() {
		try {
			return getCreatedCountryList();
		} catch (Exception e) {
			throw new ApplicationException(e);
		}
	}
}
