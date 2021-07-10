/**
 * 
 */
package com.rpinfotech.org.bean;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;



/**
 * @author Rajendra
 *
 */
@Entity
public class CustomerOrder {
	
	@Id
	@GeneratedValue
	int orderId;
	
	Date orderDate;
	@OneToOne
	Customer customer;
	
	@ManyToMany(/*mappedBy = "CustomerOrder", */cascade= { CascadeType.ALL } )
	@JoinTable(name="customer_order_item_details",joinColumns= @JoinColumn(name="orderId"), inverseJoinColumns=@JoinColumn(name="productId") )
	List<Product> products;
	/**
	 * 
	 */
	public CustomerOrder() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param orderDate
	 * @param customer
	 * @param product
	 */
	public CustomerOrder(Date orderDate, Customer customer, List<Product> products) {
		super();
		this.orderDate = orderDate;
		this.customer = customer;
		this.products = products;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CustomerOrder [orderId=" + orderId + ", orderDate=" + orderDate + ", customer=" + customer
				+ ", product=" + products + "]";
	}

	
}
