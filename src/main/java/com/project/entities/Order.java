package com.project.entities;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "status")
	private Boolean status;
	@Column(name = "shippingMethod")
	private String shippingMethod;
	@Column(name = "paymentMethod")
	private String paymentMethod;
	@Column(name = "orderNote")
	private String orderNote;
	@Column(name = "orderDate")
	private Date orderDate;
	@Column(name = "orderCode")
	private String orderCode;
	@Column(name = "token")
	private String token;
	
	@ManyToOne
	@JoinColumn(name = "userId", referencedColumnName = "id")
	private User user;
	
	@OneToMany(mappedBy = "order")
	private Set<OrderDetail> orderProduct;
	
	public Order() {
		
	}

	public Order(Integer id, Boolean status, String shippingMethod, String paymentMethod, String orderNote,
			Date orderDate, String orderCode, String token, User user, Set<OrderDetail> orderProduct) {
		super();
		this.id = id;
		this.status = status;
		this.shippingMethod = shippingMethod;
		this.paymentMethod = paymentMethod;
		this.orderNote = orderNote;
		this.orderDate = orderDate;
		this.orderCode = orderCode;
		this.token = token;
		this.user = user;
		this.orderProduct = orderProduct;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public String getShippingMethod() {
		return shippingMethod;
	}

	public void setShippingMethod(String shippingMethod) {
		this.shippingMethod = shippingMethod;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public String getOrderNote() {
		return orderNote;
	}

	public void setOrderNote(String orderNote) {
		this.orderNote = orderNote;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<OrderDetail> getOrderProduct() {
		return orderProduct;
	}

	public void setOrderProduct(Set<OrderDetail> orderProduct) {
		this.orderProduct = orderProduct;
	}

}
