package com.lti.spring.dao;

import java.util.List;

import com.lti.spring.exception.UserException;
import com.lti.spring.model.CustomerCart;
import com.lti.spring.model.Product;

public interface ICustomerCartDao {
	public void addProduct(Product product, Integer customerId) throws UserException;

	public List<CustomerCart> getCustomerProducts(Integer cartId) throws UserException;
}
