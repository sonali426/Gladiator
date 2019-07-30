package com.lti.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lti.spring.dao.ICategoryDao;
import com.lti.spring.exception.UserException;
import com.lti.spring.model.Category;
@Service
public class CategoryService implements ICategoryService {

	@Autowired
	private ICategoryDao categoryDao;
	
	@Override
	@Transactional
	public List<Category> getCategoryList()throws UserException{
	return categoryDao.getCategoryList();	
	}
	
	@Override
	@Transactional
	public Category getCategoryById(Integer categoryId)throws UserException{
		return categoryDao.getCategoryById(categoryId);
	}

}
