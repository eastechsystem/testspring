package com.ts.packagemanager.service;

import java.util.List;

import com.ts.packagemanager.model.PackageInformation;

/**
 * @author Jahanzaib Ali
 * @since May 21, 2017
 *
 */
public interface PackageInformationService {
	public List<PackageInformation> getAllPackageInformation();

	public PackageInformation getPackageInformationById(Integer packageInfoId);
}
