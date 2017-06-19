package com.ts.packagemanager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ts.packagemanager.common.logging.Level;
import com.ts.packagemanager.common.logging.Logger;
import com.ts.packagemanager.dao.PackageInformationDao;
import com.ts.packagemanager.exception.ApplicationException;
import com.ts.packagemanager.model.PackageInformation;
import com.ts.packagemanager.util.Infrastructure;

/**
 * @author Jahanzaib Ali
 * @since June 19, 2017
 *
 */
@Service("packageInformationService")
public class PackageInformationServiceImpl implements PackageInformationService {

	@Autowired
	@Qualifier("packageInformationDao")
	private PackageInformationDao packageInformationDao;

	private static Logger logger = null;

	static {
		try {
			logger = Infrastructure.getLogger(PackageInformationServiceImpl.class.getName());
		} catch (Exception e) {
			throw new ApplicationException(e, logger);
		}
	}

	@Override
	@Transactional(readOnly = true, propagation = Propagation.REQUIRED)
	public PackageInformation getPackageInformationById(Integer packageInfoId) {
		try {
			return packageInformationDao.getPackageInformationById(packageInfoId);
		} catch (RuntimeException e) {
			logger.log(Level.WARNING, e.getMessage(), e);
			throw new ApplicationException(e);
		}
	}

	@Override
	@Transactional(readOnly = true, propagation = Propagation.REQUIRED)
	public List<PackageInformation> getAllPackageInformation() {
		try {
			return packageInformationDao.getAllPackageInformation();
		} catch (RuntimeException e) {
			logger.log(Level.WARNING, e.getMessage(), e);
			throw new ApplicationException(e);
		}
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public String deletePackageInformationById(Integer packageInfoId) {
		try {
			return packageInformationDao.deletePackageInformationById(packageInfoId);
		} catch (RuntimeException e) {
			logger.log(Level.WARNING, e.getMessage(), e);
			throw new ApplicationException(e);
		}
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public String saveOrUpdate(PackageInformation packageInformation) {
		try {
			return packageInformationDao.saveOrUpdate(packageInformation);
		} catch (RuntimeException e) {
			logger.log(Level.WARNING, e.getMessage(), e);
			throw new ApplicationException(e);
		}
	}
}
