package com.lti.spring.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.spring.dao.ICustomerCartDao;
import com.lti.spring.exception.UserException;
import com.lti.spring.model.CustomerCart;
import com.lti.spring.model.Product;

@Service
public class CustomerCartService implements ICustomerCartService{
	
	@Autowired
	private ICustomerCartDao customerCartDao;
	
	@Override
	@Transactional
	public void addProduct(Product product, Integer customerId) throws UserException{
		// TODO Auto-generated method stub
		System.err.println("customer cart service");
		customerCartDao.addProduct(product, customerId); System.err.println("customer cart service");
	}

	@Override
	public List<CustomerCart> getCustomerProducts(Integer cartId) throws UserException {
		// TODO Auto-generated method stub
		
		return customerCartDao.getCustomerProducts(cartId);
	}
}
