package com.lti.spring.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lti.spring.exception.UserException;
import com.lti.spring.model.CustomerCart;
import com.lti.spring.model.Product;
import com.lti.spring.service.ICustomerCartService;
import com.lti.spring.service.ICustomerService;
import com.lti.spring.service.IProductService;

@Controller
@RequestMapping("/cart")
public class CartController {

	@Autowired
	IProductService productService;

	@Autowired
	ICustomerCartService customerCartService;

	@Autowired
	ICustomerService customerService;

	
	  @RequestMapping(value = "/checkout") 
	  public String checkout(@Valid @ModelAttribute(value = "product") @Validated Product
	  product,Model model, HttpSession session,
	  HttpServletRequest request) throws UserException{
		  System.err.println("Cart Controller checkout");
		  if(session.getAttribute("customerId") == null) model.addAttribute("action", "Login");
			else model.addAttribute("action", "Logout");
		  model.addAttribute("categoryList", session.getAttribute("categoryList"));
		  /*Integer customerCartId = (Integer) session.getAttribute("customerId");
		  Integer cartId = customerService.getCustomerById(customerCartId).getCart().getCartId();
		  System.err.println("Cart Controller cartId: " + cartId + customerCartId);
		  List<CustomerCart> customerCartList = customerCartService.getCustomerProducts(cartId);
		  List<Product> customerProductList = new ArrayList<>();
		  Iterator iterator = customerCartList.iterator();
		  int cartTotal = 0;
		  CustomerCart customerCart = new CustomerCart();
		  while(iterator.hasNext()) {
			  customerCart = (CustomerCart) iterator.next();
			  customerProductList.add(productService.getProductById(customerCart.getProductId()));
			  cartTotal += productService.getProductById(customerCart.getProductId()).getProductPrice();
			  System.err.println("Chechout " + productService.getProductById(customerCart.getProductId()));
		  }
		  model.addAttribute("customerProductList", customerProductList);
		  model.addAttribute("cartTotal", cartTotal);
		  model.addAttribute("current",session.getAttribute("customerId"));*/
		  return "checkout";
		  
	  }
	 
	 

	@RequestMapping(value = "/addProduct/{productId}")
	public String addproduct(@Valid @ModelAttribute(value = "product") @Validated Product product,
			@PathVariable("productId") Integer productId, /* @RequestParam(name = "quantity") Integer quantity */
			Model model, HttpSession session, HttpServletRequest request) throws UserException {
		// String url = request.getRequestURI().toString();
		// ServletContext url = request.getServletContext();
		// session.setAttribute("productId", productId);
		// System.err.println("Quantity in cart controller add product:" + quantity);
		model.addAttribute("categoryList", session.getAttribute("categoryList"));
		if(session.getAttribute("customerId") == null) model.addAttribute("action", "Login");
		else model.addAttribute("action", "Logout");
		System.err.println("Cart Controller prod id: " + productId);
		System.err.println("Product Id is:" + productService.getProductById(productId).getCategory().getCategoryId());
		System.err.println("Customer Id in AddProduct session: " + session.getAttribute("customerId"));
		if (session.getAttribute("customerId") != null) {
			model.addAttribute("categoryList", session.getAttribute("categoryList"));
			String url = (String) session.getAttribute("redirectPath");
			customerCartService.addProduct(productService.getProductById(productId),
					(Integer)session.getAttribute("customerId"));
			  Integer customerCartId = (Integer) session.getAttribute("customerId");
			  Integer cartId = customerService.getCustomerById(customerCartId).getCart().getCartId();
			  System.err.println("Cart Controller cartId: " + cartId + customerCartId);
			  List<CustomerCart> customerCartList = customerCartService.getCustomerProducts(cartId);
			  List<Product> customerProductList = new ArrayList<>();
			  Iterator iterator = customerCartList.iterator();
			  int cartTotal = 0;
			  CustomerCart customerCart = new CustomerCart();
			  while(iterator.hasNext()) {
				  customerCart = (CustomerCart) iterator.next();
				  customerProductList.add(productService.getProductById(customerCart.getProductId()));
				  cartTotal += productService.getProductById(customerCart.getProductId()).getProductPrice();
				  System.err.println("Checkout " + productService.getProductById(customerCart.getProductId()));
			  }
			  model.addAttribute("customerProductList", customerProductList);
			  model.addAttribute("cartTotal", cartTotal);
			  model.addAttribute("current",session.getAttribute("customerId"));
			model.addAttribute("productId", productId);
			model.addAttribute("categoryId", productService.getProductById(productId).getCategory().getCategoryId());
			return "cartPage";
		}

		else {
			session.setAttribute("productId", productId);
			session.setAttribute("redirectPath", request.getRequestURI().toString());
			System.err.println("customer cart controller:else");
			return "redirect:/customer/Login";
		}
	}
}
