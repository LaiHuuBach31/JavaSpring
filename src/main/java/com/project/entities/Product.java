package com.project.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "pro")
public class Product {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "name")
	private String name;
	@Column(name = "price")
	private Float price;
	@Column(name = "image")
	private String image;
	@Column(name = "status")
	private Boolean status;
	@Column(name = "description")
	private String description;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "categoryId",referencedColumnName  = "id")
	private Category category;
	
	@OneToMany(mappedBy = "product")
	private Set<Cart> carts;
	
	@OneToMany(mappedBy = "product")
	private Set<OrderDetail> productOrder;
	
	public Product() {
		// TODO Auto-generated constructor stub
	}

	public Product(Integer id, String name, Float price, String image, Boolean status, String description,
			Category category, Set<Cart> carts, Set<OrderDetail> productOrder) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.image = image;
		this.status = status;
		this.description = description;
		this.category = category;
		this.carts = carts;
		this.productOrder = productOrder;
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

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Set<Cart> getCarts() {
		return carts;
	}

	public void setCarts(Set<Cart> carts) {
		this.carts = carts;
	}

	public Set<OrderDetail> getProductOrder() {
		return productOrder;
	}

	public void setProductOrder(Set<OrderDetail> productOrder) {
		this.productOrder = productOrder;
	}

}
