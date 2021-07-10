/**
 * 
 */
package com.rpinfotech.org.bean;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * @author Rajendra
 *
 */
@Entity

public class Customer {

	@Id
	@GeneratedValue
	int customerId;

	String customerFirstName;
	String customerLastName;
	Date customerDOB;

	@OneToOne ( cascade = {CascadeType.ALL} )
	Address address;

	
	
	/**
	 * 
	 */
	public Customer() {
		super();
	}

	/**
	 * @param customerFirstName
	 * @param customerLastName
	 * @param customerDOB
	 * @param address
	 */
	public Customer(String customerFirstName, String customerLastName, Date customerDOB, Address address) {
		super();
		this.customerFirstName = customerFirstName;
		this.customerLastName = customerLastName;
		this.customerDOB = customerDOB;
		this.address = address;
	}

	/**
	 * @return the customerFirstName
	 */
	public String getCustomerFirstName() {
		return customerFirstName;
	}

	/**
	 * @param customerFirstName the customerFirstName to set
	 */
	public void setCustomerFirstName(String customerFirstName) {
		this.customerFirstName = customerFirstName;
	}

	/**
	 * @return the customerLastName
	 */
	public String getCustomerLastName() {
		return customerLastName;
	}

	/**
	 * @param customerLastName the customerLastName to set
	 */
	public void setCustomerLastName(String customerLastName) {
		this.customerLastName = customerLastName;
	}

	/**
	 * @return the customerDOB
	 */
	public Date getCustomerDOB() {
		return customerDOB;
	}

	/**
	 * @param customerDOB the customerDOB to set
	 */
	public void setCustomerDOB(Date customerDOB) {
		this.customerDOB = customerDOB;
	}

	/**
	 * @return the address
	 */
	public Address getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(Address address) {
		this.address = address;
	}
	public int getCustomerId()
	{
		return this.customerId;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerFirstName=" + customerFirstName + ", customerLastName="
				+ customerLastName + ", customerDOB=" + customerDOB + ", address=" + address + "]";
	}




}
