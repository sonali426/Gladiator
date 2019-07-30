package com.lti.spring.model;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author Zaeni
 *
 */
@Entity
@Table(name = "Product2")
public class Product implements Serializable {
	
	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
	private List<CustomerCart> customerCartList = new ArrayList<CustomerCart>();

	@ManyToOne(targetEntity = Category.class)
	private Category category;
	
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	/*
	 * @ManyToMany
	 * 
	 * @JoinTable( name = "Customer_Cart2", joinColumns = @JoinColumn(name =
	 * "product_id"), inverseJoinColumns = @JoinColumn(name = "cart_id")) private
	 * List<Cart> cart;
	 */
	
	/*
	 * public List<Cart> getCart() { return cart; }
	 * 
	 * public void setCart(List<Cart> cart) { this.cart = cart; }
	 */

	@SequenceGenerator(name = "productSequence", initialValue = 300, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "productSequence")
	@Id
	@Column(name = "product_Id")
	private Integer productId;

	@Column(name = "product_Name")
	private String productName;

	@Column(name = "product_Price")
	private Double productPrice;
	
	
	public List<CustomerCart> getCustomerCartList() {
		return customerCartList;
	}

	public void setCustomerCartList(List<CustomerCart> customerCartList) {
		this.customerCartList = customerCartList;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}

	@Override
	public String toString() {
		return "Product [ category=" + category + ", productId=" + productId
				+ ", productName=" + productName + ", productPrice=" + productPrice + "]";
	}

	public Product(List<CustomerCart> customerCartList, Category category, Integer productId, String productName,
			Double productPrice) {
		super();
		this.customerCartList = customerCartList;
		this.category = category;
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
	}
	
	public Product() {
	super();	// TODO Auto-generated constructor stub
	}

}