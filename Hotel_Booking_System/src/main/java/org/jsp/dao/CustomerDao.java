package org.jsp.dao;

import org.jsp.entity.Customer;

public interface CustomerDao {

	void registration(Customer customer);
	
	Customer login(String email, String password);
}
