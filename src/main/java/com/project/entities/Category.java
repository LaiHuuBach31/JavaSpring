package com.project.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="cate")
public class Category {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "name", unique = true)
	private String name;
	@Column(name = "image")
	private String image;
	@Column(name = "status")
	private Boolean status;
	
	@OneToMany(mappedBy = "category")
	private Set<Product> products;
	
	public Category() {
		// TODO Auto-generated constructor stub
	}

	public Category(Integer id, String name, String image, Boolean status, Set<Product> products) {
		super();
		this.id = id;
		this.name = name;
		this.image = image;
		this.status = status;
		this.products = products;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

}
