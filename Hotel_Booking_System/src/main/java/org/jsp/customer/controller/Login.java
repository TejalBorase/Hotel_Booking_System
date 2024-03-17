package org.jsp.customer.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.jsp.dao.CustomerDao;
import org.jsp.dao.CustomerDaoImpl;
import org.jsp.entity.Customer;

@WebServlet("/login")
public class Login extends HttpServlet{

	private CustomerDao customerDao = new CustomerDaoImpl();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		Customer customer = customerDao.login(email, password);
		if(customer != null) {
			//display Home.jsp 
//			req.setAttribute("message", "Login Successful!!!");
//			RequestDispatcher dispatcher = req.getRequestDispatcher("/user/Home.jsp");
//			dispatcher.forward(req, resp);
			HttpSession session = req.getSession();
			session.setAttribute("customerObj", customer);
			
			resp.sendRedirect("/Hotel_Booking_System/user/Home.jsp?msg=login");
		}
		else {
			//display login.jsp
			resp.sendRedirect("/Hotel_Booking_System/user/Login.jsp?msg=login");
		}
	}
}










