package org.jsp.entity;

import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
@Cacheable
public class Hotel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "hotel_name")
	private String hotelName;
	private String city;
	private String address;

	@Column(name = "mobile_no")
	private long mobile;
	private double price;

	@Column(name = "total_no_of_room")
	private int totalNoOfRoom;

	@Column(name = "no_of_booked_room")
	private int noOfBookedRoom;

	@OneToMany(mappedBy = "hotel", cascade = CascadeType.REMOVE)
	private List<BookingDetails> bookingDetails;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getMobile() {
		return mobile;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getTotalNoOfRoom() {
		return totalNoOfRoom;
	}

	public void setTotalNoOfRoom(int totalNoOfRoom) {
		this.totalNoOfRoom = totalNoOfRoom;
	}

	public int getNoOfBookedRoom() {
		return noOfBookedRoom;
	}

	public void setNoOfBookedRoom(int noOfBookedRoom) {
		this.noOfBookedRoom = noOfBookedRoom;
	}

	public List<BookingDetails> getBookingDetails() {
		return bookingDetails;
	}

	public void setBookingDetails(List<BookingDetails> bookingDetails) {
		this.bookingDetails = bookingDetails;
	}

}
