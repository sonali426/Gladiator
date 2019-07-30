package com.lti.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lti.spring.dao.ICategoryDao;
import com.lti.spring.dao.IProductDao;
import com.lti.spring.exception.UserException;
import com.lti.spring.model.Category;
import com.lti.spring.model.Product;



@Service
public class ProductService implements IProductService{
	@Autowired
	private IProductDao productDao;

	@Override
	@Transactional
	public List<Product> getProductList() throws UserException {
		System.out.println("product service");
		return productDao.getProductList();
	}

	@Override
	@Transactional
	public Product addProduct(Product product) throws UserException {
		
		return productDao.addProduct(product);
	}
	
	@Override
	@Transactional
	public List<Product> getProductByCategoryId(Category category) throws UserException{
		return productDao.getProductByCategoryId(category);
	}
	
	@Override
	@Transactional
	public Product updateProduct(Product product) throws UserException {
		
		return productDao.updateProduct(product);
	}

	@Override
	@Transactional
	public Product getProductById(Integer productId) throws UserException {
		return productDao.getProductById(productId);
	}

	@Override
	@Transactional
	public Product deleteProduct(Integer productId) throws UserException {
		
		return productDao.deleteProduct(productId);
	}

}
