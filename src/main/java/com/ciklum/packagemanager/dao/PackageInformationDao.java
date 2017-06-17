/**
 * 
 */
package com.ciklum.packagemanager.dao;

import com.ciklum.packagemanager.exception.DaoException;
import com.ciklum.packagemanager.model.PackageInformation;

/**
 * @author Jahanzaib Ali
 *
 */
public interface PackageInformationDao {

	public PackageInformation getPackageInformationById(Integer packageInformationId) throws DaoException;
	
}
