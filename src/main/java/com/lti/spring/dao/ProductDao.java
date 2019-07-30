package com.lti.spring.dao;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.lti.spring.exception.UserException;
import com.lti.spring.model.Category;
import com.lti.spring.model.Product;

@Repository
public class ProductDao implements IProductDao {

	@PersistenceContext
	private EntityManager enitityManager;

	@SuppressWarnings("unchecked")//Suppressing the unchecked warnings
	@Override
	public List<Product> getProductList() throws UserException {
		System.out.println("product dao");
		return enitityManager.createQuery("from Product").getResultList();
	}

	@Override
	public Product addProduct(Product product) throws UserException {
		enitityManager.persist(product);
		return product;
	}
	
	@Override
	public List<Product> getProductByCategoryId(Category category) throws UserException {
		CategoryDao categoryDao = new CategoryDao();
		Query query = enitityManager.createQuery("from Product where category = :category");
		query.setParameter("category", category);
		List<Product> productList = query.getResultList();
		return productList;
	}

	@Override
	public Product updateProduct(Product product) throws UserException {
		enitityManager.merge(product);/*
										 * Hibernate handles persisting any changes to objects in the session when the
										 * session is flushed. update can fail if an instance of the object is already
										 * in the session. Merge should be used in that case. It merges the changes of
										 * the detached object with an object in the session, if it exists.
										 */
		return product;
	}

	@Override
	public Product getProductById(Integer productId) throws UserException {
		return (Product)enitityManager.find(Product.class, productId);// searches product in Product.class using Id
	}

	@Override
	public Product deleteProduct(Integer productId) throws UserException {
		Product product = getProductById(productId);
		if (product != null)
			enitityManager.remove(product); // removes the product from the list
		return product;

	}

}
