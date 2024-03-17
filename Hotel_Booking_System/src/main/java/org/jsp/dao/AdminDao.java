package org.jsp.dao;
import java.util.List;

import org.jsp.entity.Admin;
import org.jsp.entity.Hotel;
public interface AdminDao {
	/**
	 * To verify Admin Email & password
	 */
	Admin login(String email, String password);
	
	void addHotel(Hotel hotel);
	
	List<Hotel> getAllHotelsDetails();
	
	boolean deleteHotelById(int id);
	
	Hotel updateHotelDetails(Hotel hotel);
	
	Hotel getHotelById(int id);
}












