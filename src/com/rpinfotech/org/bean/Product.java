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
public class Product {

	@Id
	@GeneratedValue
	int productId;
	
	String productName;
	String desciption;
	double price;
	/**
	 * 
	 */
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param productName
	 * @param desciption
	 * @param price
	 */
	public Product(String productName, String desciption, double price) {
		super();
		this.productName = productName;
		this.desciption = desciption;
		this.price = price;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", desciption=" + desciption
				+ ", price=" + price + "]";
	}
	
	
}
