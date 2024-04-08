package org.jsp.dao;

import org.jsp.entity.BookingDetails;
import org.jsp.entity.Card;
import org.jsp.entity.Customer;

public interface CustomerDao {

	void registration(Customer customer);
	
	Customer login(String email, String password);
	
	void registerBookingDetails(BookingDetails details);
	
	boolean addCard(Card card);
	
	BookingDetails updateStatus(BookingDetails details);
	
	Card getCardById(int cardId);
}


