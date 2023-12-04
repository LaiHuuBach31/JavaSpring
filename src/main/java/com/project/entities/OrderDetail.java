package com.project.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "order_detail")
public class OrderDetail {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "price")
	private Float price;
	@Column(name = "quantity")
	private Integer quantity;
	@ManyToOne
	@JoinColumn(name = "orderId",referencedColumnName = "id")
	private Order order;
	@ManyToOne
	@JoinColumn(name = "productId",referencedColumnName = "id")
	private Product product;
	
	public OrderDetail() {
		
	}

	public OrderDetail(Integer id, Float price, Integer quantity, Order order, Product product) {
		super();
		this.id = id;
		this.price = price;
		this.quantity = quantity;
		this.order = order;
		this.product = product;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}
