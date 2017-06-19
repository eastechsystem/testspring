/**
 * 
 */
package com.ts.packagemanager.dao;

import com.ts.packagemanager.exception.DaoException;
import com.ts.packagemanager.model.PackageInformation;

/**
 * @author Jahanzaib Ali
 *
 */
public interface PackageInformationDao {

	public PackageInformation getPackageInformationById(Integer packageInformationId) throws DaoException;
	
}
