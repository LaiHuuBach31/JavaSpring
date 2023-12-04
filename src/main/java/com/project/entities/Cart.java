package com.project.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cart")
public class Cart {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "quantity")
	private Integer quantity;
	@Column(name = "total")
	private Float total;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "productId",referencedColumnName  = "id")
	private Product product;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "userId",referencedColumnName  = "id")
	private User user;
	
	public Cart() {
		// TODO Auto-generated constructor stub
	}

	public Cart(Integer id, Integer quantity, Float total, Product product, User user) {
		super();
		this.id = id;
		this.quantity = quantity;
		this.total = total;
		this.product = product;
		this.user = user;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Float getTotal() {
		return total;
	}

	public void setTotal(Float total) {
		this.total = total;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
