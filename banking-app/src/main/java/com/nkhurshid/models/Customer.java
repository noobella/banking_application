package com.nkhurshid.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="customer")
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="customer_id")
	private int customerId;
	@Column(name="first_name")
	private String firstName;
	@Column(name="last_name")
	private String lastName;
	@Column(name="door_no")
	private int doorNo;
	@Column(name="street_name")
	private String streetName;
	@Column(name="postcode")
	private String postcode;
	@Column(name="phone_no", unique=true) 
	private String phoneNo;
	@Column(name="password")
	private String password;
	@OneToMany(mappedBy = "customer")
	private List<BankAccount> accounts;
	
	public Customer() {}
	
	public Customer(String firstName, String lastName, int doorNo, String streetName,
			String postcode, String phoneNo) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.doorNo = doorNo;
		this.streetName = streetName;
		this.postcode = postcode;
		this.phoneNo = phoneNo;
	}
	
	public Customer(String firstName, String lastName, int doorNo, String streetName,
			String postcode, String phoneNo, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.doorNo = doorNo;
		this.streetName = streetName;
		this.postcode = postcode;
		this.phoneNo = phoneNo;
		this.password = password;
	}

	public Customer(int customerId, String firstName, String lastName, int doorNo, String streetName,
			String postcode, String phoneNo, String password) {
		super();
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.doorNo = doorNo;
		this.streetName = streetName;
		this.postcode = postcode;
		this.phoneNo = phoneNo;
		this.password = password;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
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

	public int getDoorNo() {
		return doorNo;
	}

	public void setDoorNo(int doorNo) {
		this.doorNo = doorNo;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<BankAccount> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<BankAccount> accounts) {
		this.accounts = accounts;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", doorNo=" + doorNo + ", streetName=" + streetName + ", postcode=" + postcode + ", phoneNo="
				+ phoneNo + ", password=" + password + ", accounts=" + accounts + "]";
	}
	
}
