package org.forten.sample.hibernate.client;

import org.forten.sample.hibernate.dao.HibernateDao;
import org.forten.sample.hibernate.entity.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UpdateTest {

	public static void main(String[] args) {
		Session session = HibernateDao.getSession();
		// user对象是持久化状态
		User user = (User) session.get(User.class, 19);
		HibernateDao.close(session);
		
		System.out.println(user);
		// 目前user对象是脱管状态
		user.setName("XXX");
		System.out.println(user);

		
		session = HibernateDao.getSession();
		Transaction tx = session.beginTransaction();
		session.update(user);
		tx.commit();
		HibernateDao.close(session);
	}

}
