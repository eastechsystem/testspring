package com.ts.packagemanager.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ts.packagemanager.exception.DaoException;
import com.ts.packagemanager.model.PackageInformation;

/**
 * @author Jahanzaib Ali
 *
 */

@Repository("packageInformationDao")
public class PackageInformationDaoHibernateImpl implements PackageInformationDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public PackageInformation getPackageInformationById(Integer packageInfoId) throws DaoException {
		Session session = null;
		try {
			session = getSession();
			PackageInformation profile = (PackageInformation) session.get(PackageInformation.class, packageInfoId);
			return profile;

		} catch (Exception e) {
			throw new DaoException(e);
		} finally {
			if (session != null) {
				closeSession(session);
			}
		}
	}
	
	
	private Session getSession() {
		return sessionFactory.openSession();
	}

	/**
	 * This method closes the given Hibernate session.
	 * 
	 * @param session
	 *            Specifies Hibernate session to be closed.
	 */
	private static void closeSession(Session session) {
		if (session.isOpen()) {
			session.close();
		}
	}
}
