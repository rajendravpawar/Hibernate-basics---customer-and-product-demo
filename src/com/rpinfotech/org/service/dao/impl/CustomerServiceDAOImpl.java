/**
 * 
 */
package com.rpinfotech.org.service.dao.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.classic.Session;

import com.rpinfotech.org.bean.Address;
import com.rpinfotech.org.bean.Customer;
import com.rpinfotech.org.bean.CustomerOrder;
import com.rpinfotech.org.bean.Product;
import com.rpinfotech.org.service.dao.CustomerServiceDAO;

/**
 * @author Rajendra
 *
 */
public class CustomerServiceDAOImpl implements CustomerServiceDAO {

	SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();

	@Override
	public void createCustomer(Customer customer) {
		Session openSession = sessionFactory.openSession();
		Transaction transaction = openSession.beginTransaction();
		Address address = customer.getAddress();
		Serializable saveAddress = openSession.save(address);

		Serializable save = openSession.save(customer);
		if( Objects.isNull(save) )
		{
			System.out.println(save);
		}

		transaction.commit();

	}

	@Override
	public Customer getCustomerDetails(int id) {
		Customer customerToReturn = null;
		List<Customer> custList= this.getAllCustomers();
		for (Customer customer : custList) {
			if( customer.getCustomerId() == id )
			{
				customerToReturn =  customer;
				break;
			}
		}
		return customerToReturn;
	}

	@Override
	public List<Customer> getAllCustomers() {
		Session session = sessionFactory.openSession();
		List<Customer> custList= (List<Customer>)session.createQuery(" from Customer").list();
		return custList;
	}

	@Override
	public void creatProduct(Product product) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(product);
		transaction.commit();

	}

	@Override
	public void createCustomerOrder(CustomerOrder customerOrder) {
		try {
			Session session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			session.save(customerOrder);
			transaction.commit();
			session.close();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public List<Product> getProducts() {
		Session session = sessionFactory.openSession();
		List productList = session.createQuery("from Product").list();
		return productList;
	}

	@Override
	public List<CustomerOrder> getAllOrders() {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery(" from CustomerOrder");
		List list = query.list();
		System.out.println("hi");
		return list;
	}

}
