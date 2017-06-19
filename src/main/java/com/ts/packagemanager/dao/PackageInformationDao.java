/**
 * 
 */
package com.ts.packagemanager.dao;

import java.util.List;

import com.ts.packagemanager.exception.DaoException;
import com.ts.packagemanager.model.PackageInformation;

/**
 * @author Jahanzaib Ali
 * @since June 19, 2017
 *
 */
public interface PackageInformationDao {

	public PackageInformation getPackageInformationById(Integer packageInformationId) throws DaoException;

	public List<PackageInformation> getAllPackageInformation() throws DaoException;

	public String deletePackageInformationById(Integer packageInfoId) throws DaoException;

	public String saveOrUpdate(PackageInformation packageInformation) throws DaoException;

}
