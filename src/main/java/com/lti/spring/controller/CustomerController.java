package com.lti.spring.controller;

import javax.persistence.Tuple;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lti.spring.exception.UserException;
import com.lti.spring.model.Cart;
import com.lti.spring.model.Customer;
import com.lti.spring.service.ICustomerService;
import com.lti.spring.service.IProductService;

@Controller
@RequestMapping(value = "/customer")
public class CustomerController {
	
	
	@Autowired
	private ICustomerService customerService;
	
	@Autowired
	private IProductService productService;
	
	/*@RequestMapping(value = "/addProduct/{productId}")
	public String addProduct(@Valid @ModelAttribute(value = "product") @Validated Product product, @PathVariable("productId") Integer productId, Model model) throws UserException {
		System.err.println("Customer Controller " + productService.getProductById(productId));
		int ret = customerService.addProduct(productService.getProductById(productId));
		System.err.println("Product being added in customer controller is "  + ret);
		return "redirect:/";
	}*/
	
	@RequestMapping(value = "/addCustomerForm", 
			method = RequestMethod.GET)
	public String saveCustomerPage(Model model, HttpSession session) throws UserException {
		model.addAttribute("categoryList", session.getAttribute("categoryList"));
		if(session.getAttribute("customerId") == null) model.addAttribute("action", "Login");
		else model.addAttribute("action", "Logout");
		//model.addAttribute("msg", "Username already exists! Choose a different Username");
		model.addAttribute("customer", new Customer());//Z: Empty model returned by controller to view
		return "customerForm";
	}
	
	@RequestMapping(value = "/Login", 
			method = RequestMethod.GET)
	public String showLoginPage(Model model, HttpServletRequest request, HttpSession session) throws UserException {
		model.addAttribute("categoryList", session.getAttribute("categoryList"));
		if(session.getAttribute("customerId") == null) model.addAttribute("action", "Login");
		else model.addAttribute("action", "Logout");
		String url = request.getRequestURI();
		System.err.println("URL in login is:" + url);
		//model.addAttribute("msg", "Username already exists! Choose a different Username");
		model.addAttribute("customer", new Customer());//Z: Empty model returned by controller to view
		return "loginFormPage";
	}
	
	@RequestMapping(value = "/Logout", 
			method = RequestMethod.GET)
	public String showLogoutPage(Model model, HttpServletRequest request, HttpSession session) throws UserException {
		model.addAttribute("categoryList", session.getAttribute("categoryList"));
		if(session.getAttribute("customerId") == null) model.addAttribute("action", "Login");
		else model.addAttribute("action", "Logout");
		String url = request.getRequestURI();
		System.err.println("URL in login is:" + url);
		
		session.invalidate();
		return "logout";
	}
	
	
	@RequestMapping(value = "/addCustomer", 
			method = RequestMethod.POST)
	public String addCustomerPage(@Valid @ModelAttribute(value="customer") 
	       @Validated Customer customer,
			BindingResult result, Model model, HttpSession session) throws UserException{
		model.addAttribute("categoryList", session.getAttribute("categoryList"));
		if(session.getAttribute("customerId") == null) model.addAttribute("action", "Login");
		else model.addAttribute("action", "Logout");
		String viewName = "addCustomerPage";
		if (result.hasErrors()) {
			System.out.println("Reached Error Page");
			return "errorPage";
        }
		
		Boolean userNameExists = customerService.getCustomerByUsername(customer.getUsername());
		
		if (userNameExists) {
			//viewName = "redirect:addCustomerForm";
			model.addAttribute("message", "Username already exists");
			return "customerForm";
		}
		
		else {
		session.setAttribute("cart", new Cart());
        customerService.addCustomer(customer, session);
        model.addAttribute("customer",customer);
		return viewName;
				}
	}
	
	@RequestMapping(value = "/loginStatus", 
			method = RequestMethod.POST)
	public String loginStatus(@Valid @ModelAttribute(value="customer") 
	       @Validated Customer customer,
			BindingResult result, Model model, HttpSession session, HttpServletRequest request) throws UserException{
		//String url = request.getRequestURL().toString() + "?" + request.getQueryString();
		model.addAttribute("categoryList", session.getAttribute("categoryList"));
		if(session.getAttribute("customerId") == null) model.addAttribute("action", "Login");
		else model.addAttribute("action", "Logout");
		
		if(session.getAttribute("customerId")!=null) { 
			model.addAttribute("Message", "You are already logged in");
			String redirectPath = (String) session.getAttribute("redirectPath");
			session.removeAttribute("redirectPath");
			return "redirect:" + redirectPath;
			
		}
		
		
			if(customer.getEmail()==null || customer.getPassword()==null) {
				model.addAttribute("message", "Please enter your credentials");
				return "loginFormPage";
			}
			
			else {
			String redirectPath = (String) session.getAttribute("redirectPath");
			session.removeAttribute("redirectPath");
			/* return "redirect:" + redirectPath; */
		
		String url = request.getContextPath().toString();
		System.err.println("URL in loginStatus is:" + url);
		if (result.hasErrors()) {
			System.out.println("Reached Error Page");
			return "errorPage";
        }
		
		String recu = customer.getEmail();
		String recp = customer.getPassword();
		System.err.println(customer.getEmail() + "  "+ customer.getPassword());
		Tuple emailExists = customerService.loginValidation(customer.getEmail());
		
		String valu = (String) emailExists.get(0);
		String valp = (String) emailExists.get(1);
		
		
		System.err.println(emailExists.get(0));
		System.err.println(emailExists.get(1));
		
		/* String viewName = ""; */
		if (recu.equals(valu) && recp.equals(valp)) {
			System.err.println("LoginStatus: " + emailExists.get(2)); System.err.println("customer login status 1");
		    session.setAttribute("customerId", emailExists.get(2)); System.err.println("customer login status 2");
		    //Customer customerLogged = customerService.getCustomerByUsername(userName);
		    Integer customerLogged = (Integer)session.getAttribute("customerId"); System.err.println("customer login status 3");
		    //customerLogged = customerService.getCustomerByUsername(customerLogged.get);
		    //System.err.println("Customer logged in is:" + (Customer)session.getAttribute("customer"));
		    System.err.println("Customer logged in is:" + customerService.getCustomerById(customerLogged)); System.err.println("customer cart service 4");
			//viewName = "loginSuccessfulPage";
		}
		
		System.err.println("customer cart service 5");
		//String redirectPath = (String) session.getAttribute("redirectPath");
		session.removeAttribute("redirectPath");
		return "redirect:" + redirectPath;
		//return "loginSuccessfulPage";
		}
	}
}
