package com.ciklum.usermanagement.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import com.ciklum.packagemanager.common.DaoManager;
import com.ciklum.packagemanager.exception.ApplicationException;
import com.ciklum.packagemanager.model.PackageInformation;

/**
 * @author Jahanzaib Ali
 * @since May 21, 2017
 *
 */
@Stateless
public class PackageInformationService implements PackageInformationServiceRemote {

	/**
	 * TODO Add method doc
	 *
	 * @return UserDao
	 */
	private PackageInformation getPackageInformationDao() {
		return (PackageInformation) DaoManager.getInstance().getDao(PackageInformation.class.getName());
	}
	
	/*@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public List<User> getAllUser() throws Exception {
		try {
			return getNotificationDao().getAllUser();
		} catch (RuntimeException aex) {
			throw new EJBException(aex);
		}
	}
	
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public User getUserById(Integer userId) throws Exception {
		try {
			return getNotificationDao().getUserById(userId);
		} catch (RuntimeException aex) {
			throw new EJBException(aex);
		}
	}*/
	
	@Override
	public PackageInformation addPackageInformation(PackageInformation packageInformation) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public PackageInformation updatePackageInformation(PackageInformation packageInformation) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void deletePackageInformationById(Integer packageInformationId) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public PackageInformation getPackageInformationById(Integer packageInformationId) {
		try {
			return null;//packageInformationDao.getPackageInformationById(packageInformationId);
		} catch (Exception e) {
			throw new ApplicationException(e);
		}
	}
	
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public List<PackageInformation> getAllPackageInformation() {
		// TODO Auto-generated method stub
		return null;
	}

}
