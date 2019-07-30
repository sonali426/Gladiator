package com.lti.spring.model;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author Zaeni
 *
 */
@Entity
@Table(name = "Category2")
public class Category implements Serializable {
	
	@SequenceGenerator(name = "categorySequence", initialValue = 400, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "categorySequence")
	@Id
	@Column(name = "category_Id")
	private Integer categoryId;
	
	@Column(name="category_Name")
	private String categoryName;
	
	@OneToMany(mappedBy="category", cascade=CascadeType.ALL)
	private List<Product> product;// making the flow bidirectional with category

	public List<Product> getProduct() {
		return product;
	}

	public void setProduct(List<Product> product) {
		this.product = product;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", categoryName=" + categoryName + "]";
	}

}