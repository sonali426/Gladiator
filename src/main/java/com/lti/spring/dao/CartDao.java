package com.lti.spring.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.lti.spring.model.Cart;
import com.lti.spring.model.CustomerCart;

@Repository
public class CartDao {
	@PersistenceContext
	private EntityManager entityManager;
	
	CustomerCart customerCart = new CustomerCart();
	
	public Cart getCartById(Integer cartId) {
		Cart cart = (Cart)entityManager.find(Cart.class, cartId);
		return cart;
	}
	/*
	 * public void addProduct(Integer productId) {
	 * System.err.println("Entering cartdao");
	 * System.err.println("Entering cart dao: 1");
	 * customerCart.addProduct(productId);
	 * System.err.println("Entering cart dao: 2"); //entityManager.persist(product);
	 * System.err.println("Entering cart dao: 3"); }
	 */
}
