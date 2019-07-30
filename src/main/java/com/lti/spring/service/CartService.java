package com.lti.spring.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.spring.dao.CartDao;
import com.lti.spring.model.Product;

@Service
public class CartService implements ICartService {
	
	@Autowired 
	CartDao cartDao;
	
	/*
	 * @Override
	 * 
	 * @Transactional public void addProduct(Integer productId) {
	 * System.err.println("Entering cartService"); cartDao.addProduct(product); }
	 */

}
