/**
 * 
 */
package com.rpinfotech.org.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author Rajendra
 *
 */
@Entity
public class Address {
	
	@Id
	@GeneratedValue
	int addressId;
	String addressStreet;
	String addressCity;
	String addressState;
	String addressCountr;
	
	
	/**
	 * 
	 */
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param addressId
	 * @param addressStreet
	 * @param addressCity
	 * @param addressState
	 * @param addressCountr
	 */
	public Address( String addressStreet, String addressCity, String addressState, String addressCountr) {
		this.addressStreet = addressStreet;
		this.addressCity = addressCity;
		this.addressState = addressState;
		this.addressCountr = addressCountr;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", addressStreet=" + addressStreet + ", addressCity=" + addressCity
				+ ", addressState=" + addressState + ", addressCountr=" + addressCountr + "]";
	}
	

	

}
