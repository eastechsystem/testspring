package com.ts.packagemanager.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Jahanzaib Ali
 * @since June 19, 2017
 *
 */
public abstract class AbstractHibernateDao {
	protected static final String SUCCESS = "Success";
	protected static final String FAILURE = "Failure";

	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * @return current session
	 */
	protected Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	/**
	 * @return return opened session
	 */
	protected Session getOpendSession() {
		return sessionFactory.openSession();
	}

	/**
	 * This method closes the given Hibernate session.
	 * 
	 * @param session
	 *            Specifies Hibernate session to be closed.
	 */
	protected static void closeSession(Session session) {
		if (session.isOpen()) {
			session.close();
		}
	}
}
