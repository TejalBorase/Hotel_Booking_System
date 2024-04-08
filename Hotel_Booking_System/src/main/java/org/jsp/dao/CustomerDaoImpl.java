package org.jsp.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.entity.BookingDetails;
import org.jsp.entity.Card;
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

	public void registerBookingDetails(BookingDetails details) {
		transaction = manager.getTransaction();
		transaction.begin();
		manager.persist(details);
		transaction.commit();
	}

	public boolean addCard(Card card) {
		transaction = manager.getTransaction();
		transaction.begin();
		if(card != null) {
			manager.persist(card);
			transaction.commit();
			return true;
		}
		return false;
	}

	public BookingDetails updateStatus(BookingDetails details) {
		transaction = manager.getTransaction();
		transaction.begin();
		if(details != null) {
			BookingDetails update = manager.merge(details);	
			transaction.commit();
			return update;
		}
		return null;
	}

	public Card getCardById(int cardId) {
		Card card = manager.find(Card.class, cardId);
		if(card != null) {
			return card;
		}
		return null;
	}

}







