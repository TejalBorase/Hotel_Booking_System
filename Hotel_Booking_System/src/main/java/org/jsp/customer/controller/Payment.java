package org.jsp.customer.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
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

@WebServlet("/payment")
public class Payment extends HttpServlet{
	
	private CustomerDao customerDao = new CustomerDaoImpl();
	private AdminDao adminDao = new AdminDaoImpl();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//Fetch Booking details from session
		HttpSession session = req.getSession();
		BookingDetails details = (BookingDetails)session.getAttribute("bookingDetails");
		
		//Fetch Hotel details from session
		Hotel hotel = (Hotel)session.getAttribute("hotelObj");
		
		//Fetch Customer from session
		Customer customer = (Customer)session.getAttribute("customerObj");
		
		//Fetch Card details from html form & store into Card object
		Card card = new Card();
		card.setCardNumber(req.getParameter("cardnumber"));
		card.setCardHolderName(req.getParameter("cardHolderName"));
		card.setCvv(Integer.parseInt(req.getParameter("cvv")));
		card.setExpiryDate(LocalDate.parse(req.getParameter("expiryDate")));
		
		//add bookingDetails to List
		List<BookingDetails> bookingDetails = customer.getBookingDetails();
		bookingDetails.add(details);
		
		card.setBookingDetails(bookingDetails);
		card.setCustomer(customer);
		
		boolean status = customerDao.addCard(card);
		if(status) {
			//update bookingStatus
			details.setStatus("booked");
			details.setCard(card);
			BookingDetails updateStatus = customerDao.updateStatus(details);
			session.setAttribute("bookingDetails", updateStatus);
			
			//update hotel no. of room booked
			int totalNoOfBookedRoom = hotel.getNoOfBookedRoom() + details.getNoOfRooms();
			hotel.setNoOfBookedRoom(totalNoOfBookedRoom);
			
			Hotel updateHotelDetails = adminDao.updateHotelDetails(hotel);
			
			if(updateHotelDetails != null && updateStatus != null) {
				customer.setBookingDetails(bookingDetails);
				session.setAttribute("customerObj", customer);
				resp.sendRedirect("/Hotel_Booking_System/user/Payment.jsp?msg=payment");
			}
			else {
				resp.sendRedirect("/Hotel_Booking_System/user/AfterHotelPayment.jsp?msg=fail");
			}
		}
		else {
			resp.sendRedirect("/Hotel_Booking_System/user/AfterHotelPayment.jsp?msg=fail");
		}
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int cardId = Integer.parseInt(req.getParameter("cardId"));
		Card card = customerDao.getCardById(cardId);
		
		HttpSession session = req.getSession();
		BookingDetails details = (BookingDetails)session.getAttribute("bookingDetails");
		
		//Fetch Hotel details from session
		Hotel hotel = (Hotel)session.getAttribute("hotelObj");
		
		List<BookingDetails> bookingDetails = customer.getBookingDetails();
		bookingDetails.add(details);
		
		if(card != null) {
			//update bookingStatus
			details.setStatus("booked");
			details.setCard(card);
			BookingDetails updateStatus = customerDao.updateStatus(details);
			session.setAttribute("bookingDetails", updateStatus);
			
			//update hotel no. of room booked
			int totalNoOfBookedRoom = hotel.getNoOfBookedRoom() + details.getNoOfRooms();
			hotel.setNoOfBookedRoom(totalNoOfBookedRoom);
			
			Hotel updateHotelDetails = adminDao.updateHotelDetails(hotel);
			
			if(updateHotelDetails != null && updateStatus != null) {
				resp.sendRedirect("/Hotel_Booking_System/user/Payment.jsp?msg=payment");
			}
			else {
				resp.sendRedirect("/Hotel_Booking_System/user/CardDetails.jsp?msg=fail");
			}
		}
		else {
			resp.sendRedirect("/Hotel_Booking_System/user/CardDetails.jsp?msg=fail");
		}
		
	}
}














