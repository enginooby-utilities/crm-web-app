package com.cpulover.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.cpulover.springdemo.entity.Customer;

public class CustomerDAOImpl implements CustomerDAO {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public List<Customer> getCustomers() {
		// Get the current Hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// Create a query
		Query<Customer> theQuery = currentSession.createQuery("from customer", Customer.class);
 
		//Execute query and get result list
		List<Customer> customers = theQuery.getResultList();
		
		return customers;
	}

}
