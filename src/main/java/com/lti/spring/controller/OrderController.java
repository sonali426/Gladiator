package com.lti.spring.controller;

import java.io.FileOutputStream;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.lti.spring.exception.UserException;
import com.lti.spring.service.ICustomerService;

@Controller
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	ICustomerService customerService;
	
	//@SuppressWarnings("finally")
	@SuppressWarnings("finally")
	@RequestMapping(value = "/placeOrder", produces = MediaType.APPLICATION_PDF_VALUE, method = RequestMethod.GET)
	public ResponseEntity<Document> placeOrder(Model model, HttpSession session) throws UserException {
		
		HttpHeaders headers = new HttpHeaders();
		Document document = new Document();
		try {
			PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("Custom.pdf"));
			document.open();
			document.add(new Paragraph("A Hello World PDF document."));
			document.close();
			writer.close();
			headers.add("Content-Disposition", "inline; filename=" + "Cust.pdf");
			return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF).body(document);
		} catch (DocumentException e) {
			e.printStackTrace();
		} finally {
			return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF).body(document);
		}

	      
	   }
	}
