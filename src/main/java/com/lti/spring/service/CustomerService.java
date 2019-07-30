package com.lti.spring.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Tuple;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lti.spring.dao.CategoryDao;
import com.lti.spring.dao.ICategoryDao;
import com.lti.spring.dao.ICustomerDao;
import com.lti.spring.dao.IProductDao;
import com.lti.spring.exception.UserException;
import com.lti.spring.model.Customer;
import com.lti.spring.model.Product;

@Service
public class CustomerService implements ICustomerService {
	
	private List<Product> productList = new ArrayList<Product>();
	@Autowired
	private ICustomerDao customerDao;
	
	@Autowired
	private IProductDao productDao;
	
	@Autowired
	private ICategoryDao categoryDao;
	
	@Override
	@Transactional
	public Integer addProduct(Product product) throws UserException{
		productList.add(product);
		System.err.println(product);
		return product.getProductId();
	}
	
	@Override
	@Transactional
	public List<Customer> getCustomerList()throws UserException{
	List<Customer> customerList = customerDao.getCustomerList();	
	System.out.println("get list at service" + customerList);
	return customerDao.getCustomerList();	
	}
	
	@Override
	@Transactional
	public Customer addCustomer(Customer customer, HttpSession session)throws UserException{
		return customerDao.addCustomer(customer, session);
	}
	
	
	@Override
	@Transactional
	public Customer updateCustomer(Customer customer)throws UserException{
		return customerDao.updateCustomer(customer);
	}
	
	@Override
	@Transactional
	public Customer getCustomerById(Integer customerId)throws UserException{
		return customerDao.getCustomerById(customerId);
	}
	
	@Override
	@Transactional
	public Customer deleteCustomer(Integer customerId)throws UserException{
		return customerDao.deleteCustomer(customerId);
	}
	
	@Override
	@Transactional
	public Boolean getCustomerByUsername(String userName) throws UserException{
		return customerDao.getCustomerByUsername(userName);
	}
	
	@Override
	@Transactional
	public Tuple loginValidation(String userName) throws UserException{
		return customerDao.loginValidation(userName);
	}
	
}
