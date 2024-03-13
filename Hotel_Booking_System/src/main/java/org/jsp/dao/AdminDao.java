package org.jsp.dao;
import org.jsp.entity.Admin;
import org.jsp.entity.Hotel;
public interface AdminDao {
	/**
	 * To verify Admin Email & password
	 */
	Admin login(String email, String password);
	
	void addHotel(Hotel hotel);
}
