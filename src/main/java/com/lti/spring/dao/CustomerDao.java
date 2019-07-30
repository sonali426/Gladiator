package com.lti.spring.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Tuple;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Repository;

import com.lti.spring.exception.UserException;
import com.lti.spring.model.Cart;
import com.lti.spring.model.Customer;

@Repository
public class CustomerDao implements ICustomerDao {
	
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<Customer> getCustomerList() throws UserException {
		// TODO Auto-generated method stub
		List<Customer> customerList = entityManager.createQuery("from Customer").getResultList();
		System.out.println("Getlist at dao" + customerList);
		return entityManager.createQuery("from Customer").getResultList();
	}

	@Override
	public Customer addCustomer(Customer customer, HttpSession session) throws UserException {
		// TODO Auto-generated method stub
		Cart cart = (Cart)session.getAttribute("cart");
		
		cart.setCustomer(customer);
		customer.setCart(cart);
		entityManager.persist(customer);
		return customer;
	}

	@Override
	public Customer updateCustomer(Customer customer) throws UserException {
		// TODO Auto-generated method stub
		entityManager.merge(customer);
		return customer;
	}

	@Override
	public Customer getCustomerById(Integer customerId) throws UserException {
		// TODO Auto-generated method stub
		return (Customer) entityManager.find(Customer.class,customerId);
	}
	
	public Boolean getCustomerByUsername(String userName) throws UserException {
		// TODO Auto-generated method stub
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<String> criteria = builder.createQuery(String.class);
		Root<Customer> customerRoot = criteria.from(Customer.class);
		criteria.select(customerRoot.get("username"));
		criteria.where( builder.equal( customerRoot.get("username"), userName ) );
		try {
		String result = entityManager.createQuery( criteria ).getSingleResult();
		return true ;
		}
		catch(javax.persistence.NoResultException nre) {
			return false;
		}
		
	}
	
	public Tuple loginValidation(String email) throws UserException {
		// TODO Auto-generated method stub
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Tuple> criteria = builder.createTupleQuery();
		Root<Customer> customerRoot = criteria.from(Customer.class);
		criteria.multiselect(customerRoot.get("email"), customerRoot.get("password"), customerRoot.get("customerId"));
		criteria.where( builder.equal( customerRoot.get("email"), email));
		Tuple result = entityManager.createQuery(criteria).getSingleResult();
		System.err.println("Login Validation: " + result);
		return result;
		/*Criteria crit = ((Criteria) entityManager).createCriteria(Customer.class);
		crit.add(Restrictions.eq("username",userName));
		List<Product> results = crit.list();*/
	}

	@Override
	public Customer deleteCustomer(Integer customerId) throws UserException {
		// TODO Auto-generated method stub
		Customer customer=getCustomerById(customerId);
		if (customer!=null) entityManager.remove(customer);
		return customer;
	}
	
}
