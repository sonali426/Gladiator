package com.lti.spring.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable 
public class CustomerCartId implements Serializable {
	
	@Column(name = "cart_id")
	private Integer cartId;
	
	@Column(name = "product_id")
	private Integer productId;

	public Integer getCartId() {
		return cartId;
	}

	public void setCartId(Integer cartId) {
		this.cartId = cartId;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public CustomerCartId(Integer cartId, Integer productId) {
		super();
		this.cartId = cartId; System.err.println("Customer cart id :1");
		this.productId = productId;System.err.println("Customer cart id:2");
	}

	public CustomerCartId() {
		super();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cartId == null) ? 0 : cartId.hashCode());
		result = prime * result + ((productId == null) ? 0 : productId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CustomerCartId other = (CustomerCartId) obj;
		if (cartId == null) {
			if (other.cartId != null)
				return false;
		} else if (!cartId.equals(other.cartId))
			return false;
		if (productId == null) {
			if (other.productId != null)
				return false;
		} else if (!productId.equals(other.productId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CustomerCartId [cartId=" + cartId + ", productId=" + productId + "]";
	}
	
	
}
