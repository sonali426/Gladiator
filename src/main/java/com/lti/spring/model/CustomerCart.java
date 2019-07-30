package com.lti.spring.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "customer_cart2")
public class CustomerCart implements Serializable{
	
//	@EmbeddedId
//	private CustomerCartId customerCartId;
	
	@SequenceGenerator(name = "customerCartSequence", initialValue = 500, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customerCartSequence")
	@Id
	@Column(name = "customer_cart_id")
	private Integer customerCartId;
	
	@ManyToOne
	//@MapsId("cartId")
	private Cart cart;
	
	@ManyToOne
	//@MapsId("productId")
	private Product product;
	
	@Column(name = "quantity")
	private Integer quantity;
	
	@Column
	private Integer productId;
	
	@Column
	private Integer cartId;

//	public CustomerCartId getCustomerCartId() {
//		return customerCartId;
//	}
//
//	public void setCustomerCartId(CustomerCartId customerCartId) {
//		this.customerCartId = customerCartId;
//	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public Integer getCartId() {
		return cartId;
	}

	public void setCartId(Integer cartId) {
		this.cartId = cartId;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	public CustomerCart(Cart cart, Product product) {
		super();
		System.err.println("Customer cart :1");
		//this.customerCartId = new CustomerCartId(cart.getCartId(), product.getProductId());System.err.println("Customer cart :2");
		
	this.cart = cart; System.err.println("Customer cart :3");
		  
	this.product = product; System.err.println("Customer cart :4");
		 
		
	}
	
	@Override
	public String toString() {
		return "CustomerCart [cart=" + cart + ", product=" + product + ", productId=" + productId + ", cartId=" + cartId
				+ "]";
	}

	public CustomerCart() {
		super();// TODO Auto-generated constructor stub
	}
	
	
}
