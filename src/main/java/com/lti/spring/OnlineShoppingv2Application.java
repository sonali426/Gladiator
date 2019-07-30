package com.lti.spring;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

//CODE RUNNUNG TILL PLAVING THE ORDER
@SpringBootApplication
@ComponentScan(basePackages={"com.lti.spring"})
public class OnlineShoppingv2Application {

	public static void main(String[] args) {
		SpringApplication.run(OnlineShoppingv2Application.class, args);
	}

}
