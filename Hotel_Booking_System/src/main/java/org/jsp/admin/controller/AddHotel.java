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
import org.jsp.entity.Hotel;

@WebServlet("/AddHotel")
public class AddHotel extends HttpServlet{
	private AdminDao adminDao = new AdminDaoImpl();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//Fetch data from jsp file
		String hotelName = req.getParameter("hotelName");
		long mobile = Long.parseLong(req.getParameter("contact"));
		double price = Double.parseDouble(req.getParameter("price"));
		String city = req.getParameter("city");
		String address = req.getParameter("address");
		int noOfRooms = Integer.parseInt(req.getParameter("rooms"));
		
		//Store above data in Hotel object
		Hotel hotel = new Hotel();
		hotel.setHotelName(hotelName);
		hotel.setMobile(mobile);
		hotel.setAddress(address);
		hotel.setCity(city);
		hotel.setTotalNoOfRoom(noOfRooms);
		hotel.setPrice(price);
		
		//call addHotel method from dao
		adminDao.addHotel(hotel);
		
		resp.sendRedirect("/Hotel_Booking_System/admin/HotelList.jsp?msg=added");
	}
}















