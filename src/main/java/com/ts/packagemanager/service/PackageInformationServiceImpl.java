package com.ts.packagemanager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ts.packagemanager.dao.PackageInformationDao;
import com.ts.packagemanager.model.PackageInformation;

/**
 * @author Jahanzaib Ali
 * @since May 21, 2017
 *
 */
@Service("packageInformationService")
public class PackageInformationServiceImpl implements PackageInformationService {
	
	@Autowired
	@Qualifier("packageInformationDao")
	private PackageInformationDao packageInformationDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<PackageInformation> getAllPackageInformation() {
		return null;
	}
	
	@Override
	@Transactional(readOnly = true)
	public PackageInformation getPackageInformationById(Integer packageInfoId) {
		return packageInformationDao.getPackageInformationById(packageInfoId);
	}

}
