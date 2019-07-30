package com.lti.spring.dao;

import java.util.List;

import com.lti.spring.exception.UserException;
import com.lti.spring.model.Category;

public interface ICategoryDao {
	public List<Category> getCategoryList()throws UserException;
	public Category getCategoryById(Integer categoryId)throws UserException;
}
