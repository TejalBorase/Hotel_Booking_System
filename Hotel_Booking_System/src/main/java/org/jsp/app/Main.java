package org.jsp.app;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.jsp.entity.Admin;
import org.jsp.entity.BookingDetails;
import org.jsp.entity.Customer;
import org.jsp.entity.Hotel;

public class Main {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("hotel_booking_system");
		EntityManager manager = factory.createEntityManager();
//		EntityTransaction transaction = manager.getTransaction();
		/*
		 * Admin admin = new Admin(); admin.setFirstName("Ramesh");
		 * admin.setLastName("Patil"); admin.setEmail("ramesh22@gmail.com");
		 * admin.setMobile(9989889988l); admin.setPassword("ramesh#123");
		 */
		
//		Customer customer = new Customer();
//		customer.setFirstName("Sam");
//		customer.setLastName("Johnson");
//		customer.setGender("Male");
//		customer.setEmail("sam48@gmail.com");
//		customer.setMobile(8989898987l);
//		customer.setPassword("1234");
//		
//		Hotel hotel = new Hotel();
//		hotel.setHotelName("ITC");
//		hotel.setMobile(2345678908l);
//		hotel.setCity("Pune");
//		hotel.setAddress("Hadapsar");
//		hotel.setPrice(3000);
//		hotel.setTotalNoOfRoom(40);
//		hotel.setNoOfBookedRoom(1);
//		
//		BookingDetails details = new BookingDetails();
//		details.setCustomer(customer);
//		details.setHotel(hotel);
//		details.setNoOfDays(1);
//		details.setNoOfPersons(1);
//		details.setNoOfRooms(1);
//		details.setTotalPrice(3000);
//		details.setStatus("booked");
//		details.setStartDate(LocalDate.parse("2024-03-13"));
//		details.setEndDate(LocalDate.parse("2024-03-15"));
//		
//		transaction.begin();
//		
////		manager.persist(admin);
//		manager.persist(details);
//		
//		transaction.commit();
//		
	}
}










