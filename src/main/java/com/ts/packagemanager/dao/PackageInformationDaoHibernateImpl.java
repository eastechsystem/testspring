package com.ts.packagemanager.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;

import com.ts.packagemanager.exception.DaoException;
import com.ts.packagemanager.model.PackageInformation;

/**
 * @author Jahanzaib Ali
 * @since June 19, 2017
 *
 */

@Repository("packageInformationDao")
public class PackageInformationDaoHibernateImpl extends AbstractHibernateDao implements PackageInformationDao {

	@Override
	public PackageInformation getPackageInformationById(Integer packageInfoId) {
		Session session = null;
		try {
			session = getOpendSession();
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

	@SuppressWarnings("unchecked")
	@Override
	public List<PackageInformation> getAllPackageInformation() {
		Session session = null;
		try {
			session = getOpendSession();

			Criteria criteria = session.createCriteria(PackageInformation.class);
			criteria.addOrder(Order.asc("id")).setMaxResults(25);
			List<PackageInformation> packageInformations = (List<PackageInformation>) criteria.list();

			return packageInformations;

		} catch (Exception e) {
			throw new DaoException(e);
		} finally {
			if (session != null) {
				closeSession(session);
			}
		}
	}

	@Override
	public String deletePackageInformationById(Integer packageInfoId) {
		String message = SUCCESS;
		Session session = null;
		try {
			session = getOpendSession();
			PackageInformation profile = (PackageInformation) session.get(PackageInformation.class, packageInfoId);

			if (profile == null) {
				message = FAILURE;
			} else {
				session = getCurrentSession();
				session.delete(profile);
			}

		} catch (Exception e) {
			message = FAILURE;
			throw new DaoException(e);
		}

		return message;
	}

	@Override
	public String saveOrUpdate(PackageInformation packageInformation) {
		String message = SUCCESS;
		if (packageInformation == null) {
			message = FAILURE + " - null instance cannot be saved or updated";
			return message;
		}

		Session session = null;
		try {
			if (packageInformation.getId() == null) {
				session = getOpendSession();
				session.saveOrUpdate(packageInformation);
			} else {
				session = getCurrentSession();
				session.merge(packageInformation);
				message = SUCCESS;
			}
		} catch (HibernateException ex) {
			message = FAILURE;
			throw new DaoException(ex);
		}

		return message;
	}
}
