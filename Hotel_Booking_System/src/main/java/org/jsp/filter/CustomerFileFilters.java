package org.jsp.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(urlPatterns = {"/user/Home.jsp", "/user/HotelList.jsp", "/user/BookHotel.jsp",
						  "/user/Logout.jsp"})
public class CustomerFileFilters implements  Filter{

	public void init(FilterConfig filterConfig) throws ServletException {
		
		System.out.println("Filter");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		//to check whether user is logged in or not
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		
		HttpSession session = httpRequest.getSession(false);
		if(session.getAttribute("customerObj") == null) {
			//Login.jsp
			httpResponse.sendRedirect("/Hotel_Booking_System/user/Login.jsp");
		}
		else {
			chain.doFilter(request, response);
		}
	}

	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}







