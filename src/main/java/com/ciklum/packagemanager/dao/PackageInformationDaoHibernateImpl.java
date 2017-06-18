package com.ciklum.packagemanager.dao;

import java.util.Date;

import org.springframework.stereotype.Repository;

import com.ciklum.packagemanager.exception.DaoException;
import com.ciklum.packagemanager.model.PackageInformation;

/**
 * @author Jahanzaib Ali
 *
 */

@Repository("packageInformationDao")
public class PackageInformationDaoHibernateImpl implements PackageInformationDao {

	@Override
	public PackageInformation getPackageInformationById(Integer packageInfoId) throws DaoException {
		try {
			PackageInformation profile = new PackageInformation();
			
			profile.setId(1);
			profile.setName("Profile Info 1");
			profile.setActive(true);
			profile.setDuration(5);
			profile.setPrice(100);
			profile.setCreateDateTime(new Date());
			profile.setModifiedDateTime(new Date());

			return profile;

		} catch (Exception e) {
			throw new DaoException(e);
		}
	}
}
