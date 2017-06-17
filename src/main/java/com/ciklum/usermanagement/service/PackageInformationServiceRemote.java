package com.ciklum.usermanagement.service;

import java.util.List;

import javax.ejb.Remote;

import com.ciklum.packagemanager.model.PackageInformation;
import com.ciklum.packagemanager.service.PackageInformationService;
import com.topcareer.usermanagement.model.User;

/**
 * @author Jahanzaib Ali
 * @since May 21, 2017
 *
 */
@Remote
public interface PackageInformationServiceRemote {

	public PackageInformation addPackageInformation(PackageInformation packageInformation);

	public PackageInformation updatePackageInformation(PackageInformation packageInformation);

	public void deletePackageInformationById(Integer packageInformationId);

	public PackageInformation getPackageInformationById(Integer packageInformationId);

	public List<PackageInformation> getAllPackageInformation();
}
