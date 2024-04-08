package org.jsp.dao;

import java.util.List;

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
		transaction = manager.getTransaction();
		transaction.begin();
		manager.persist(hotel);
		transaction.commit();
	}

	public List<Hotel> getAllHotelsDetails() {

		String jpql = "SELECT h FROM Hotel h";
		Query query = manager.createQuery(jpql);
		List<Hotel> hotels = query.getResultList();
		return hotels;
	}

	public boolean deleteHotelById(int id) {
		transaction = manager.getTransaction();
		transaction.begin();
		Hotel hotel = manager.find(Hotel.class, id);
		if (hotel != null) {
			manager.remove(hotel);
			transaction.commit();
			return true;
		}
		return false;
	}

	/**
	 * hotel ref var contains - data which has to be update in a DB. 
	 * hotelFromDb contains - old data which is already present in a DB.
	 * updatedHotel contains - entire new data which is already updated in DB 
	 * after calling merge method.
	 */
	public Hotel updateHotelDetails(Hotel hotel) {
		transaction = manager.getTransaction();
		Hotel hotelFromDb = manager.find(Hotel.class, hotel.getId());
		if (hotelFromDb != null) {
			hotelFromDb.setHotelName(hotel.getHotelName());
			hotelFromDb.setMobile(hotel.getMobile());
			hotelFromDb.setAddress(hotel.getAddress());
			hotelFromDb.setCity(hotel.getCity());
			hotelFromDb.setNoOfBookedRoom(hotel.getNoOfBookedRoom());
			hotelFromDb.setTotalNoOfRoom(hotel.getTotalNoOfRoom());
			hotelFromDb.setPrice(hotel.getPrice());
			
			transaction.begin();
			Hotel updatedHotel = manager.merge(hotelFromDb);
			transaction.commit();
			return updatedHotel;
		}
		return null;

	}

	public Hotel getHotelById(int id) {
		Hotel hotel = manager.find(Hotel.class, id);
		if(hotel != null) {
			return hotel;
		}
		return null;
	}
	
	public List<Hotel> getHotelByKeyword(String keyword) {
		//%?1%
		String jpql = "SELECT h FROM Hotel h WHERE CONCAT(h.id,' ', h.hotelName,' ',"
				+ " h.city, ' ', h.address) LIKE CONCAT('%', ?1, '%') ";
				
		
		Query query = manager.createQuery(jpql);
		query.setParameter(1, keyword);
		List<Hotel> hotels = query.getResultList();
		
		return hotels;
	}


}










