package com.lti.spring.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lti.spring.exception.UserException;
import com.lti.spring.model.Category;
import com.lti.spring.model.Product;
import com.lti.spring.service.ICategoryService;
import com.lti.spring.service.IProductService;



@Controller
@RequestMapping(value="/product")
public class ProductController {
	@Autowired
	private IProductService productService;
	
	@Autowired ICategoryService categoryService;
	
	
	@RequestMapping(value = "/productDetails/{productId}")
	public String productDetails(Model model, HttpSession session, @PathVariable("productId") Integer productId, HttpServletRequest request) throws UserException {
		model.addAttribute("productId", productId);
		Product product = productService.getProductById(productId);
		model.addAttribute("product", product);
		model.addAttribute("categoryList", session.getAttribute("categoryList"));
		if(session.getAttribute("customerId") == null) model.addAttribute("action", "Login");
		else model.addAttribute("action", "Logout");
		//productList.forEach((data)->System.out.println("product controller")); 
		session.setAttribute("redirectPathFromProductDetails", request.getRequestURL().toString());
		return "productDetails";
	}
	
	@RequestMapping(value = "/showProductList/{categoryId}", 
			method = RequestMethod.GET)
	public String showProductList(Model model, @PathVariable("categoryId") Integer categoryId, HttpSession session, HttpServletRequest request) throws UserException {
		Category category = categoryService.getCategoryById(categoryId); System.err.println("Category id in prod cont:" + categoryId);
		session.setAttribute("redirectPath", request.getRequestURI().toString());
		System.err.println("Category in showProductList: " + category);
		List<Product> productList=
				productService.getProductByCategoryId(category);
		System.err.println("Product list in product Controller is: " + productList);
		//productList.forEach((data)->System.out.println("product controller"));
		model.addAttribute("categoryList", session.getAttribute("categoryList"));
		model.addAttribute("productList", productList);
		if(session.getAttribute("customerId") == null) model.addAttribute("action", "Login");
		else model.addAttribute("action", "Logout");
		return "productList";
	}

	@RequestMapping(value = "/saveProduct", method = RequestMethod.POST)
	public String saveProductAction(/*@ModelAttribute("product")*/ @Valid Product product, BindingResult bindingResult, Model model) throws UserException {
		/*if (bindingResult.hasErrors()) {
			return "redirect:/product/addProductForm";
		}*/
		if(product.getProductId()==null){
			//new product, add it
			product=this.productService.addProduct(product);
			
		}else{
			/*//existing product, call update
			product=this.productService.updateProduct(product);*/
			model.addAttribute("product",product);
			productService.updateProduct(product);
			//productList.forEach((data)->System.out.println("product controller")); 
			
			
		}
		model.addAttribute("product", product);
		return "redirect:/product/addProductForm";//"redirect:/product/successProduct";
	}
	@RequestMapping(value="/deleteProduct/{productId}", method = RequestMethod.POST)
    public String deleteProduct(@PathVariable("productId") Integer productId) throws UserException{
        this.productService.deleteProduct(productId);
        return "productSuccess";
    }
 
    @GetMapping("/editProduct/{productId}")
    public String editProduct(@ModelAttribute("product") @Valid Product product, @PathVariable("productId") Integer productId, Model model) throws UserException{
        model.addAttribute("product", this.productService.getProductById(productId));
        model.addAttribute("productList", this.productService.getProductList());
        
    	return "productForm";
    }
	@RequestMapping(value="/productSuccess")
	public String gotoSuccessPage(Model model) {
			return  "redirect:/product/productSuccess";//view name which will be returned to dispacherServlet
	}
}
