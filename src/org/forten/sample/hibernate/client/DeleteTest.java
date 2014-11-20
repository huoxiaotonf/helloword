package org.forten.sample.hibernate.client;

import org.forten.sample.hibernate.dao.HibernateDao;
import org.forten.sample.hibernate.entity.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class DeleteTest {
	public static void main(String[] args) {
		Session session = HibernateDao.getSession();
		
		Transaction tx = session.beginTransaction();
		// user是持久化状态
		User user = (User) session.load(User.class, 19);
		// user直到被从数据库真正删除之前，都是移除状态
		session.delete(user);
		tx.commit();
		
		HibernateDao.close(session);
	}
}
