/**
 * 
 */
package com.rpinfotech.org.service.dao;

import java.util.List;

import com.rpinfotech.org.bean.Customer;
import com.rpinfotech.org.bean.CustomerOrder;
import com.rpinfotech.org.bean.Product;

/**
 * @author Rajendra
 *
 */
public interface CustomerServiceDAO {
	public void createCustomer(Customer customer);
	public Customer getCustomerDetails(int id);
	public List<Customer> getAllCustomers();
	public void creatProduct(Product product);
	public void createCustomerOrder(CustomerOrder customerOrder);
	public List<Product> getProducts();
	public List<CustomerOrder> getAllOrders();
	

}
