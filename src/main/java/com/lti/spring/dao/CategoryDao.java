package com.lti.spring.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.lti.spring.exception.UserException;
import com.lti.spring.model.Category;

	@Repository
	public class CategoryDao implements ICategoryDao {
		
		
		@PersistenceContext
		private EntityManager entityManager;
		
		@Override
		public List<Category> getCategoryList() throws UserException {
			return entityManager.createQuery("from Category").getResultList();
		}
		@Override
		public Category getCategoryById(Integer categoryId) throws UserException {
			return (Category) entityManager.find(Category.class,categoryId);
		}

}
