package com.cpulover.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cpulover.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public List<Customer> getCustomers() {
		// Get the current Hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// Create a query, sort by first name
		Query<Customer> theQuery = currentSession.createQuery("from Customer order by firstName", Customer.class);

		// Execute query and get result list
		List<Customer> customers = theQuery.getResultList();

		return customers;
	}

	@Override
	public void saveCustomer(Customer customer) {
		// Get the current Hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// save or update (if id already exits) the customer
		currentSession.saveOrUpdate(customer);
	}

	@Override
	public Customer getCustomer(int id) {
		// Get the current Hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// retrieve customer from database by the primary key (id)
		Customer customer = currentSession.get(Customer.class, id);
		return customer;
	}

	@Override
	public void deleteCustomer(int id) {
		// Get the current Hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		//use HQL to delete customer by the primary key (id)
		Query theQuery = currentSession.createQuery("delete from Customer where id=:customerId");
		theQuery.setParameter("customerId", id);
		theQuery.executeUpdate();
		
		//we can also delete customer by getting the customer first the delete:
		//Customer theCustomer = currentSession.get(Customer.class, id);
		//currentSession.delete(theCustomer);
	}

}
