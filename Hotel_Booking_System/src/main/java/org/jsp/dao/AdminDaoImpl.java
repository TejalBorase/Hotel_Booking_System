package org.jsp.dao;

import javax.persistence.*;
import org.jsp.entity.Admin;
import org.jsp.entity.Hotel;

public class AdminDaoImpl implements AdminDao {

	EntityManagerFactory factory = Persistence.createEntityManagerFactory("hotel_booking_system");
	EntityManager manager = factory.createEntityManager();
	EntityTransaction transaction = null;

	public Admin login(String email, String password) {
		String jpql = "SELECT a FROM Admin a WHERE a.email = ?1 AND a.password = ?2";
		Query query = manager.createQuery(jpql);
		query.setParameter(1, email);
		query.setParameter(2, password);
		try {
			Admin admin = (Admin) query.getSingleResult();
			return admin;
		} catch (Exception e) {
			return null;
		}
	}

	public void addHotel(Hotel hotel) {
		transaction.begin();
		
		manager.persist(hotel);
		
		transaction.commit();
	}

}
