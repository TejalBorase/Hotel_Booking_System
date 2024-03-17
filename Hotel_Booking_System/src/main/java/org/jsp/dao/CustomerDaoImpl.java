package org.jsp.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.entity.Customer;

public class CustomerDaoImpl implements CustomerDao{
	
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("hotel_booking_system");
	EntityManager manager = factory.createEntityManager();
	EntityTransaction transaction = null;

	public void registration(Customer customer) {
		transaction = manager.getTransaction();
		transaction.begin();
		manager.persist(customer);
		transaction.commit();
	}

	public Customer login(String email, String password) {
		String jpql = "FROM Customer c WHERE c.email = ?1 and c.password = ?2";
		
		Query query = manager.createQuery(jpql);
		query.setParameter(1, email);
		query.setParameter(2, password);
		try {
			Customer customer = (Customer)query.getSingleResult();
			return customer;
		}
		catch (Exception e) {
			return null;
		}
	}

}







