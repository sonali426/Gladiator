package com.lti.spring.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lti.spring.exception.UserException;
import com.lti.spring.model.Category;
import com.lti.spring.model.Product;
import com.lti.spring.service.ICategoryService;
import com.lti.spring.service.IProductService;



@Controller
@RequestMapping(value="/")
public class HomeController {
	
	@Autowired
	private IProductService productService;
	
	@Autowired
	private ICategoryService categoryService;
	
	@RequestMapping(value="/")
	public String showHomePage(Model model, HttpSession session, HttpServletRequest request) throws UserException {
		//return model and view
		if(session.getAttribute("customerId") == null) model.addAttribute("action", "Login");
		else model.addAttribute("action", "Logout");
		List<Product> productList = productService.getProductList();
		List<Category> categoryList = categoryService.getCategoryList();
		//model.addAttribute("msg", "Welcome to your one stop store!");
		//System.err.println("msg in home controller" + session.getAttribute("addedToCart"));
		//String msg1 ="Product " + session.getAttribute("addedToCart");
		//System.err.println(msg1);
		//model.addAttribute("msg1", msg1);
		session.setAttribute("categoryList", categoryList);
		model.addAttribute("categoryList", categoryList);
		session.setAttribute("redirectPath", request.getRequestURL().toString());
		//model.addAttribute("productList", productList);
		//model object associated with name 'msg'
		return "home";//view name which will be returned to dispacherServlet
	}
	
	/*
	 * @RequestMapping(value="/home") public String gotoHomePage(Model model) throws
	 * UserException{ //return model and view List<Product> productList =
	 * productService.getProductList(); model.addAttribute("CustomerCart", new
	 * CustomerCart()); model.addAttribute("productList", productList);
	 * model.addAttribute("msg", "Added To Cart Successfully");
	 * model.addAttribute("today",LocalDate.now()); //model object associated with
	 * name 'msg' return "productList";//view name which will be returned to
	 * dispacherServlet }
	 */
}
