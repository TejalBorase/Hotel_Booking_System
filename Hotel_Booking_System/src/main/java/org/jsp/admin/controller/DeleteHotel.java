package org.jsp.admin.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jsp.dao.AdminDao;
import org.jsp.dao.AdminDaoImpl;

@WebServlet("/DeleteHotel")
public class DeleteHotel extends HttpServlet{

	private AdminDao adminDao = new AdminDaoImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int hotelId = Integer.parseInt(req.getParameter("hotelId"));
		
		boolean status = adminDao.deleteHotelById(hotelId);
		
		if(status) {
			req.setAttribute("message", "HOTEL DELETED SUCCESSFULLY!!!");
		}
		else {
			req.setAttribute("message", "Error while deleting a hotel.");
		}
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/admin/HotelList.jsp");
		dispatcher.forward(req, resp);
	}
}











