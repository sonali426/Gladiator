package com.lti.spring.service;

import java.util.List;

import com.lti.spring.exception.UserException;
import com.lti.spring.model.CustomerCart;
import com.lti.spring.model.Product;

public interface ICustomerCartService {
	public void addProduct(Product product, Integer customerId) throws UserException;

	public List<CustomerCart> getCustomerProducts(Integer cartId) throws UserException;
}
