/*
 * copyright THCIC 1976-2014 
 */
package org.forten.sample.hibernate.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * 
 * 
 * @author <a href="mailto:du_yi@bbn.cn">Duyi</a>
 * @version 2014年5月22日
 */
public class HibernateDao {
	private static final SessionFactory FACTORY = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {
		Configuration cfg = new Configuration().configure();
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder()
				.applySettings(cfg.getProperties()).buildServiceRegistry();
		SessionFactory factory = cfg.buildSessionFactory(serviceRegistry);
		return factory;
	}

	public static SessionFactory getSessionFactory() {
		return FACTORY;
	}
	
	public static Session getSession(){
		return FACTORY.openSession();
	}

	public static void close(Session session) {
		if (session != null)
			session.close();
	}
}
