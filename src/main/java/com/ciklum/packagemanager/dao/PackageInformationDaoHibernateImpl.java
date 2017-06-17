package com.ciklum.packagemanager.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.ciklum.packagemanager.exception.DaoException;
import com.ciklum.packagemanager.model.PackageInformation;

/**
 * @author Jahanzaib Ali
 *
 */
public class PackageInformationDaoHibernateImpl implements PackageInformationDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public PackageInformation getPackageInformationById(Integer packageInformationId) throws DaoException {
		Session session = null;
		try {
			session = sessionFactory.getCurrentSession();
			PackageInformation profile = (PackageInformation) session.get(PackageInformation.class, packageInformationId);
			return profile;

		} catch (Exception e) {
			throw new DaoException(e);
		}
	}
}
