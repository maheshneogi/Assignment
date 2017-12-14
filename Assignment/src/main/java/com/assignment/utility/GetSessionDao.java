package com.assignment.utility;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public  abstract class GetSessionDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	protected SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	protected Session getSession()
	{
		return getSessionFactory().getCurrentSession();
	}
}
