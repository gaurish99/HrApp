package com.nagarro.hrmanagementapp.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.nagarro.hrmanagementapp.model.Hr;

public class HrDao {

	private SessionFactory sessionFactory;

	public boolean validate(String username, String password) {

		sessionFactory = new Configuration().configure().addAnnotatedClass(Hr.class)
				.setProperty("hibernate.hbm2ddl.auto", "update").buildSessionFactory();

		boolean check;
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		String hql = "from Hr where email = :email and password= :password";

		@SuppressWarnings("rawtypes")
		Query query = session.createQuery(hql);
		query.setParameter("email", username);
		query.setParameter("password", password);

		@SuppressWarnings("unchecked")
		List<Hr> results = query.list();

		if (results.size() == 1) {
			check = true;
		} else
			check = false;

		session.getTransaction().commit();

		return check;

	}

}
