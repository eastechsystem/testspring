package com.ts.packagemanager.service;

import java.util.List;

import com.ts.packagemanager.exception.DaoException;
import com.ts.packagemanager.model.PackageInformation;

/**
 * @author Jahanzaib Ali
 * @since June 19, 2017
 *
 */
public interface PackageInformationService {
	
	public PackageInformation getPackageInformationById(Integer packageInformationId);

	public List<PackageInformation> getAllPackageInformation();

	public String deletePackageInformationById(Integer packageInfoId);

	public String saveOrUpdate(PackageInformation packageInformation);
}
