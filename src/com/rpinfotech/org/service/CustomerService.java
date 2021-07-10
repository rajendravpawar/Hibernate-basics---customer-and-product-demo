/**
 * 
 */
package com.rpinfotech.org.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.rpinfotech.org.bean.Address;
import com.rpinfotech.org.bean.Customer;
import com.rpinfotech.org.bean.CustomerOrder;
import com.rpinfotech.org.bean.Product;
import com.rpinfotech.org.service.dao.CustomerServiceDAO;
import com.rpinfotech.org.service.dao.impl.CustomerServiceDAOImpl;

/**
 * @author Rajendra
 *
 */
public class CustomerService {

	public static void main( String args[])
	{
		CustomerService customerService = new CustomerService();

		//Create New Customer
		Customer customer = customerService.createCustomer();

		//Create New Products
		List<Product> products = customerService.createProducts();

		//Create Order for the customer 
		//customerService.createCustomerOrder(customer, products);

		/*
		 *  Fetch data
		 */

		//Fetch all customers
		List<Customer> allCustomers = customerService.printAllCustomers();


		//Fetch all the product details
		List<Product> allProducts = customerService.printAllProducts();
		customerService.createCustomerOrder(customer, allProducts);
		customerService.createCustomerOrder(customer, allProducts);
		//customerService.createCustomerOrder(customer, allProducts);



		//Fetch all the order by each customer
		List<CustomerOrder> printAllOrders = customerService.printAllOrders();


	}

	public Customer createCustomer() {
		CustomerServiceDAO customerServiceDAO = new CustomerServiceDAOImpl();
		Address address = new Address("Balewadi", "Pune", "Maharashtra","India");
		Customer customer = new Customer("Rajendra", "Pawar", new Date(2016, 9, 8), address);
		customerServiceDAO.createCustomer(customer);
		return customer;
	}

	public List<Product> createProducts() {

		List<Product> products = new ArrayList();
		CustomerServiceDAO customerServiceDAO = new CustomerServiceDAOImpl();
		Product applePhone =  new Product("Apple Phone", "World best smart phone", 85999.56);
		customerServiceDAO.creatProduct(applePhone);

		Product lgTc =  new Product("LG TV", "World best smart TV", 85999.56);
		customerServiceDAO.creatProduct(lgTc);
		products.add(applePhone);
		products.add(lgTc);
		return products;
	}
	public  CustomerOrder createCustomerOrder(Customer customer, List<Product> products) {
		CustomerServiceDAO customerServiceDAO = new CustomerServiceDAOImpl();
		CustomerOrder customerOrder = new CustomerOrder(new Date(), customer, products);
		customerServiceDAO.createCustomerOrder(customerOrder);
		return customerOrder;
	}


	public List<Product> printAllProducts() {
		CustomerServiceDAO customerServiceDAO = new CustomerServiceDAOImpl();
		List<Product> allProducts = customerServiceDAO.getProducts();
		allProducts.forEach(product -> System.out.println("Customer details : "+product));
		return allProducts;
	}


	public List<Customer> printAllCustomers() {
		CustomerServiceDAO customerServiceDAO = new CustomerServiceDAOImpl();
		List<Customer> allCustomers = customerServiceDAO.getAllCustomers();
		allCustomers.forEach(cust -> System.out.println("Customer details : "+cust));
		return allCustomers;
	}
	public List<CustomerOrder> printAllOrders() {
		CustomerServiceDAO customerServiceDAO = new CustomerServiceDAOImpl();
		List<CustomerOrder> allCustomerOrder = customerServiceDAO.getAllOrders();
		allCustomerOrder.forEach(custOrder -> System.out.println("Customer details : "+custOrder));
		return allCustomerOrder;
	}
}
