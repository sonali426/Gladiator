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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Cart2")
public class Cart implements Serializable {
	
	
	@SequenceGenerator(name = "cartSequence", initialValue = 200, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cartSequence")
	@Id
	@Column(name = "cart_Id")
	private Integer cartId;

	/*
	 * @ManyToMany(targetEntity = Customer.class) private List<Product> productList;
	 */
	
	@OneToMany(mappedBy = "cart", cascade = CascadeType.ALL)
	private List<CustomerCart> customerCartList = new ArrayList<CustomerCart>();
		
	public Cart() {
	   super();	// TODO Auto-generated constructor stub
	}
	public Cart(Integer cartId, List<CustomerCart> customerCartList, Customer customer, Integer quantity) {
		super();
		this.cartId = cartId;
		this.customerCartList = customerCartList;
		this.customer = customer;
		this.quantity = quantity;
	}

	@OneToOne(targetEntity = Customer.class)
	private Customer customer;
	
	@Column
	private Integer quantity;

	
	public List<CustomerCart> getCustomerCartList() {
		return customerCartList;
	}

	public void setCustomerCartList(List<CustomerCart> customerCartList) {
		this.customerCartList = customerCartList;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getCartId() {
		return cartId;
	}

	public void setCartId(Integer cartId) {
		this.cartId = cartId;
	}

	/*
	 * public List<Product> getProductList() { return productList; }
	 * 
	 * public void setProductList(List<Product> productList) { this.productList =
	 * productList; }
	 */

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	

	@Override
	public String toString() {
		return "Cart [cartId=" + cartId;
	}

	/*
	 * public void addProduct(Product product) { productList.add(product);
	 * 
	 * }
	 */

	public void addProduct(Product product) {
		CustomerCart customerCart = new CustomerCart(this, product); System.err.println("Entering cart: 1");
		customerCartList.add(customerCart); System.err.println("Entering cart: 2");
		product.getCustomerCartList().add(customerCart); System.err.println("Entering cart: 3");
		
	}

			
}
