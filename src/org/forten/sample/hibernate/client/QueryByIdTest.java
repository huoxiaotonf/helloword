package org.forten.sample.hibernate.client;

import org.forten.sample.hibernate.dao.HibernateDao;
import org.forten.sample.hibernate.entity.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class QueryByIdTest {

	public static void main(String[] args) {
		Session session = HibernateDao.getSession();
		Transaction tx = session.beginTransaction();
		// user对象是持久化状态
		User user = (User) session.get(User.class, 19);
		// User user = (User) session.load(User.class, 19);
		System.out.println(user);
		user.setName("Tom");
		tx.commit();
		HibernateDao.close(session);
	}

}
