	package com.lti.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lti.spring.exception.UserException;
import com.lti.spring.model.Category;
import com.lti.spring.service.ICategoryService;

@Controller
@RequestMapping(value = "/category")
public class CategoryController {
	
	@Autowired
	private ICategoryService categoryService;
	
	@RequestMapping(value = "/addCategoryForm", 
			method = RequestMethod.GET)
	public String saveCategoryPage(Model model) throws UserException {
		model.addAttribute("category", new Category());
		List<Category> categoryList=
				categoryService.getCategoryList();
		
		categoryList.forEach((data)->System.out.println(data)); 
		model.addAttribute("categoryList",categoryList);
		return "categoryForm";
	}
}