package com.lti.spring.service;


import java.util.List;

import com.lti.spring.exception.UserException;
import com.lti.spring.model.Category;
import com.lti.spring.model.Product;



public interface IProductService {
	public List<Product> getProductList()throws UserException;
	public Product addProduct(Product product)throws UserException;
	public Product updateProduct(Product product)throws UserException;
	public Product getProductById(Integer productId)throws UserException;
	public Product deleteProduct(Integer productId)throws UserException;
	public List<Product> getProductByCategoryId(Category category) throws UserException;
}
