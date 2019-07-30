package com.lti.spring.service;

import java.util.List;

import javax.persistence.Tuple;
import javax.servlet.http.HttpSession;

import com.lti.spring.exception.UserException;
import com.lti.spring.model.Customer;
import com.lti.spring.model.Product;

public interface ICustomerService {
	public List<Customer> getCustomerList()throws UserException;
	public Customer addCustomer(Customer customer, HttpSession sessionS)throws UserException;
	public Customer updateCustomer(Customer customer)throws UserException;
	public Customer getCustomerById(Integer customerId)throws UserException;
	public Customer deleteCustomer(Integer customerId)throws UserException;
	public Boolean getCustomerByUsername(String userName) throws UserException;
	public Tuple loginValidation(String userName) throws UserException;
	public Integer addProduct(Product product) throws UserException;
	
}
