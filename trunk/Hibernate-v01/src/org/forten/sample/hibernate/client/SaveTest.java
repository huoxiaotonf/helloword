package org.forten.sample.hibernate.client;

import org.forten.sample.hibernate.dao.HibernateDao;
import org.forten.sample.hibernate.entity.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class SaveTest {
	public static void main(String[] args) {
		// u1目前是瞬时状态（自由状态）
		User u1 = new User("程昱", 23, "cy@sohu.com");

		Session session = HibernateDao.getSession();
		// 把session对象绑定到一个事务上
		Transaction tx = session.beginTransaction();
		// 以下语句执行后，u1是持久化状态
		session.save(u1);
		tx.commit();
		HibernateDao.close(session);
	}
}
