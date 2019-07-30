 package com.lti.spring.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Customer2")

public class Customer implements Serializable {
		@SequenceGenerator(name = "customerSequence", initialValue = 100, allocationSize = 1)
		@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customerSequence")
		@Id
		@Column(name="customer_Id")
		Integer customerId;
		
		@Column(name = "first_name")
		String firstName;
		
		@Column(name = "last_name")
		String lastName;
		
		
		@Column(name = "username", unique = true)
		String username;
		
		@Column(name = "password")
		String password;
		
		@Column(name = "email")
		String email;
		
		@Column(name = "address")
		String address;
		
		@OneToOne(mappedBy = "customer", cascade = CascadeType.ALL)
		private Cart cart;
		
		public Cart getCart() { 
			return cart;
		}

		public void setCart(Cart cart) {
			this.cart = cart;
		}

		public String getFirstName() {
			return firstName;
		}
		
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		
		public String getLastName() {
			return lastName;
		}
		
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		
		public String getUsername() {
			return username;
		}
		
		public void setUsername(String username) {
			this.username = username;
		}
		
		public String getPassword() {
			return password;
		}
		
		public void setPassword(String password) {
			this.password = password;
		}
		
		public String getEmail() {
			return email;
		}
		
		public void setEmail(String email) {
			this.email = email;
		}
		
		public String getAddress() {
			return address;
		}
		
		public void setAddress(String address) {
			this.address = address;
		}
		
		public Integer getCustomerId() {
			return customerId;
		}
		
		public void setCustomerId(Integer customerId) {
			this.customerId =  customerId;
		}
		
		public Customer(String firstName, String lastName, String username, String password, String email,
				String address, Integer customerId) {
			super();
			this.firstName = firstName;
			this.lastName = lastName;
			this.username = username;
			this.password = password;
			this.email = email;
			this.address = address;
			this.customerId = customerId;
		}
		
		public Customer() {
			super();
		}

		@Override
		public String toString() {
			return "Customer [customerId=" + customerId + ", firstName=" + firstName + ", lastName=" + lastName
					+ ", username=" + username + ", password=" + password + ", email=" + email + ", address=" + address
					+ "]";
		}
		
}


