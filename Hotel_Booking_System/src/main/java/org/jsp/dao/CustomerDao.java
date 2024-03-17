package org.jsp.dao;

import org.jsp.entity.Customer;
import org.jsp.entity.Hotel;

public interface CustomerDao {

	void registration(Customer customer);
	
	Customer login(String email, String password);
	
}
