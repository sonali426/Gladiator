package com.lti.spring.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lti.spring.exception.UserException;
import com.lti.spring.model.Customer;
import com.lti.spring.model.CustomerCart;
import com.lti.spring.model.Product;

@Repository
public class CustomerCartDao implements ICustomerCartDao{
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Autowired
	private CartDao cartDao;
	
	@Autowired
	private CustomerDao customerDao;
	
	private Customer customer = new Customer();
	
	@Override
	@Transactional
	public void addProduct(Product product, Integer customerId) throws UserException {
		//System.err.println(session.get);
		Integer cartId = customerDao.getCustomerById(customerId).getCart().getCartId();
		System.err.println(cartId + "  " + product.getProductId());
		CustomerCart customerCart = new CustomerCart(cartDao.getCartById(cartId), product); System.err.println("customer cart dao: 1");
		//System.err.println(customerCart.getCustomerCartId());
		System.err.println("Customer Cart: " + customerCart);
		customerCart.setCartId(cartDao.getCartById(cartId).getCartId());
		customerCart.setProductId(product.getProductId());
		/*customerCart.setCart(cartDao.getCartById(200)); System.err.println("customer cart sdao: 2");
		customerCart.setProduct(product);System.err.println("customer cart dao: 3");
		cartDao.getCartById(200).getCustomerCartList().add(customerCart);System.err.println("customer cart dao: 4");
		product.getCustomerCartList().add(customerCart);System.err.println("customer cart dao: 5");*/
		entityManager.persist(customerCart);System.err.println("customer cart dao: 6");
	}
	
	@Override
	public List<CustomerCart> getCustomerProducts(Integer cartId) throws UserException {
		// TODO Auto-generated method stub
		Query query = entityManager.createQuery("from CustomerCart where cartId =: cartId");
		query.setParameter("cartId", cartId);
		System.err.println("Cart Product List in customercartdao: " + query.getResultList());
		return query.getResultList();
		
	}
}
