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
import javax.persistence.SequenceGenerator;

@Entity
@Cacheable
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customerId")
	@SequenceGenerator(name = "customerId", sequenceName = "customerIdsequence", initialValue = 101, allocationSize = 3)
	private int id;

	@Column(name = "first_Name", nullable = false)
	private String firstName;

	@Column(name = "last_Name")
	private String lastName;

	@Column(name = "mobile_No", unique = true, nullable = false)
	private long mobile;

	@Column(name = "email_Id", unique = true, nullable = false)
	private String email;

	@Column(nullable = false)
	private String password;

	@Column(length = 10)
	private String gender;

	@OneToMany(mappedBy = "customer")
	private List<BookingDetails> bookingDetails;

	@OneToMany(mappedBy = "customer")
	private List<Card> cards;

	public void setBookingDetails(List<BookingDetails> bookingDetails) {
		this.bookingDetails = bookingDetails;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public long getMobile() {
		return mobile;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public List<Card> getCards() {
		return cards;
	}

	public void setCards(List<Card> cards) {
		this.cards = cards;
	}

	public List<BookingDetails> getBookingDetails() {
		return bookingDetails;
	}

}
