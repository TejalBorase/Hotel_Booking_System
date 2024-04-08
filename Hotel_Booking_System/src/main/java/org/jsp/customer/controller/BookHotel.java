package org.jsp.customer.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.jsp.dao.AdminDao;
import org.jsp.dao.AdminDaoImpl;
import org.jsp.dao.CustomerDao;
import org.jsp.dao.CustomerDaoImpl;
import org.jsp.entity.BookingDetails;
import org.jsp.entity.Card;
import org.jsp.entity.Customer;
import org.jsp.entity.Hotel;

@WebServlet("/bookHotel")
public class BookHotel extends HttpServlet {

	private CustomerDao customerDao = new CustomerDaoImpl();
	private AdminDao adminDao = new AdminDaoImpl();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Fetch Customer From Session
		HttpSession session = req.getSession();
		Customer customer = (Customer) session.getAttribute("customerObj");

		// Fetch Hotel Id
		int hotelId = Integer.parseInt(req.getParameter("hotelId"));
		//Fetch hotel from Db
		Hotel hotel = adminDao.getHotelById(hotelId);
		session.setAttribute("hotelObj", hotel);

		// Fetch Booking Details From Html form
		LocalDate startDate = LocalDate.parse(req.getParameter("startDate"));
		LocalDate endDate = LocalDate.parse(req.getParameter("endDate"));
		int noOfRooms = Integer.parseInt(req.getParameter("noOfrooms"));
		int noOfPersons = Integer.parseInt(req.getParameter("noOfpersons"));
		int noOfDays = Integer.parseInt(req.getParameter("noOfdays"));
		double price = Double.parseDouble(req.getParameter("price"));

		BookingDetails bookingDetails = new BookingDetails();
		bookingDetails.setCustomer(customer);
		bookingDetails.setHotel(hotel);
		bookingDetails.setStartDate(startDate);
		bookingDetails.setEndDate(endDate);
		bookingDetails.setNoOfDays(noOfDays);
		bookingDetails.setNoOfPersons(noOfPersons);
		bookingDetails.setNoOfRooms(noOfRooms);
		bookingDetails.setTotalPrice(price);
		bookingDetails.setStatus("Pending");
		
		customerDao.registerBookingDetails(bookingDetails);
		session.setAttribute("bookingDetails", bookingDetails);
		
		List<Card> cards = customer.getCards();
		if(cards.isEmpty()) {
			resp.sendRedirect("/Hotel_Booking_System/user/AfterHotelPayment.jsp");
		}
		else {
			resp.sendRedirect("/Hotel_Booking_System/user/CardDetails.jsp");
		}
	}
}










