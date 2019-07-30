package com.lti.spring.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ForgotPasswordController {
	
	@RequestMapping(value="/forgotPassword")
	public String forgotPassword(Model model, HttpSession session) {
		if(session.getAttribute("customerId") == null) model.addAttribute("action", "Login");
		else model.addAttribute("action", "Logout");
		model.addAttribute("categoryList", session.getAttribute("categoryList"));
		return "ForgotPassword";
	}
}
