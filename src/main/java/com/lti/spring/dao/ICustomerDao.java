package com.lti.spring.dao;

import java.util.List;

import javax.persistence.Tuple;
import javax.servlet.http.HttpSession;

import com.lti.spring.exception.UserException;
import com.lti.spring.model.Customer;

public interface ICustomerDao {
	public List<Customer> getCustomerList()throws UserException;
	public Customer addCustomer(Customer customer, HttpSession session)throws UserException;
	public Customer updateCustomer(Customer customer)throws UserException;
	public Customer getCustomerById(Integer customerId)throws UserException;
	public Customer deleteCustomer(Integer customerId)throws UserException;
	public Boolean getCustomerByUsername(String userName) throws UserException;
	public Tuple loginValidation(String userName) throws UserException;
}
